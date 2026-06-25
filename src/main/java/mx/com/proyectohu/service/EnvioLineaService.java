package mx.com.proyectohu.service;



import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.controller.CargaLineaController;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.ListaContactoRespuestaEntity;
import mx.com.proyectohu.entity.LlaveListaContactoRespuesta;
import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.ListaContactoRespuestaRepository;
import mx.com.proyectohu.repository.MapeoActividadLineaRepository;
import mx.com.proyectohu.repository.RespuestaTareaLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class EnvioLineaService {

	@Autowired
	public TareaLineaRepository  tareaLineaRepository;

	@Autowired
	public EnvioLineaDAO   envioLineaDAO;

	@Autowired
	public MiddlewareCLClient  middlewareClient;

	@Autowired
	public BitacoraTareaLineaRepository  bitacoraTareaLineaRepository;

	@Autowired
	public  RespuestaTareaLineaRepository respuestaTareaLineaRepository;

	@Autowired
	public  ListaContactoRespuestaRepository listaContactoRespuestaRepository;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;
	
	@Autowired
	public MapeoActividadLineaRepository mapeoActividadLineaRepository;
	
	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;


	@Value("${numero.registros.enviados.linea}")
	public Integer numeroRegistrosEnviados;

	Integer totalregistros =0;

	Integer totalRegistrosEnviados = 0;

	public MiddlewareCLDTO ejecutarEnvioListaContacto(Long idTareaLinea) throws Exception {

		TareaLineaEntity tareaLineaEntity = new TareaLineaEntity(); 

		tareaLineaEntity = tareaLineaRepository.findById(idTareaLinea).get();
		
		ActividadMapeoLineaEntity actividadMapeoLineaEntity=mapeoActividadLineaRepository.findById(tareaLineaEntity.getIdActividadMapeoLinea()).get();

		Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(actividadMapeoLineaEntity.getIdMapeoLinea());

		String lineaNegocio = lineaNegocioRepository.findById(abcConfigMapeoLineaEntityOptional.get().getIdABCCatLineaNegocio()).get().getNombre();


		List<Map<String, Object>> datos = new ArrayList<Map<String, Object>>();
		List<String>  columnasNombreCorrecto = new ArrayList<String>();
		List<String>  columnas = new ArrayList<String>();

		columnas = tareaLineaRepository.obtenerColumnasXidTarea(idTareaLinea);



		if (columnas.isEmpty()) {
			throw new Exception("lista de columnas vacia no se puede enviar informacion");
		}

		for(String columna : columnas ) {
			if (!columna.contains("FC")) {
				columna="TEP.FC"+columna;
			}

			columnasNombreCorrecto.add(columna);

		}

		actualizarTarea(idTareaLinea, 2L);

		MiddlewareCLDTO middlewareCLDTO = new MiddlewareCLDTO();

		RecordDataDTO recordDataDTO = new RecordDataDTO();

		MergeRuleDTO mergeRuleDTO = new MergeRuleDTO();

		recordDataDTO.setFieldNames(columnas);

		datos= envioLineaDAO.obtenerDatosXColumnas(columnasNombreCorrecto,lineaNegocio);

		List<List<Object>> resultado = new ArrayList<>();

		for (Map<String, Object> fila : datos) {
			List<Object> valores = new ArrayList<>();

			for (Object valor : fila.values()) {
				valores.add(valor);
			}

			resultado.add(valores);
		}

		//	recordDataDTO.setRecords(resultado);
		totalregistros = resultado.size();

		middlewareCLDTO.setRecordData(recordDataDTO);

		mergeRuleDTO.setHtmlValue("H");
		mergeRuleDTO.setTextValue("T");
		mergeRuleDTO.setOptinValue("I");
		mergeRuleDTO.setOptoutValue("O");
		mergeRuleDTO.setInsertOnNoMatch(true);
		mergeRuleDTO.setUpdateOnMatch("REPLACE_ALL");
		mergeRuleDTO.setMatchColumnName1("CUSTOMER_ID_");
		mergeRuleDTO.setMatchColumnName2(null);
		mergeRuleDTO.setMatchOperator("NONE");
		mergeRuleDTO.setRejectRecordIfChannelEmpty(null);
		mergeRuleDTO.setDefaultPermissionStatus("OPTIN");

		middlewareCLDTO.setMergeRule(mergeRuleDTO);

		int numeroRegistros = numeroRegistrosEnviados;


		for (int i =0 ;i< resultado.size(); i+= numeroRegistros ) {


			int fin = Math.min(i + numeroRegistros, resultado.size());
			List<List<Object>> lote = resultado.subList(i, fin);

			List<List<String>> registrosString = lote.stream()
					.map(registro -> registro.subList(1, registro.size())
							.stream()
							.map(obj -> obj != null ? obj.toString() : null)
							.toList())
					.toList();


			recordDataDTO.setRecords(registrosString);
			totalRegistrosEnviados = lote.size();
			String respuesta = middlewareClient.llamadoAsyncUpdateCL(middlewareCLDTO, lineaNegocio);

			Long idRespuesta = registrarRespuesta(idTareaLinea, respuesta);

			for (List<Object> registro : lote) {

				Long id =  ((BigDecimal) registro.get(0)).longValue();

				registrarRespuestaListaContacto(idRespuesta, id);
			}

		}

		List<Long> listaId = envioLineaDAO.obtenerids(lineaNegocio);

		registrarBitacora(listaId,idTareaLinea);

		actualizarTarea(idTareaLinea, 4L);

		return middlewareCLDTO;

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
	public void registrarBitacora(List<Long> list, Long idTareaLinea) {
		for(Long id : list) {
			envioLineaDAO.insertarBitacoraListaContacto(id,idTareaLinea);
		}
	}

	public Long registrarRespuesta(Long idTareaLinea,String response) {
		RespuestaTareaLineaEntity respuestaTareaLineaEntity = new RespuestaTareaLineaEntity();

		JSONObject jsonObject = new JSONObject(response);

		String resquestId = jsonObject.getString("requestId");

		respuestaTareaLineaEntity.setDetalle(jsonObject.toString());
		respuestaTareaLineaEntity.setIdTareaLinea(idTareaLinea);
		respuestaTareaLineaEntity.setRequestId(resquestId);
		respuestaTareaLineaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		respuestaTareaLineaEntity.setTotalRegistros(totalRegistrosEnviados);

		return respuestaTareaLineaRepository.save(respuestaTareaLineaEntity).getIdRespuestaTareaLinea();
	}



	public void registrarRespuestaListaContacto(Long idRespuestaTarea,Long idListaContacto) {
		ListaContactoRespuestaEntity listaContactoRespuestaEntity = new ListaContactoRespuestaEntity();
		LlaveListaContactoRespuesta   llaveListaContactoRespuesta = new LlaveListaContactoRespuesta();

		llaveListaContactoRespuesta.setIdRespuestaTareaLinea(idRespuestaTarea);
		llaveListaContactoRespuesta.setIdListaContacto(idListaContacto);

		listaContactoRespuestaEntity.setLlaveListaContactoRespuesta(llaveListaContactoRespuesta);
		listaContactoRespuestaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());

		listaContactoRespuestaRepository.save(listaContactoRespuestaEntity);


	}
}
