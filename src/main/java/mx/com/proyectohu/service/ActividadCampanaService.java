package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.MapeoActividadCampanaRepository;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;
import mx.com.proyectohu.repository.ActividadCampanaRepository;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio.CatCampana;
import mx.com.proyectohu.entity.LlaveActividadMapeoCampana;
import mx.com.proyectohu.entity.LlaveActividadMapeoLinea;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ActividadCampanaEntity;
import mx.com.proyectohu.entity.ActividadMapeoCampanaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;

@Service
public class ActividadCampanaService {

	@Autowired
	public ActividadCampanaRepository actividadCampanaRepository;
	
	@Autowired
	public MapeoActividadCampanaRepository mapeoActividadCampanaRepository;
	
	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;



	public Long  registrarActividadCampana(Long idLinea, Long idCampana,ActividadCampanaRequestDTO actividadCampanaRequestDTO) {


		ActividadCampanaEntity actividadCampanaEntity = new ActividadCampanaEntity();
		Long idTareaCampana = 0L;

		actividadCampanaEntity.setIdUsuario(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setIdLineaNegocio(idLinea);
		actividadCampanaEntity.setIdCampana(idCampana);
		actividadCampanaEntity.setIdActividad(actividadCampanaRequestDTO.getActividadDTO().getActividad().getIdActividad());
		actividadCampanaEntity.setIdEjecucion(actividadCampanaRequestDTO.getActividadDTO().getEjecucion().getIdEjecucion());
		actividadCampanaEntity.setBolActivo(true);
		actividadCampanaEntity.setFechaCreacion(new Date());
		actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setFechaUltModificacion(new Date());


		idTareaCampana=actividadCampanaRepository.save(actividadCampanaEntity).getIdActividadCampana();

		registrarMapeoActividad(idTareaCampana,actividadCampanaRequestDTO.getActividadDTO().getMapeoDTO().getIdABCConfigMapeoLinea(),actividadCampanaRequestDTO.getIdUsuario()); 


		return	idTareaCampana;	

	}


	public List<ActividadCampanaResponseDTO>  consultarActividadesCampana(){
		List<ActividadCampanaResponseDTO> actividadCampanaResponseDTOLista = new ArrayList<ActividadCampanaResponseDTO>();
		List<ActividadCampanaEntity>  actividadCampanaEntityLista= new ArrayList<ActividadCampanaEntity>();

		actividadCampanaEntityLista = actividadCampanaRepository.findAll();


		if(!actividadCampanaEntityLista.isEmpty()) {


			for(ActividadCampanaEntity actividadCampanaEntity: actividadCampanaEntityLista) {
				ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();
				CatCampana catCampana = new CatCampana();
				
				

				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getIdActividadCampana());

				catCampana.setIdCampana(actividadCampanaEntity.getIdCampana());
				catLineaNegocio.setIdLineaNegocio(actividadCampanaEntity.getIdLineaNegocio());
				catLineaNegocio.setCatCampana(catCampana);
				actividadCampanaResponseDTO.setCatLineaNegocio(catLineaNegocio);

				catActividad.setIdActividad(actividadCampanaEntity.getIdActividad());
				actividadCampanaResponseDTO.setCatActividad(catActividad);

				catEjecucion.setIdEjecucion(actividadCampanaEntity.getIdEjecucion());
				actividadCampanaResponseDTO.setCatEjecucion(catEjecucion);

				actividadCampanaResponseDTO.setBolActivo(actividadCampanaEntity.getBolActivo());
				actividadCampanaResponseDTO.setFechaCreacion(actividadCampanaEntity.getFechaCreacion());
				actividadCampanaResponseDTO.setFechaUltModificacion(actividadCampanaEntity.getFechaUltModificacion());
				
				ActividadMapeoCampanaEntity actividadMapeoCampanaEntity = new ActividadMapeoCampanaEntity();

				actividadMapeoCampanaEntity = mapeoActividadCampanaRepository.findByLlaveActividadMapeoCampana_idActividadCampana(actividadCampanaResponseDTO.getIdActividadCampana());
				
				if(actividadMapeoCampanaEntity== null) {
					continue;
				}
				
				MapeoDTO mapeoDTO = new MapeoDTO();
				mapeoDTO.setIdABCConfigMapeoLinea(actividadMapeoCampanaEntity.getLlaveActividadMapeoCampana().getIdABCConfigMapeoCampana());
			
				Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(actividadMapeoCampanaEntity.getLlaveActividadMapeoCampana().getIdABCConfigMapeoCampana());
				mapeoDTO.setNombre(abcConfigMapeoCampanaEntityOptional.get().getNombre());
				
				actividadCampanaResponseDTO.setMapeoDTO(mapeoDTO);

			
				


				actividadCampanaResponseDTOLista.add(actividadCampanaResponseDTO);


			}

		}


		return actividadCampanaResponseDTOLista;

	}



	public ActividadCampanaResponseDTO actualizarActividadCampana(ActividadCampanaRequestDTO actividadCampanaRequestDTO) {

		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(actividadCampanaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();
			actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
			actividadCampanaEntity.setIdActividad(actividadCampanaRequestDTO.getActividadDTO().getActividad().getIdActividad());
			actividadCampanaEntity.setIdEjecucion(actividadCampanaRequestDTO.getActividadDTO().getEjecucion().getIdEjecucion());
			actividadCampanaEntity.setFechaUltModificacion(new Date());

			actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
			actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getIdActividadCampana());


		}else {
			actividadCampanaResponseDTO=null;
		}


		return actividadCampanaResponseDTO;


	}


	public ActividadCampanaResponseDTO activar(ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(actividadCampanaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();

			if (!actividadCampanaEntity.getBolActivo()) {
				actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadCampanaEntity.setBolActivo(true);
				actividadCampanaEntity.setFechaUltModificacion(new Date());
				actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getIdActividadCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}

	public ActividadCampanaResponseDTO desactivar(ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		Optional<ActividadCampanaEntity> actividadCampanaEntityOptional = actividadCampanaRepository.findById(actividadCampanaRequestDTO.getActividadDTO().getIdActividadLineaCampana());

		if (actividadCampanaEntityOptional.isPresent()) {

			ActividadCampanaEntity actividadCampanaEntity = actividadCampanaEntityOptional.get();

			if (actividadCampanaEntity.getBolActivo()) {
				actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
				actividadCampanaEntity.setBolActivo(false);
				actividadCampanaEntity.setFechaUltModificacion(new Date());
				actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getIdActividadCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}

	public void registrarMapeoActividad(Long idTareaCampana, Long idMapeoCampana,Long idUsuario) {
		
		ActividadMapeoCampanaEntity actividadMapeoCampanaEntity = new  ActividadMapeoCampanaEntity();
		LlaveActividadMapeoCampana llaveActividadMapeoCampana = new LlaveActividadMapeoCampana();
		
		llaveActividadMapeoCampana.setIdABCConfigMapeoCampana(idMapeoCampana);
		llaveActividadMapeoCampana.setIdActividadCampana(idTareaCampana);
		
		actividadMapeoCampanaEntity.setLlaveActividadMapeoCampana(llaveActividadMapeoCampana);
		actividadMapeoCampanaEntity.setBolActivo(true);
		actividadMapeoCampanaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		actividadMapeoCampanaEntity.setFecCreacion(new Date());
		actividadMapeoCampanaEntity.setFecUltModificacion(new Date());
		
		mapeoActividadCampanaRepository.save(actividadMapeoCampanaEntity);
		
		
		
		
		
	}
	


}
