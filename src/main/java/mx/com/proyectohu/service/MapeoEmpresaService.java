package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.MapeoEmpresaColumnaResponseDTO;
import mx.com.proyectohu.dto.MapeoEmpresaRequestDTO;
import mx.com.proyectohu.dto.MapeoEmpresaResponseDTO;
import mx.com.proyectohu.entity.MapeoEmpresaEntity;
import mx.com.proyectohu.repository.MapeoEmpresaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class MapeoEmpresaService {

	@Autowired
	public MapeoEmpresaRepository mapeoEmpresaRepository;

	@Autowired
	public MapeoEmpresaColumnaService mapeoEmpresaColumnaService;





	public Long  registrarEmpresa(MapeoEmpresaRequestDTO mapeoEmpresaRequestDTO) {


		MapeoEmpresaEntity mapeoEmpresaEntity = new MapeoEmpresaEntity();
		Long idMapeoEmpresa = 0L;

		mapeoEmpresaEntity.setIdUsuario(mapeoEmpresaRequestDTO.getIdUsuario());
		mapeoEmpresaEntity.setBolActivo(true);
		mapeoEmpresaEntity.setNombre(mapeoEmpresaRequestDTO.getMapeoEmpresaDTO().getNombre());
		mapeoEmpresaEntity.setDescripcion(mapeoEmpresaRequestDTO.getMapeoEmpresaDTO().getDescripcion());
		mapeoEmpresaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		mapeoEmpresaEntity.setIdUsuarioUltModificacion(mapeoEmpresaRequestDTO.getIdUsuario());
		mapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

		idMapeoEmpresa=mapeoEmpresaRepository.save(mapeoEmpresaEntity).getIdMapeoEmpresa();



		return	idMapeoEmpresa;	

	}


	public List<MapeoEmpresaResponseDTO>  consultarMapeosEmpresas(){
		List<MapeoEmpresaResponseDTO> mapeoEmpresaResponseDTOLista = new ArrayList<MapeoEmpresaResponseDTO>();


		List<MapeoEmpresaEntity> mapeoEmpresaEntityLista = mapeoEmpresaRepository.findAll();


		if(!mapeoEmpresaEntityLista.isEmpty()) {

			for(MapeoEmpresaEntity mapeoEmpresaEntity: mapeoEmpresaEntityLista) {
				MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();

				mapeoEmpresaResponseDTO.setIdMapeoEmpresa(mapeoEmpresaEntity.getIdMapeoEmpresa());
				mapeoEmpresaResponseDTO.setBolActivo(mapeoEmpresaEntity.getBolActivo());
				mapeoEmpresaResponseDTO.setNombre(mapeoEmpresaEntity.getNombre() );
				mapeoEmpresaResponseDTO.setDescripcion(mapeoEmpresaEntity.getDescripcion() );
				mapeoEmpresaResponseDTO.setFecCreacion(mapeoEmpresaEntity.getFecCreacion().getTime());
				mapeoEmpresaResponseDTO.setFecUltModificacion(mapeoEmpresaEntity.getFecUltModificacion().getTime());

				List<MapeoEmpresaColumnaResponseDTO> empresaColumnaResponseDTOLista = mapeoEmpresaColumnaService.consultarMapeoEmpresaColumna(mapeoEmpresaEntity.getIdMapeoEmpresa());
				if (!empresaColumnaResponseDTOLista.isEmpty()) {
					mapeoEmpresaResponseDTO.setColumnas(empresaColumnaResponseDTOLista.size());
				}else {
					mapeoEmpresaResponseDTO.setColumnas(0);
				}
				mapeoEmpresaResponseDTOLista.add(mapeoEmpresaResponseDTO);


			}

		}


		return mapeoEmpresaResponseDTOLista;

	}



	public MapeoEmpresaResponseDTO actualizarMapeoEmpresa(Long idMapeoEmpresa, MapeoEmpresaRequestDTO mapeoEmpresaRequestDTO) {

		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();
		Optional<MapeoEmpresaEntity> mapeoEmpresaEntityOptional = mapeoEmpresaRepository.findById(idMapeoEmpresa);

		if (mapeoEmpresaEntityOptional.isPresent()) {

			MapeoEmpresaEntity mapeoEmpresaEntity = mapeoEmpresaEntityOptional.get();


			mapeoEmpresaEntity.setNombre(mapeoEmpresaRequestDTO.getMapeoEmpresaDTO().getNombre());
			mapeoEmpresaEntity.setDescripcion(mapeoEmpresaRequestDTO.getMapeoEmpresaDTO().getDescripcion());
			mapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
			mapeoEmpresaEntity.setIdUsuarioUltModificacion(mapeoEmpresaRequestDTO.getIdUsuario());


			mapeoEmpresaEntity = mapeoEmpresaRepository.save(mapeoEmpresaEntity);
			mapeoEmpresaResponseDTO.setIdMapeoEmpresa(mapeoEmpresaEntity.getIdMapeoEmpresa());


		}else {
			mapeoEmpresaResponseDTO=null;
		}


		return mapeoEmpresaResponseDTO;


	}


	public MapeoEmpresaResponseDTO activar(Long idMapeoEmpresa) {
		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();


		Optional<MapeoEmpresaEntity> mapeoEmpresaEntityOptional = mapeoEmpresaRepository.findById(idMapeoEmpresa);

		if (mapeoEmpresaEntityOptional.isPresent()) {

			MapeoEmpresaEntity mapeoEmpresaEntity = mapeoEmpresaEntityOptional.get();

			if (!mapeoEmpresaEntity.getBolActivo()) {
				mapeoEmpresaEntity.setIdUsuarioUltModificacion(mapeoEmpresaEntity.getIdUsuario());
				mapeoEmpresaEntity.setBolActivo(true);
				mapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				mapeoEmpresaEntity = mapeoEmpresaRepository.save(mapeoEmpresaEntity);
				mapeoEmpresaResponseDTO.setIdMapeoEmpresa(mapeoEmpresaEntity.getIdMapeoEmpresa());
			}
		}

		return mapeoEmpresaResponseDTO;
	}

	public MapeoEmpresaResponseDTO desactivar(Long idMapeoEmpresa) {
		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();


		Optional<MapeoEmpresaEntity> mapeoEmpresaEntityOptional = mapeoEmpresaRepository.findById(idMapeoEmpresa);

		if (mapeoEmpresaEntityOptional.isPresent()) {

			MapeoEmpresaEntity mapeoEmpresaEntity = mapeoEmpresaEntityOptional.get();

			if (mapeoEmpresaEntity.getBolActivo()) {
				mapeoEmpresaEntity.setIdUsuarioUltModificacion(mapeoEmpresaEntity.getIdUsuario());
				mapeoEmpresaEntity.setBolActivo(false);
				mapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				mapeoEmpresaEntity = mapeoEmpresaRepository.save(mapeoEmpresaEntity);
				mapeoEmpresaResponseDTO.setIdMapeoEmpresa(mapeoEmpresaEntity.getIdMapeoEmpresa());
			}
		}

		return mapeoEmpresaResponseDTO;
	}




}
