package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.ListaContactoRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.component.ReporteIndividualCLDAO;
import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseCargaDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.CLResponseEnvioDTO;


@Service
public class ReporteIndividualLineaService {

	@Autowired
	public ListaContactoRepository listaContactoRepository;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaLineaRepository tareaLineaRepository;

	
	@Autowired
	public ReporteIndividualCLDAO reporteIndividualDAO;

	public List<CLResponseCargaDTO> consultaCLCarga(CLRequestDTO clRequestDTO){
		List<CLResponseCargaDTO> clResponseDTOLista = new ArrayList<CLResponseCargaDTO>();
		clRequestDTO.setTipoActividad("CRG");
	
		clResponseDTOLista = reporteIndividualDAO.consultarCLRegistroIndividualCarga(clRequestDTO);
		
		return clResponseDTOLista;
	}


	
	public List<CLResponseDTO> consultaCLValidacion(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		clRequestDTO.setTipoActividad("VLD");

		clResponseDTOLista=reporteIndividualDAO.consultarCLRegistroIndividualValidacion(clRequestDTO);


		return clResponseDTOLista;
	}

	public List<CLResponseEnvioDTO> consultaCLEnvio(CLRequestDTO clRequestDTO){
		List<CLResponseEnvioDTO> clResponseDTOLista = new ArrayList<CLResponseEnvioDTO>();
		clRequestDTO.setTipoActividad("ENV");
		

		clResponseDTOLista=reporteIndividualDAO.consultarCLRegistroIndividualEnvio(clRequestDTO);

		return clResponseDTOLista;
	}


	

}
