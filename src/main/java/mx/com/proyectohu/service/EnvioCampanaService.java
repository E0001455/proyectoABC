package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.MiddlewareCLClient;
import mx.com.proyectohu.client.MiddlewarePETClient;
import mx.com.proyectohu.component.EnvioCampanaDAO;
import mx.com.proyectohu.dto.MergeRuleDTO;
import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;
import mx.com.proyectohu.dto.RecordDataDTO;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.EstatusABCEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.BitacoraExtencionPerfilRepository;
import mx.com.proyectohu.repository.BitacoraTareaCampanaRepository;
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
	public BitacoraExtencionPerfilRepository bitacoraExtencionPerfilRepository;
	
	
	Integer totalregistros =0;
	
	
	public MiddlewarePETDTO ejecutarEnvioExtensionPerfil(String lineaNegocio,  Long idTareaCampana) throws Exception {
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
		
		MiddlewarePETDTO middlewarePETDTO = new MiddlewarePETDTO();
		
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
		
		middlewarePETDTO.setRecordData(recordDataDTO);
		
		
		middlewarePETDTO.setInsertOnNoMatch(true);
		middlewarePETDTO.setUpdateOnMatch("REPLACE_ALL");
		middlewarePETDTO.setMatchColumnName1("CUSTOMER_ID");
		middlewarePETDTO.setMatchColumnName2(null);
		
		
		
		
		middlewarePETClient.llamadoAsyncUpdatePET(middlewarePETDTO, lineaNegocio);

	List<Long> listaId = envioCampanaDAO.obtenerids();
		
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
}
