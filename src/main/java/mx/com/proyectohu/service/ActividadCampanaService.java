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
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatLineaNegocio.CatCampana;
import mx.com.proyectohu.entity.LlaveActividadMapeoCampana;
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



	public Long  registrarActividadCampana(Long idLinea, Long idCampana,ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		
		Long idActividad = actividadCampanaRequestDTO.getActividadDTO().getActividad().getIdActividad();
		
		Long idActividadMapeoCampana = registrarMapeoActividad(idActividad,actividadCampanaRequestDTO.getActividadDTO().getMapeoDTO().getIdABCConfigMapeoLinea(),actividadCampanaRequestDTO.getIdUsuario()); 


		ActividadCampanaEntity actividadCampanaEntity = new ActividadCampanaEntity();
		
		LlaveActividadCampana llaveActividadCampana = new LlaveActividadCampana();
		llaveActividadCampana.setIdActividadMapeoCampana(idActividadMapeoCampana);
		llaveActividadCampana.setIdActividad(idActividad);
		actividadCampanaEntity.setLlaveActividadCampana(llaveActividadCampana);

		actividadCampanaEntity.setIdUsuario(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setIdEjecucion(actividadCampanaRequestDTO.getActividadDTO().getEjecucion().getIdEjecucion());
		actividadCampanaEntity.setBolActivo(true);
		
		actividadCampanaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
		actividadCampanaEntity.setIdUsuarioUltModificacion(actividadCampanaRequestDTO.getIdUsuario());
		actividadCampanaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());


		idActividadMapeoCampana=actividadCampanaRepository.save(actividadCampanaEntity).getIdUsuarioUltModificacion();

		


		return	idActividadMapeoCampana;	

	}

	/*
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
				actividadCampanaResponseDTO.setFechaCreacion(actividadCampanaEntity.getFechaCreacion().getTime());
				actividadCampanaResponseDTO.setFechaUltModificacion(actividadCampanaEntity.getFechaUltModificacion().getTime());
				
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
			Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
			actividadCampanaEntity.setFechaUltModificacion(fechaActual);

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
				Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
				actividadCampanaEntity.setFechaUltModificacion(fechaActual);
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
				Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
				actividadCampanaEntity.setFechaUltModificacion(fechaActual);
				actividadCampanaEntity = actividadCampanaRepository.save(actividadCampanaEntity);
				actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaEntity.getIdActividadCampana());
			}
		}

		return actividadCampanaResponseDTO;
	}
*/
	public Long  registrarMapeoActividad(Long idTareaCampana, Long idMapeoCampana,Long idUsuario) {
		
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
