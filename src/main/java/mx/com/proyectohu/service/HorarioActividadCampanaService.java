package mx.com.proyectohu.service;





import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.HorarioActividadCampanaRepository;
import mx.com.proyectohu.repository.ActividadCampanaRepository;
import mx.com.proyectohu.dto.HorarioCampanaDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaResponseDTO.Dia;
import mx.com.proyectohu.dto.HorarioActividadCampanaResponseDTO.Hora;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO.CatEjecucion;

import mx.com.proyectohu.entity.LlaveHorarioActividadCampana;
import mx.com.proyectohu.entity.HorarioActividadCampanaEntity;
import mx.com.proyectohu.entity.ActividadCampanaEntity;

@Service
public class HorarioActividadCampanaService {

	@Autowired
	public HorarioActividadCampanaRepository horarioActividadCampanaRepository;


	public void  registrarHorarioActividadCampana(Long idTareaCampana,HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {


		HorarioActividadCampanaEntity horarioActividadCampanaEntity = new HorarioActividadCampanaEntity();


		for (HorarioCampanaDTO horarioCampanaDTO : horarioActividadCampanaRequestDTO.getHorarioCampanaDTO()) {

			LlaveHorarioActividadCampana llaveHorarioActividadCampana = new LlaveHorarioActividadCampana();

			llaveHorarioActividadCampana.setIdActividadCampana(idTareaCampana);
			llaveHorarioActividadCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveHorarioActividadCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());

			horarioActividadCampanaEntity.setLlaveHorarioActividadCampana(llaveHorarioActividadCampana);
			horarioActividadCampanaEntity.setIdUsuario(horarioActividadCampanaRequestDTO.getIdUsuario());
			horarioActividadCampanaEntity.setIdUsuarioUltModificacion(horarioActividadCampanaRequestDTO.getIdUsuario());
			horarioActividadCampanaEntity.setBolActivo(true);
			Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
			horarioActividadCampanaEntity.setFechaCreacion(fechaActual);
			horarioActividadCampanaEntity.setFechaUltModificacion(fechaActual);



			horarioActividadCampanaRepository.save(horarioActividadCampanaEntity);

		}


	}


	public List<HorarioActividadCampanaResponseDTO>  consultarHorariosActividadCampanas(Long idTareaCampana){
		List<HorarioActividadCampanaResponseDTO> horarioActividadCampanaResponseDTOLista = new ArrayList<HorarioActividadCampanaResponseDTO>();
		List<HorarioActividadCampanaEntity>  horarioActividadCampanaEntityLista= new ArrayList<HorarioActividadCampanaEntity>();

		horarioActividadCampanaEntityLista = horarioActividadCampanaRepository.findByLlaveHorarioActividadCampana_idActividadCampana(idTareaCampana);


		if(!horarioActividadCampanaEntityLista.isEmpty()) {


			for(HorarioActividadCampanaEntity horarioActividadCampanaEntity: horarioActividadCampanaEntityLista) {

				HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
				Dia dia= new Dia();
				Hora hora = new Hora();
				hora.setIdHora(horarioActividadCampanaEntity.getLlaveHorarioActividadCampana().getIdHora());
				dia.setIdDia(horarioActividadCampanaEntity.getLlaveHorarioActividadCampana().getIdDia());
				dia.setHora(hora);

				horarioActividadCampanaResponseDTO.setDia(dia);
				horarioActividadCampanaResponseDTO.setBolActivo(horarioActividadCampanaEntity.getBolActivo());
				horarioActividadCampanaResponseDTO.setFechaCreacion(horarioActividadCampanaEntity.getFechaCreacion().getTime());
				horarioActividadCampanaResponseDTO.setFechaUltModificacion(horarioActividadCampanaEntity.getFechaUltModificacion().getTime());



				horarioActividadCampanaResponseDTOLista.add(horarioActividadCampanaResponseDTO);


			}

		}


		return horarioActividadCampanaResponseDTOLista;

	}





	public HorarioActividadCampanaResponseDTO activar(Long idTareaCampana, HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();

		for (HorarioCampanaDTO horarioCampanaDTO : horarioActividadCampanaRequestDTO.getHorarioCampanaDTO()) {

			LlaveHorarioActividadCampana llaveHorarioActividadCampana = new LlaveHorarioActividadCampana();

			llaveHorarioActividadCampana.setIdActividadCampana(idTareaCampana);
			llaveHorarioActividadCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveHorarioActividadCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());
			Optional<HorarioActividadCampanaEntity> horarioActividadCampanaEntityOptional = horarioActividadCampanaRepository.findById(llaveHorarioActividadCampana);

			if(horarioActividadCampanaEntityOptional.isPresent()) {
				HorarioActividadCampanaEntity horarioActividadCampanaEntity = horarioActividadCampanaEntityOptional.get();
				if (!horarioActividadCampanaEntity.getBolActivo()) {

					horarioActividadCampanaEntity.setIdUsuarioUltModificacion(horarioActividadCampanaRequestDTO.getIdUsuario());
					horarioActividadCampanaEntity.setBolActivo(true);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadCampanaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadCampanaRepository.save(horarioActividadCampanaEntity);
					horarioActividadCampanaResponseDTO.setIdActividadCampana(idTareaCampana);
				}
			}else {
				continue;
			}
		}

		
		return horarioActividadCampanaResponseDTO;
	}

	public HorarioActividadCampanaResponseDTO desactivar(Long idTareaCampana, HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
		
		for (HorarioCampanaDTO horarioCampanaDTO : horarioActividadCampanaRequestDTO.getHorarioCampanaDTO()) {

			LlaveHorarioActividadCampana llaveHorarioActividadCampana = new LlaveHorarioActividadCampana();

			llaveHorarioActividadCampana.setIdActividadCampana(idTareaCampana);
			llaveHorarioActividadCampana.setIdDia(horarioCampanaDTO.getDia().getIdDia());
			llaveHorarioActividadCampana.setIdHora(horarioCampanaDTO.getDia().getHora().getIdHora());
			Optional<HorarioActividadCampanaEntity> horarioActividadCampanaEntityOptional = horarioActividadCampanaRepository.findById(llaveHorarioActividadCampana);

			if(horarioActividadCampanaEntityOptional.isPresent()) {
				HorarioActividadCampanaEntity horarioActividadCampanaEntity = horarioActividadCampanaEntityOptional.get();
				if (horarioActividadCampanaEntity.getBolActivo()) {

					horarioActividadCampanaEntity.setIdUsuarioUltModificacion(horarioActividadCampanaRequestDTO.getIdUsuario());
					horarioActividadCampanaEntity.setBolActivo(false);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadCampanaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadCampanaRepository.save(horarioActividadCampanaEntity);
					
					horarioActividadCampanaResponseDTO.setIdActividadCampana(idTareaCampana);
				}
			}else {
				continue;
			}
		}

		
		return horarioActividadCampanaResponseDTO;
	}




}
