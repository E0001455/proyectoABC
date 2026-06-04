package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.ListaContactoEntity;
import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
import mx.com.proyectohu.repository.ListaContactoRepository;
import mx.com.proyectohu.repository.RespuestaTareaLineaRepository;
import mx.com.proyectohu.repository.TareaCronRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.util.FechaUtil;



@Service
public class CLRespuestaCronService {

	@Autowired
	public RespuestaTareaLineaRepository respuestaTareaLineaRepository;

	@Autowired
	public RespuestaCLService respuestaCLService;

	@Autowired
	public EnvioLineaDAO envioLineaDAO;
	
	@Autowired
	public TareaLineaRepository  tareaLineaRepository;


	@Autowired
	public ListaContactoRepository listaContactoRepository;
	
	@Autowired
	public BitacoraTareaLineaRepository  bitacoraTareaLineaRepository;

	Integer totalregistros =0;
	
	
	Integer aprobados =0;
	


	public void ejecutarVerificacionRespuesta(String lineaNegocio, Long idTareaLinea) {
		List<Object[]> listaRespuesta= null;
		
		totalregistros =0;
		aprobados =0;
		
		actualizarTarea(idTareaLinea, 2L);


		List<Long> listaId = envioLineaDAO.obteneridsRespuesta(lineaNegocio);


		String placeholders = listaId.stream()
		        .map(String::valueOf)
		        .collect(Collectors.joining(","));

		List<Long> listaIdTarea = envioLineaDAO.obtenerTareaRespuesta(placeholders);


		for(Long idTarea: listaIdTarea) {

			listaRespuesta = respuestaTareaLineaRepository.findRequestIdById(idTarea);

			List<List<String>> totalRespuestas = new ArrayList<List<String>>();
			List<String> result =null;

			for (Object[] requestId : listaRespuesta) {

				String response = respuestaCLService.llamarPollingStatus((String)requestId[1]);

				JSONObject jsonObject = new JSONObject(response);

				JSONArray records = jsonObject
						.getJSONObject("response")
						.getJSONObject("recordData")
						.getJSONArray("records");

				result = new ArrayList<String>();
				result.addFirst(requestId[0].toString());

				for (int i = 0; i < records.length(); i++) {
					JSONArray row = records.getJSONArray(i);

					for (int j = 0; j < row.length(); j++) {
						result.add(row.getString(j));
					}
				}
				totalRespuestas.add(result);
			}



			for (int i=0; i < totalRespuestas.size(); i++ ) {

				RespuestaTareaLineaEntity respuestaTareaLineaEntity = new RespuestaTareaLineaEntity(); 
				Long idRespuestaLinea= Long.valueOf(totalRespuestas.get(i).getFirst());

				respuestaTareaLineaEntity= respuestaTareaLineaRepository.findById(idRespuestaLinea).get();

				List<Long> listaIdContactos = respuestaTareaLineaRepository.findIdListaContactos(idRespuestaLinea);
				totalregistros=	listaIdContactos.size();
				if (listaIdContactos.size()== totalRespuestas.get(i).size() -1 ) {

					for (int j = 1; j <totalRespuestas.get(i).size(); j++) {

						envioLineaDAO.insertarBitacoraListaContactoEnviado(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j),respuestaTareaLineaEntity.getIdTareaLinea());
						if (!totalRespuestas.get(i).get(j).contains("MERGEFAILED")) {
							actualizarRIIDListaContacto(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j));
							aprobados++;
							
						}
					}
				}
			}
		}
		
		actualizarTarea(idTareaLinea, 4L);
	}


	public void actualizarRIIDListaContacto(Long idListaContacto, String RIID) {

		ListaContactoEntity listaContactoEntity = new ListaContactoEntity();

		listaContactoEntity = listaContactoRepository.findById(idListaContacto).get();

		listaContactoEntity.setRiid(RIID);

		listaContactoRepository.save(listaContactoEntity);

	}
	
	
	public void actualizarTarea(Long idTareaLinea,Long estatus) {

		Optional<TareaLineaEntity> tareaLineaEntityOptional =  tareaLineaRepository.findById(idTareaLinea);

		if (tareaLineaEntityOptional.isPresent()) {
			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();

			tareaLineaEntity.setIdEstatusTarea(estatus);

			if (estatus==2) {
				tareaLineaEntity.setFdFechaInicio(FechaUtil.obtenerFechaActual());
			}else {
				tareaLineaEntity.setFdFechaFin(FechaUtil.obtenerFechaActual());
				tareaLineaEntity.setFinProcesados(totalregistros);
				tareaLineaEntity.setFinRegistros(totalregistros);
				tareaLineaEntity.setRegistrosAprobados(aprobados);
				tareaLineaEntity.setRegistrosRechazados(totalregistros-aprobados);
			}

			tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);

			BitacoraTareaLineaEntity bitacoraTareaLineaEntity = new  BitacoraTareaLineaEntity();

			bitacoraTareaLineaEntity.setIdTareaLinea(idTareaLinea);
			bitacoraTareaLineaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaLineaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());

			if (estatus==2) {
				bitacoraTareaLineaEntity.setDetalle("EJECUCION DE ENVIO");
			}else {
				bitacoraTareaLineaEntity.setDetalle("COMPLETADA");
			}

			bitacoraTareaLineaEntity= bitacoraTareaLineaRepository.save(bitacoraTareaLineaEntity);
		}
	}
}
