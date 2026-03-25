package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.BitacoraTareaCampanaDTO;
import mx.com.proyectohu.dto.DiaDTO;
import mx.com.proyectohu.dto.HoraDTO;
import mx.com.proyectohu.dto.MapeoCampanaDTO;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.TareaCampanaDTO;
import mx.com.proyectohu.dto.TareaCampanaDTO.CatActividad;
import mx.com.proyectohu.dto.TareaCampanaDTO.CatEjecucion;
import mx.com.proyectohu.dto.TareaCampanaDTO.CatEstatus;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatCampana;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;
import mx.com.proyectohu.repository.BitacoraTareaCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;


@Service
public class TareaCampanaService {


	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;

	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;

	@Autowired
	public BitacoraTareaCampanaRepository bitacoraTareaCampanaRepository;

	/*


	public Long  registrarTareaLinea(Long idLineaNegocio,TareaLineaRequestDTO tareaLineaRequestDTO) {


		TareaLineaEntity tareaLineaEntity = new TareaLineaEntity();
		Long idTareaLinea = 0L;

		tareaLineaEntity.setIdMapeoLinea(idLineaNegocio);
		tareaLineaEntity.setIdActividadLinea(1l);
		tareaLineaEntity.setIdActividad(tareaLineaRequestDTO.getTareaDTO().getActividad().getIdActividad());
		tareaLineaEntity.setIdEjecucion(tareaLineaRequestDTO.getTareaDTO().getEjecucion().getIdEjecucion());
		tareaLineaEntity.setIdDia(tareaLineaRequestDTO.getTareaDTO().getHorarioLineaDTO().getDiaDTO().getIdDia());
		tareaLineaEntity.setIdHora(tareaLineaRequestDTO.getTareaDTO().getHorarioLineaDTO().getDiaDTO().getHoraDTO().getIdHora());
		tareaLineaEntity.setIdEstatusTarea(1l);
		tareaLineaEntity.setFinRegistros(tareaLineaRequestDTO.getTareaDTO().getRegistros());
		tareaLineaEntity.setFechaCreacion(new Date());
		tareaLineaEntity.setFechaUltModificacion(new Date());


		idTareaLinea=tareaLineaRepository.save(tareaLineaEntity).getIdTareaLinea();


		return	idTareaLinea;	

	}

	 */
	public List<TareaCampanaResponseDTO>  consultarTareasCampanas(){
		List<TareaCampanaResponseDTO> tareaCampanaResponseDTOLista = new ArrayList<TareaCampanaResponseDTO>();
		List<TareaCampanaEntity>  tareaCampanaEntityLista= new ArrayList<TareaCampanaEntity>();

		tareaCampanaEntityLista = tareaCampanaRepository.findAll(Sort.by("idTareaCampana").ascending().and(Sort.by("idMapeoCampana").ascending().and(Sort.by("idActividadCampana").ascending())));



		if(!tareaCampanaEntityLista.isEmpty()) {

			Long mapeo=null;
			List<TareaCampanaDTO>  tareaDTOLista = new ArrayList<TareaCampanaDTO>();
			TareaCampanaDTO tareaDTO = new TareaCampanaDTO();



			for(TareaCampanaEntity tareaCampanaEntity: tareaCampanaEntityLista) {

				if(mapeo==tareaCampanaEntity.getIdMapeoCampana()) {
					tareaDTO = new TareaCampanaDTO();
					CatActividad catActividad = new CatActividad();
					CatEjecucion catEjecucion = new CatEjecucion();
					DiaDTO diaDTO = new DiaDTO();
					HoraDTO horaDTO = new HoraDTO();
					CatEstatus catEstatus = new CatEstatus();

					catActividad.setIdActividad(tareaCampanaEntity.getIdActividad());
					catEjecucion.setIdEjecucion(tareaCampanaEntity.getIdEjecucion());
					diaDTO.setIdDia(tareaCampanaEntity.getIdDia());
					horaDTO.setIdHora(tareaCampanaEntity.getIdHora());
					catEstatus.setIdEstatus(tareaCampanaEntity.getIdEstatusTarea());
					
					List<BitacoraTareaCampanaEntity> bitacoraTareaCampanaList =new ArrayList<BitacoraTareaCampanaEntity>();
					
					bitacoraTareaCampanaList = bitacoraTareaCampanaRepository.findByidTareaCampana(tareaCampanaEntity.getIdTareaCampana());
					
					List<BitacoraTareaCampanaDTO> bitacoraTareaLineaLista =new ArrayList<BitacoraTareaCampanaDTO>(); 
					
					for(BitacoraTareaCampanaEntity bitacoraTareaCampanaEntity : bitacoraTareaCampanaList) {
						BitacoraTareaCampanaDTO bitacoraTareaCampanaDTO = new BitacoraTareaCampanaDTO();
						bitacoraTareaCampanaDTO.setId(bitacoraTareaCampanaEntity.getIdEstatusTarea());
						bitacoraTareaCampanaDTO.setDetalle(bitacoraTareaCampanaEntity.getDetalle());
						bitacoraTareaCampanaDTO.setFechaCreacion(bitacoraTareaCampanaEntity.getFechaCreacion());
						bitacoraTareaLineaLista.add(bitacoraTareaCampanaDTO);
					}
					
					tareaDTO.setBitacoraTareaCampana(bitacoraTareaLineaLista);


					tareaDTO.setCatActividad(catActividad);
					tareaDTO.setCatEjecucion(catEjecucion);

					tareaDTO.setDiaDTO(diaDTO);
					tareaDTO.setHoraDTO(horaDTO);
					tareaDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdTareaCampana());
					
					tareaDTO.setFdFechaInicio(tareaCampanaEntity.getFdFechaInicio());
					tareaDTO.setFdFechaFin(tareaCampanaEntity.getFdFechaFin());
					tareaDTO.setFinRegistros(tareaCampanaEntity.getFinRegistros());
					tareaDTO.setFinProcesados(tareaCampanaEntity.getFinProcesados());
					tareaDTO.setFechaCreacion(tareaCampanaEntity.getFechaCreacion());
					tareaDTO.setFiDictaminacion(tareaCampanaEntity.getFiDictaminacion());
					

					tareaDTOLista.add(tareaDTO);


					continue;
				}

				MapeoCampanaDTO mapeoCampanaDTO = new MapeoCampanaDTO();	
				TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();
				mapeoCampanaDTO.setIdABCConfigMapeoCampana(tareaCampanaEntity.getIdMapeoCampana());
				CatCampana catCampana = new CatCampana();
				Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(tareaCampanaEntity.getIdMapeoCampana());
				mapeoCampanaDTO.setNombre(abcConfigMapeoCampanaEntityOptional.get().getNombre());
				catCampana.setIdCampana(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatCampana());
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				catLineaNegocio.setIdLineaNegocio(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatLineaNegocio());
				tareaCampanaResponseDTO.setCatLineaNegocio(catLineaNegocio);
				tareaCampanaResponseDTO.setMapeoCampanaDTO(mapeoCampanaDTO);
				tareaCampanaResponseDTO.setCatCampana(catCampana);
				tareaDTOLista = new ArrayList<TareaCampanaDTO>();
				tareaDTO = new TareaCampanaDTO();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();
				DiaDTO diaDTO = new DiaDTO();
				HoraDTO horaDTO = new HoraDTO();
				CatEstatus catEstatus = new CatEstatus();

				catActividad.setIdActividad(tareaCampanaEntity.getIdActividad());
				catEjecucion.setIdEjecucion(tareaCampanaEntity.getIdEjecucion());
				diaDTO.setIdDia(tareaCampanaEntity.getIdDia());
				horaDTO.setIdHora(tareaCampanaEntity.getIdHora());
				catEstatus.setIdEstatus(tareaCampanaEntity.getIdEstatusTarea());


				tareaDTO.setCatActividad(catActividad);
				tareaDTO.setCatEjecucion(catEjecucion);
				
				List<BitacoraTareaCampanaEntity> bitacoraTareaCampanaList =new ArrayList<BitacoraTareaCampanaEntity>();
				
				bitacoraTareaCampanaList = bitacoraTareaCampanaRepository.findByidTareaCampana(tareaCampanaEntity.getIdTareaCampana());
				
				List<BitacoraTareaCampanaDTO> bitacoraTareaCampanaLista =new ArrayList<BitacoraTareaCampanaDTO>(); 
				
				for(BitacoraTareaCampanaEntity bitacoraTareaLineaEntity : bitacoraTareaCampanaList) {
					BitacoraTareaCampanaDTO bitacoraTareaCampanaDTO = new BitacoraTareaCampanaDTO();
					bitacoraTareaCampanaDTO.setId(bitacoraTareaLineaEntity.getIdEstatusTarea());
					bitacoraTareaCampanaDTO.setDetalle(bitacoraTareaLineaEntity.getDetalle());
					bitacoraTareaCampanaDTO.setFechaCreacion(bitacoraTareaLineaEntity.getFechaCreacion());
					bitacoraTareaCampanaLista.add(bitacoraTareaCampanaDTO);
				}
				
				tareaDTO.setBitacoraTareaCampana(bitacoraTareaCampanaLista);
				
				tareaDTO.setDiaDTO(diaDTO);
				tareaDTO.setHoraDTO(horaDTO);
				tareaDTO.setIdCFGTareaCampana(tareaCampanaEntity.getIdTareaCampana());
				
				tareaDTO.setFdFechaInicio(tareaCampanaEntity.getFdFechaInicio());
				tareaDTO.setFdFechaFin(tareaCampanaEntity.getFdFechaFin());
				tareaDTO.setFinRegistros(tareaCampanaEntity.getFinRegistros());
				tareaDTO.setFinProcesados(tareaCampanaEntity.getFinProcesados());
				tareaDTO.setFechaCreacion(tareaCampanaEntity.getFechaCreacion());
				tareaDTO.setFiDictaminacion(tareaCampanaEntity.getFiDictaminacion());
				

				tareaDTOLista.add(tareaDTO);
				tareaCampanaResponseDTO.setTareaDTO(tareaDTOLista);

				tareaCampanaResponseDTOLista.add(tareaCampanaResponseDTO);

				mapeo=mapeoCampanaDTO.getIdABCConfigMapeoCampana();

			}

		}


		return tareaCampanaResponseDTOLista;

	}
}
