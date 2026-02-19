package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.TareaCampanaRepository;


import mx.com.proyectohu.dto.TareaCampanaRequestDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatLineaNegocio.CatCampana;
import mx.com.proyectohu.entity.TareaCampanaEntity;

@Service
public class TareaCampanaService {

	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;


	public Long  registrarTareaCampana(Long idLinea, Long idCampana,TareaCampanaRequestDTO tareaCampanaRequestDTO) {


		TareaCampanaEntity tareaCampanaEntity = new TareaCampanaEntity();
		Long idTareaCampana = 0L;

		tareaCampanaEntity.setIdUsuario(tareaCampanaRequestDTO.getIdUsuario());
		tareaCampanaEntity.setIdLineaNegocio(idLinea);
		tareaCampanaEntity.setIdCampana(idCampana);
		tareaCampanaEntity.setIdActividad(tareaCampanaRequestDTO.getTareaDTO().getActividad().getIdActividad());
		tareaCampanaEntity.setIdEjecucion(tareaCampanaRequestDTO.getTareaDTO().getEjecucion().getIdEjecucion());
		tareaCampanaEntity.setBolActivo(true);
		tareaCampanaEntity.setFechaCreacion(new Date());
		tareaCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaRequestDTO.getIdUsuario());
		tareaCampanaEntity.setFechaUltModificacion(new Date());


		idTareaCampana=tareaCampanaRepository.save(tareaCampanaEntity).getIdCFGTareaCampana();



		return	idTareaCampana;	

	}


	public List<TareaCampanaResponseDTO>  consultarTareasCampana(){
		List<TareaCampanaResponseDTO> tareaCampanaResponseDTOLista = new ArrayList<TareaCampanaResponseDTO>();
		List<TareaCampanaEntity>  tareaCampanaEntityLista= new ArrayList<TareaCampanaEntity>();

		tareaCampanaEntityLista = tareaCampanaRepository.findAll();


		if(!tareaCampanaEntityLista.isEmpty()) {


			for(TareaCampanaEntity tareaCampanaEntity: tareaCampanaEntityLista) {
				TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();
				CatCampana catCampana = new CatCampana();
				
				

				tareaCampanaResponseDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdCFGTareaCampana());

				catCampana.setIdCampana(tareaCampanaEntity.getIdCampana());
				catLineaNegocio.setIdLineaNegocio(tareaCampanaEntity.getIdLineaNegocio());
				catLineaNegocio.setCatCampana(catCampana);
				tareaCampanaResponseDTO.setCatLineaNegocio(catLineaNegocio);

				catActividad.setIdActividad(tareaCampanaEntity.getIdActividad());
				tareaCampanaResponseDTO.setCatActividad(catActividad);

				catEjecucion.setIdEjecucion(tareaCampanaEntity.getIdEjecucion());
				tareaCampanaResponseDTO.setCatEjecucion(catEjecucion);

				tareaCampanaResponseDTO.setBolActivo(tareaCampanaEntity.getBolActivo());
				tareaCampanaResponseDTO.setFechaCreacion(tareaCampanaEntity.getFechaCreacion());
				tareaCampanaResponseDTO.setFechaUltModificacion(tareaCampanaEntity.getFechaUltModificacion());


				tareaCampanaResponseDTOLista.add(tareaCampanaResponseDTO);


			}

		}


		return tareaCampanaResponseDTOLista;

	}



	public TareaCampanaResponseDTO actualizarTareaCampana(TareaCampanaRequestDTO tareaCampanaRequestDTO) {

		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();
		Optional<TareaCampanaEntity> tareaCampanaEntityOptional = tareaCampanaRepository.findById(tareaCampanaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaCampanaEntityOptional.isPresent()) {

			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();
			tareaCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaRequestDTO.getIdUsuario());
			tareaCampanaEntity.setIdActividad(tareaCampanaRequestDTO.getTareaDTO().getActividad().getIdActividad());
			tareaCampanaEntity.setIdEjecucion(tareaCampanaRequestDTO.getTareaDTO().getEjecucion().getIdEjecucion());
			tareaCampanaEntity.setFechaUltModificacion(new Date());

			tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);
			tareaCampanaResponseDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdCFGTareaCampana());


		}else {
			tareaCampanaResponseDTO=null;
		}


		return tareaCampanaResponseDTO;


	}


	public TareaCampanaResponseDTO activar(TareaCampanaRequestDTO tareaCampanaRequestDTO) {
		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();


		Optional<TareaCampanaEntity> tareaCampanaEntityOptional = tareaCampanaRepository.findById(tareaCampanaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaCampanaEntityOptional.isPresent()) {

			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();

			if (!tareaCampanaEntity.getBolActivo()) {
				tareaCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaRequestDTO.getIdUsuario());
				tareaCampanaEntity.setBolActivo(true);
				tareaCampanaEntity.setFechaUltModificacion(new Date());
				tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);
				tareaCampanaResponseDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdCFGTareaCampana());
			}
		}

		return tareaCampanaResponseDTO;
	}

	public TareaCampanaResponseDTO desactivar(TareaCampanaRequestDTO tareaCampanaRequestDTO) {
		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();


		Optional<TareaCampanaEntity> tareaCampanaEntityOptional = tareaCampanaRepository.findById(tareaCampanaRequestDTO.getTareaDTO().getIdCFGTareaLineaCampana());

		if (tareaCampanaEntityOptional.isPresent()) {

			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();

			if (tareaCampanaEntity.getBolActivo()) {
				tareaCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaRequestDTO.getIdUsuario());
				tareaCampanaEntity.setBolActivo(false);
				tareaCampanaEntity.setFechaUltModificacion(new Date());
				tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);
				tareaCampanaResponseDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdCFGTareaCampana());
			}
		}

		return tareaCampanaResponseDTO;
	}




}
