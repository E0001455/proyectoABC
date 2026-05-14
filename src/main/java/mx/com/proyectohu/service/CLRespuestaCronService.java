package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.entity.ListaContactoEntity;
import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;
import mx.com.proyectohu.repository.ListaContactoRepository;
import mx.com.proyectohu.repository.RespuestaTareaLineaRepository;
import mx.com.proyectohu.repository.TareaCronRepository;



@Service
public class CLRespuestaCronService {

	@Autowired
	public RespuestaTareaLineaRepository respuestaTareaLineaRepository;

	@Autowired
	public RespuestaCLService respuestaCLService;

	@Autowired
	public EnvioLineaDAO envioLineaDAO;


	@Autowired
	public ListaContactoRepository listaContactoRepository;


	@Scheduled(cron= "${cron.cl.respuesta}")
	public void ejecutarVerificacionRespuesta() {

		List<Object[]> listaRespuesta = respuestaTareaLineaRepository.findRequestId();

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

			if (listaIdContactos.size()== totalRespuestas.get(i).size() -1 ) {

				for (int j = 1; j <totalRespuestas.get(i).size(); j++) {

					envioLineaDAO.insertarBitacoraListaContactoEnviado(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j),respuestaTareaLineaEntity.getIdTareaLinea());
					if (!totalRespuestas.get(i).get(j).contains("MERGEFAILED")) {
					actualizarRIIDListaContacto(listaIdContactos.get(j-1), totalRespuestas.get(i).get(j));
					}
				}
			}
		}
	}


	public void actualizarRIIDListaContacto(Long idListaContacto, String RIID) {

		ListaContactoEntity listaContactoEntity = new ListaContactoEntity();

		listaContactoEntity = listaContactoRepository.findById(idListaContacto).get();

		listaContactoEntity.setRiid(RIID);

		listaContactoRepository.save(listaContactoEntity);

	}
}
