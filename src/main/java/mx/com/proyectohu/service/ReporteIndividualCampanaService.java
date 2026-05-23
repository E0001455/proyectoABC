package mx.com.proyectohu.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.component.ReporteIndividualPETDAO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseCargaDTO;
import mx.com.proyectohu.dto.PETResponseDTO;

@Service
public class ReporteIndividualCampanaService {
	
	@Autowired
	public ReporteIndividualPETDAO reporteIndividualPETDAO;
	
	public List<PETResponseCargaDTO> consultaPETCarga(PETRequestDTO petRequestDTO){
		List<PETResponseCargaDTO> petResponseDTOLista = new ArrayList<PETResponseCargaDTO>();
		petRequestDTO.setTipoActividad("CRG");
		
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualCarga(petRequestDTO);

		return petResponseDTOLista;
	}
	

	public List<PETResponseDTO> consultaPETValidacion(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		petRequestDTO.setTipoActividad("VLD");
		
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualValidacion(petRequestDTO);
		
		return petResponseDTOLista;
	}
	
	public List<PETResponseDTO> consultaPETEnvio(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		petRequestDTO.setTipoActividad("ENV");
	
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualEnvio(petRequestDTO);
		
		
		return petResponseDTOLista;
	}
	
	


}
