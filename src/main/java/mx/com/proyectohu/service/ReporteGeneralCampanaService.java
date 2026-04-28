package mx.com.proyectohu.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.CampanaRepository;
import mx.com.proyectohu.repository.ExtencionPerfilRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.component.ReporteGeneralPETDAO;
import mx.com.proyectohu.component.ReporteIndividualPETDAO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralCampanaRecordDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;

@Service
public class ReporteGeneralCampanaService {

	@Autowired
	public ExtencionPerfilRepository extencionPerfilRepository;
	
	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;
	
	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;
	
	@Autowired
	public CampanaRepository campanaRepository;
	
	@Autowired
	public ReporteIndividualPETDAO reporteIndividualPETDAO;
	
	@Autowired
	public ReporteGeneralPETDAO  reporteGeneralPETDAO;
	

	public List<ReporteGeneralPETResponseDTO> consultaPETCargaLineaNegocio(Long idLineaNegocio, Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		List<ReporteGeneralCampanaRecordDTO> tareaCampanaEntityList = new ArrayList<ReporteGeneralCampanaRecordDTO>();
		String nombrelineaNegocio = null;
		String nombreCampana = null;
		
		
		if (idLineaNegocio!=null) {
			nombrelineaNegocio = lineaNegocioRepository.findById(idLineaNegocio).get().getNombre();
		}
		

		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (petRequestDTO.getFechaInicio() != null) {
			inicio = petRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (petRequestDTO.getFechaFin() != null) {
			fin = petRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
			
			
		}
		
		
		
		tareaCampanaEntityList= tareaCampanaRepository.obtenerTareasCargaXFechas(nombrelineaNegocio, idCampana, inicio, fin);
		
		for(ReporteGeneralCampanaRecordDTO reporteGeneralCampanaRecordDTO: tareaCampanaEntityList ) {
			ReporteGeneralPETResponseDTO reporteGeneralPETResponseDTO = new ReporteGeneralPETResponseDTO();
			
			reporteGeneralPETResponseDTO.setNombreLineaNegocio(reporteGeneralCampanaRecordDTO.lineaDeNegocio());
			reporteGeneralPETResponseDTO.setTotalRegistros(reporteGeneralCampanaRecordDTO.registros().intValue());
			reporteGeneralPETResponseDTO.setFdFechaFin(reporteGeneralCampanaRecordDTO.fecha().toLocalDate());
			reporteGeneralPETResponseDTO.setNombreCampana(reporteGeneralCampanaRecordDTO.nombreCampana());
			
				
				
		
			
			reporteGeneralPETResponseDTOList.add(reporteGeneralPETResponseDTO);
			
		}
		
		return reporteGeneralPETResponseDTOList;
	}

	
	

	
	
	public List<ReporteGeneralPETResponseDTO> consultaPETGeneralValidacion(Long idLineaNegocio,Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		
		petRequestDTO.setTipoActividad("VLD");
		petRequestDTO.setTipoConsulta("PET");
		
		
		reporteGeneralPETResponseDTOList = reporteGeneralPETDAO.consultarPETRegistroGeneralValidacion(idLineaNegocio, petRequestDTO);
	
	
		
		return reporteGeneralPETResponseDTOList;
	}
	
	
	
	public List<ReporteGeneralPETResponseDTO> consultaPETEnvioLineaNegocio(Long idLineaNegocio,Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		List<TareaCampanaEntity> tareaCampanaEntityList = new ArrayList<TareaCampanaEntity>();
		String nombrelineaNegocio = null;
		String nombreCampana = null;
		
		
		
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (petRequestDTO.getFechaInicio() != null) {
			inicio = petRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (petRequestDTO.getFechaFin() != null) {
			fin = petRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
			
			
		}
		
		
		tareaCampanaEntityList= tareaCampanaRepository.obtenerTareasEnvioXFechas(idLineaNegocio, idCampana, inicio, fin);
		
		for(TareaCampanaEntity tareaCampanaEntity: tareaCampanaEntityList ) {
			ReporteGeneralPETResponseDTO reporteGeneralPETResponseDTO = new ReporteGeneralPETResponseDTO();
			
			reporteGeneralPETResponseDTO.setNombreMapeo(tareaCampanaEntity.getMapeoCampana().getNombre());
			
			nombrelineaNegocio = lineaNegocioRepository.findById(tareaCampanaEntity.getMapeoCampana().getIdABCCatLineaNegocio()).get().getNombre();
			reporteGeneralPETResponseDTO.setNombreLineaNegocio(nombrelineaNegocio);
			nombreCampana= campanaRepository.findById(tareaCampanaEntity.getMapeoCampana().getIdABCCatCampana()).get().getNombre();
			reporteGeneralPETResponseDTO.setNombreCampana(nombreCampana);
			reporteGeneralPETResponseDTO.setTotalRegistros(tareaCampanaEntity.getFinRegistros());
			reporteGeneralPETResponseDTO.setTotalRegistrosAprobados(tareaCampanaEntity.getRegistrosAprobados());
			reporteGeneralPETResponseDTO.setTotalRegistrosRechazados(tareaCampanaEntity.getRegistrosRechazados());
			
			Date date = new Date(); 
			LocalDate localDate = tareaCampanaEntity.getFdFechaFin().toInstant()
			                          .atZone(ZoneId.systemDefault())
			                          .toLocalDate();
			reporteGeneralPETResponseDTO.setFdFechaFin(localDate);
			
				
				
		
			
			reporteGeneralPETResponseDTOList.add(reporteGeneralPETResponseDTO);
			
		}
		
		return reporteGeneralPETResponseDTOList;
	}
	


}
