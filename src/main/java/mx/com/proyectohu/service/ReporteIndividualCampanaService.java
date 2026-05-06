package mx.com.proyectohu.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.CampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.component.ReporteIndividualPETDAO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseDTO;

@Service
public class ReporteIndividualCampanaService {
	
	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;
	
	@Autowired
	public CampanaRepository campanaRepository;
	
	@Autowired
	public ReporteIndividualPETDAO reporteIndividualPETDAO;
	
	public List<PETResponseDTO> consultaPETCarga(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
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
