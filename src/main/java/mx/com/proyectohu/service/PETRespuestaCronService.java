package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.EnvioCampanaDAO;
import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.RespuestaTareaCampanaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.BitacoraTareaCampanaRepository;
import mx.com.proyectohu.repository.ExtencionPerfilRepository;
import mx.com.proyectohu.repository.RespuestaTareaCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.util.FechaUtil;



@Service
public class PETRespuestaCronService {

	@Autowired
	public RespuestaTareaCampanaRepository respuestaTareaCampanaRepository;

	@Autowired
	public RespuestaCLService respuestaCLService;

	@Autowired
	public EnvioCampanaDAO envioCampanaDAO;

	@Autowired
	public ExtencionPerfilRepository extencionPerfilRepository;

	@Autowired
	public TareaCampanaRepository  tareaCampanaRepository;

	@Autowired
	public BitacoraTareaCampanaRepository bitacoraTareaCampanaRepository;

	Integer totalregistros =0;

	Integer aprobados =0;

	public void ejecutarVerificacionRespuesta(String lineaNegocio,Long idTareaCampana) {
		List<Object[]> listaRespuesta = null;
		totalregistros =0;
		aprobados =0;

		actualizarTarea(idTareaCampana, 2L);

		//		List<Long> listaId = envioCampanaDAO.obteneridsRespuesta(lineaNegocio);
		//
		//		if (!listaId.isEmpty()) {
		//
		//
		//			List<List<Long>> listaDividida = new ArrayList<>();
		//			for(int d=0;d<listaId.size();d+=1000) {
		//				listaDividida.add(listaId.subList(d, Math.min(d+1000,listaId.size())));
		//			}
		//
		//			for(List<Long> listaReducida : listaDividida ) {	
		//				String placeholders = listaReducida.stream()
		//						.map(String::valueOf)
		//						.collect(Collectors.joining(","));
		//
		//				List<Long> listaIdTarea = envioCampanaDAO.obtenerTareaRespuesta(placeholders);	
		//
		//				for(Long idTarea: listaIdTarea) {

		listaRespuesta = respuestaTareaCampanaRepository.findRequestIdById(lineaNegocio);
		
		if (!listaRespuesta.isEmpty()) {
			
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

				RespuestaTareaCampanaEntity respuestaTareaCampanaEntity = new RespuestaTareaCampanaEntity();
				Long idRespuestaCampana= Long.valueOf(totalRespuestas.get(i).getFirst());

				respuestaTareaCampanaEntity= respuestaTareaCampanaRepository.findById(idRespuestaCampana).get();

				List<Long> listaIdExtensionPerfil = respuestaTareaCampanaRepository.findIdExtensionPerfil(idRespuestaCampana);

				if (listaIdExtensionPerfil.size()== totalRespuestas.get(i).size() -1 ) {
					totalregistros= totalregistros+	listaIdExtensionPerfil.size();
					for (int j = 1; j <totalRespuestas.get(i).size(); j++) {

						envioCampanaDAO.insertarBitacoraExtensionPerfilEnviado(listaIdExtensionPerfil.get(j-1), totalRespuestas.get(i).get(j), respuestaTareaCampanaEntity.getIdTareaCampana());
						if (!totalRespuestas.get(i).get(j).contains("MERGEFAILED")) {
							actualizarRIIDListaContacto(listaIdExtensionPerfil.get(j-1), totalRespuestas.get(i).get(j));
							aprobados++;
						}
					}
				}
			}
			//}
			//}
			//}
		}
		actualizarTarea(idTareaCampana, 4L);
	}


	public void actualizarRIIDListaContacto(Long idListaContacto, String RIID) {

		ExtensionPerfilEntity extensionPerfilEntity = new ExtensionPerfilEntity();

		extensionPerfilEntity = extencionPerfilRepository.findById(idListaContacto).get();

		extensionPerfilEntity.setRiid(RIID);

		extencionPerfilRepository.save(extensionPerfilEntity);

	}
	public void actualizarTarea(Long idTareaCampana,Long estatus) {

		Optional<TareaCampanaEntity> tareaCampanaEntityOptional =  tareaCampanaRepository.findById(idTareaCampana);

		if (tareaCampanaEntityOptional.isPresent()) {
			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();

			tareaCampanaEntity.setIdEstatusTarea(estatus);

			if (estatus==2) {
				tareaCampanaEntity.setFdFechaInicio(FechaUtil.obtenerFechaActual());
			}else {
				tareaCampanaEntity.setFdFechaFin(FechaUtil.obtenerFechaActual());
				tareaCampanaEntity.setFinProcesados(totalregistros);
				tareaCampanaEntity.setFinRegistros(totalregistros);
				tareaCampanaEntity.setRegistrosAprobados(aprobados);
				tareaCampanaEntity.setRegistrosRechazados(totalregistros-aprobados);
			}

			tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);

			BitacoraTareaCampanaEntity bitacoraTareaCampanaEntity = new  BitacoraTareaCampanaEntity();

			bitacoraTareaCampanaEntity.setIdTareaCampana(idTareaCampana);
			bitacoraTareaCampanaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaCampanaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());

			if (estatus==2) {
				bitacoraTareaCampanaEntity.setDetalle("EJECUCION DE RESPUESTA");
			}else {
				bitacoraTareaCampanaEntity.setDetalle("COMPLETADA");
			}

			bitacoraTareaCampanaEntity= bitacoraTareaCampanaRepository.save(bitacoraTareaCampanaEntity);
		}
	}
}
