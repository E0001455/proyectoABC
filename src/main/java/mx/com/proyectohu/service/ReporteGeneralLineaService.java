package mx.com.proyectohu.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.ListaContactoRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.component.ReporteGeneralCLDAO;
import mx.com.proyectohu.component.ReporteIndividualCLDAO;
import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;


@Service
public class ReporteGeneralLineaService {

	@Autowired
	public ListaContactoRepository listaContactoRepository;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaLineaRepository tareaLineaRepository;

	
	@Autowired
	public ReporteIndividualCLDAO reporteIndividualDAO;
	
	@Autowired
	public ReporteGeneralCLDAO reporteGeneralCLDAO; 


	public List<ReporteGeneralLCResponseDTO> consultaCLGeneralCarga(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		
		clRequestDTO.setTipoActividad("CRG");
		clRequestDTO.setTipoConsulta("CL");
		
				
		reporteGeneralLCResponseDTOlist = reporteGeneralCLDAO.consultarCLRegistroGeneralCarga(idLineaNegocio,clRequestDTO);

		return reporteGeneralLCResponseDTOlist;
	}



	public List<ReporteGeneralLCResponseDTO> consultaCLGeneralValidacion(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
	
		clRequestDTO.setTipoActividad("VLD");
		clRequestDTO.setTipoConsulta("CL");
		

		reporteGeneralLCResponseDTOlist = reporteGeneralCLDAO.consultarCLRegistroGeneralValidacion(idLineaNegocio,clRequestDTO);

		return reporteGeneralLCResponseDTOlist;
	}

	public List<ReporteGeneralLCResponseDTO> consultaCLGeneralEnvio(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();

		clRequestDTO.setTipoActividad("ENV");
		clRequestDTO.setTipoConsulta("CL");
	
		reporteGeneralLCResponseDTOlist = reporteGeneralCLDAO.consultarCLRegistroGeneralEnvio(idLineaNegocio,clRequestDTO);

		return reporteGeneralLCResponseDTOlist;
	}


}
