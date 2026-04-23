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
import mx.com.proyectohu.component.ReporteIndividualDAO;
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
	public ReporteIndividualDAO reporteIndividualDAO;

	public List<CLResponseDTO> consultaCLCarga(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		clRequestDTO.setTipoActividad("CRG");
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}

		CLResponseDTO cLResponseDTO2 = new CLResponseDTO();
		cLResponseDTO2=reporteIndividualDAO.consultarCLRegistroIndividualCarga(clRequestDTO);
		
	/*	
		listaContactoEntityList = listaContactoRepository.buscarContactosConBitacora(
				clRequestDTO.getRiid(),
				clRequestDTO.getNombre(),
				clRequestDTO.getApellidoPaterno(),
				clRequestDTO.getCorreo(),
				clRequestDTO.getTelefono(),
				clRequestDTO.getNoCuenta(),
				clRequestDTO.getNss(),
				clRequestDTO.getCurp(),
				clRequestDTO.getRfc(),
				clRequestDTO.getPoliza(),
				inicio,
				fin);

		for(ListaContactoEntity listaContactoEntity: listaContactoEntityList ) {
			CLResponseDTO clResponseDTO = new CLResponseDTO();

			clResponseDTO.setLineaNegocio(listaContactoEntity.getLineaDeNegocio());
			clResponseDTO.setRiid(listaContactoEntity.getRiid());
			clResponseDTO.setNombre(listaContactoEntity.getNombre());
			clResponseDTO.setApellidoPaterno(listaContactoEntity.getApellidoPaterno());
			clResponseDTO.setApellidoMaterno(listaContactoEntity.getApellidoMaterno());
			clResponseDTO.setCorreo(listaContactoEntity.getEmailAddress());
			clResponseDTO.setTelefono1(listaContactoEntity.getMobileNumber());
			clResponseDTO.setTelefono2(listaContactoEntity.getMobileCountry());
			clResponseDTO.setNoCuenta(listaContactoEntity.getNumeroDeCuenta());
			clResponseDTO.setNss(listaContactoEntity.getNss());
			clResponseDTO.setCurp(listaContactoEntity.getCurp());
			clResponseDTO.setRfc(listaContactoEntity.getRfc());
			clResponseDTO.setPoliza(listaContactoEntity.getPoliza());
			clResponseDTO.setFechaNacimiento(listaContactoEntity.getDateOfBirth());
			clResponseDTO.setCp(listaContactoEntity.getPostalCode());
			clResponseDTO.setCalle1(listaContactoEntity.getPostalStreet1());
			clResponseDTO.setCalle2(listaContactoEntity.getPostalStreet2());
			clResponseDTO.setCiudad(listaContactoEntity.getCity());
			clResponseDTO.setEstado(listaContactoEntity.getState());
			clResponseDTO.setGenero(listaContactoEntity.getGenero());
			clResponseDTO.setPrueba(listaContactoEntity.getUsuarioPrueba());
			clResponseDTO.setSuspension(listaContactoEntity.getSuspensionLogica());

			for (BitacoraListaContactoEntity bitacora: listaContactoEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("CRG")) {
					clResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
				}


			}

			clResponseDTOLista.add(clResponseDTO);

		}
*/
		clResponseDTOLista.add(cLResponseDTO2);
		return clResponseDTOLista;
	}


	public List<ReporteGeneralLCResponseDTO> consultaCLCargaLineaNegocio(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		List<TareaLineaEntity> tareaLineaEntitylist = new ArrayList<TareaLineaEntity>();
		String lineaNegocio = null;

		if( idLineaNegocio != null) {

		}

		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}

		tareaLineaEntitylist=tareaLineaRepository.obtenerTareasCargaXFechas(idLineaNegocio,inicio, fin);
		ReporteGeneralLCResponseDTO reporteGeneralLCResponseDTO =null;

		for(TareaLineaEntity tareaLineaEntity: tareaLineaEntitylist ) {

			reporteGeneralLCResponseDTO= new ReporteGeneralLCResponseDTO();

			reporteGeneralLCResponseDTO.setNombreMapeo(tareaLineaEntity.getMapeoLinea().getNombre());
			lineaNegocio = lineaNegocioRepository.findById(tareaLineaEntity.getMapeoLinea().getIdABCCatLineaNegocio()).get().getNombre();
			reporteGeneralLCResponseDTO.setNombreLineaNegocio(lineaNegocio);
			
			LocalDate fecha = tareaLineaEntity.getFdFechaFin()
				    .toInstant()
				    .atZone(ZoneId.systemDefault())
				    .toLocalDate();
			
			reporteGeneralLCResponseDTO.setFdFechaFin(fecha);
			
			System.out.println(tareaLineaEntity.getFdFechaFin().toInstant());
			reporteGeneralLCResponseDTO.setTotalRegistros(tareaLineaEntity.getFinProcesados());


			reporteGeneralLCResponseDTOlist.add(reporteGeneralLCResponseDTO);
		}

		return reporteGeneralLCResponseDTOlist;
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

		CLResponseDTO cLResponseDTO2 = new CLResponseDTO();
		cLResponseDTO2=reporteIndividualDAO.consultarCLRegistroIndividualCarga(clRequestDTO);

/*
		listaContactoEntityList = listaContactoRepository.consultarValidacion(
				clRequestDTO.getRiid(),
				clRequestDTO.getNombre(),
				clRequestDTO.getApellidoPaterno(),
				clRequestDTO.getCorreo(),
				clRequestDTO.getTelefono(),
				clRequestDTO.getNoCuenta(),
				clRequestDTO.getNss(),
				clRequestDTO.getCurp(),
				clRequestDTO.getRfc(),
				clRequestDTO.getPoliza(),
				inicio,
				fin);

		for(ListaContactoEntity listaContactoEntity: listaContactoEntityList ) {
			CLResponseDTO clResponseDTO = new CLResponseDTO();

			clResponseDTO.setLineaNegocio(listaContactoEntity.getLineaDeNegocio());
			clResponseDTO.setRiid(listaContactoEntity.getRiid());
			clResponseDTO.setNombre(listaContactoEntity.getNombre());
			clResponseDTO.setApellidoPaterno(listaContactoEntity.getApellidoPaterno());
			clResponseDTO.setApellidoMaterno(listaContactoEntity.getApellidoMaterno());
			clResponseDTO.setCorreo(listaContactoEntity.getEmailAddress());
			clResponseDTO.setTelefono1(listaContactoEntity.getMobileNumber());
			clResponseDTO.setTelefono2(listaContactoEntity.getMobileCountry());
			clResponseDTO.setNoCuenta(listaContactoEntity.getNumeroDeCuenta());
			clResponseDTO.setNss(listaContactoEntity.getNss());
			clResponseDTO.setCurp(listaContactoEntity.getCurp());
			clResponseDTO.setRfc(listaContactoEntity.getRfc());
			clResponseDTO.setPoliza(listaContactoEntity.getPoliza());
			clResponseDTO.setFechaNacimiento(listaContactoEntity.getDateOfBirth());
			clResponseDTO.setCp(listaContactoEntity.getPostalCode());
			clResponseDTO.setCalle1(listaContactoEntity.getPostalStreet1());
			clResponseDTO.setCalle2(listaContactoEntity.getPostalStreet2());
			clResponseDTO.setCiudad(listaContactoEntity.getCity());
			clResponseDTO.setEstado(listaContactoEntity.getState());
			clResponseDTO.setGenero(listaContactoEntity.getGenero());
			clResponseDTO.setPrueba(listaContactoEntity.getUsuarioPrueba());
			clResponseDTO.setSuspension(listaContactoEntity.getSuspensionLogica());

			for (BitacoraListaContactoEntity bitacora: listaContactoEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("APR")||bitacora.getEstatus().getCodigo().equals("RCH")) {
					clResponseDTO.setEstatus(bitacora.getEstatus().getNombre());
					clResponseDTO.setDetalle(bitacora.getDetalle());
					clResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
				}


			}

			clResponseDTOLista.add(clResponseDTO);

		}
*/
		clResponseDTOLista.add(cLResponseDTO2);
		return clResponseDTOLista;
	}

	public List<CLResponseDTO> consultaCLEnvio(CLRequestDTO clRequestDTO){
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		Boolean env =false;
		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}



		listaContactoEntityList = listaContactoRepository.consultarValidacion(
				clRequestDTO.getRiid(),
				clRequestDTO.getNombre(),
				clRequestDTO.getApellidoPaterno(),
				clRequestDTO.getCorreo(),
				clRequestDTO.getTelefono(),
				clRequestDTO.getNoCuenta(),
				clRequestDTO.getNss(),
				clRequestDTO.getCurp(),
				clRequestDTO.getRfc(),
				clRequestDTO.getPoliza(),
				inicio,
				fin);

		for(ListaContactoEntity listaContactoEntity: listaContactoEntityList ) {
			CLResponseDTO clResponseDTO = new CLResponseDTO();

			clResponseDTO.setLineaNegocio(listaContactoEntity.getLineaDeNegocio());
			clResponseDTO.setRiid(listaContactoEntity.getRiid());
			clResponseDTO.setNombre(listaContactoEntity.getNombre());
			clResponseDTO.setApellidoPaterno(listaContactoEntity.getApellidoPaterno());
			clResponseDTO.setApellidoMaterno(listaContactoEntity.getApellidoMaterno());
			clResponseDTO.setCorreo(listaContactoEntity.getEmailAddress());
			clResponseDTO.setTelefono1(listaContactoEntity.getMobileNumber());
			clResponseDTO.setTelefono2(listaContactoEntity.getMobileCountry());
			clResponseDTO.setNoCuenta(listaContactoEntity.getNumeroDeCuenta());
			clResponseDTO.setNss(listaContactoEntity.getNss());
			clResponseDTO.setCurp(listaContactoEntity.getCurp());
			clResponseDTO.setRfc(listaContactoEntity.getRfc());
			clResponseDTO.setPoliza(listaContactoEntity.getPoliza());
			clResponseDTO.setFechaNacimiento(listaContactoEntity.getDateOfBirth());
			clResponseDTO.setCp(listaContactoEntity.getPostalCode());
			clResponseDTO.setCalle1(listaContactoEntity.getPostalStreet1());
			clResponseDTO.setCalle2(listaContactoEntity.getPostalStreet2());
			clResponseDTO.setCiudad(listaContactoEntity.getCity());
			clResponseDTO.setEstado(listaContactoEntity.getState());
			clResponseDTO.setGenero(listaContactoEntity.getGenero());
			clResponseDTO.setPrueba(listaContactoEntity.getUsuarioPrueba());
			clResponseDTO.setSuspension(listaContactoEntity.getSuspensionLogica());

			for (BitacoraListaContactoEntity bitacora: listaContactoEntity.getBitacoras() ) {
				if (bitacora.getEstatus().getCodigo().equals("APR")||bitacora.getEstatus().getCodigo().equals("RCH")) {
					clResponseDTO.setEstatus(bitacora.getEstatus().getNombre());
					clResponseDTO.setDetalle(bitacora.getDetalle());
					clResponseDTO.setFecha(bitacora.getFechaCreacion().toLocalDate());
					
				}


			}
			if (listaContactoEntity.getIdEstatusAbc()==10) {
				clResponseDTOLista.add(clResponseDTO);
			}
			
		}

		return clResponseDTOLista;
	}


	public List<ReporteGeneralLCResponseDTO> consultaCLValidacionLineaNegocio(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		List<TareaLineaEntity> tareaLineaEntitylist = new ArrayList<TareaLineaEntity>();
		String lineaNegocio = null;

		if( idLineaNegocio != null) {

		}

		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}

		tareaLineaEntitylist=tareaLineaRepository.obtenerTareasValidacionXFechas(idLineaNegocio,inicio, fin);
		ReporteGeneralLCResponseDTO reporteGeneralLCResponseDTO =null;

		for(TareaLineaEntity tareaLineaEntity: tareaLineaEntitylist ) {

			reporteGeneralLCResponseDTO= new ReporteGeneralLCResponseDTO();

			reporteGeneralLCResponseDTO.setNombreMapeo(tareaLineaEntity.getMapeoLinea().getNombre());
			lineaNegocio = lineaNegocioRepository.findById(tareaLineaEntity.getMapeoLinea().getIdABCCatLineaNegocio()).get().getNombre();
			reporteGeneralLCResponseDTO.setNombreLineaNegocio(lineaNegocio);
			
			LocalDate fecha = tareaLineaEntity.getFdFechaFin()
				    .toInstant()
				    .atZone(ZoneId.systemDefault())
				    .toLocalDate();
			
			reporteGeneralLCResponseDTO.setFdFechaFin(fecha);
			reporteGeneralLCResponseDTO.setTotalRegistros(tareaLineaEntity.getFinProcesados());
			reporteGeneralLCResponseDTO.setTotalRegistrosAprobados(tareaLineaEntity.getRegistrosAprobados());
			reporteGeneralLCResponseDTO.setTotalRegistrosRechazados(tareaLineaEntity.getRegistrosRechazados());


			reporteGeneralLCResponseDTOlist.add(reporteGeneralLCResponseDTO);
		}

		return reporteGeneralLCResponseDTOlist;
	}

	public List<ReporteGeneralLCResponseDTO> consultaCLEnvioLineaNegocio(Long idLineaNegocio, CLRequestDTO clRequestDTO){
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		List<ListaContactoEntity> listaContactoEntityList = new ArrayList<ListaContactoEntity>();
		List<TareaLineaEntity> tareaLineaEntitylist = new ArrayList<TareaLineaEntity>();
		String lineaNegocio = null;

		if( idLineaNegocio != null) {

		}

		LocalDateTime inicio = null;
		LocalDateTime fin = null;

		if (clRequestDTO.getFechaInicio() != null) {
			inicio = clRequestDTO.getFechaInicio().atStartOfDay(); 
		}

		if (clRequestDTO.getFechaFin() != null) {
			fin = clRequestDTO.getFechaFin().plusDays(1).atStartOfDay(); 
		}

		tareaLineaEntitylist=tareaLineaRepository.obtenerTareasEnvioXFechas(idLineaNegocio,inicio, fin);
		ReporteGeneralLCResponseDTO reporteGeneralLCResponseDTO =null;

		for(TareaLineaEntity tareaLineaEntity: tareaLineaEntitylist ) {

			reporteGeneralLCResponseDTO= new ReporteGeneralLCResponseDTO();

			reporteGeneralLCResponseDTO.setNombreMapeo(tareaLineaEntity.getMapeoLinea().getNombre());
			lineaNegocio = lineaNegocioRepository.findById(tareaLineaEntity.getMapeoLinea().getIdABCCatLineaNegocio()).get().getNombre();
			reporteGeneralLCResponseDTO.setNombreLineaNegocio(lineaNegocio);
			LocalDate fecha = tareaLineaEntity.getFdFechaFin()
				    .toInstant()
				    .atZone(ZoneId.systemDefault())
				    .toLocalDate();
			
			
			reporteGeneralLCResponseDTO.setFdFechaFin(fecha);
			
			
			reporteGeneralLCResponseDTO.setTotalRegistros(tareaLineaEntity.getFinProcesados());
			reporteGeneralLCResponseDTO.setTotalRegistrosAprobados(tareaLineaEntity.getRegistrosAprobados());
			reporteGeneralLCResponseDTO.setTotalRegistrosRechazados(tareaLineaEntity.getRegistrosRechazados());


			reporteGeneralLCResponseDTOlist.add(reporteGeneralLCResponseDTO);
		}

		return reporteGeneralLCResponseDTOlist;
	}


}
