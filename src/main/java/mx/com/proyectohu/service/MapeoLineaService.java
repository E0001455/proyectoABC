package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.mapper.MapeoLineasMapper;

@Service
public class MapeoLineaService {

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;

	


	public Long  registrarLineaNegocio(Long idLineaNegocio,MapeoLineaRequestDTO mapeoLineaRequestDTO) {


		ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = new ABCConfigMapeoLineaEntity();
		Long idMapeoLineaNegocio = 0L;

		abcConfigMapeoLineaEntity.setIdABCUsuario(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setIdABCCatLineaNegocio(idLineaNegocio);
		abcConfigMapeoLineaEntity.setBolActivo(true);
		abcConfigMapeoLineaEntity.setNombre(mapeoLineaRequestDTO.getMapeoDTO().getNombre());
		abcConfigMapeoLineaEntity.setDescripcion(mapeoLineaRequestDTO.getMapeoDTO().getDescripcion());
		abcConfigMapeoLineaEntity.setFecCreacion(new Date());
		abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
		abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
		abcConfigMapeoLineaEntity.setBolValidacion(mapeoLineaRequestDTO.getMapeoDTO().getBolValidacion());
		abcConfigMapeoLineaEntity.setBolEnvio(mapeoLineaRequestDTO.getMapeoDTO().getBolEnvio());
		abcConfigMapeoLineaEntity.setFiDictaminacion(mapeoLineaRequestDTO.getMapeoDTO().getFiDictaminacion());
		abcConfigMapeoLineaEntity.setFiPorcentajeError(mapeoLineaRequestDTO.getMapeoDTO().getFiPorcentajeError());


		idMapeoLineaNegocio=abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity).getIdABCConfigMapeoLinea();



		return	idMapeoLineaNegocio;	

	}


	public List<MapeoLineaResponseDTO>  consultarMapeosLinea(){
		List<MapeoLineaResponseDTO> mapeoLineaResponseDTOLista = new ArrayList<MapeoLineaResponseDTO>();


		List<MapeoLineaRecordDTO> mapeoLineaRecordDTOLista = abcConfigMapeoLineaRepository.consultarMapeoLineasColumnas();


		if(!mapeoLineaRecordDTOLista.isEmpty()) {

			for(MapeoLineaRecordDTO mapeoLineaRecordDTO: mapeoLineaRecordDTOLista) {
				MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
				CatLineaNegocio   catLineaNegocio   = new CatLineaNegocio();
				
				mapeoLineaResponseDTO.setIdABCConfigMapeoLinea( mapeoLineaRecordDTO.idABCConfigMapeoLinea() );
				catLineaNegocio.setIdABCConfigMapeoLinea(mapeoLineaRecordDTO.idABCCatLineaNegocio());
				mapeoLineaResponseDTO.setCatLineaNegocio(catLineaNegocio);
				mapeoLineaResponseDTO.setBolActivo(mapeoLineaRecordDTO.bolActivo());
				mapeoLineaResponseDTO.setNombre(mapeoLineaRecordDTO.nombre() );
				mapeoLineaResponseDTO.setDescripcion(mapeoLineaRecordDTO.descripcion() );
				mapeoLineaResponseDTO.setFecCreacion(mapeoLineaRecordDTO.fecCreacion() );
				mapeoLineaResponseDTO.setFecUltModificacion( mapeoLineaRecordDTO.fecUltModificacion() );
				mapeoLineaResponseDTO.setBolValidacion(mapeoLineaRecordDTO.bolValidacion());
				mapeoLineaResponseDTO.setBolEnvio(mapeoLineaRecordDTO.bolEnvio());
				mapeoLineaResponseDTO.setFiDictaminacion(mapeoLineaRecordDTO.fiDictaminacion());
				mapeoLineaResponseDTO.setFiPorcentajeError(mapeoLineaRecordDTO.fiPorcentajeError());
				mapeoLineaResponseDTO.setColumnas(mapeoLineaRecordDTO.columnas().intValue());
				
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
			abcConfigMapeoLineaEntity.setBolValidacion(mapeoLineaRequestDTO.getMapeoDTO().getBolValidacion());
			abcConfigMapeoLineaEntity.setBolEnvio(mapeoLineaRequestDTO.getMapeoDTO().getBolEnvio());
			abcConfigMapeoLineaEntity.setFiDictaminacion(mapeoLineaRequestDTO.getMapeoDTO().getFiDictaminacion());
			abcConfigMapeoLineaEntity.setFiPorcentajeError(mapeoLineaRequestDTO.getMapeoDTO().getFiPorcentajeError());
			
			abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
			mapeoLineaResponseDTO.setIdABCConfigMapeoLinea(abcConfigMapeoLineaEntity.getIdABCConfigMapeoLinea());


		}else {
			mapeoLineaResponseDTO=null;
		}


		return mapeoLineaResponseDTO;


	}


	public MapeoLineaResponseDTO activar(MapeoLineaRequestDTO mapeoLineaRequestDTO) {
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();


		Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea());

		if (abcConfigMapeoLineaEntityOptional.isPresent()) {

			ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = abcConfigMapeoLineaEntityOptional.get();

			if (!abcConfigMapeoLineaEntity.getBolActivo()) {
				abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
				abcConfigMapeoLineaEntity.setBolActivo(true);
				abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
				mapeoLineaResponseDTO.setIdABCConfigMapeoLinea(abcConfigMapeoLineaEntity.getIdABCConfigMapeoLinea());
			}
		}

		return mapeoLineaResponseDTO;
	}

	public MapeoLineaResponseDTO desactivar(MapeoLineaRequestDTO mapeoLineaRequestDTO) {
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();


		Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea());

		if (abcConfigMapeoLineaEntityOptional.isPresent()) {

			ABCConfigMapeoLineaEntity abcConfigMapeoLineaEntity = abcConfigMapeoLineaEntityOptional.get();

			if (abcConfigMapeoLineaEntity.getBolActivo()) {
				abcConfigMapeoLineaEntity.setIdABCUsuarioUltModificacion(mapeoLineaRequestDTO.getIdUsuario());
				abcConfigMapeoLineaEntity.setBolActivo(false);
				abcConfigMapeoLineaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoLineaEntity = abcConfigMapeoLineaRepository.save(abcConfigMapeoLineaEntity);
				mapeoLineaResponseDTO.setIdABCConfigMapeoLinea(abcConfigMapeoLineaEntity.getIdABCConfigMapeoLinea());
			}
		}

		return mapeoLineaResponseDTO;
	}




}
