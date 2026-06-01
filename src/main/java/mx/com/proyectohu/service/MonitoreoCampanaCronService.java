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

import mx.com.proyectohu.client.EnvioCampanaClient;
import mx.com.proyectohu.client.RespuestaCampanaClient;
import mx.com.proyectohu.client.RespuestaLineaClient;
import mx.com.proyectohu.client.ValidarCampanaClient;
import mx.com.proyectohu.component.TareaCampanaDAO;
import mx.com.proyectohu.entity.ABCCatActividad;
import mx.com.proyectohu.entity.ABCCatHora;
import mx.com.proyectohu.repository.ActividadRepository;
import mx.com.proyectohu.repository.HorarioRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;



@Service
public class MonitoreoCampanaCronService {

	@Autowired
	public HorarioRepository horarioRepository;

	@Autowired
	public TareaCampanaDAO tareaCampanaDAO;
	
	@Autowired
	public ActividadRepository actividadRepository;
	
	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;
	
	@Autowired
	public ValidarCampanaClient validarCampanaClient;
	
	@Autowired
	public EnvioCampanaClient envioCampanaClient;
	
	@Autowired
	public RespuestaCampanaClient respuestaCampanaClient;
	
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
					
					String json = tareaCampanaDAO.consultarTareasHoraEstatus(codigoHora, codigoEstatus);


					ObjectMapper mapper = new ObjectMapper();
					JsonNode rootArray;

					rootArray = mapper.readTree(json);


					if (rootArray.isArray()) {
						for (JsonNode item : rootArray) {
							Long idLineaNegocio = item.path("linea").path("id").asLong();
							JsonNode tareas = item.path("tareas");
							if (tareas.isArray()) {
								for (JsonNode tarea : tareas) {
									Long idActividad = tarea.path("actividad").path("id").asLong();
									Long idTareaCampana = tarea.path("id").asLong();
									
										Optional<ABCCatActividad> abcCatActividad = actividadRepository.findById(idActividad);
										
										String codigoActividad = abcCatActividad.get().getCodigo();
										
										String lineaNegocio = lineaNegocioRepository.findById(idLineaNegocio).get().getNombre();
										
										if(codigoActividad.equals("VLD")) {
										
											validarCampanaClient.llamarValidarCampana(lineaNegocio,idTareaCampana);
											
										}
										if(codigoActividad.equals("ENV")) {
											
											envioCampanaClient.llamarEnvioCampana(lineaNegocio,idTareaCampana);
											
										}
										if(codigoActividad.equals("RES")) {

											respuestaCampanaClient.llamarRespuestaCampana(lineaNegocio, idTareaCampana);



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
}
