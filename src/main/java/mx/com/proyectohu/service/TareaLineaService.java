package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.MapeoTareaLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.TareaLineaRequestDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.LlaveTareaMapeoLinea;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.entity.TareaMapeoLineaEntity;

@Service
public class TareaLineaService {

	@Autowired
	public TareaLineaRepository tareaLineaRepository;
	
	@Autowired
	public MapeoTareaLineaRepository mapeoTareaLineaRepository;


	public Long  registrarTareaLinea(Long idLineaNegocio,TareaLineaRequestDTO tareaLineaRequestDTO) {


		TareaLineaEntity tareaLineaEntity = new TareaLineaEntity();
		Long idTareaLinea = 0L;

		tareaLineaEntity.setIdUsuario(tareaLineaRequestDTO.getIdUsuario());
		tareaLineaEntity.setIdLineaNegocio(idLineaNegocio);
		tareaLineaEntity.setIdActividad(tareaLineaRequestDTO.getTareaDTO().getActividad().getIdActividad());
		tareaLineaEntity.setIdEjecucion(tareaLineaRequestDTO.getTareaDTO().getEjecucion().getIdEjecucion());
		tareaLineaEntity.setBolActivo(true);
		tareaLineaEntity.setFechaCreacion(new Date());
		tareaLineaEntity.setIdUsuarioUltModificacion(tareaLineaRequestDTO.getIdUsuario());
		tareaLineaEntity.setFechaUltModificacion(new Date());


		idTareaLinea=tareaLineaRepository.save(tareaLineaEntity).getIdCFGTareaLinea();
		
		
		
		registrarMapeoTarea(idTareaLinea,tareaLineaRequestDTO.getTareaDTO().getMapeoDTO().getIdABCConfigMapeoLinea(),tareaLineaRequestDTO.getIdUsuario()); 
		



		return	idTareaLinea;	

	}


	public List<TareaLineaResponseDTO>  consultarTareasLinea(){
		List<TareaLineaResponseDTO> tareaLineaResponseDTOLista = new ArrayList<TareaLineaResponseDTO>();
		List<TareaLineaEntity>  tareaLineaEntityLista= new ArrayList<TareaLineaEntity>();

		tareaLineaEntityLista = tareaLineaRepository.findAll();


		if(!tareaLineaEntityLista.isEmpty()) {


			for(TareaLineaEntity tareaLineaEntity: tareaLineaEntityLista) {
				TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();

				tareaLineaResponseDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdCFGTareaLinea());

				catLineaNegocio.setIdLineaNegocio(tareaLineaEntity.getIdLineaNegocio());
				tareaLineaResponseDTO.setCatLineaNegocio(catLineaNegocio);

				catActividad.setIdActividad(tareaLineaEntity.getIdActividad());
				tareaLineaResponseDTO.setCatActividad(catActividad);

				catEjecucion.setIdEjecucion(tareaLineaEntity.getIdEjecucion());
				tareaLineaResponseDTO.setCatEjecucion(catEjecucion);

				tareaLineaResponseDTO.setBolActivo(tareaLineaEntity.getBolActivo());
				tareaLineaResponseDTO.setFechaCreacion(tareaLineaEntity.getFechaCreacion());
				tareaLineaResponseDTO.setFechaUltModificacion(tareaLineaEntity.getFechaUltModificacion());
				
				TareaMapeoLineaEntity tareaMapeoLineaEntity = new TareaMapeoLineaEntity();

				tareaMapeoLineaEntity = mapeoTareaLineaRepository.findByLlaveTareaMapeoLinea_idCFGTareaLinea(tareaLineaEntity.getIdCFGTareaLinea());
				
				if(tareaMapeoLineaEntity== null) {
					continue;
				}
				
				MapeoDTO mapeoDTO = new MapeoDTO();
				mapeoDTO.setIdABCConfigMapeoLinea(tareaMapeoLineaEntity.getLlaveTareaMapeoLinea().getIdABCConfigMapeoLinea());
			
				tareaLineaResponseDTO.setMapeoDTO(mapeoDTO);

				tareaLineaResponseDTOLista.add(tareaLineaResponseDTO);


			}

		}


		return tareaLineaResponseDTOLista;

	}



	public TareaLineaResponseDTO actualizarTareaLinea(TareaLineaRequestDTO tareaLineaRequestDTO) {

		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();
		Optional<TareaLineaEntity> tareaLineaEntityOptional = tareaLineaRepository.findById(tareaLineaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaLineaEntityOptional.isPresent()) {

			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();
			tareaLineaEntity.setIdUsuarioUltModificacion(tareaLineaRequestDTO.getIdUsuario());
			tareaLineaEntity.setIdActividad(tareaLineaRequestDTO.getTareaDTO().getActividad().getIdActividad());
			tareaLineaEntity.setIdEjecucion(tareaLineaRequestDTO.getTareaDTO().getEjecucion().getIdEjecucion());
			tareaLineaEntity.setFechaUltModificacion(new Date());

			tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);
			tareaLineaResponseDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdCFGTareaLinea());


		}else {
			tareaLineaResponseDTO=null;
		}


		return tareaLineaResponseDTO;


	}


	public TareaLineaResponseDTO activar(TareaLineaRequestDTO tareaLineaRequestDTO) {
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();


		Optional<TareaLineaEntity> tareaLineaEntityOptional = tareaLineaRepository.findById(tareaLineaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaLineaEntityOptional.isPresent()) {

			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();

			if (!tareaLineaEntity.getBolActivo()) {
				tareaLineaEntity.setIdUsuarioUltModificacion(tareaLineaRequestDTO.getIdUsuario());
				tareaLineaEntity.setBolActivo(true);
				tareaLineaEntity.setFechaUltModificacion(new Date());
				tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);
				tareaLineaResponseDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdCFGTareaLinea());
			}
		}

		return tareaLineaResponseDTO;
	}

	public TareaLineaResponseDTO desactivar(TareaLineaRequestDTO tareaLineaRequestDTO) {
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();


		Optional<TareaLineaEntity> tareaLineaEntityOptional = tareaLineaRepository.findById(tareaLineaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaLineaEntityOptional.isPresent()) {

			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();

			if (tareaLineaEntity.getBolActivo()) {
				tareaLineaEntity.setIdUsuarioUltModificacion(tareaLineaRequestDTO.getIdUsuario());
				tareaLineaEntity.setBolActivo(false);
				tareaLineaEntity.setFechaUltModificacion(new Date());
				tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);
				tareaLineaResponseDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdCFGTareaLinea());
			}
		}

		return tareaLineaResponseDTO;
	}
	
	
	public void registrarMapeoTarea(Long idTareaLinea, Long idMapeoLinea,Long idUsuario) {
		
		TareaMapeoLineaEntity tareaMapeoLineaEntity = new  TareaMapeoLineaEntity();
		LlaveTareaMapeoLinea llaveTareaMapeoLinea = new LlaveTareaMapeoLinea();
		
		llaveTareaMapeoLinea.setIdABCConfigMapeoLinea(idMapeoLinea);
		llaveTareaMapeoLinea.setIdCFGTareaLinea(idTareaLinea);
		
		tareaMapeoLineaEntity.setLlaveTareaMapeoLinea(llaveTareaMapeoLinea);
		tareaMapeoLineaEntity.setBolActivo(true);
		tareaMapeoLineaEntity.setIdABCUsuarioUltModificacion(idUsuario);
		tareaMapeoLineaEntity.setFecCreacion(new Date());
		tareaMapeoLineaEntity.setFecUltModificacion(new Date());
		
		mapeoTareaLineaRepository.save(tareaMapeoLineaEntity);
		
		
		
		
		
	}
	
	




}
