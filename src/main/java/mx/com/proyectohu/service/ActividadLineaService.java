package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.MapeoActividadLineaRepository;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.ActividadLineaRepository;
import mx.com.proyectohu.dto.ActividadDTO;
import mx.com.proyectohu.dto.ActividadDTO.Actividad;
import mx.com.proyectohu.dto.ActividadDTO.Ejecucion;
import mx.com.proyectohu.dto.ActividadLineaRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;
import mx.com.proyectohu.entity.LlaveActividadLinea;

@Service
public class ActividadLineaService {

	@Autowired
	public ActividadLineaRepository actividadLineaRepository;

	@Autowired
	public MapeoActividadLineaRepository mapeoActividadLineaRepository;

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;

	public Long  registrarActividadLinea(ActividadLineaRequestDTO actividadLineaRequestDTO) {
		
		
		ActividadLineaEntity actividadLineaEntity =null;
		
		
	
		Long idActividadMapeoLinea = registrarMapeoActividad(actividadLineaRequestDTO.getMapeoDTO().getIdABCConfigMapeoLinea(),actividadLineaRequestDTO.getIdUsuario()); 

		for(ActividadDTO actividadDTO: actividadLineaRequestDTO.getActividadDTOlista() ) {
		
		 actividadLineaEntity = new ActividadLineaEntity();

		LlaveActividadLinea llaveActividadLinea = new LlaveActividadLinea();
		llaveActividadLinea.setIdActividadMapeoLinea(idActividadMapeoLinea);
		llaveActividadLinea.setIdActividad(actividadDTO.getActividad().getIdActividad());
		actividadLineaEntity.setLlaveActividadLinea(llaveActividadLinea);

		actividadLineaEntity.setIdUsuario(actividadLineaRequestDTO.getIdUsuario());
		actividadLineaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
		actividadLineaEntity.setBolActivo(true);
		actividadLineaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
		actividadLineaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

		actividadLineaRepository.save(actividadLineaEntity).getIdUsuarioUltModificacion();
		}

		return	idActividadMapeoLinea;	

	}


	public List<ActividadLineaResponseDTO>  consultarActividadesLinea(){

		List<ActividadLineaResponseDTO> actividadLineaResponseDTOLista = new ArrayList<ActividadLineaResponseDTO>();
		List<ActividadMapeoLineaEntity>   actividadMapeoLineaEntityList = new ArrayList<ActividadMapeoLineaEntity>();

		ActividadLineaResponseDTO actividadLineaResponseDTO=null;
		MapeoDTO mapeoDTO=null;
		List<ActividadDTO> actividadDTOLista= null;
		ActividadDTO actividadDTO=null;
		Actividad actividad =null;
		Ejecucion catEjecucion =null;
		List<ActividadLineaEntity> actividadLineaEntitylista =null;
		actividadMapeoLineaEntityList = mapeoActividadLineaRepository.findAllByOrderByIdMapeoLinea();
		Long mapeolinea=0L;

		for(ActividadMapeoLineaEntity actividadMapeoLineaEntity :actividadMapeoLineaEntityList) {
			
			
		
			actividadLineaResponseDTO = new ActividadLineaResponseDTO();
			mapeoDTO = new MapeoDTO();
			mapeoDTO.setIdABCConfigMapeoLinea(actividadMapeoLineaEntity.getIdMapeoLinea());
			Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(mapeoDTO.getIdABCConfigMapeoLinea());
			mapeoDTO.setNombre(abcConfigMapeoLineaEntityOptional.get().getNombre());
			actividadLineaResponseDTO.setIdActividadLinea(actividadMapeoLineaEntity.getIdActividadMapeoLinea());
			actividadLineaResponseDTO.setMapeoDTO(mapeoDTO);
			actividadLineaResponseDTO.setBolActivo(actividadMapeoLineaEntity.getBolActivo());
			CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
			catLineaNegocio.setIdLineaNegocio(abcConfigMapeoLineaEntityOptional.get().getIdABCCatLineaNegocio());
			actividadLineaResponseDTO.setCatLineaNegocio(catLineaNegocio);
			actividadLineaResponseDTO.setFechaCreacion(actividadMapeoLineaEntity.getFecCreacion().getTime());
			actividadLineaResponseDTO.setFechaUltModificacion(actividadMapeoLineaEntity.getFecUltModificacion().getTime());
			actividadLineaResponseDTOLista.add(actividadLineaResponseDTO);
			
			
			
			actividadLineaEntitylista = actividadLineaRepository.findByLlaveActividadLinea_IdActividadMapeoLinea(actividadMapeoLineaEntity.getIdActividadMapeoLinea());

			if (!actividadLineaEntitylista.isEmpty()) {
				actividadDTOLista= new ArrayList<ActividadDTO>();
				
				for(ActividadLineaEntity actividadLineaEntity: actividadLineaEntitylista) {
				
					 actividadDTO = new ActividadDTO();
					 actividad = new Actividad();
					 catEjecucion=	 new Ejecucion();
					
					 catEjecucion.setIdEjecucion(actividadLineaEntity.getIdEjecucion());
					 actividadDTO.setEjecucion(catEjecucion);
					 
					actividad.setIdActividad(actividadLineaEntity.getLlaveActividadLinea().getIdActividad());
					actividadDTO.setActividad(actividad);
					actividadDTO.setActivo(actividadLineaEntity.getBolActivo());
					actividadDTO.setFechaCreacion(actividadLineaEntity.getFechaCreacion().getTime());
					actividadDTO.setFechaUltimaModificacion(actividadLineaEntity.getFechaUltModificacion().getTime());
					actividadDTOLista.add(actividadDTO);
					
				}
				
				

			}
			
			actividadLineaResponseDTO.setActividadDTOLista(actividadDTOLista);
			
		}		
		
			
			
			
		

		return actividadLineaResponseDTOLista;

	}


	
	public ActividadLineaResponseDTO actualizarActividadLinea(Long idActividadMapeo, ActividadesRequestDTO  actividadesRequestDTO) {

		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		LlaveActividadLinea llaveActividadLinea = new LlaveActividadLinea();
		
		
		for (ActividadDTO actividadDTO :    actividadesRequestDTO.getActividadDTOList()) {
		
		llaveActividadLinea.setIdActividadMapeoLinea(idActividadMapeo);
		llaveActividadLinea.setIdActividad(actividadDTO.getActividad().getIdActividad());
		
		
		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(llaveActividadLinea);

		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();
			actividadLineaEntity.setIdUsuarioUltModificacion(actividadesRequestDTO.getIdUsuario());
			llaveActividadLinea.setIdActividad(actividadDTO.getActividad().getIdActividad());
			actividadLineaEntity.setLlaveActividadLinea(llaveActividadLinea);
			actividadLineaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
			actividadLineaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

			actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
			actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getLlaveActividadLinea().getIdActividadMapeoLinea());


		}

	}
		return actividadLineaResponseDTO;
	}
	
	
	

	
	public ActividadLineaResponseDTO activarActividadMapeo(Long idActividadMapeo, ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		Optional<ActividadMapeoLineaEntity> actividadMapeoLineaEntityOptional= mapeoActividadLineaRepository.findById(idActividadMapeo);

		if (actividadMapeoLineaEntityOptional.isPresent()) {

			ActividadMapeoLineaEntity actividadMapeoLineaEntity = actividadMapeoLineaEntityOptional.get();

			if (!actividadMapeoLineaEntity.getBolActivo()) {
				actividadMapeoLineaEntity.setIdABCUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadMapeoLineaEntity.setBolActivo(true);
				actividadMapeoLineaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoLineaEntity = mapeoActividadLineaRepository.save(actividadMapeoLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadMapeoLineaEntity.getIdActividadMapeoLinea());
			}
		}

		return actividadLineaResponseDTO;
	}
	
	
	
	public ActividadLineaResponseDTO desactivarActividadMapeo(Long idActividadMapeo, ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		Optional<ActividadMapeoLineaEntity> actividadMapeoLineaEntityOptional= mapeoActividadLineaRepository.findById(idActividadMapeo);

		if (actividadMapeoLineaEntityOptional.isPresent()) {

			ActividadMapeoLineaEntity actividadMapeoLineaEntity = actividadMapeoLineaEntityOptional.get();

			if (actividadMapeoLineaEntity.getBolActivo()) {
				actividadMapeoLineaEntity.setIdABCUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadMapeoLineaEntity.setBolActivo(false);
				actividadMapeoLineaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoLineaEntity = mapeoActividadLineaRepository.save(actividadMapeoLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadMapeoLineaEntity.getIdActividadMapeoLinea());
			}
		}

		return actividadLineaResponseDTO;
	}


	public ActividadLineaResponseDTO activar(Long idActividadMapeo,Long idTipo, ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		
	LlaveActividadLinea llaveActividadLinea = new LlaveActividadLinea();
		
		
	
		llaveActividadLinea.setIdActividadMapeoLinea(idActividadMapeo);
		llaveActividadLinea.setIdActividad(idTipo);
		


		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(llaveActividadLinea);

		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();

			if (!actividadLineaEntity.getBolActivo()) {
				actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadLineaEntity.setBolActivo(true);
				actividadLineaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getLlaveActividadLinea().getIdActividadMapeoLinea());
			}
		}

		return actividadLineaResponseDTO;
	}

	public ActividadLineaResponseDTO desactivar(Long idActividadMapeo, Long idTipo, ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		LlaveActividadLinea llaveActividadLinea = new LlaveActividadLinea();
		
		
		
		llaveActividadLinea.setIdActividadMapeoLinea(idActividadMapeo);
		llaveActividadLinea.setIdActividad(idTipo);
		


		Optional<ActividadLineaEntity> actividadLineaEntityOptional = actividadLineaRepository.findById(llaveActividadLinea);


		if (actividadLineaEntityOptional.isPresent()) {

			ActividadLineaEntity actividadLineaEntity = actividadLineaEntityOptional.get();

			if (actividadLineaEntity.getBolActivo()) {
				actividadLineaEntity.setIdUsuarioUltModificacion(actividadLineaRequestDTO.getIdUsuario());
				actividadLineaEntity.setBolActivo(false);
				actividadLineaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadLineaEntity = actividadLineaRepository.save(actividadLineaEntity);
				actividadLineaResponseDTO.setIdActividadLinea(actividadLineaEntity.getLlaveActividadLinea().getIdActividadMapeoLinea());
			}
		}

		return actividadLineaResponseDTO;
	}


	 
	public Long  registrarMapeoActividad(Long idMapeoLinea,Long idUsuario) {

		ActividadMapeoLineaEntity actividadMapeoLineaEntity = new  ActividadMapeoLineaEntity();
		actividadMapeoLineaEntity.setIdMapeoLinea(idMapeoLinea);
		actividadMapeoLineaEntity.setIdUsuario(idUsuario);
		actividadMapeoLineaEntity.setBolActivo(true);
		actividadMapeoLineaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		actividadMapeoLineaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		actividadMapeoLineaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

		return mapeoActividadLineaRepository.save(actividadMapeoLineaEntity).getIdActividadMapeoLinea();


	}





}
