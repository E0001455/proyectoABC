package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.BitacoraTareaLineaDTO;
import mx.com.proyectohu.dto.DiaDTO;
import mx.com.proyectohu.dto.HoraDTO;
import mx.com.proyectohu.dto.MapeoDTO;
import mx.com.proyectohu.dto.TareaDTO;
import mx.com.proyectohu.dto.TareaDTO.CatActividad;
import mx.com.proyectohu.dto.TareaDTO.CatEjecucion;
import mx.com.proyectohu.dto.TareaDTO.CatEstatus;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;

import mx.com.proyectohu.dto.TareaLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.BitacoraTareaLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;


@Service
public class TareaLineaService {


	@Autowired
	public TareaLineaRepository tareaLineaRepository;

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;

	@Autowired
	public BitacoraTareaLineaRepository bitacoraTareaLineaRepository;

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
	public List<TareaLineaResponseDTO>  consultarTareasLinea(){
		List<TareaLineaResponseDTO> tareaLineaResponseDTOLista = new ArrayList<TareaLineaResponseDTO>();
		List<TareaLineaEntity>  tareaLineaEntityLista= new ArrayList<TareaLineaEntity>();

		tareaLineaEntityLista = tareaLineaRepository.findAll(Sort.by("idTareaLinea").ascending().and(Sort.by("idMapeoLinea").ascending().and(Sort.by("idActividadLinea").ascending())));



		if(!tareaLineaEntityLista.isEmpty()) {

			Long mapeo=null;
			List<TareaDTO>  tareaDTOLista = new ArrayList<TareaDTO>();
			TareaDTO tareaDTO = new TareaDTO();



			for(TareaLineaEntity tareaLineaEntity: tareaLineaEntityLista) {

				if(mapeo==tareaLineaEntity.getIdMapeoLinea()) {
					tareaDTO = new TareaDTO();
					CatActividad catActividad = new CatActividad();
					CatEjecucion catEjecucion = new CatEjecucion();
					DiaDTO diaDTO = new DiaDTO();
					HoraDTO horaDTO = new HoraDTO();
					CatEstatus catEstatus = new CatEstatus();

					catActividad.setIdActividad(tareaLineaEntity.getIdActividad());
					catEjecucion.setIdEjecucion(tareaLineaEntity.getIdEjecucion());
					diaDTO.setIdDia(tareaLineaEntity.getIdDia());
					horaDTO.setIdHora(tareaLineaEntity.getIdHora());
					catEstatus.setIdEstatus(tareaLineaEntity.getIdEstatusTarea());
					
					List<BitacoraTareaLineaEntity> bitacoraTareaLineaList =new ArrayList<BitacoraTareaLineaEntity>();
					
					bitacoraTareaLineaList = bitacoraTareaLineaRepository.findByidTareaLinea(tareaLineaEntity.getIdTareaLinea());
					
					List<BitacoraTareaLineaDTO> bitacoraTareaLineaLista =new ArrayList<BitacoraTareaLineaDTO>(); 
					
					for(BitacoraTareaLineaEntity bitacoraTareaLineaEntity : bitacoraTareaLineaList) {
						BitacoraTareaLineaDTO bitacoraTareaLineaDTO = new BitacoraTareaLineaDTO();
						bitacoraTareaLineaDTO.setId(bitacoraTareaLineaEntity.getIdEstatusTarea());
						bitacoraTareaLineaDTO.setDetalle(bitacoraTareaLineaEntity.getDetalle());
						bitacoraTareaLineaDTO.setFechaCreacion(bitacoraTareaLineaEntity.getFechaCreacion());
						bitacoraTareaLineaLista.add(bitacoraTareaLineaDTO);
					}
					
					tareaDTO.setBitacoraTareaLinea(bitacoraTareaLineaLista);


					tareaDTO.setCatActividad(catActividad);
					tareaDTO.setCatEjecucion(catEjecucion);

					tareaDTO.setDiaDTO(diaDTO);
					tareaDTO.setHoraDTO(horaDTO);
					tareaDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdTareaLinea());
					
					tareaDTO.setFdFechaInicio(tareaLineaEntity.getFdFechaInicio());
					tareaDTO.setFdFechaFin(tareaLineaEntity.getFdFechaFin());
					tareaDTO.setFinRegistros(tareaLineaEntity.getFinRegistros());
					tareaDTO.setFinProcesados(tareaLineaEntity.getFinProcesados());
					tareaDTO.setFechaCreacion(tareaLineaEntity.getFechaCreacion());
					tareaDTO.setFiDictaminacion(tareaLineaEntity.getFiDictaminacion());


					tareaDTOLista.add(tareaDTO);


					continue;
				}

				MapeoDTO mapeoDTO = new MapeoDTO();	
				TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();
				mapeoDTO.setIdABCConfigMapeoLinea(tareaLineaEntity.getIdMapeoLinea());
				Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(tareaLineaEntity.getIdMapeoLinea());
				mapeoDTO.setNombre(abcConfigMapeoLineaEntityOptional.get().getNombre());
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				catLineaNegocio.setIdLineaNegocio(abcConfigMapeoLineaEntityOptional.get().getIdABCCatLineaNegocio());
				tareaLineaResponseDTO.setCatLineaNegocio(catLineaNegocio);
				tareaLineaResponseDTO.setMapeoDTO(mapeoDTO);
				tareaDTOLista = new ArrayList<TareaDTO>();
				tareaDTO = new TareaDTO();
				CatActividad catActividad = new CatActividad();
				CatEjecucion catEjecucion = new CatEjecucion();
				DiaDTO diaDTO = new DiaDTO();
				HoraDTO horaDTO = new HoraDTO();
				CatEstatus catEstatus = new CatEstatus();

				catActividad.setIdActividad(tareaLineaEntity.getIdActividad());
				catEjecucion.setIdEjecucion(tareaLineaEntity.getIdEjecucion());
				diaDTO.setIdDia(tareaLineaEntity.getIdDia());
				horaDTO.setIdHora(tareaLineaEntity.getIdHora());
				catEstatus.setIdEstatus(tareaLineaEntity.getIdEstatusTarea());


				tareaDTO.setCatActividad(catActividad);
				tareaDTO.setCatEjecucion(catEjecucion);
				
				List<BitacoraTareaLineaEntity> bitacoraTareaLineaList =new ArrayList<BitacoraTareaLineaEntity>();
				
				bitacoraTareaLineaList = bitacoraTareaLineaRepository.findByidTareaLinea(tareaLineaEntity.getIdTareaLinea());
				
				List<BitacoraTareaLineaDTO> bitacoraTareaLineaLista =new ArrayList<BitacoraTareaLineaDTO>(); 
				
				for(BitacoraTareaLineaEntity bitacoraTareaLineaEntity : bitacoraTareaLineaList) {
					BitacoraTareaLineaDTO bitacoraTareaLineaDTO = new BitacoraTareaLineaDTO();
					bitacoraTareaLineaDTO.setId(bitacoraTareaLineaEntity.getIdEstatusTarea());
					bitacoraTareaLineaDTO.setDetalle(bitacoraTareaLineaEntity.getDetalle());
					bitacoraTareaLineaDTO.setFechaCreacion(bitacoraTareaLineaEntity.getFechaCreacion());
					bitacoraTareaLineaLista.add(bitacoraTareaLineaDTO);
				}
				
				tareaDTO.setBitacoraTareaLinea(bitacoraTareaLineaLista);
				
				tareaDTO.setDiaDTO(diaDTO);
				tareaDTO.setHoraDTO(horaDTO);
				tareaDTO.setIdCFGTareaLinea(tareaLineaEntity.getIdTareaLinea());
				
				tareaDTO.setFdFechaInicio(tareaLineaEntity.getFdFechaInicio());
				tareaDTO.setFdFechaFin(tareaLineaEntity.getFdFechaFin());
				tareaDTO.setFinRegistros(tareaLineaEntity.getFinRegistros());
				tareaDTO.setFinProcesados(tareaLineaEntity.getFinProcesados());
				tareaDTO.setFechaCreacion(tareaLineaEntity.getFechaCreacion());
				tareaDTO.setFiDictaminacion(tareaLineaEntity.getFiDictaminacion());


				tareaDTOLista.add(tareaDTO);
				tareaLineaResponseDTO.setTareaDTO(tareaDTOLista);

				tareaLineaResponseDTOLista.add(tareaLineaResponseDTO);

				mapeo=mapeoDTO.getIdABCConfigMapeoLinea();

			}

		}


		return tareaLineaResponseDTOLista;

	}
}
