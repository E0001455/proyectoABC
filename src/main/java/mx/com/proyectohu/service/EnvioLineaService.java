package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.EnvioLineaClient;
import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;


@Service
public class EnvioLineaService {


	@Autowired
	public EnvioLineaClient envioLineaClient;
	
	@Autowired
	public TareaLineaRepository  tareaLineaRepository;

	
	@Autowired
	public EnvioLineaDAO   envioLineaDAO;
	
	@Autowired
	public MiddlewareCLClient  middlewareClient;
	
	@Autowired
	public BitacoraTareaLineaRepository  bitacoraTareaLineaRepository;
	
	
	Integer totalregistros =0;
	
	
	public MiddlewareDTO ejecutarEnvioListaContacto(String lineaNegocio,  Long idTareaLinea) throws Exception {
		List<Map<String, Object>> datos = new ArrayList<Map<String, Object>>();
		
		List<String>  columnas = new ArrayList<String>();
		
		columnas = tareaLineaRepository.obtenerColumnasXidTarea(idTareaLinea);
		
		
		
		if (columnas.isEmpty()) {
			throw new Exception("lista de columnas vacia no se puede enviar informacion");
		}
		
		actualizarTarea(idTareaLinea, 2L);
		
		MiddlewareDTO middlewareDTO = new MiddlewareDTO();
		
		RecordDataDTO recordDataDTO = new RecordDataDTO();
		
		MergeRuleDTO mergeRuleDTO = new MergeRuleDTO();
		
		recordDataDTO.setFieldNames(columnas);
		
		datos= envioLineaDAO.obtenerDatosXColumnas(columnas);
		
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
		
		middlewareDTO.setRecordData(recordDataDTO);
		
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
		
	//	middlewareDTO.setMergeRule(mergeRuleDTO);
		
		middlewareClient.llamadoAsyncUpdateCL(middlewareDTO, lineaNegocio);
		
		actualizarTarea(idTareaLinea, 4L);
		
		return middlewareDTO;
		
	}
	
	public void actualizarTarea(Long idTareaLinea,Long estatus) {
		
		
		
		Optional<TareaLineaEntity> tareaLineaEntityOptional =  tareaLineaRepository.findById(idTareaLinea);
		
		if (tareaLineaEntityOptional.isPresent()) {
			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();
			
			tareaLineaEntity.setIdEstatusTarea(estatus);
			
			if (estatus==2) {
				tareaLineaEntity.setFdFechaInicio(new Date());
				}else {
					tareaLineaEntity.setFdFechaFin(new Date());
					tareaLineaEntity.setFinProcesados(totalregistros);
					tareaLineaEntity.setFinRegistros(totalregistros);
				}
			
			tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);
			
			
			
			BitacoraTareaLineaEntity bitacoraTareaLineaEntity = new  BitacoraTareaLineaEntity();
			
			bitacoraTareaLineaEntity.setIdTareaLinea(idTareaLinea);
			bitacoraTareaLineaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaLineaEntity.setFechaCreacion(new Date());
			
			if (estatus==2) {
			bitacoraTareaLineaEntity.setDetalle("EJECUCION DE ENVIO");
			}else {
				bitacoraTareaLineaEntity.setDetalle("COMPLETADA");
			}
			
			bitacoraTareaLineaEntity= bitacoraTareaLineaRepository.save(bitacoraTareaLineaEntity);
		}
		
		
	}
}
