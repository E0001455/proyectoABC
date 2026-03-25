package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.MapeoActividadLineaRepository;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.ActividadLineaRepository;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.ActividadLineaRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.LlaveActividadMapeoLinea;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;

@Service
public class ActividadLineaService {

	@Autowired
	public ActividadLineaRepository actividadLineaRepository;
	
	@Autowired
	public MapeoActividadLineaRepository mapeoActividadLineaRepository;

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;

	public Long  registrarActividadLinea(Long idLineaNegocio,ActividadLineaRequestDTO actividadLineaRequestDTO) {


		ActividadLineaEntity actividadLineaEntity = new ActividadLineaEntity();
		Long idTareaLinea = 0L;

		actividadLineaEntity.setIdUsuario(actividadLineaRequestDTO.getIdUsuario());
		actividadLineaEntity.setIdLineaNegocio(idLineaNegocio);
		actividadLineaEntity.setIdActividad(actividadLineaRequestDTO.getActividadDTO().getActividad().getIdActividad());
		actividadLineaEntity.setIdEjecucion(actividadLineaRequestDTO.getActividadDTO().getEjecucion().getIdEjecucion());
		actividadLineaEntity.setBolActivo(true);
		actividadLineaEntity.setFechaCreacion(new Date());
		actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
		actividadLineaEntity.setFechaUltModificacion(new Date());


		idTareaLinea=actividadLineaRepository.save(actividadLineaEntity).getIdActividadLinea();
		
		
		
		registrarMapeoActividad(idTareaLinea,actividadLineaRequestDTO.getActividadDTO().getMapeoDTO().getIdABCConfigMapeoLinea(),actividadLineaRequestDTO.getIdUsuario()); 
		



		return	idTareaLinea;	

	}


	public List<ActividadLineaResponseDTO>  consultarActividadesLinea(){
		List<ActividadLineaResponseDTO> actividadLineaResponseDTOLista = new ArrayList<ActividadLineaResponseDTO>();
		List<ActividadLineaEntity>  actividadLineaEntityLista= new ArrayList<ActividadLineaEntity>();

		actividadLineaEntityLista = actividadLineaRepository.findAll();


		if(!actividadLineaEntityLista.isEmpty()) {


			for(ActividadLineaEntity actividadLineaEntity: actividadLineaEntityLista) {
				ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();

				actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getIdActividadLinea());

				catLineaNegocio.setIdLineaNegocio(actividadLineaEntity.getIdLineaNegocio());
				actividadLineaResponseDTO.setCatLineaNegocio(catLineaNegocio);

				catActividad.setIdActividad(actividadLineaEntity.getIdActividad());
				actividadLineaResponseDTO.setCatActividad(catActividad);

				catEjecucion.setIdEjecucion(actividadLineaEntity.getIdEjecucion());
				actividadLineaResponseDTO.setCatEjecucion(catEjecucion);

				actividadLineaResponseDTO.setBolActivo(actividadLineaEntity.getBolActivo());
				actividadLineaResponseDTO.setFechaCreacion(actividadLineaEntity.getFechaCreacion());
				actividadLineaResponseDTO.setFechaUltModificacion(actividadLineaEntity.getFechaUltModificacion());
				
				ActividadMapeoLineaEntity actividadMapeoLineaEntity = new ActividadMapeoLineaEntity();

				actividadMapeoLineaEntity = mapeoActividadLineaRepository.findByLlaveActividadMapeoLinea_idActividadLinea(actividadLineaEntity.getIdActividadLinea());
				
				if(actividadMapeoLineaEntity== null) {
					continue;
				}
				
				MapeoDTO mapeoDTO = new MapeoDTO();
				mapeoDTO.setIdABCConfigMapeoLinea(actividadMapeoLineaEntity.getLlaveActividadMapeoLinea().getIdABCConfigMapeoLinea());
				Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoDTO.getIdABCConfigMapeoLinea());
				mapeoDTO.setNombre(abcConfigMapeoLineaEntityOptional.get().getNombre());
				actividadLineaResponseDTO.setMapeoDTO(mapeoDTO);

				actividadLineaResponseDTOLista.add(actividadLineaResponseDTO);


			}

		}


		return actividadLineaResponseDTOLista;

	}



	public ActividadLineaResponseDTO actualizarActividadLinea(ActividadLineaRequestDTO actividadLineaRequestDTO) {

		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(actividadLineaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();
			actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
			actividadLineaEntity.setIdActividad(actividadLineaRequestDTO.getActividadDTO().getActividad().getIdActividad());
			actividadLineaEntity.setIdEjecucion(actividadLineaRequestDTO.getActividadDTO().getEjecucion().getIdEjecucion());
			actividadLineaEntity.setFechaUltModificacion(new Date());

			actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
			actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getIdActividadLinea());


		}else {
			actividadLineaResponseDTO=null;
		}


		return actividadLineaResponseDTO;


	}


	public ActividadLineaResponseDTO activar(ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(actividadLineaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();

			if (!actividadLineaEntity.getBolActivo()) {
				actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadLineaEntity.setBolActivo(true);
				actividadLineaEntity.setFechaUltModificacion(new Date());
				actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getIdActividadLinea());
			}
		}

		return actividadLineaResponseDTO;
	}

	public ActividadLineaResponseDTO desactivar(ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(actividadLineaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();

			if (actividadLineaEntity.getBolActivo()) {
				actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadLineaEntity.setBolActivo(false);
				actividadLineaEntity.setFechaUltModificacion(new Date());
				actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getIdActividadLinea());
			}
		}

		return actividadLineaResponseDTO;
	}
	
	
	public void registrarMapeoActividad(Long idTareaLinea, Long idMapeoLinea,Long idUsuario) {
		
		ActividadMapeoLineaEntity actividadMapeoLineaEntity = new  ActividadMapeoLineaEntity();
		LlaveActividadMapeoLinea llaveActividadMapeoLinea = new LlaveActividadMapeoLinea();
		
		llaveActividadMapeoLinea.setIdABCConfigMapeoLinea(idMapeoLinea);
		llaveActividadMapeoLinea.setIdActividadLinea(idTareaLinea);
		
		actividadMapeoLineaEntity.setLlaveActividadMapeoLinea(llaveActividadMapeoLinea);
		actividadMapeoLineaEntity.setBolActivo(true);
		actividadMapeoLineaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		actividadMapeoLineaEntity.setFecCreacion(new Date());
		actividadMapeoLineaEntity.setFecUltModificacion(new Date());
		
		mapeoActividadLineaRepository.save(actividadMapeoLineaEntity);
		
		
		
		
		
	}
	
	




}
