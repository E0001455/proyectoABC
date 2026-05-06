package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
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
	
	
	Integer totalregistros =0;
	
	
	public MiddlewareCLDTO ejecutarEnvioListaContacto(String lineaNegocio,  Long idTareaLinea) throws Exception {
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
		
		datos= envioLineaDAO.obtenerDatosXColumnas(columnasNombreCorrecto);
		
		List<List<String>> resultado = new ArrayList<>();

		for (Map<String, Object> fila : datos) {
		    List<String> valores = new ArrayList<>();

		    for (Object valor : fila.values()) {
		        valores.add((String) valor);
		    }

		    resultado.add(valores);
		}
		
		
		
		recordDataDTO.setRecords(resultado);
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
		
		middlewareClient.llamadoAsyncUpdateCL(middlewareCLDTO, lineaNegocio);
		
			List<Long> listaId = envioLineaDAO.obtenerids();
		
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
}
