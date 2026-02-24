package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.TareaHorarioCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.dto.HorarioCampanaDTO;
import mx.com.proyectohu.dto.TareaCampanaHorarioRequestDTO;
import mx.com.proyectohu.dto.TareaCampanaHorarioResponseDTO;
import mx.com.proyectohu.dto.TareaCampanaHorarioResponseDTO.Dia;
import mx.com.proyectohu.dto.TareaCampanaHorarioResponseDTO.Hora;
import mx.com.proyectohu.dto.TareaCampanaRequestDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatEjecucion;

import mx.com.proyectohu.entity.LlaveTareaHorarioCampana;
import mx.com.proyectohu.entity.TareaHorarioCampanaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;

@Service
public class TareaHorarioCampanaService {

	@Autowired
	public TareaHorarioCampanaRepository tareaHorarioCampanaRepository;


	public void  registrarTareaCampanaHorario(Long idTareaCampana,TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO) {


		TareaHorarioCampanaEntity tareaHorarioCampanaEntity = new TareaHorarioCampanaEntity();


		for (HorarioCampanaDTO horarioCampanaDTO :tareaCampanaHorarioRequestDTO.getHorarioCampanaDTO()) {

			LlaveTareaHorarioCampana llaveTareaHorarioCampana = new LlaveTareaHorarioCampana();

			llaveTareaHorarioCampana.setIdCFGTareaCampana(idTareaCampana);
			llaveTareaHorarioCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveTareaHorarioCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());

			tareaHorarioCampanaEntity.setLlaveTareaHorarioCampana(llaveTareaHorarioCampana);
			tareaHorarioCampanaEntity.setIdUsuario(tareaCampanaHorarioRequestDTO.getIdUsuario());
			tareaHorarioCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaHorarioRequestDTO.getIdUsuario());
			tareaHorarioCampanaEntity.setBolActivo(true);
			tareaHorarioCampanaEntity.setFechaCreacion(new Date());
			tareaHorarioCampanaEntity.setFechaUltModificacion(new Date());



			tareaHorarioCampanaRepository.save(tareaHorarioCampanaEntity);

		}







	}


	public List<TareaCampanaHorarioResponseDTO>  consultarTareasCampanaHorarios(Long idTareaCampana){
		List<TareaCampanaHorarioResponseDTO> tareaCampanaHorarioResponseDTOLista = new ArrayList<TareaCampanaHorarioResponseDTO>();
		List<TareaHorarioCampanaEntity>  tareaHorarioCampanaEntityLista= new ArrayList<TareaHorarioCampanaEntity>();

		tareaHorarioCampanaEntityLista = tareaHorarioCampanaRepository.findByLlaveTareaHorarioCampana_idCFGTareaCampana(idTareaCampana);


		if(!tareaHorarioCampanaEntityLista.isEmpty()) {


			for(TareaHorarioCampanaEntity tareaHorarioCampanaEntity: tareaHorarioCampanaEntityLista) {

				TareaCampanaHorarioResponseDTO tareaCampanaHorarioResponseDTO = new TareaCampanaHorarioResponseDTO();
				Dia dia= new Dia();
				Hora hora = new Hora();
				hora.setIdHora(tareaHorarioCampanaEntity.getLlaveTareaHorarioCampana().getIdHora());
				dia.setIdDia(tareaHorarioCampanaEntity.getLlaveTareaHorarioCampana().getIdDia());
				dia.setHora(hora);

				tareaCampanaHorarioResponseDTO.setDia(dia);
				tareaCampanaHorarioResponseDTO.setBolActivo(tareaHorarioCampanaEntity.getBolActivo());
				tareaCampanaHorarioResponseDTO.setFechaCreacion(tareaHorarioCampanaEntity.getFechaCreacion());
				tareaCampanaHorarioResponseDTO.setFechaUltModificacion(tareaHorarioCampanaEntity.getFechaUltModificacion());



				tareaCampanaHorarioResponseDTOLista.add(tareaCampanaHorarioResponseDTO);


			}

		}


		return tareaCampanaHorarioResponseDTOLista;

	}





	public TareaCampanaHorarioResponseDTO activar(Long idTareaCampana, TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO) {
		TareaCampanaHorarioResponseDTO tareaCampanaHorarioResponseDTO = new TareaCampanaHorarioResponseDTO();

		for (HorarioCampanaDTO horarioCampanaDTO :tareaCampanaHorarioRequestDTO.getHorarioCampanaDTO()) {

			LlaveTareaHorarioCampana llaveTareaHorarioCampana = new LlaveTareaHorarioCampana();

			llaveTareaHorarioCampana.setIdCFGTareaCampana(idTareaCampana);
			llaveTareaHorarioCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveTareaHorarioCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());
			Optional<TareaHorarioCampanaEntity> tareaHorarioCampanaEntityOptional = tareaHorarioCampanaRepository.findById(llaveTareaHorarioCampana);

			if(tareaHorarioCampanaEntityOptional.isPresent()) {
				TareaHorarioCampanaEntity tareaHorarioCampanaEntity = tareaHorarioCampanaEntityOptional.get();
				if (!tareaHorarioCampanaEntity.getBolActivo()) {

					tareaHorarioCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaHorarioRequestDTO.getIdUsuario());
					tareaHorarioCampanaEntity.setBolActivo(true);
					tareaHorarioCampanaEntity.setFechaUltModificacion(new Date());
					tareaHorarioCampanaRepository.save(tareaHorarioCampanaEntity);
					tareaCampanaHorarioResponseDTO.setIdCFGTareaCampana(idTareaCampana);
				}
			}else {
				continue;
			}
		}

		
		return tareaCampanaHorarioResponseDTO;
	}

	public TareaCampanaHorarioResponseDTO desactivar(Long idTareaCampana, TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO) {
		TareaCampanaHorarioResponseDTO tareaCampanaHorarioResponseDTO = new TareaCampanaHorarioResponseDTO();
		
		for (HorarioCampanaDTO horarioCampanaDTO :tareaCampanaHorarioRequestDTO.getHorarioCampanaDTO()) {

			LlaveTareaHorarioCampana llaveTareaHorarioCampana = new LlaveTareaHorarioCampana();

			llaveTareaHorarioCampana.setIdCFGTareaCampana(idTareaCampana);
			llaveTareaHorarioCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveTareaHorarioCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());
			Optional<TareaHorarioCampanaEntity> tareaHorarioCampanaEntityOptional = tareaHorarioCampanaRepository.findById(llaveTareaHorarioCampana);

			if(tareaHorarioCampanaEntityOptional.isPresent()) {
				TareaHorarioCampanaEntity tareaHorarioCampanaEntity = tareaHorarioCampanaEntityOptional.get();
				if (tareaHorarioCampanaEntity.getBolActivo()) {

					tareaHorarioCampanaEntity.setIdUsuarioUltModificacion(tareaCampanaHorarioRequestDTO.getIdUsuario());
					tareaHorarioCampanaEntity.setBolActivo(false);
					tareaHorarioCampanaEntity.setFechaUltModificacion(new Date());
					tareaHorarioCampanaRepository.save(tareaHorarioCampanaEntity);
					
					tareaCampanaHorarioResponseDTO.setIdCFGTareaCampana(idTareaCampana);
				}
			}else {
				continue;
			}
		}

		
		return tareaCampanaHorarioResponseDTO;
	}




}
