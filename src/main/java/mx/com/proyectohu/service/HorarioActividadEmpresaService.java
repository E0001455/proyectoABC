package mx.com.proyectohu.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.HorarioActividadEmpresaRepository;
import mx.com.proyectohu.util.FechaUtil;

import mx.com.proyectohu.entity.LlaveHorarioActividadEmpresa;
import mx.com.proyectohu.dto.HorarioActividadEmpresaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadEmpresaResponseDTO;
import mx.com.proyectohu.dto.HorarioActividadEmpresaResponseDTO.Dia;
import mx.com.proyectohu.dto.HorarioActividadEmpresaResponseDTO.Hora;
import mx.com.proyectohu.dto.HorarioEmpresaDTO;
import mx.com.proyectohu.entity.HorarioActividadEmpresaEntity;

@Service
public class HorarioActividadEmpresaService {

	@Autowired
	public HorarioActividadEmpresaRepository horarioActividadEmpresaRepository;


	public void  registrarHorarioActividadEmpresa(Long idActividadMapeoEmpresa,Long idActividad, HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO) {

		HorarioActividadEmpresaEntity horarioActividadEmpresaEntity = new HorarioActividadEmpresaEntity();


		for (HorarioEmpresaDTO horarioEmpresaDTO : horarioActividadEmpresaRequestDTO.getHorarioEmpresaDTO()) {

			LlaveHorarioActividadEmpresa llaveHorarioActividadEmpresa = new LlaveHorarioActividadEmpresa();

			llaveHorarioActividadEmpresa.setIdActividadMapeoEmpresa(idActividadMapeoEmpresa);
			llaveHorarioActividadEmpresa.setIdActividad(idActividad);
			llaveHorarioActividadEmpresa.setIdDia(horarioEmpresaDTO.getDia().getIdDia());
			llaveHorarioActividadEmpresa.setIdHora(horarioEmpresaDTO.getDia().getHora().getIdHora());

			horarioActividadEmpresaEntity.setLlaveHorarioActividadEmpresa(llaveHorarioActividadEmpresa);
			horarioActividadEmpresaEntity.setIdUsuario(horarioActividadEmpresaRequestDTO.getIdUsuario());
			horarioActividadEmpresaEntity.setIdUsuarioUltModificacion(horarioActividadEmpresaRequestDTO.getIdUsuario());
			horarioActividadEmpresaEntity.setBolActivo(true);
			horarioActividadEmpresaEntity.setFechaCreacion(FechaUtil.obtenerFechaActual());
			horarioActividadEmpresaEntity.setFechaUltModificacion(FechaUtil.obtenerFechaActual());
			horarioActividadEmpresaRepository.save(horarioActividadEmpresaEntity);

		}

	}


	public List<HorarioActividadEmpresaResponseDTO>  consultarHorariosActividadesEmpresa(Long idActividadMapeo, Long idActividad){
		List<HorarioActividadEmpresaResponseDTO> horarioActividadEmpresaResponseDTOLista = new ArrayList<HorarioActividadEmpresaResponseDTO>();
		List<HorarioActividadEmpresaEntity>  horarioActividadEmpresaEntityLista= new ArrayList<HorarioActividadEmpresaEntity>();

		horarioActividadEmpresaEntityLista = horarioActividadEmpresaRepository.findByLlaveHorarioActividadEmpresa_IdActividadMapeoEmpresaAndLlaveHorarioActividadEmpresa_IdActividad(idActividadMapeo,idActividad);

		if(!horarioActividadEmpresaEntityLista.isEmpty()) {

			for(HorarioActividadEmpresaEntity horarioActividadEmpresaEntity: horarioActividadEmpresaEntityLista) {

				HorarioActividadEmpresaResponseDTO horarioActividadEmpresaResponseDTO = new HorarioActividadEmpresaResponseDTO();
				Dia dia= new Dia();
				Hora hora = new Hora();
				hora.setIdHora(horarioActividadEmpresaEntity.getLlaveHorarioActividadEmpresa().getIdHora());
				dia.setIdDia(horarioActividadEmpresaEntity.getLlaveHorarioActividadEmpresa().getIdDia());
				dia.setHora(hora);

				horarioActividadEmpresaResponseDTO.setDia(dia);
				horarioActividadEmpresaResponseDTO.setBolActivo(horarioActividadEmpresaEntity.getBolActivo());
				horarioActividadEmpresaResponseDTO.setFechaCreacion(horarioActividadEmpresaEntity.getFechaCreacion().getTime());
				horarioActividadEmpresaResponseDTO.setFechaUltModificacion(horarioActividadEmpresaEntity.getFechaUltModificacion().getTime());

				horarioActividadEmpresaResponseDTOLista.add(horarioActividadEmpresaResponseDTO);
			}

		}
		return horarioActividadEmpresaResponseDTOLista;

	}





	public HorarioActividadEmpresaResponseDTO activar(Long idActividadMapeo, Long idActividad, HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO) {
		HorarioActividadEmpresaResponseDTO horarioActividadEmpresaResponseDTO = new HorarioActividadEmpresaResponseDTO();
		List<HorarioActividadEmpresaEntity>  horarioActividadEmpresaEntityLista= new ArrayList<HorarioActividadEmpresaEntity>();


		horarioActividadEmpresaEntityLista = horarioActividadEmpresaRepository.findByLlaveHorarioActividadEmpresa_IdActividadMapeoEmpresaAndLlaveHorarioActividadEmpresa_IdActividad(idActividadMapeo,idActividad);


		if(!horarioActividadEmpresaEntityLista.isEmpty()) {

			for(HorarioActividadEmpresaEntity horarioActividadEmpresaEntity: horarioActividadEmpresaEntityLista) {

				if (!horarioActividadEmpresaEntity.getBolActivo()) {

					horarioActividadEmpresaEntity.setIdUsuarioUltModificacion(horarioActividadEmpresaRequestDTO.getIdUsuario());
					horarioActividadEmpresaEntity.setBolActivo(true);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadEmpresaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadEmpresaRepository.save(horarioActividadEmpresaEntity);
					horarioActividadEmpresaResponseDTO.setIdActividadEmpresa(idActividadMapeo);
				}

			}


		}
		return horarioActividadEmpresaResponseDTO;
	}

	public HorarioActividadEmpresaResponseDTO desactivar(Long idActividadMapeo, Long idActividad, HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO) {
		HorarioActividadEmpresaResponseDTO horarioActividadEmpresaResponseDTO = new HorarioActividadEmpresaResponseDTO();
		List<HorarioActividadEmpresaEntity>  horarioActividadEmpresaEntityLista= new ArrayList<HorarioActividadEmpresaEntity>();


		horarioActividadEmpresaEntityLista = horarioActividadEmpresaRepository.findByLlaveHorarioActividadEmpresa_IdActividadMapeoEmpresaAndLlaveHorarioActividadEmpresa_IdActividad(idActividadMapeo,idActividad);


		if(!horarioActividadEmpresaEntityLista.isEmpty()) {

			for(HorarioActividadEmpresaEntity horarioActividadEmpresaEntity: horarioActividadEmpresaEntityLista) {

				if (horarioActividadEmpresaEntity.getBolActivo()) {

					horarioActividadEmpresaEntity.setIdUsuarioUltModificacion(horarioActividadEmpresaRequestDTO.getIdUsuario());
					horarioActividadEmpresaEntity.setBolActivo(false);
					Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
					horarioActividadEmpresaEntity.setFechaUltModificacion(fechaActual);
					horarioActividadEmpresaRepository.save(horarioActividadEmpresaEntity);
					horarioActividadEmpresaResponseDTO.setIdActividadEmpresa(idActividadMapeo);
				}

			}


		}
		return horarioActividadEmpresaResponseDTO;




	}




}
