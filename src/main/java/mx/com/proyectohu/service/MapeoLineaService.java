package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.mapper.MapeoLineasMapper;

@Service
public class MapeoLineaService {

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;
	
	@Autowired
	public MapeoLineasMapper   mapeoLineasMapper;


	public Long  registrarLineaNegocio(Long idLineaNegocio,MapeoLineaRequestDTO mapeoLineaRequestDTO) {


		ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = new ABCConfigMapeoLineaEntity();
		Long idMapeoLineaNegocio = 0L;

		abcConfigMapeoLineaEntity.setIdABCUsuario(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setIdABCCatLineaNegocio(idLineaNegocio);
		abcConfigMapeoLineaEntity.setBolActivo(true);
		abcConfigMapeoLineaEntity.setNombre(mapeoLineaRequestDTO.getMapeoDTO().getNombre());
		abcConfigMapeoLineaEntity.setDescripcion(mapeoLineaRequestDTO.getMapeoDTO().getDescripcion());
		abcConfigMapeoLineaEntity.setBolDictaminacion(null);
		abcConfigMapeoLineaEntity.setFecCreacion(new Date());
		abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());


		idMapeoLineaNegocio=abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity).getIdABCConfigMapeoLinea();



		return	idMapeoLineaNegocio;	

	}
	
	public MapeoLineaResponseDTO consultarMapeoLinea(Long id) {
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
		
		Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(id);
		
		if (abcConfigMapeoLineaEntityOptional.isPresent()) {
			
			mapeoLineaResponseDTO = mapeoLineasMapper.llenarDTO(abcConfigMapeoLineaEntityOptional.get());
			
		}else {
			mapeoLineaResponseDTO = null;
		}
		

		return mapeoLineaResponseDTO;
	}
	
	
	public List<MapeoLineaResponseDTO>  consultarMapeosLinea(){
		List<MapeoLineaResponseDTO> mapeoLineaResponseDTOLista = new ArrayList<MapeoLineaResponseDTO>();
		
		
		List<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityLista = abcConfigMapeoLineaRepository.findAll(Sort.by(Sort.Direction.ASC,"idABCConfigMapeoLinea"));
		
		
		if(!abcConfigMapeoLineaEntityLista.isEmpty()) {
			
			for(ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity: abcConfigMapeoLineaEntityLista) {
				MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
				mapeoLineaResponseDTO = mapeoLineasMapper.llenarDTO(abcConfigMapeoLineaEntity);
				mapeoLineaResponseDTOLista.add(mapeoLineaResponseDTO);
				
				
			}
			
		}
		
		
		return mapeoLineaResponseDTOLista;
		
	}
	
	public MapeoLineaResponseDTO actualizarMapeoLinea(MapeoLineaRequestDTO mapeoLineaRequestDTO) {
	
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
	Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea());
	
	if (abcConfigMapeoLineaEntityOptional.isPresent()) {
		
		ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = abcConfigMapeoLineaEntityOptional.get();
		abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setNombre(mapeoLineaRequestDTO.getMapeoDTO().getNombre());
		abcConfigMapeoLineaEntity.setDescripcion(mapeoLineaRequestDTO.getMapeoDTO().getDescripcion());
		abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
		
		
		abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
		
		mapeoLineaResponseDTO = mapeoLineasMapper.llenarDTO(abcConfigMapeoLineaEntity);
		
	}else {
		mapeoLineaResponseDTO=null;
	}
	
		
	return mapeoLineaResponseDTO;
		
		
	}
	
	
public Boolean activar(MapeoLineaRequestDTO mapeoLineaRequestDTO) {
	Boolean activado= false;
	
	
	Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea());
	
	if (abcConfigMapeoLineaEntityOptional.isPresent()) {

		ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = abcConfigMapeoLineaEntityOptional.get();
		
		if (!abcConfigMapeoLineaEntity.getBolActivo()) {
		abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setBolActivo(true);
		abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
		abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
		activado=true;
		}
	}
	
	return activado;
}

public Boolean desactivar(MapeoLineaRequestDTO mapeoLineaRequestDTO) {
	Boolean desactivado= false;
	

	Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea());
	
	if (abcConfigMapeoLineaEntityOptional.isPresent()) {
		
		ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = abcConfigMapeoLineaEntityOptional.get();
		
		if (abcConfigMapeoLineaEntity.getBolActivo()) {
		abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setBolActivo(false);
		abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
		abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
		desactivado=true;
		}
	}
	
	return desactivado;
}
	
	
	

}
