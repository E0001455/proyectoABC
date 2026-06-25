package mx.com.proyectohu.service;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.client.MiddlewarePETClient;
import mx.com.proyectohu.component.EnvioCampanaDAO;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ActividadMapeoCampanaEntity;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.EstatusABCEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.ExtensionPerfilRespuestaEntity;
import mx.com.proyectohu.entity.ListaContactoRespuestaEntity;
import mx.com.proyectohu.entity.LlaveExtensionPerfilRespuesta;
import mx.com.proyectohu.entity.LlaveListaContactoRespuesta;
import mx.com.proyectohu.entity.RespuestaTareaCampanaEntity;
import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;
import mx.com.proyectohu.repository.BitacoraExtencionPerfilRepository;
import mx.com.proyectohu.repository.BitacoraTareaCampanaRepository;
import mx.com.proyectohu.repository.ExtensionPerfilRespuestaRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.MapeoActividadCampanaRepository;
import mx.com.proyectohu.repository.RespuestaTareaCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class EnvioCampanaService {

	@Autowired
	public MiddlewarePETClient  middlewarePETClient;

	@Autowired
	public TareaCampanaRepository  tareaCampanaRepository;

	@Autowired
	public EnvioCampanaDAO envioCampanaDAO;

	@Autowired
	public BitacoraTareaCampanaRepository bitacoraTareaCampanaRepository;

	@Autowired
	public  RespuestaTareaCampanaRepository respuestaTareaCampanaRepository;
	
	@Autowired
	public ExtensionPerfilRespuestaRepository extensionPerfilRespuestaRepository;

	@Value("${numero.registros.enviados.campana}")
	public Integer numeroRegistrosEnviados;

	Integer totalregistros =0;
	
	Integer totalRegistrosEnviados = 0;
	
	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;


	@Autowired
	public MapeoActividadCampanaRepository mapeoActividadCampanaRepository;
	
	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;
	
	
	public MiddlewarePETDTO ejecutarEnvioExtensionPerfil(Long idTareaCampana) throws Exception {
		List<Map<String, Object>> datos = new ArrayList<Map<String, Object>>();
		List<String>  columnasNombreCorrecto = new ArrayList<String>();
		List<String>  columnas = new ArrayList<String>();
		
		TareaCampanaEntity tareaCampanaEntity = new TareaCampanaEntity(); 

		tareaCampanaEntity = tareaCampanaRepository.findById(idTareaCampana).get();

		ActividadMapeoCampanaEntity actividadMapeoCampanaEntity=mapeoActividadCampanaRepository.findById(tareaCampanaEntity.getIdActividadMapeoCampana()).get();

		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(actividadMapeoCampanaEntity.getIdMapeoCampana());

		String lineaNegocio = lineaNegocioRepository.findById(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatLineaNegocio()).get().getNombre();
		

		columnas = tareaCampanaRepository.obtenerColumnasXidTarea(idTareaCampana);


		if (columnas.isEmpty()) {
			throw new Exception("lista de columnas vacia no se puede enviar informacion");
		}

		for(String columna : columnas ) {
			if (!columna.contains("FC")) {
				columna="FC"+columna;
			}

			columnasNombreCorrecto.add(columna);

		}

		actualizarTarea(idTareaCampana, 2L);

		MiddlewarePETDTO middlewarePETDTO = new MiddlewarePETDTO();

		RecordDataDTO recordDataDTO = new RecordDataDTO();

		MergeRuleDTO mergeRuleDTO = new MergeRuleDTO();

		recordDataDTO.setFieldNames(columnas);

		datos= envioCampanaDAO.obtenerDatosXColumnas(columnasNombreCorrecto,lineaNegocio);

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

		recordDataDTO.setMapTemplateName(null);

		middlewarePETDTO.setRecordData(recordDataDTO);

		middlewarePETDTO.setInsertOnNoMatch(true);
		middlewarePETDTO.setUpdateOnMatch("REPLACE_ALL");
		middlewarePETDTO.setMatchColumnName1("CUSTOMER_ID");
		middlewarePETDTO.setMatchColumnName2(null);

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
			String respuesta = middlewarePETClient.llamadoAsyncUpdatePET(middlewarePETDTO, lineaNegocio);

			Long idRespuesta = registrarRespuesta(idTareaCampana, respuesta);


			for (List<Object> registro : lote) {

				Long id =  ((BigDecimal) registro.get(0)).longValue();

				registrarRespuestaExtensionPerfil(idRespuesta, id);
			}


		}

		List<Long> listaId = envioCampanaDAO.obtenerids(lineaNegocio);

		registrarBitacora(listaId,idTareaCampana);

		actualizarTarea(idTareaCampana, 4L);

		return middlewarePETDTO;

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
			}

			tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);

			BitacoraTareaCampanaEntity bitacoraTareaCampanaEntity = new  BitacoraTareaCampanaEntity();

			bitacoraTareaCampanaEntity.setIdTareaCampana(idTareaCampana);
			bitacoraTareaCampanaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaCampanaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());

			if (estatus==2) {
				bitacoraTareaCampanaEntity.setDetalle("EJECUCION DE ENVIO");
			}else {
				bitacoraTareaCampanaEntity.setDetalle("COMPLETADA");
			}

			bitacoraTareaCampanaEntity= bitacoraTareaCampanaRepository.save(bitacoraTareaCampanaEntity);
		}
	}
	public void registrarBitacora(List<Long> list, Long idTareaCampana) {
		for(Long id : list) {
			envioCampanaDAO.insertarBitacoraExtensionPerfil(id,idTareaCampana);
		}
	}

	public Long registrarRespuesta(Long idTareaCampana,String response) {
		RespuestaTareaCampanaEntity respuestaTareaCampanaEntity = new RespuestaTareaCampanaEntity();

		JSONObject jsonObject = new JSONObject(response);

		String resquestId = jsonObject.getString("requestId");

		respuestaTareaCampanaEntity.setDetalle(jsonObject.toString());
		respuestaTareaCampanaEntity.setIdTareaCampana(idTareaCampana);
		respuestaTareaCampanaEntity.setRequestId(resquestId);
		respuestaTareaCampanaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		respuestaTareaCampanaEntity.setTotalRegistros(totalRegistrosEnviados);

		return respuestaTareaCampanaRepository.save(respuestaTareaCampanaEntity).getIdRespuestaTareaCampana();

	}
	
	public void registrarRespuestaExtensionPerfil(Long idRespuestaTarea,Long idExtensionPerfil) {
		ExtensionPerfilRespuestaEntity extensionPerfilRespuestaEntity = new ExtensionPerfilRespuestaEntity();
		LlaveExtensionPerfilRespuesta   llaveExtensionPerfilRespuesta = new LlaveExtensionPerfilRespuesta();

		llaveExtensionPerfilRespuesta.setIdRespuestaTareaCampana(idRespuestaTarea);
		llaveExtensionPerfilRespuesta.setIdExtensionPerfil(idExtensionPerfil);

		extensionPerfilRespuestaEntity.setLlaveExtensionPerfilRespuesta(llaveExtensionPerfilRespuesta);
		extensionPerfilRespuestaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());

		extensionPerfilRespuestaRepository.save(extensionPerfilRespuestaEntity);


	}
}
