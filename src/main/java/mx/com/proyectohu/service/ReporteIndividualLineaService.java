package mx.com.proyectohu.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.ListaContactoRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.component.ReporteIndividualCLDAO;
import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;
import mx.com.proyectohu.entity.BitacoraListaContactoEntity;
import mx.com.proyectohu.entity.ListaContactoEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;


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

	public List<CLResponseDTO> consultaCLCarga(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		clRequestDTO.setTipoActividad("CRG");
		LocalDateTime inicio = null;
		LocalDateTime fin = null;
	
		clResponseDTOLista = reporteIndividualDAO.consultarCLRegistroIndividualCarga(clRequestDTO);
		
		return clResponseDTOLista;
	}


	
	public List<CLResponseDTO> consultaCLValidacion(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		clRequestDTO.setTipoActividad("VLD");

		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}

		
		clResponseDTOLista=reporteIndividualDAO.consultarCLRegistroIndividualValidacion(clRequestDTO);


		return clResponseDTOLista;
	}

	public List<CLResponseDTO> consultaCLEnvio(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		clRequestDTO.setTipoActividad("ENV");
		
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}


		clResponseDTOLista=reporteIndividualDAO.consultarCLRegistroIndividualEnvio(clRequestDTO);

		return clResponseDTOLista;
	}


	

}
