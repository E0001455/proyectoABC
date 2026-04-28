package mx.com.proyectohu.service;


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
import mx.com.proyectohu.component.ReporteIndividualPETDAO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralCampanaRecordDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;

@Service
public class ReporteIndividualCampanaService {

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
	
	public List<PETResponseDTO> consultaPETCarga(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		petRequestDTO.setTipoActividad("CRG");
		
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualCarga(petRequestDTO);

		return petResponseDTOLista;
	}
	

	public List<PETResponseDTO> consultaPETValidacion(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		petRequestDTO.setTipoActividad("VLD");
		
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualValidacion(petRequestDTO);
		
		return petResponseDTOLista;
	}
	
	public List<PETResponseDTO> consultaPETEnvio(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		petRequestDTO.setTipoActividad("ENV");
	
		petResponseDTOLista = reporteIndividualPETDAO.consultarPETRegistroIndividualEnvio(petRequestDTO);
		
		
		return petResponseDTOLista;
	}
	
	


}
