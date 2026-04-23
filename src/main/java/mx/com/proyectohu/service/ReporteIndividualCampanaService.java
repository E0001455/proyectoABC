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
	
	public List<PETResponseDTO> consultaPETCarga(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (petRequestDTO.getFechaInicio() != null) {
		    inicio = petRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (petRequestDTO.getFechaFin() != null) {
		    fin = petRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}
		
		
		
		extensionPerfilEntityList = extencionPerfilRepository.buscarExtencionPerfilConBitacora(
				petRequestDTO.getNoLote(),
				petRequestDTO.getIdCliente(),
				petRequestDTO.getIdAfore(),
				petRequestDTO.getIdClienteAhorrador(),
				petRequestDTO.getIdPrestamoPensionado(),
				petRequestDTO.getIdSusceptiblePrestamo(),
				petRequestDTO.getIdBajaCambio(),
				petRequestDTO.getIdComunicacion(),
				petRequestDTO.getIdPersona(),
				petRequestDTO.getNombre(),
				petRequestDTO.getApellido(),
				inicio,
				fin);
		
		for(ExtensionPerfilEntity extensionPerfilEntity: extensionPerfilEntityList ) {
			PETResponseDTO petResponseDTO = new PETResponseDTO();
			
			petResponseDTO.setLineaDeNegocio(extensionPerfilEntity.getLineaDeNegocio());
			petResponseDTO.setIdCampana(extensionPerfilEntity.getIdCampana());
			petResponseDTO.setNumLote(extensionPerfilEntity.getNumLote());
			petResponseDTO.setCustomerId(extensionPerfilEntity.getCustomerId());
			petResponseDTO.setIdAfore(extensionPerfilEntity.getIdAfore());
			petResponseDTO.setDescripcionDeAfore(extensionPerfilEntity.getDescripcionDeAfore());
			petResponseDTO.setIdClienteAhorrrador(extensionPerfilEntity.getIdClienteAhorrador());
			petResponseDTO.setIdPrestamoPensionado(extensionPerfilEntity.getIdPrestamoPensionado());
			petResponseDTO.setIdSusceptiblePrestamo(extensionPerfilEntity.getIdSusceptiblePrestamo());
			petResponseDTO.setIdBajaCambio(extensionPerfilEntity.getIdBajaCambio());
			petResponseDTO.setIdComunicacion(extensionPerfilEntity.getIdComunicacion());
			petResponseDTO.setIdPersona(extensionPerfilEntity.getIdpersona());
			petResponseDTO.setFirstName(extensionPerfilEntity.getFirstName());
			petResponseDTO.setLastName(extensionPerfilEntity.getLastName());
			petResponseDTO.setCorreo(extensionPerfilEntity.getCorreo());
			petResponseDTO.setTelefono(extensionPerfilEntity.getTelefono());
			petResponseDTO.setSiefore(extensionPerfilEntity.getSiefore());
			petResponseDTO.setSegmento(extensionPerfilEntity.getSegmento());
			petResponseDTO.setRegimen(extensionPerfilEntity.getRegimen());
			petResponseDTO.setTipoPension(extensionPerfilEntity.getTipoPension());
			petResponseDTO.setGrupoPago(extensionPerfilEntity.getGrupoPago());
			petResponseDTO.setFechaBajaCambio(extensionPerfilEntity.getFechaBajaCambio());
			petResponseDTO.setRegimenImss(extensionPerfilEntity.getRegimenImss());
			petResponseDTO.setSegmentoAfo(extensionPerfilEntity.getSegmentoAfo());
			petResponseDTO.setEdad(extensionPerfilEntity.getEdad());
			petResponseDTO.setGenero(extensionPerfilEntity.getGenero());
			petResponseDTO.setLigaRsaldos(extensionPerfilEntity.getLigaRsaldos());
			petResponseDTO.setSegmentoPre(extensionPerfilEntity.getSegmentoPre());
			petResponseDTO.setDomicilioPreferente(extensionPerfilEntity.getDomicilioPreferente());
			petResponseDTO.setEmpresa(extensionPerfilEntity.getEmpresa());
			petResponseDTO.setSegmentoProy(extensionPerfilEntity.getSegmentoProy());
			petResponseDTO.setPaterno(extensionPerfilEntity.getPaterno());
			petResponseDTO.setLigaTitular(extensionPerfilEntity.getLigaTitular());
			petResponseDTO.setInstituto(extensionPerfilEntity.getInstituto());
			petResponseDTO.setTrabajador(extensionPerfilEntity.getTrabajador());
			petResponseDTO.setEntidad(extensionPerfilEntity.getEntidad());
			petResponseDTO.setMediosDigitales(extensionPerfilEntity.getMediosDigitales());
			petResponseDTO.setApertura(extensionPerfilEntity.getApertura());
			petResponseDTO.setNumeroHijos(extensionPerfilEntity.getNumeroHijos());
			petResponseDTO.setMasy65(extensionPerfilEntity.getMasy65());
			petResponseDTO.setMenores(extensionPerfilEntity.getMenores());
			petResponseDTO.setCuentaMenor1(extensionPerfilEntity.getCuentaMenor1());
			petResponseDTO.setNombreHijo1(extensionPerfilEntity.getNombreHijo1());
			petResponseDTO.setLigaHijo1(extensionPerfilEntity.getLigaHijo1());
			petResponseDTO.setCuentaMenor2(extensionPerfilEntity.getCuentaMenor2());
			petResponseDTO.setNombreHijo2(extensionPerfilEntity.getNombreHijo2());
			petResponseDTO.setLigaHijo2(extensionPerfilEntity.getLigaHijo2());
			petResponseDTO.setCuentaMenor3(extensionPerfilEntity.getCuentaMenor3());
			petResponseDTO.setNombreHijo3(extensionPerfilEntity.getNombreHijo3());
			petResponseDTO.setLigaHijo3(extensionPerfilEntity.getLigaHijo3());
			petResponseDTO.setCuentaMenor4(extensionPerfilEntity.getCuentaMenor4());
			petResponseDTO.setNombreHijo4(extensionPerfilEntity.getNombreHijo4());
			petResponseDTO.setLigaHijo4(extensionPerfilEntity.getLigaHijo4());
			petResponseDTO.setCuentaMenor5(extensionPerfilEntity.getCuentaMenor5());
			petResponseDTO.setNombreHijo5(extensionPerfilEntity.getNombreHijo5());
			petResponseDTO.setLigaHijo5(extensionPerfilEntity.getLigaHijo5());
			petResponseDTO.setCuentaMenor6(extensionPerfilEntity.getCuentaMenor6());
			petResponseDTO.setNombreHijo6(extensionPerfilEntity.getNombreHijo6());
			petResponseDTO.setLigaHijo6(extensionPerfilEntity.getLigaHijo6());
			petResponseDTO.setPerfil(extensionPerfilEntity.getPerfil());
			petResponseDTO.setHijos(extensionPerfilEntity.getHijos());
			petResponseDTO.setEstatusExp(extensionPerfilEntity.getEstatusExp());
			petResponseDTO.setSucursal(extensionPerfilEntity.getSucursal());
			petResponseDTO.setDomSucursal(extensionPerfilEntity.getDomSucursal());
			
			
			for (BitacoraExtencionPerfilEntity bitacora: extensionPerfilEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("CRG")) {
					petResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
				}
				
				
			}
			
			petResponseDTOLista.add(petResponseDTO);
			
		}
		
		return petResponseDTOLista;
	}
	

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
			reporteGeneralPETResponseDTO.setFdFechaFin(reporteGeneralCampanaRecordDTO.fecha());
			
			
				
				
		
			
			reporteGeneralPETResponseDTOList.add(reporteGeneralPETResponseDTO);
			
		}
		
		return reporteGeneralPETResponseDTOList;
	}

	public List<PETResponseDTO> consultaPETValidacion(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (petRequestDTO.getFechaInicio() != null) {
		    inicio = petRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (petRequestDTO.getFechaFin() != null) {
		    fin = petRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}
		
		
		
		extensionPerfilEntityList = extencionPerfilRepository.consultarValidacion(
				petRequestDTO.getNoLote(),
				petRequestDTO.getIdCliente(),
				petRequestDTO.getIdAfore(),
				petRequestDTO.getIdClienteAhorrador(),
				petRequestDTO.getIdPrestamoPensionado(),
				petRequestDTO.getIdSusceptiblePrestamo(),
				petRequestDTO.getIdBajaCambio(),
				petRequestDTO.getIdComunicacion(),
				petRequestDTO.getIdPersona(),
				petRequestDTO.getNombre(),
				petRequestDTO.getApellido(),
				inicio,
				fin);
		
		for(ExtensionPerfilEntity extensionPerfilEntity: extensionPerfilEntityList ) {
			PETResponseDTO petResponseDTO = new PETResponseDTO();
			
			petResponseDTO.setLineaDeNegocio(extensionPerfilEntity.getLineaDeNegocio());
			petResponseDTO.setIdCampana(extensionPerfilEntity.getIdCampana());
			petResponseDTO.setNumLote(extensionPerfilEntity.getNumLote());
			petResponseDTO.setCustomerId(extensionPerfilEntity.getCustomerId());
			petResponseDTO.setIdAfore(extensionPerfilEntity.getIdAfore());
			petResponseDTO.setDescripcionDeAfore(extensionPerfilEntity.getDescripcionDeAfore());
			petResponseDTO.setIdClienteAhorrrador(extensionPerfilEntity.getIdClienteAhorrador());
			petResponseDTO.setIdPrestamoPensionado(extensionPerfilEntity.getIdPrestamoPensionado());
			petResponseDTO.setIdSusceptiblePrestamo(extensionPerfilEntity.getIdSusceptiblePrestamo());
			petResponseDTO.setIdBajaCambio(extensionPerfilEntity.getIdBajaCambio());
			petResponseDTO.setIdComunicacion(extensionPerfilEntity.getIdComunicacion());
			petResponseDTO.setIdPersona(extensionPerfilEntity.getIdpersona());
			petResponseDTO.setFirstName(extensionPerfilEntity.getFirstName());
			petResponseDTO.setLastName(extensionPerfilEntity.getLastName());
			petResponseDTO.setCorreo(extensionPerfilEntity.getCorreo());
			petResponseDTO.setTelefono(extensionPerfilEntity.getTelefono());
			petResponseDTO.setSiefore(extensionPerfilEntity.getSiefore());
			petResponseDTO.setSegmento(extensionPerfilEntity.getSegmento());
			petResponseDTO.setRegimen(extensionPerfilEntity.getRegimen());
			petResponseDTO.setTipoPension(extensionPerfilEntity.getTipoPension());
			petResponseDTO.setGrupoPago(extensionPerfilEntity.getGrupoPago());
			petResponseDTO.setFechaBajaCambio(extensionPerfilEntity.getFechaBajaCambio());
			petResponseDTO.setRegimenImss(extensionPerfilEntity.getRegimenImss());
			petResponseDTO.setSegmentoAfo(extensionPerfilEntity.getSegmentoAfo());
			petResponseDTO.setEdad(extensionPerfilEntity.getEdad());
			petResponseDTO.setGenero(extensionPerfilEntity.getGenero());
			petResponseDTO.setLigaRsaldos(extensionPerfilEntity.getLigaRsaldos());
			petResponseDTO.setSegmentoPre(extensionPerfilEntity.getSegmentoPre());
			petResponseDTO.setDomicilioPreferente(extensionPerfilEntity.getDomicilioPreferente());
			petResponseDTO.setEmpresa(extensionPerfilEntity.getEmpresa());
			petResponseDTO.setSegmentoProy(extensionPerfilEntity.getSegmentoProy());
			petResponseDTO.setPaterno(extensionPerfilEntity.getPaterno());
			petResponseDTO.setLigaTitular(extensionPerfilEntity.getLigaTitular());
			petResponseDTO.setInstituto(extensionPerfilEntity.getInstituto());
			petResponseDTO.setTrabajador(extensionPerfilEntity.getTrabajador());
			petResponseDTO.setEntidad(extensionPerfilEntity.getEntidad());
			petResponseDTO.setMediosDigitales(extensionPerfilEntity.getMediosDigitales());
			petResponseDTO.setApertura(extensionPerfilEntity.getApertura());
			petResponseDTO.setNumeroHijos(extensionPerfilEntity.getNumeroHijos());
			petResponseDTO.setMasy65(extensionPerfilEntity.getMasy65());
			petResponseDTO.setMenores(extensionPerfilEntity.getMenores());
			petResponseDTO.setCuentaMenor1(extensionPerfilEntity.getCuentaMenor1());
			petResponseDTO.setNombreHijo1(extensionPerfilEntity.getNombreHijo1());
			petResponseDTO.setLigaHijo1(extensionPerfilEntity.getLigaHijo1());
			petResponseDTO.setCuentaMenor2(extensionPerfilEntity.getCuentaMenor2());
			petResponseDTO.setNombreHijo2(extensionPerfilEntity.getNombreHijo2());
			petResponseDTO.setLigaHijo2(extensionPerfilEntity.getLigaHijo2());
			petResponseDTO.setCuentaMenor3(extensionPerfilEntity.getCuentaMenor3());
			petResponseDTO.setNombreHijo3(extensionPerfilEntity.getNombreHijo3());
			petResponseDTO.setLigaHijo3(extensionPerfilEntity.getLigaHijo3());
			petResponseDTO.setCuentaMenor4(extensionPerfilEntity.getCuentaMenor4());
			petResponseDTO.setNombreHijo4(extensionPerfilEntity.getNombreHijo4());
			petResponseDTO.setLigaHijo4(extensionPerfilEntity.getLigaHijo4());
			petResponseDTO.setCuentaMenor5(extensionPerfilEntity.getCuentaMenor5());
			petResponseDTO.setNombreHijo5(extensionPerfilEntity.getNombreHijo5());
			petResponseDTO.setLigaHijo5(extensionPerfilEntity.getLigaHijo5());
			petResponseDTO.setCuentaMenor6(extensionPerfilEntity.getCuentaMenor6());
			petResponseDTO.setNombreHijo6(extensionPerfilEntity.getNombreHijo6());
			petResponseDTO.setLigaHijo6(extensionPerfilEntity.getLigaHijo6());
			petResponseDTO.setPerfil(extensionPerfilEntity.getPerfil());
			petResponseDTO.setHijos(extensionPerfilEntity.getHijos());
			petResponseDTO.setEstatusExp(extensionPerfilEntity.getEstatusExp());
			petResponseDTO.setSucursal(extensionPerfilEntity.getSucursal());
			petResponseDTO.setDomSucursal(extensionPerfilEntity.getDomSucursal());
			
			
			for (BitacoraExtencionPerfilEntity bitacora: extensionPerfilEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("APR")||bitacora.getEstatus().getCodigo().equals("RCH")) {
					petResponseDTO.setEstatus(bitacora.getEstatus().getNombre());
					petResponseDTO.setDetalle(bitacora.getDetalle());
					petResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
				}
				
				
			}
			
			petResponseDTOLista.add(petResponseDTO);
			
		}
		
		return petResponseDTOLista;
	}
	
	public List<PETResponseDTO> consultaPETEnvio(PETRequestDTO petRequestDTO){
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		List<ExtensionPerfilEntity> extensionPerfilEntityList = new ArrayList<ExtensionPerfilEntity>();
		
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (petRequestDTO.getFechaInicio() != null) {
		    inicio = petRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (petRequestDTO.getFechaFin() != null) {
		    fin = petRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}
		
		
		
		extensionPerfilEntityList = extencionPerfilRepository.consultarValidacion(
				petRequestDTO.getNoLote(),
				petRequestDTO.getIdCliente(),
				petRequestDTO.getIdAfore(),
				petRequestDTO.getIdClienteAhorrador(),
				petRequestDTO.getIdPrestamoPensionado(),
				petRequestDTO.getIdSusceptiblePrestamo(),
				petRequestDTO.getIdBajaCambio(),
				petRequestDTO.getIdComunicacion(),
				petRequestDTO.getIdPersona(),
				petRequestDTO.getNombre(),
				petRequestDTO.getApellido(),
				inicio,
				fin);
		
		for(ExtensionPerfilEntity extensionPerfilEntity: extensionPerfilEntityList ) {
			PETResponseDTO petResponseDTO = new PETResponseDTO();
			
			petResponseDTO.setLineaDeNegocio(extensionPerfilEntity.getLineaDeNegocio());
			petResponseDTO.setIdCampana(extensionPerfilEntity.getIdCampana());
			petResponseDTO.setNumLote(extensionPerfilEntity.getNumLote());
			petResponseDTO.setCustomerId(extensionPerfilEntity.getCustomerId());
			petResponseDTO.setIdAfore(extensionPerfilEntity.getIdAfore());
			petResponseDTO.setDescripcionDeAfore(extensionPerfilEntity.getDescripcionDeAfore());
			petResponseDTO.setIdClienteAhorrrador(extensionPerfilEntity.getIdClienteAhorrador());
			petResponseDTO.setIdPrestamoPensionado(extensionPerfilEntity.getIdPrestamoPensionado());
			petResponseDTO.setIdSusceptiblePrestamo(extensionPerfilEntity.getIdSusceptiblePrestamo());
			petResponseDTO.setIdBajaCambio(extensionPerfilEntity.getIdBajaCambio());
			petResponseDTO.setIdComunicacion(extensionPerfilEntity.getIdComunicacion());
			petResponseDTO.setIdPersona(extensionPerfilEntity.getIdpersona());
			petResponseDTO.setFirstName(extensionPerfilEntity.getFirstName());
			petResponseDTO.setLastName(extensionPerfilEntity.getLastName());
			petResponseDTO.setCorreo(extensionPerfilEntity.getCorreo());
			petResponseDTO.setTelefono(extensionPerfilEntity.getTelefono());
			petResponseDTO.setSiefore(extensionPerfilEntity.getSiefore());
			petResponseDTO.setSegmento(extensionPerfilEntity.getSegmento());
			petResponseDTO.setRegimen(extensionPerfilEntity.getRegimen());
			petResponseDTO.setTipoPension(extensionPerfilEntity.getTipoPension());
			petResponseDTO.setGrupoPago(extensionPerfilEntity.getGrupoPago());
			petResponseDTO.setFechaBajaCambio(extensionPerfilEntity.getFechaBajaCambio());
			petResponseDTO.setRegimenImss(extensionPerfilEntity.getRegimenImss());
			petResponseDTO.setSegmentoAfo(extensionPerfilEntity.getSegmentoAfo());
			petResponseDTO.setEdad(extensionPerfilEntity.getEdad());
			petResponseDTO.setGenero(extensionPerfilEntity.getGenero());
			petResponseDTO.setLigaRsaldos(extensionPerfilEntity.getLigaRsaldos());
			petResponseDTO.setSegmentoPre(extensionPerfilEntity.getSegmentoPre());
			petResponseDTO.setDomicilioPreferente(extensionPerfilEntity.getDomicilioPreferente());
			petResponseDTO.setEmpresa(extensionPerfilEntity.getEmpresa());
			petResponseDTO.setSegmentoProy(extensionPerfilEntity.getSegmentoProy());
			petResponseDTO.setPaterno(extensionPerfilEntity.getPaterno());
			petResponseDTO.setLigaTitular(extensionPerfilEntity.getLigaTitular());
			petResponseDTO.setInstituto(extensionPerfilEntity.getInstituto());
			petResponseDTO.setTrabajador(extensionPerfilEntity.getTrabajador());
			petResponseDTO.setEntidad(extensionPerfilEntity.getEntidad());
			petResponseDTO.setMediosDigitales(extensionPerfilEntity.getMediosDigitales());
			petResponseDTO.setApertura(extensionPerfilEntity.getApertura());
			petResponseDTO.setNumeroHijos(extensionPerfilEntity.getNumeroHijos());
			petResponseDTO.setMasy65(extensionPerfilEntity.getMasy65());
			petResponseDTO.setMenores(extensionPerfilEntity.getMenores());
			petResponseDTO.setCuentaMenor1(extensionPerfilEntity.getCuentaMenor1());
			petResponseDTO.setNombreHijo1(extensionPerfilEntity.getNombreHijo1());
			petResponseDTO.setLigaHijo1(extensionPerfilEntity.getLigaHijo1());
			petResponseDTO.setCuentaMenor2(extensionPerfilEntity.getCuentaMenor2());
			petResponseDTO.setNombreHijo2(extensionPerfilEntity.getNombreHijo2());
			petResponseDTO.setLigaHijo2(extensionPerfilEntity.getLigaHijo2());
			petResponseDTO.setCuentaMenor3(extensionPerfilEntity.getCuentaMenor3());
			petResponseDTO.setNombreHijo3(extensionPerfilEntity.getNombreHijo3());
			petResponseDTO.setLigaHijo3(extensionPerfilEntity.getLigaHijo3());
			petResponseDTO.setCuentaMenor4(extensionPerfilEntity.getCuentaMenor4());
			petResponseDTO.setNombreHijo4(extensionPerfilEntity.getNombreHijo4());
			petResponseDTO.setLigaHijo4(extensionPerfilEntity.getLigaHijo4());
			petResponseDTO.setCuentaMenor5(extensionPerfilEntity.getCuentaMenor5());
			petResponseDTO.setNombreHijo5(extensionPerfilEntity.getNombreHijo5());
			petResponseDTO.setLigaHijo5(extensionPerfilEntity.getLigaHijo5());
			petResponseDTO.setCuentaMenor6(extensionPerfilEntity.getCuentaMenor6());
			petResponseDTO.setNombreHijo6(extensionPerfilEntity.getNombreHijo6());
			petResponseDTO.setLigaHijo6(extensionPerfilEntity.getLigaHijo6());
			petResponseDTO.setPerfil(extensionPerfilEntity.getPerfil());
			petResponseDTO.setHijos(extensionPerfilEntity.getHijos());
			petResponseDTO.setEstatusExp(extensionPerfilEntity.getEstatusExp());
			petResponseDTO.setSucursal(extensionPerfilEntity.getSucursal());
			petResponseDTO.setDomSucursal(extensionPerfilEntity.getDomSucursal());
			
			
			for (BitacoraExtencionPerfilEntity bitacora: extensionPerfilEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("APR")||bitacora.getEstatus().getCodigo().equals("RCH")) {
					petResponseDTO.setEstatus(bitacora.getEstatus().getNombre());
					petResponseDTO.setDetalle(bitacora.getDetalle());
					petResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
				}
				
				
			}
			if(extensionPerfilEntity.getIdEstatusAbc()==10) {
			petResponseDTOLista.add(petResponseDTO);
			}
		}
		
		return petResponseDTOLista;
	}
	
	
	public List<ReporteGeneralPETResponseDTO> consultaPETValidacionLineaNegocio(Long idLineaNegocio,Long idCampana, PETRequestDTO petRequestDTO){
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
		
		tareaCampanaEntityList= tareaCampanaRepository.obtenerTareasValidacionXFechas(idLineaNegocio, idCampana, inicio, fin);
		
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
			reporteGeneralPETResponseDTO.setFdFechaFin(tareaCampanaEntity.getFdFechaFin());
			
				
				
		
			
			reporteGeneralPETResponseDTOList.add(reporteGeneralPETResponseDTO);
			
		}
		
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
			reporteGeneralPETResponseDTO.setFdFechaFin(tareaCampanaEntity.getFdFechaFin());
			
				
				
		
			
			reporteGeneralPETResponseDTOList.add(reporteGeneralPETResponseDTO);
			
		}
		
		return reporteGeneralPETResponseDTOList;
	}
	


}
