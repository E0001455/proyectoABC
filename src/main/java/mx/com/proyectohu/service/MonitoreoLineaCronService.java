package mx.com.proyectohu.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.proyectohu.client.CargarLineaClient;
import mx.com.proyectohu.client.EnvioLineaClient;
import mx.com.proyectohu.client.RespuestaLineaClient;
import mx.com.proyectohu.client.ValidarLineaClient;
import mx.com.proyectohu.component.TareaCampanaDAO;
import mx.com.proyectohu.component.TareaLineaDAO;
import mx.com.proyectohu.entity.ABCCatActividad;
import mx.com.proyectohu.entity.ABCCatHora;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.feign.EnvioLineaClientFeign;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.ActividadLineaRepository;
import mx.com.proyectohu.repository.ActividadRepository;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
import mx.com.proyectohu.repository.EjecucionRepository;
import mx.com.proyectohu.repository.HorarioRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class MonitoreoLineaCronService {

	@Autowired
	public HorarioRepository horarioRepository;

	@Autowired
	public BitacoraTareaLineaRepository  bitacoraTareaLineaRepository;

	@Autowired
	public TareaLineaRepository  tareaLineaRepository;

	@Autowired
	public TareaLineaDAO tareaLineaDAO;

	@Autowired
	public ActividadRepository actividadRepository;

	@Autowired
	public CargarLineaClient cargarLineaClient;

	@Autowired
	public ValidarLineaClient validarLineaClient;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public EnvioLineaClient envioLineaClient;

	@Autowired
	public RespuestaLineaClient respuestaLineaClient;

	@Autowired
	public EjecucionRepository ejecucionRepository;

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;


	@Value("${hora.cron.monitoreo}")
	public String codigoHoraAPP;


	@Scheduled(cron= "${cron.monitoreo.configuracion}")
	public void checarHorarios() {
		try {
			LocalTime horaReal = LocalTime.now();
			List<ABCCatHora> horarios = horarioRepository.findAll();

			for (ABCCatHora h : horarios) {
				String horaTabla = h.getNombre();

				LocalTime horaBase = LocalTime.parse(horaTabla,DateTimeFormatter.ofPattern("HH:mm"));

				if (horaBase.getHour() == horaReal.getHour() && horaBase.getMinute() == horaReal.getMinute()) {
					String codigoHora = codigoHoraAPP;
					String codigoEstatus = "PLN"; 

					String json = tareaLineaDAO.consultarTareasHoraEstatus(codigoHora, codigoEstatus);


					ObjectMapper mapper = new ObjectMapper();
					JsonNode rootArray;

					rootArray = mapper.readTree(json);


					if (rootArray.isArray()) {
						for (JsonNode item : rootArray) {
							Long idLineaNegocio = item.path("linea").path("id").asLong();
							Long idMapeo = item.path("mapeo").path("id").asLong();
							JsonNode tareas = item.path("tareas");
							if (tareas.isArray()) {
								for (JsonNode tarea : tareas) {
									Long idActividad = tarea.path("actividad").path("id").asLong();
									Long idTareaLinea = tarea.path("id").asLong();
									Long idEjecucion = tarea.path("ejecucion").path("id").asLong();
									Boolean dictaminado = tarea.path("dictaminado").asBoolean();
									String CodigoEjecucion = ejecucionRepository.findById(idEjecucion).get().getCodigo();
									Boolean dictaminar = tarea.path("dictaminar").asBoolean();

									Optional<ABCCatActividad> abcCatActividad = actividadRepository.findById(idActividad);

									String codigoActividad = abcCatActividad.get().getCodigo();
									
									String lineaNegocio = lineaNegocioRepository.findById(idLineaNegocio).get().getNombre();

									if (CodigoEjecucion.equals("HBD")||CodigoEjecucion.equals("ATM")) {

										if(codigoActividad.equals("CAG")) {


											cargarLineaClient.llamarCargaLinea(lineaNegocio,idTareaLinea);
										}

										if(codigoActividad.equals("VLD")) {

											validarLineaClient.llamarValidarLinea(lineaNegocio,idTareaLinea);

										}
										if(codigoActividad.equals("ENV")) {
											if (dictaminar&&!dictaminado) {
												Long tareal =	idTareaLinea;
												for(int i=0;i<2;i++) {	
													actualizarTarea(tareal,7L);
													tareal=idTareaLinea+1;
												}

											}else {

												envioLineaClient.llamarEnvioLinea(lineaNegocio, idTareaLinea);
											}
										}

										if(codigoActividad.equals("RES")) {

											respuestaLineaClient.llamarRespuestaLinea(lineaNegocio, idTareaLinea);



										}
									}

								}
							}
						}
					}
				}	





			}

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	public void actualizarTarea(Long idTareaLinea,Long estatus) {

		Optional<TareaLineaEntity> tareaLineaEntityOptional =  tareaLineaRepository.findById(idTareaLinea);

		if (tareaLineaEntityOptional.isPresent()) {
			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();

			tareaLineaEntity.setIdEstatusTarea(estatus);

			tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);

			BitacoraTareaLineaEntity bitacoraTareaLineaEntity = new  BitacoraTareaLineaEntity();

			bitacoraTareaLineaEntity.setIdTareaLinea(idTareaLinea);
			bitacoraTareaLineaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaLineaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());


			bitacoraTareaLineaEntity.setDetalle("CANCELADA");

			bitacoraTareaLineaEntity= bitacoraTareaLineaRepository.save(bitacoraTareaLineaEntity);
		}
	}

}

