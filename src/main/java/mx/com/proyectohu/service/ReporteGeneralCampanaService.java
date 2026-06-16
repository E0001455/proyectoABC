package mx.com.proyectohu.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.component.ReporteGeneralPETDAO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;

@Service
public class ReporteGeneralCampanaService {

	
	@Autowired
	public ReporteGeneralPETDAO  reporteGeneralPETDAO;
	

	public List<ReporteGeneralPETResponseDTO> consultaPETCargaLineaNegocio(Long idLineaNegocio, Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		
		petRequestDTO.setTipoActividad("CRG");
		petRequestDTO.setTipoConsulta("PET");
		
		reporteGeneralPETResponseDTOList = reporteGeneralPETDAO.consultarCLRegistroGeneralCarga(idLineaNegocio,idCampana, petRequestDTO);
		
		return reporteGeneralPETResponseDTOList;
	}

	public List<ReporteGeneralPETResponseDTO> consultaPETGeneralValidacion(Long idLineaNegocio,Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		
		petRequestDTO.setTipoActividad("VLD");
		petRequestDTO.setTipoConsulta("PET");
		
		reporteGeneralPETResponseDTOList = reporteGeneralPETDAO.consultarPETRegistroGeneralValidacion(idLineaNegocio,idCampana,  petRequestDTO);
		
		return reporteGeneralPETResponseDTOList;
	}
	
	
	
	public List<ReporteGeneralPETResponseDTO> consultaPETEnvioLineaNegocio(Long idLineaNegocio,Long idCampana, PETRequestDTO petRequestDTO){
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOList = new ArrayList<ReporteGeneralPETResponseDTO>();
		
		petRequestDTO.setTipoActividad("ENV");
		petRequestDTO.setTipoConsulta("PET");
		reporteGeneralPETResponseDTOList = reporteGeneralPETDAO.consultarPETRegistroGeneralEnvio(idLineaNegocio, idCampana,petRequestDTO);
	
		
		return reporteGeneralPETResponseDTOList;
	}
	


}
