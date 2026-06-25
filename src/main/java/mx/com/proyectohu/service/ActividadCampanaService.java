package mx.com.proyectohu.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.MapeoActividadCampanaRepository;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;
import mx.com.proyectohu.repository.ActividadCampanaRepository;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadDTO;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio.CatCampana;
import mx.com.proyectohu.dto.ActividadDTO.Actividad;
import mx.com.proyectohu.dto.ActividadDTO.Ejecucion;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ActividadCampanaEntity;
import mx.com.proyectohu.entity.ActividadMapeoCampanaEntity;
import mx.com.proyectohu.entity.LlaveActividadCampana;

@Service
public class ActividadCampanaService {

	@Autowired
	public ActividadCampanaRepository actividadCampanaRepository;
	
	@Autowired
	public MapeoActividadCampanaRepository mapeoActividadCampanaRepository;
	
	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;


	public Long  registrarActividadCampana(ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		
		ActividadCampanaEntity actividadCampanaEntity =null;
	
		Long idActividadMapeoCampana = registrarMapeoActividad(actividadCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana(),actividadCampanaRequestDTO.getIdUsuario()); 

		for(ActividadDTO actividadDTO: actividadCampanaRequestDTO.getActividadDTOLista()) {
		
		 actividadCampanaEntity = new ActividadCampanaEntity();

		LlaveActividadCampana llaveActividadCampana = new LlaveActividadCampana();
		llaveActividadCampana.setIdActividadMapeoCampana(idActividadMapeoCampana);
		llaveActividadCampana.setIdActividad(actividadDTO.getActividad().getIdActividad());
		actividadCampanaEntity.setLlaveActividadCampana(llaveActividadCampana);

		actividadCampanaEntity.setIdUsuario(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
		actividadCampanaEntity.setBolActivo(true);
		actividadCampanaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

		actividadCampanaRepository.save(actividadCampanaEntity).getIdUsuarioUltModificacion();
		}

		return	idActividadMapeoCampana;	

	}


	public List<ActividadCampanaResponseDTO>  consultarActividadesCampana(){

		List<ActividadCampanaResponseDTO> actividadCampanaResponseDTOLista = new ArrayList<ActividadCampanaResponseDTO>();
		List<ActividadMapeoCampanaEntity>   actividadMapeoCampanaEntityList = new ArrayList<ActividadMapeoCampanaEntity>();

		ActividadCampanaResponseDTO actividadCampanaResponseDTO=null;
		MapeoCampanaDTO mapeoDTO=null;
		List<ActividadDTO> actividadDTOLista= null;
		ActividadDTO actividadDTO=null;
		Actividad actividad =null;
		Ejecucion catEjecucion =null;
		List<ActividadCampanaEntity> actividadCampanaEntitylista =null;
		actividadMapeoCampanaEntityList = mapeoActividadCampanaRepository.findAllByOrderByIdMapeoCampana();
		Long mapeoCampana=0L;

		for(ActividadMapeoCampanaEntity actividadMapeoCampanaEntity :actividadMapeoCampanaEntityList) {
			
			
		
			actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
			mapeoDTO = new MapeoCampanaDTO();
			mapeoDTO.setIdABCConfigMapeoCampana(actividadMapeoCampanaEntity.getIdMapeoCampana());
			Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoDTO.getIdABCConfigMapeoCampana());
			mapeoDTO.setNombre(abcConfigMapeoCampanaEntityOptional.get().getNombre());
			actividadCampanaResponseDTO.setIdActividadCampana(actividadMapeoCampanaEntity.getIdActividadMapeoCampana());
			actividadCampanaResponseDTO.setMapeoCampanaDTO(mapeoDTO);
			actividadCampanaResponseDTO.setBolActivo(actividadMapeoCampanaEntity.getBolActivo());
			CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
			catLineaNegocio.setIdLineaNegocio(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatLineaNegocio());
			
			CatCampana catCampana = new CatCampana();
			catCampana.setIdCampana(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatCampana());
			catLineaNegocio.setCatCampana(catCampana);
				
			
			actividadCampanaResponseDTO.setCatLineaNegocio(catLineaNegocio);
			actividadCampanaResponseDTO.setFechaCreacion(actividadMapeoCampanaEntity.getFecCreacion().getTime());
			actividadCampanaResponseDTO.setFechaUltModificacion(actividadMapeoCampanaEntity.getFecUltModificacion().getTime());
			actividadCampanaResponseDTOLista.add(actividadCampanaResponseDTO);
			
			
			
			actividadCampanaEntitylista = actividadCampanaRepository.findByLlaveActividadCampana_IdActividadMapeoCampana(actividadMapeoCampanaEntity.getIdActividadMapeoCampana());

			if (!actividadCampanaEntitylista.isEmpty()) {
				actividadDTOLista= new ArrayList<ActividadDTO>();
				
				for(ActividadCampanaEntity actividadCampanaEntity: actividadCampanaEntitylista) {
				
					 actividadDTO = new ActividadDTO();
					 actividad = new Actividad();
					 catEjecucion=	 new Ejecucion();
					
					 catEjecucion.setIdEjecucion(actividadCampanaEntity.getIdEjecucion());
					 actividadDTO.setEjecucion(catEjecucion);
					 
					actividad.setIdActividad(actividadCampanaEntity.getLlaveActividadCampana().getIdActividad());
					actividadDTO.setActividad(actividad);
					actividadDTO.setActivo(actividadCampanaEntity.getBolActivo());
					actividadDTO.setFechaCreacion(actividadCampanaEntity.getFechaCreacion().getTime());
					actividadDTO.setFechaUltimaModificacion(actividadCampanaEntity.getFechaUltModificacion().getTime());
					actividadDTOLista.add(actividadDTO);
					
				}
				
				

			}
			
		actividadCampanaResponseDTO.setActividadDTOLista(actividadDTOLista);
			
		}		
		
			
			
			
		

		return actividadCampanaResponseDTOLista;

	}


	
	public ActividadCampanaResponseDTO actualizarActividadCampana(Long idActividadMapeo, ActividadesRequestDTO  actividadesRequestDTO) {

		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		LlaveActividadCampana llaveActividadCampana = new LlaveActividadCampana();
		
		
		for (ActividadDTO actividadDTO :    actividadesRequestDTO.getActividadDTOList()) {
		
		llaveActividadCampana.setIdActividadMapeoCampana(idActividadMapeo);
		llaveActividadCampana.setIdActividad(actividadDTO.getActividad().getIdActividad());
		
		
		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(llaveActividadCampana);

		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();
			actividadCampanaEntity.setIdUsuarioUltModificacion(actividadesRequestDTO.getIdUsuario());
			llaveActividadCampana.setIdActividad(actividadDTO.getActividad().getIdActividad());
			actividadCampanaEntity.setLlaveActividadCampana(llaveActividadCampana);
			actividadCampanaEntity.setIdEjecucion(actividadDTO.getEjecucion().getIdEjecucion());
			actividadCampanaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());

			actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
			actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getLlaveActividadCampana().getIdActividadMapeoCampana());


		}

	}
		return actividadCampanaResponseDTO;
	}
	
	
	public ActividadCampanaResponseDTO activarActividadMapeo(Long idActividadMapeo, ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		Optional<ActividadMapeoCampanaEntity> actividadMapeoCampanaEntityOptional= mapeoActividadCampanaRepository.findById(idActividadMapeo);

		if (actividadMapeoCampanaEntityOptional.isPresent()) {

			ActividadMapeoCampanaEntity actividadMapeoCampanaEntity = actividadMapeoCampanaEntityOptional.get();

			if (!actividadMapeoCampanaEntity.getBolActivo()) {
				actividadMapeoCampanaEntity.setIdABCUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadMapeoCampanaEntity.setBolActivo(true);
				actividadMapeoCampanaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoCampanaEntity = mapeoActividadCampanaRepository.save(actividadMapeoCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadMapeoCampanaEntity.getIdActividadMapeoCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}
	
	
	
	public ActividadCampanaResponseDTO desactivarActividadMapeo(Long idActividadMapeo, ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		Optional<ActividadMapeoCampanaEntity> actividadMapeoCampanaEntityOptional= mapeoActividadCampanaRepository.findById(idActividadMapeo);

		if (actividadMapeoCampanaEntityOptional.isPresent()) {

			ActividadMapeoCampanaEntity actividadMapeoCampanaEntity = actividadMapeoCampanaEntityOptional.get();

			if (actividadMapeoCampanaEntity.getBolActivo()) {
				actividadMapeoCampanaEntity.setIdABCUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadMapeoCampanaEntity.setBolActivo(false);
				actividadMapeoCampanaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				actividadMapeoCampanaEntity = mapeoActividadCampanaRepository.save(actividadMapeoCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadMapeoCampanaEntity.getIdActividadMapeoCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}


	public ActividadCampanaResponseDTO activar(Long idActividadMapeo,Long idTipo, ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		
	LlaveActividadCampana llaveActividadCampana = new LlaveActividadCampana();
		
		
	
		llaveActividadCampana.setIdActividadMapeoCampana(idActividadMapeo);
		llaveActividadCampana.setIdActividad(idTipo);
		


		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(llaveActividadCampana);

		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();

			if (!actividadCampanaEntity.getBolActivo()) {
				actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadCampanaEntity.setBolActivo(true);
				actividadCampanaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getLlaveActividadCampana().getIdActividadMapeoCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}

	public ActividadCampanaResponseDTO desactivar(Long idActividadMapeo, Long idTipo, ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		LlaveActividadCampana llaveActividadCampana = new LlaveActividadCampana();
		
		
		
		llaveActividadCampana.setIdActividadMapeoCampana(idActividadMapeo);
		llaveActividadCampana.setIdActividad(idTipo);
		


		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(llaveActividadCampana);


		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();

			if (actividadCampanaEntity.getBolActivo()) {
				actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadCampanaEntity.setBolActivo(false);
				actividadCampanaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
				actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getLlaveActividadCampana().getIdActividadMapeoCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}


	 
	public Long  registrarMapeoActividad(Long idMapeoCampana,Long idUsuario) {

		ActividadMapeoCampanaEntity actividadMapeoCampanaEntity = new  ActividadMapeoCampanaEntity();
		actividadMapeoCampanaEntity.setIdMapeoCampana(idMapeoCampana);
		actividadMapeoCampanaEntity.setIdUsuario(idUsuario);
		actividadMapeoCampanaEntity.setBolActivo(true);
		actividadMapeoCampanaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		actividadMapeoCampanaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		actividadMapeoCampanaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

		return mapeoActividadCampanaRepository.save(actividadMapeoCampanaEntity).getIdActividadMapeoCampana();


	}

	


}
