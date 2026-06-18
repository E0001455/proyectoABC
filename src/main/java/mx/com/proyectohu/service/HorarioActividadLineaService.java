package mx.com.proyectohu.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.HorarioActividadLineaRepository;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.dto.HorarioLineaDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaResponseDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaResponseDTO.Dia;
import mx.com.proyectohu.dto.HorarioActividadLineaResponseDTO.Hora;
import mx.com.proyectohu.entity.LlaveHorarioActividadLinea;
import mx.com.proyectohu.entity.HorarioActividadLineaEntity;

@Service
public class HorarioActividadLineaService {

	@Autowired
	public HorarioActividadLineaRepository horarioActividadLineaRepository;


	public void  registrarHorarioActividadLinea(Long idActividadMapeoLinea,HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {

		HorarioActividadLineaEntity horarioActividadLineaEntity = new HorarioActividadLineaEntity();


		for (HorarioLineaDTO horarioLineaDTO :horarioActividadLineaRequestDTO.getHorarioLineaDTO()) {

			LlaveHorarioActividadLinea llaveHorarioActividadLinea = new LlaveHorarioActividadLinea();

			llaveHorarioActividadLinea.setIdActividadMapeoLinea(idActividadMapeoLinea);
			llaveHorarioActividadLinea.setIdActividad(horarioLineaDTO.getIdActividad());
			llaveHorarioActividadLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveHorarioActividadLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());

			horarioActividadLineaEntity.setLlaveHorarioActividadLinea(llaveHorarioActividadLinea);
			horarioActividadLineaEntity.setIdUsuario(horarioActividadLineaRequestDTO.getIdUsuario());
			horarioActividadLineaEntity.setIdUsuarioUltModificacion(horarioActividadLineaRequestDTO.getIdUsuario());
			horarioActividadLineaEntity.setBolActivo(true);
			horarioActividadLineaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
			horarioActividadLineaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
			horarioActividadLineaRepository.save(horarioActividadLineaEntity);

		}

	}

/*
	public List<HorarioActividadLineaResponseDTO>  consultarHorariosActividadesLinea(Long idTareaLinea){
		List<HorarioActividadLineaResponseDTO> horarioActividadLineaResponseDTOLista = new ArrayList<HorarioActividadLineaResponseDTO>();
		List<HorarioActividadLineaEntity>  horarioActividadLineaEntityLista= new ArrayList<HorarioActividadLineaEntity>();

		horarioActividadLineaEntityLista = horarioActividadLineaRepository.findByLlaveHorarioActividadLinea_idActividadLinea(idTareaLinea);

		if(!horarioActividadLineaEntityLista.isEmpty()) {

			for(HorarioActividadLineaEntity horarioActividadLineaEntity: horarioActividadLineaEntityLista) {

				HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();
				Dia dia= new Dia();
				Hora hora = new Hora();
				hora.setIdHora(horarioActividadLineaEntity.getLlaveHorarioActividadLinea().getIdHora());
				dia.setIdDia(horarioActividadLineaEntity.getLlaveHorarioActividadLinea().getIdDia());
				dia.setHora(hora);

				horarioActividadLineaResponseDTO.setDia(dia);
				horarioActividadLineaResponseDTO.setBolActivo(horarioActividadLineaEntity.getBolActivo());
				horarioActividadLineaResponseDTO.setFechaCreacion(horarioActividadLineaEntity.getFechaCreacion().getTime());
				horarioActividadLineaResponseDTO.setFechaUltModificacion(horarioActividadLineaEntity.getFechaUltModificacion().getTime());

				horarioActividadLineaResponseDTOLista.add(horarioActividadLineaResponseDTO);
			}

		}
		return horarioActividadLineaResponseDTOLista;

	}





	public HorarioActividadLineaResponseDTO activar(Long idTareaLinea, HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();

		for (HorarioLineaDTO horarioLineaDTO :horarioActividadLineaRequestDTO.getHorarioLineaDTO()) {

			LlaveHorarioActividadLinea llaveHorarioActividadLinea = new LlaveHorarioActividadLinea();

			llaveHorarioActividadLinea.setIdActividadLinea(idTareaLinea);
			llaveHorarioActividadLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveHorarioActividadLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());
			Optional<HorarioActividadLineaEntity> horarioActividadLineaEntityOptional = horarioActividadLineaRepository.findById(llaveHorarioActividadLinea);

			if(horarioActividadLineaEntityOptional.isPresent()) {
				HorarioActividadLineaEntity horarioActividadLineaEntity = horarioActividadLineaEntityOptional.get();
				if (!horarioActividadLineaEntity.getBolActivo()) {

					horarioActividadLineaEntity.setIdUsuarioUltModificacion(horarioActividadLineaRequestDTO.getIdUsuario());
					horarioActividadLineaEntity.setBolActivo(true);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadLineaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadLineaRepository.save(horarioActividadLineaEntity);
					horarioActividadLineaResponseDTO.setIdActividadLinea(idTareaLinea);
				}
			}else {
				continue;
			}
		}

		return horarioActividadLineaResponseDTO;
	}

	public HorarioActividadLineaResponseDTO desactivar(Long idTareaLinea, HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();

		for (HorarioLineaDTO horarioLineaDTO :horarioActividadLineaRequestDTO.getHorarioLineaDTO()) {

			LlaveHorarioActividadLinea llaveHorarioActividadLinea = new LlaveHorarioActividadLinea();

			llaveHorarioActividadLinea.setIdActividadLinea(idTareaLinea);
			llaveHorarioActividadLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveHorarioActividadLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());
			Optional<HorarioActividadLineaEntity> horarioActividadLineaEntityOptional = horarioActividadLineaRepository.findById(llaveHorarioActividadLinea);

			if(horarioActividadLineaEntityOptional.isPresent()) {
				HorarioActividadLineaEntity horarioActividadLineaEntity = horarioActividadLineaEntityOptional.get();
				if (horarioActividadLineaEntity.getBolActivo()) {

					horarioActividadLineaEntity.setIdUsuarioUltModificacion(horarioActividadLineaRequestDTO.getIdUsuario());
					horarioActividadLineaEntity.setBolActivo(false);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadLineaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadLineaRepository.save(horarioActividadLineaEntity);

					horarioActividadLineaResponseDTO.setIdActividadLinea(idTareaLinea);
				}
			}else {
				continue;
			}
		}


		return horarioActividadLineaResponseDTO;
	}

*/


}
