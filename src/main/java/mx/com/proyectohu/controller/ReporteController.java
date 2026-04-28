package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.BitacoraUsuarioRequestDTO;
import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;
import mx.com.proyectohu.service.BitacoraUsuarioService;
import mx.com.proyectohu.service.ReporteGeneralCampanaService;
import mx.com.proyectohu.service.ReporteGeneralLineaService;
import mx.com.proyectohu.service.ReporteIndividualCampanaService;
import mx.com.proyectohu.service.ReporteIndividualLineaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class ReporteController {



	@Autowired
	public ReporteIndividualLineaService reporteIndividualLineaService;

	@Autowired
	public ReporteIndividualCampanaService reporteIndividualCampanaService;

	@Autowired
	public ReporteGeneralLineaService reporteGeneralLineaService;
	
	@Autowired
	public ReporteGeneralCampanaService reporteGeneralCampanaService;

	@GetMapping("/cl/reporte/individual/carga")
	public ResponseEntity<?> consultaCLCarga(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String riid,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setRiid(riid);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));

		}




		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();

		if (idLineaNegocio==null) {
			clResponseDTOLista =reporteIndividualLineaService.consultaCLCarga(clRequestDTO);

		}


		return ResponseEntity.ok(clResponseDTOLista);
	}

	@GetMapping("/cl/reporte/individual/validacion")
	public ResponseEntity<?> consultaCLValidacion(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String riid,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String  fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setRiid(riid);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();

		clResponseDTOLista =reporteIndividualLineaService.consultaCLValidacion(clRequestDTO);

		return ResponseEntity.ok(clResponseDTOLista);

	}

	@GetMapping("/cl/reporte/individual/envio")
	public ResponseEntity<?> consultaCLEnvio(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String riid,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setRiid(riid);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();
		
			clResponseDTOLista =reporteIndividualLineaService.consultaCLEnvio(clRequestDTO);

		



		return ResponseEntity.ok(clResponseDTOLista);

	}



	@GetMapping("/cl/reporte/general/carga")
	public ResponseEntity<?> consultaCLGeneralCarga(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}



		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralCarga(idLineaNegocio,clRequestDTO);

		return ResponseEntity.ok(clResponseDTOLista);
	}






	@GetMapping("/cl/reporte/general/validacion")
	public ResponseEntity<?> consultaCLGeneralValidacion(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String  fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralValidacion(idLineaNegocio,clRequestDTO);


		return ResponseEntity.ok(clResponseDTOLista);

	}

	@GetMapping("/cl/reporte/general/envio")
	public ResponseEntity<?> consultaCLGeneralEnvio(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String  fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			clRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralEnvio(idLineaNegocio,clRequestDTO);


		return ResponseEntity.ok(clResponseDTOLista);

	}




	@GetMapping("/pet/reporte/individual/carga")
	public ResponseEntity<?> consultaPETCarga(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String noLote,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String idAfore,
			@RequestParam(required = false) String idClienteAhorrador,
			@RequestParam(required = false) String idPrestamoPensionado,
			@RequestParam(required = false) String idSusceptiblePrestamo,
			@RequestParam(required = false) String idBajaCambio,
			@RequestParam(required = false) String idComunicacion,
			@RequestParam(required = false) String idPersona,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();

		petRequestDTO.setNoLote(noLote);
		petRequestDTO.setIdCliente(idCliente);
		petRequestDTO.setIdAfore(idAfore);
		petRequestDTO.setIdClienteAhorrador(idClienteAhorrador);
		petRequestDTO.setIdPrestamoPensionado(idPrestamoPensionado);
		petRequestDTO.setIdSusceptiblePrestamo(idSusceptiblePrestamo);
		petRequestDTO.setIdBajaCambio(idBajaCambio);
		petRequestDTO.setIdComunicacion(idComunicacion);
		petRequestDTO.setIdPersona(idPersona);
		petRequestDTO.setNombre(nombre);
		petRequestDTO.setApellido(apellido);
		petRequestDTO.setCorreo(correo);
		petRequestDTO.setTelefono(telefono);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();
		
			petResponseDTOLista =reporteIndividualCampanaService.consultaPETCarga(petRequestDTO);

	


		return ResponseEntity.ok(petResponseDTOLista);
	}
	
	
	

	@GetMapping("/pet/reporte/individual/validacion")
	public ResponseEntity<?> consultaPETValidacion(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String noLote,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String idAfore,
			@RequestParam(required = false) String idClienteAhorrador,
			@RequestParam(required = false) String idPrestamoPensionado,
			@RequestParam(required = false) String idSusceptiblePrestamo,
			@RequestParam(required = false) String idBajaCambio,
			@RequestParam(required = false) String idComunicacion,
			@RequestParam(required = false) String idPersona,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();

		petRequestDTO.setNoLote(noLote);
		petRequestDTO.setIdCliente(idCliente);
		petRequestDTO.setIdAfore(idAfore);
		petRequestDTO.setIdClienteAhorrador(idClienteAhorrador);
		petRequestDTO.setIdPrestamoPensionado(idPrestamoPensionado);
		petRequestDTO.setIdSusceptiblePrestamo(idSusceptiblePrestamo);
		petRequestDTO.setIdBajaCambio(idBajaCambio);
		petRequestDTO.setIdComunicacion(idComunicacion);
		petRequestDTO.setIdPersona(idPersona);
		petRequestDTO.setNombre(nombre);
		petRequestDTO.setApellido(apellido);
		petRequestDTO.setCorreo(correo);
		petRequestDTO.setTelefono(telefono);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();

		if (idLineaNegocio==null) {
			petResponseDTOLista =reporteIndividualCampanaService.consultaPETValidacion(petRequestDTO);

		}



		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reporte/individual/envio")
	public ResponseEntity<?> consultaPETEnvio(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) String noLote,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String idAfore,
			@RequestParam(required = false) String idClienteAhorrador,
			@RequestParam(required = false) String idPrestamoPensionado,
			@RequestParam(required = false) String idSusceptiblePrestamo,
			@RequestParam(required = false) String idBajaCambio,
			@RequestParam(required = false) String idComunicacion,
			@RequestParam(required = false) String idPersona,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();

		petRequestDTO.setNoLote(noLote);
		petRequestDTO.setIdCliente(idCliente);
		petRequestDTO.setIdAfore(idAfore);
		petRequestDTO.setIdClienteAhorrador(idClienteAhorrador);
		petRequestDTO.setIdPrestamoPensionado(idPrestamoPensionado);
		petRequestDTO.setIdSusceptiblePrestamo(idSusceptiblePrestamo);
		petRequestDTO.setIdBajaCambio(idBajaCambio);
		petRequestDTO.setIdComunicacion(idComunicacion);
		petRequestDTO.setIdPersona(idPersona);
		petRequestDTO.setNombre(nombre);
		petRequestDTO.setApellido(apellido);
		petRequestDTO.setCorreo(correo);
		petRequestDTO.setTelefono(telefono);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();

		if (idLineaNegocio==null) {
			petResponseDTOLista =reporteIndividualCampanaService.consultaPETEnvio(petRequestDTO);

		}



		return ResponseEntity.ok(petResponseDTOLista);
	}


	@GetMapping("/pet/reporte/general/carga")
	public ResponseEntity<?> consultaPETGeneralCarga(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();




		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETCargaLineaNegocio(idLineaNegocio,idCampana, petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reporte/general/validacion")
	public ResponseEntity<?> consultaPETValidacion(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();




		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETGeneralValidacion(idLineaNegocio,idCampana,petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reporte/general/envio")
	public ResponseEntity<?> consultaPETEnvio(@RequestParam(required = false) Long idLineaNegocio,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) String fechaInicio,
			@RequestParam(required = false) String fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(LocalDate.parse(fechaInicio,formatter));
			petRequestDTO.setFechaFin(LocalDate.parse(fechaFin,formatter));
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETEnvioLineaNegocio(idLineaNegocio,idCampana,petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

}
