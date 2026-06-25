package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.dto.ActividadDTO;
import mx.com.proyectohu.dto.ActividadDTO.Actividad;
import mx.com.proyectohu.dto.ActividadDTO.Ejecucion;
import mx.com.proyectohu.dto.ActividadEmpresaRequestDTO;
import mx.com.proyectohu.dto.ActividadEmpresaResponseDTO;
import mx.com.proyectohu.dto.ActividadEmpresaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.MapeoEmpresaDTO;
import mx.com.proyectohu.entity.ActividadEmpresaEntity;
import mx.com.proyectohu.entity.ActividadMapeoEmpresaEntity;
import mx.com.proyectohu.entity.LlaveActividadEmpresa;
import mx.com.proyectohu.entity.MapeoEmpresaEntity;
import mx.com.proyectohu.repository.ActividadEmpresaRepository;
import mx.com.proyectohu.repository.MapeoActividadEmpresaRepository;
import mx.com.proyectohu.repository.MapeoEmpresaRepository;

@Service
public class ActividadEmpresaService {

	@Autowired
	public ActividadEmpresaRepository actividadEmpresaRepository;

	@Autowired
	public MapeoActividadEmpresaRepository mapeoActividadEmpresaRepository;

	@Autowired
	public MapeoEmpresaRepository mapeoEmpresaRepository;

	public Long  registrarActividadEmpresa(ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		
		
		ActividadEmpresaEntity actividadEmpresaEntity =null;
		
		
	
		Long idActividadMapeoEmpresa = registrarMapeoActividad(actividadEmpresaRequestDTO.getMapeoEmpresaDTO().getIdMapeoEmpresa(),actividadEmpresaRequestDTO.getIdUsuario()); 

		for(ActividadDTO actividadDTO: actividadEmpresaRequestDTO.getActividadDTOlista() ) {
		
		 actividadEmpresaEntity = new ActividadEmpresaEntity();

		LlaveActividadEmpresa llaveActividadEmpresa = new LlaveActividadEmpresa();
		llaveActividadEmpresa.setIdActividadMapeoEmpresa(idActividadMapeoEmpresa);
		llaveActividadEmpresa.setIdActividad(actividadDTO.getActividad().getIdActividad());
		actividadEmpresaEntity.setLlaveActividadEmpresa(llaveActividadEmpresa);

		actividadEmpresaEntity.setIdUsuario(actividadEmpresaRequestDTO.getIdUsuario());
		actividadEmpresaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
		actividadEmpresaEntity.setBolActivo(true);
		actividadEmpresaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		actividadEmpresaEntity.setIdUsuarioUltModificacion(actividadEmpresaRequestDTO.getIdUsuario());
		actividadEmpresaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

		actividadEmpresaRepository.save(actividadEmpresaEntity).getIdUsuarioUltModificacion();
		}

		return	idActividadMapeoEmpresa;	

	}


	public List<ActividadEmpresaResponseDTO>  consultarActividadesEmpresa(){

		List<ActividadEmpresaResponseDTO> actividadEmpresaResponseDTOLista = new ArrayList<ActividadEmpresaResponseDTO>();
		List<ActividadMapeoEmpresaEntity>   actividadMapeoEmpresaEntityList = new ArrayList<ActividadMapeoEmpresaEntity>();

		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO=null;
		MapeoEmpresaDTO mapeoEmpresaDTO=null;
		List<ActividadDTO> actividadDTOLista= null;
		ActividadDTO actividadDTO=null;
		Actividad actividad =null;
		Ejecucion catEjecucion =null;
		List<ActividadEmpresaEntity> actividadEmpresaEntitylista =null;
		actividadMapeoEmpresaEntityList = mapeoActividadEmpresaRepository.findAllByOrderByIdMapeoEmpresa();
		Long mapeoEmpresa=0L;

		for(ActividadMapeoEmpresaEntity actividadMapeoEmpresaEntity :actividadMapeoEmpresaEntityList) {
			
			
		
			actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
			mapeoEmpresaDTO = new MapeoEmpresaDTO();
			mapeoEmpresaDTO.setIdMapeoEmpresa(actividadMapeoEmpresaEntity.getIdMapeoEmpresa());
			Optional<MapeoEmpresaEntity> abcConfigMapeoEmpresaEntityOptional = mapeoEmpresaRepository.findById(mapeoEmpresaDTO.getIdMapeoEmpresa());
			mapeoEmpresaDTO.setNombre(abcConfigMapeoEmpresaEntityOptional.get().getNombre());
			actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadMapeoEmpresaEntity.getIdActividadMapeoEmpresa());
			actividadEmpresaResponseDTO.setMapeoEmpresaDTO(mapeoEmpresaDTO);
			actividadEmpresaResponseDTO.setBolActivo(actividadMapeoEmpresaEntity.getBolActivo());
				
			actividadEmpresaResponseDTO.setFechaCreacion(actividadMapeoEmpresaEntity.getFecCreacion().getTime());
			actividadEmpresaResponseDTO.setFechaUltModificacion(actividadMapeoEmpresaEntity.getFecUltModificacion().getTime());
			actividadEmpresaResponseDTOLista.add(actividadEmpresaResponseDTO);
			
			
			
			actividadEmpresaEntitylista = actividadEmpresaRepository.findByLlaveActividadEmpresa_IdActividadMapeoEmpresa(actividadMapeoEmpresaEntity.getIdActividadMapeoEmpresa());

			if (!actividadEmpresaEntitylista.isEmpty()) {
				actividadDTOLista= new ArrayList<ActividadDTO>();
				
				for(ActividadEmpresaEntity actividadEmpresaEntity: actividadEmpresaEntitylista) {
				
					 actividadDTO = new ActividadDTO();
					 actividad = new Actividad();
					 catEjecucion=	 new Ejecucion();
					
					 catEjecucion.setIdEjecucion(actividadEmpresaEntity.getIdEjecucion());
					 actividadDTO.setEjecucion(catEjecucion);
					 
					actividad.setIdActividad(actividadEmpresaEntity.getLlaveActividadEmpresa().getIdActividad());
					actividadDTO.setActividad(actividad);
					actividadDTO.setActivo(actividadEmpresaEntity.getBolActivo());
					actividadDTO.setFechaCreacion(actividadEmpresaEntity.getFechaCreacion().getTime());
					actividadDTO.setFechaUltimaModificacion(actividadEmpresaEntity.getFechaUltModificacion().getTime());
					actividadDTOLista.add(actividadDTO);
					
				}
				
				

			}
			
			actividadEmpresaResponseDTO.setActividadDTOLista(actividadDTOLista);
			
		}		
		
			
			
			
		

		return actividadEmpresaResponseDTOLista;

	}


	
	public ActividadEmpresaResponseDTO actualizarActividadEmpresa(Long idActividadMapeo, ActividadesRequestDTO  actividadesRequestDTO) {

		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		LlaveActividadEmpresa llaveActividadEmpresa = new LlaveActividadEmpresa();
		
		
		for (ActividadDTO actividadDTO :    actividadesRequestDTO.getActividadDTOList()) {
		
		llaveActividadEmpresa.setIdActividadMapeoEmpresa(idActividadMapeo);
		llaveActividadEmpresa.setIdActividad(actividadDTO.getActividad().getIdActividad());
		
		
		Optional<ActividadEmpresaEntity> actividadEmpresaEntityOptional = actividadEmpresaRepository.findById(llaveActividadEmpresa);

		if (actividadEmpresaEntityOptional.isPresent()) {

			ActividadEmpresaEntity actividadEmpresaEntity = actividadEmpresaEntityOptional.get();
			actividadEmpresaEntity.setIdUsuarioUltModificacion(actividadesRequestDTO.getIdUsuario());
			llaveActividadEmpresa.setIdActividad(actividadDTO.getActividad().getIdActividad());
			actividadEmpresaEntity.setLlaveActividadEmpresa(llaveActividadEmpresa);
			actividadEmpresaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
			actividadEmpresaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

			actividadEmpresaEntity = actividadEmpresaRepository.save(actividadEmpresaEntity);
			actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadEmpresaEntity.getLlaveActividadEmpresa().getIdActividadMapeoEmpresa());


		}

	}
		return actividadEmpresaResponseDTO;
	}
	
	
	

	
	public ActividadEmpresaResponseDTO activarActividadMapeo(Long idActividadMapeo, ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();


		Optional<ActividadMapeoEmpresaEntity> actividadMapeoEmpresaEntityOptional= mapeoActividadEmpresaRepository.findById(idActividadMapeo);

		if (actividadMapeoEmpresaEntityOptional.isPresent()) {

			ActividadMapeoEmpresaEntity actividadMapeoEmpresaEntity = actividadMapeoEmpresaEntityOptional.get();

			if (!actividadMapeoEmpresaEntity.getBolActivo()) {
				actividadMapeoEmpresaEntity.setIdABCUsuarioUltModificacion(actividadEmpresaRequestDTO.getIdUsuario());
				actividadMapeoEmpresaEntity.setBolActivo(true);
				actividadMapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoEmpresaEntity = mapeoActividadEmpresaRepository.save(actividadMapeoEmpresaEntity);
				actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadMapeoEmpresaEntity.getIdActividadMapeoEmpresa());
			}
		}

		return actividadEmpresaResponseDTO;
	}
	
	
	
	public ActividadEmpresaResponseDTO desactivarActividadMapeo(Long idActividadMapeo, ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();


		Optional<ActividadMapeoEmpresaEntity> actividadMapeoEmpresaEntityOptional= mapeoActividadEmpresaRepository.findById(idActividadMapeo);

		if (actividadMapeoEmpresaEntityOptional.isPresent()) {

			ActividadMapeoEmpresaEntity actividadMapeoEmpresaEntity = actividadMapeoEmpresaEntityOptional.get();

			if (actividadMapeoEmpresaEntity.getBolActivo()) {
				actividadMapeoEmpresaEntity.setIdABCUsuarioUltModificacion(actividadEmpresaRequestDTO.getIdUsuario());
				actividadMapeoEmpresaEntity.setBolActivo(false);
				actividadMapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoEmpresaEntity = mapeoActividadEmpresaRepository.save(actividadMapeoEmpresaEntity);
				actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadMapeoEmpresaEntity.getIdActividadMapeoEmpresa());
			}
		}

		return actividadEmpresaResponseDTO;
	}


	public ActividadEmpresaResponseDTO activar(Long idActividadMapeo,Long idTipo, ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		
	LlaveActividadEmpresa llaveActividadEmpresa = new LlaveActividadEmpresa();
		
		
	
		llaveActividadEmpresa.setIdActividadMapeoEmpresa(idActividadMapeo);
		llaveActividadEmpresa.setIdActividad(idTipo);
		


		Optional<ActividadEmpresaEntity> actividadEmpresaEntityOptional = actividadEmpresaRepository.findById(llaveActividadEmpresa);

		if (actividadEmpresaEntityOptional.isPresent()) {

			ActividadEmpresaEntity actividadEmpresaEntity = actividadEmpresaEntityOptional.get();

			if (!actividadEmpresaEntity.getBolActivo()) {
				actividadEmpresaEntity.setIdUsuarioUltModificacion(actividadEmpresaRequestDTO.getIdUsuario());
				actividadEmpresaEntity.setBolActivo(true);
				actividadEmpresaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadEmpresaEntity = actividadEmpresaRepository.save(actividadEmpresaEntity);
				actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadEmpresaEntity.getLlaveActividadEmpresa().getIdActividadMapeoEmpresa());
			}
		}

		return actividadEmpresaResponseDTO;
	}

	public ActividadEmpresaResponseDTO desactivar(Long idActividadMapeo, Long idTipo, ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		LlaveActividadEmpresa llaveActividadEmpresa = new LlaveActividadEmpresa();
		
		
		
		llaveActividadEmpresa.setIdActividadMapeoEmpresa(idActividadMapeo);
		llaveActividadEmpresa.setIdActividad(idTipo);
		


		Optional<ActividadEmpresaEntity> actividadEmpresaEntityOptional = actividadEmpresaRepository.findById(llaveActividadEmpresa);


		if (actividadEmpresaEntityOptional.isPresent()) {

			ActividadEmpresaEntity actividadEmpresaEntity = actividadEmpresaEntityOptional.get();

			if (actividadEmpresaEntity.getBolActivo()) {
				actividadEmpresaEntity.setIdUsuarioUltModificacion(actividadEmpresaRequestDTO.getIdUsuario());
				actividadEmpresaEntity.setBolActivo(false);
				actividadEmpresaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadEmpresaEntity = actividadEmpresaRepository.save(actividadEmpresaEntity);
				actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadEmpresaEntity.getLlaveActividadEmpresa().getIdActividadMapeoEmpresa());
			}
		}

		return actividadEmpresaResponseDTO;
	}


	 
	public Long  registrarMapeoActividad(Long idMapeoEmpresa,Long idUsuario) {

		ActividadMapeoEmpresaEntity actividadMapeoEmpresaEntity = new  ActividadMapeoEmpresaEntity();
		actividadMapeoEmpresaEntity.setIdMapeoEmpresa(idMapeoEmpresa);
		actividadMapeoEmpresaEntity.setIdUsuario(idUsuario);
		actividadMapeoEmpresaEntity.setBolActivo(true);
		actividadMapeoEmpresaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		actividadMapeoEmpresaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		actividadMapeoEmpresaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

		return mapeoActividadEmpresaRepository.save(actividadMapeoEmpresaEntity).getIdActividadMapeoEmpresa();


	}





}
