package mx.com.proyectohu.service;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.TareaHorarioLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.dto.HorarioLineaDTO;
import mx.com.proyectohu.dto.TareaLineaHorarioRequestDTO;
import mx.com.proyectohu.dto.TareaLineaHorarioResponseDTO;
import mx.com.proyectohu.dto.TareaLineaHorarioResponseDTO.Dia;
import mx.com.proyectohu.dto.TareaLineaHorarioResponseDTO.Hora;
import mx.com.proyectohu.dto.TareaLineaRequestDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatActividad;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatEjecucion;
import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.LlaveTareaHorarioLinea;
import mx.com.proyectohu.entity.TareaHorarioLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;

@Service
public class TareaHorarioLineaService {

	@Autowired
	public TareaHorarioLineaRepository tareaHorarioLineaRepository;


	public void  registrarTareaLineaHorario(Long idTareaLinea,TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO) {


		TareaHorarioLineaEntity tareaHorarioLineaEntity = new TareaHorarioLineaEntity();


		for (HorarioLineaDTO horarioLineaDTO :tareaLineaHorarioRequestDTO.getHorarioLineaDTO()) {

			LlaveTareaHorarioLinea llaveTareaHorarioLinea = new LlaveTareaHorarioLinea();

			llaveTareaHorarioLinea.setIdCFGTareaLinea(idTareaLinea);
			llaveTareaHorarioLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveTareaHorarioLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());

			tareaHorarioLineaEntity.setLlaveTareaHorarioLinea(llaveTareaHorarioLinea);
			tareaHorarioLineaEntity.setIdUsuario(tareaLineaHorarioRequestDTO.getIdUsuario());
			tareaHorarioLineaEntity.setIdUsuarioUltModificacion(tareaLineaHorarioRequestDTO.getIdUsuario());
			tareaHorarioLineaEntity.setBolActivo(true);
			tareaHorarioLineaEntity.setFechaCreacion(new Date());
			tareaHorarioLineaEntity.setFechaUltModificacion(new Date());



			tareaHorarioLineaRepository.save(tareaHorarioLineaEntity);

		}







	}


	public List<TareaLineaHorarioResponseDTO>  consultarTareasLineaHorarios(Long idTareaLinea){
		List<TareaLineaHorarioResponseDTO> tareaLineaHorarioResponseDTOLista = new ArrayList<TareaLineaHorarioResponseDTO>();
		List<TareaHorarioLineaEntity>  tareaHorarioLineaEntityLista= new ArrayList<TareaHorarioLineaEntity>();

		tareaHorarioLineaEntityLista = tareaHorarioLineaRepository.findByLlaveTareaHorarioLinea_idCFGTareaLinea(idTareaLinea);


		if(!tareaHorarioLineaEntityLista.isEmpty()) {


			for(TareaHorarioLineaEntity tareaHorarioLineaEntity: tareaHorarioLineaEntityLista) {

				TareaLineaHorarioResponseDTO tareaLineaHorarioResponseDTO = new TareaLineaHorarioResponseDTO();
				Dia dia= new Dia();
				Hora hora = new Hora();
				hora.setIdHora(tareaHorarioLineaEntity.getLlaveTareaHorarioLinea().getIdHora());
				dia.setIdDia(tareaHorarioLineaEntity.getLlaveTareaHorarioLinea().getIdDia());
				dia.setHora(hora);

				tareaLineaHorarioResponseDTO.setDia(dia);
				tareaLineaHorarioResponseDTO.setBolActivo(tareaHorarioLineaEntity.getBolActivo());
				tareaLineaHorarioResponseDTO.setFechaCreacion(tareaHorarioLineaEntity.getFechaCreacion());
				tareaLineaHorarioResponseDTO.setFechaUltModificacion(tareaHorarioLineaEntity.getFechaUltModificacion());



				tareaLineaHorarioResponseDTOLista.add(tareaLineaHorarioResponseDTO);


			}

		}


		return tareaLineaHorarioResponseDTOLista;

	}





	public TareaLineaHorarioResponseDTO activar(Long idTareaLinea, TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO) {
		TareaLineaHorarioResponseDTO tareaLineaHorarioResponseDTO = new TareaLineaHorarioResponseDTO();

		for (HorarioLineaDTO horarioLineaDTO :tareaLineaHorarioRequestDTO.getHorarioLineaDTO()) {

			LlaveTareaHorarioLinea llaveTareaHorarioLinea = new LlaveTareaHorarioLinea();

			llaveTareaHorarioLinea.setIdCFGTareaLinea(idTareaLinea);
			llaveTareaHorarioLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveTareaHorarioLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());
			Optional<TareaHorarioLineaEntity> tareaHorarioLineaEntityOptional = tareaHorarioLineaRepository.findById(llaveTareaHorarioLinea);

			if(tareaHorarioLineaEntityOptional.isPresent()) {
				TareaHorarioLineaEntity tareaHorarioLineaEntity = tareaHorarioLineaEntityOptional.get();
				if (!tareaHorarioLineaEntity.getBolActivo()) {

					tareaHorarioLineaEntity.setIdUsuarioUltModificacion(tareaLineaHorarioRequestDTO.getIdUsuario());
					tareaHorarioLineaEntity.setBolActivo(true);
					tareaHorarioLineaEntity.setFechaUltModificacion(new Date());
					tareaHorarioLineaRepository.save(tareaHorarioLineaEntity);
					tareaLineaHorarioResponseDTO.setIdCFGTareaLinea(idTareaLinea);
				}
			}else {
				continue;
			}
		}

		
		return tareaLineaHorarioResponseDTO;
	}

	public TareaLineaHorarioResponseDTO desactivar(Long idTareaLinea, TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO) {
		TareaLineaHorarioResponseDTO tareaLineaHorarioResponseDTO = new TareaLineaHorarioResponseDTO();
		
		for (HorarioLineaDTO horarioLineaDTO :tareaLineaHorarioRequestDTO.getHorarioLineaDTO()) {

			LlaveTareaHorarioLinea llaveTareaHorarioLinea = new LlaveTareaHorarioLinea();

			llaveTareaHorarioLinea.setIdCFGTareaLinea(idTareaLinea);
			llaveTareaHorarioLinea.setIdDia(horarioLineaDTO.getDia().getIdDia());
			llaveTareaHorarioLinea.setIdHora(horarioLineaDTO.getDia().getHora().getIdHora());
			Optional<TareaHorarioLineaEntity> tareaHorarioLineaEntityOptional = tareaHorarioLineaRepository.findById(llaveTareaHorarioLinea);

			if(tareaHorarioLineaEntityOptional.isPresent()) {
				TareaHorarioLineaEntity tareaHorarioLineaEntity = tareaHorarioLineaEntityOptional.get();
				if (tareaHorarioLineaEntity.getBolActivo()) {

					tareaHorarioLineaEntity.setIdUsuarioUltModificacion(tareaLineaHorarioRequestDTO.getIdUsuario());
					tareaHorarioLineaEntity.setBolActivo(false);
					tareaHorarioLineaEntity.setFechaUltModificacion(new Date());
					tareaHorarioLineaRepository.save(tareaHorarioLineaEntity);
					
					tareaLineaHorarioResponseDTO.setIdCFGTareaLinea(idTareaLinea);
				}
			}else {
				continue;
			}
		}

		
		return tareaLineaHorarioResponseDTO;
	}




}
