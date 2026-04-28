package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.client.MiddlewarePETClient;
import mx.com.proyectohu.component.EnvioCampanaDAO;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.EstatusABCEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.BitacoraExtencionPerfilRepository;
import mx.com.proyectohu.repository.BitacoraTareaCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;


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
	public BitacoraExtencionPerfilRepository bitacoraExtencionPerfilRepository;
	
	
	Integer totalregistros =0;
	
	
	public MiddlewareDTO ejecutarEnvioExtensionPerfil(String lineaNegocio,  Long idTareaCampana) throws Exception {
		List<Map<String, Object>> datos = new ArrayList<Map<String, Object>>();
		List<String>  columnasNombreCorrecto = new ArrayList<String>();
		List<String>  columnas = new ArrayList<String>();
		
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
		
		MiddlewareDTO middlewareDTO = new MiddlewareDTO();
		
		RecordDataDTO recordDataDTO = new RecordDataDTO();
		
		MergeRuleDTO mergeRuleDTO = new MergeRuleDTO();
		
		recordDataDTO.setFieldNames(columnas);
		
		datos= envioCampanaDAO.obtenerDatosXColumnas(columnasNombreCorrecto);
		
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
		
		recordDataDTO.setMapTemplateName(null);
		
		middlewareDTO.setRecordData(recordDataDTO);
		
		
		middlewareDTO.setInsertOnNoMatch(true);
		middlewareDTO.setUpdateOnMatch("REPLACE_ALL");
		middlewareDTO.setMatchColumnName1("CUSTOMER_ID");
		middlewareDTO.setMatchColumnName2(null);
		
		
		
		
		middlewarePETClient.llamadoAsyncUpdatePET(middlewareDTO, lineaNegocio);

	List<Long> listaId = envioCampanaDAO.obtenerids();
		
		registrarBitacora(listaId);
		
		actualizarTarea(idTareaCampana, 4L);
		
		return middlewareDTO;
		
	}
	
	public void actualizarTarea(Long idTareaCampana,Long estatus) {
		
		
		
		Optional<TareaCampanaEntity> tareaCampanaEntityOptional =  tareaCampanaRepository.findById(idTareaCampana);
		
		if (tareaCampanaEntityOptional.isPresent()) {
			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();
			
			tareaCampanaEntity.setIdEstatusTarea(estatus);
			
			if (estatus==2) {
				tareaCampanaEntity.setFdFechaInicio(new Date());
				}else {
					tareaCampanaEntity.setFdFechaFin(new Date());
					tareaCampanaEntity.setFinProcesados(totalregistros);
					tareaCampanaEntity.setFinRegistros(totalregistros);
				}
			
			tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);
			
			
			
			BitacoraTareaCampanaEntity bitacoraTareaCampanaEntity = new  BitacoraTareaCampanaEntity();
			
			bitacoraTareaCampanaEntity.setIdTareaCampana(idTareaCampana);
			bitacoraTareaCampanaEntity.setIdEstatusTarea(estatus);
			bitacoraTareaCampanaEntity.setFechaCreacion(new Date());
			
			if (estatus==2) {
				bitacoraTareaCampanaEntity.setDetalle("EJECUCION DE ENVIO");
			}else {
				bitacoraTareaCampanaEntity.setDetalle("COMPLETADA");
			}
			
			bitacoraTareaCampanaEntity= bitacoraTareaCampanaRepository.save(bitacoraTareaCampanaEntity);
		}
	}
		
		
		public void registrarBitacora(List<Long> list) {
			
			
			BitacoraExtencionPerfilEntity bitacoraExtencionPerfilEntity = null;
			EstatusABCEntity estatusABCEntity=null;
			ExtensionPerfilEntity extensionPerfilEntity= null;
			
			
			for(Long id : list) {
				bitacoraExtencionPerfilEntity = new BitacoraExtencionPerfilEntity();
				 estatusABCEntity = new EstatusABCEntity(); 
				 envioCampanaDAO.insertarBitacoraExtensionPerfil(id);
				
				
			}
		
	}
}
