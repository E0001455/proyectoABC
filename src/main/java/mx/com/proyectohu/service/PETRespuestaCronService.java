package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.EnvioCampanaDAO;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.RespuestaTareaCampanaEntity;
import mx.com.proyectohu.repository.ExtencionPerfilRepository;
import mx.com.proyectohu.repository.RespuestaTareaCampanaRepository;



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


	@Scheduled(cron= "${cron.pet.respuesta}")
	public void ejecutarVerificacionRespuesta() {

		List<Object[]> listaRespuesta = respuestaTareaCampanaRepository.findRequestId();

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
			
			List<Long> listaIdContactos = respuestaTareaCampanaRepository.findIdListaContactos(idRespuestaCampana);

			if (listaIdContactos.size()== totalRespuestas.get(i).size() -1 ) {

				for (int j = 1; j <totalRespuestas.get(i).size(); j++) {

					envioCampanaDAO.insertarBitacoraExtensionPerfilEnviado(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j), respuestaTareaCampanaEntity.getIdTareaCampana());
					if (!totalRespuestas.get(i).get(j).contains("MERGEFAILED")) {
					actualizarRIIDListaContacto(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j));
					}
				}
			}
		}
	}


	public void actualizarRIIDListaContacto(Long idListaContacto, String RIID) {

		ExtensionPerfilEntity extensionPerfilEntity = new ExtensionPerfilEntity();

		extensionPerfilEntity = extencionPerfilRepository.findById(idListaContacto).get();

		extensionPerfilEntity.setRiid(RIID);

		extencionPerfilRepository.save(extensionPerfilEntity);

	}
}
