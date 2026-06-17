package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.BitacoraUsuarioRequestDTO;
import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseCargaDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.CLResponseEnvioDTO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.PETResponseCargaDTO;
import mx.com.proyectohu.dto.PETResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;
import mx.com.proyectohu.service.BitacoraUsuarioService;
import mx.com.proyectohu.service.ReporteGeneralCampanaService;
import mx.com.proyectohu.service.ReporteGeneralLineaService;
import mx.com.proyectohu.service.ReporteIndividualCampanaService;
import mx.com.proyectohu.service.ReporteIndividualLineaService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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

	@GetMapping("/cl/reportes/individuales/cargas")
	public ResponseEntity<?> consultaCLCarga(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin,
			@RequestParam(required = false) Long idMapeo
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setCustomerID(idCliente);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);
		clRequestDTO.setIdLineaNegocio(idLinea);
		clRequestDTO.setIdMapeoLinea(idMapeo);

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());

		}




		List<CLResponseCargaDTO> clResponseDTOLista = new ArrayList<CLResponseCargaDTO>();


		clResponseDTOLista =reporteIndividualLineaService.consultaCLCarga(clRequestDTO);





		return ResponseEntity.ok(clResponseDTOLista);
	}

	@GetMapping("/cl/reportes/individuales/validaciones")
	public ResponseEntity<?> consultaCLValidacion(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long  fechaFin,
			@RequestParam(required = false) Long idMapeo
		
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setCustomerID(idCliente);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);
		clRequestDTO.setIdLineaNegocio(idLinea);
		clRequestDTO.setIdMapeoLinea(idMapeo);
		
		


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());

		}


		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>();

		clResponseDTOLista =reporteIndividualLineaService.consultaCLValidacion(clRequestDTO);

		return ResponseEntity.ok(clResponseDTOLista);

	}

	@GetMapping("/cl/reportes/individuales/sincronizaciones")
	public ResponseEntity<?> consultaCLEnvio(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) String idCliente,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String noCuenta,
			@RequestParam(required = false) String nss,
			@RequestParam(required = false) String curp,
			@RequestParam(required = false) String rfc,
			@RequestParam(required = false) String poliza,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin,
			@RequestParam(required = false) Long idMapeo,
			@RequestParam(required = false) String riid
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		clRequestDTO.setCustomerID(idCliente);
		clRequestDTO.setNombre(nombre);
		clRequestDTO.setApellidoPaterno(apellidoPaterno);
		clRequestDTO.setCorreo(correo);
		clRequestDTO.setTelefono(telefono);
		clRequestDTO.setNoCuenta(noCuenta);
		clRequestDTO.setNss(nss);
		clRequestDTO.setCurp(curp);
		clRequestDTO.setRfc(rfc);
		clRequestDTO.setPoliza(poliza);
		clRequestDTO.setIdLineaNegocio(idLinea);
		clRequestDTO.setIdMapeoLinea(idMapeo);
		clRequestDTO.setRiid(riid);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<CLResponseEnvioDTO> clResponseDTOLista = new ArrayList<CLResponseEnvioDTO>();

		clResponseDTOLista =reporteIndividualLineaService.consultaCLEnvio(clRequestDTO);





		return ResponseEntity.ok(clResponseDTOLista);

	}



	@GetMapping("/cl/reportes/generales/cargas")
	public ResponseEntity<?> consultaCLGeneralCarga(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}



		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralCarga(idLinea,clRequestDTO);

		return ResponseEntity.ok(clResponseDTOLista);
	}






	@GetMapping("/cl/reportes/generales/validaciones")
	public ResponseEntity<?> consultaCLGeneralValidacion(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long  fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralValidacion(idLinea,clRequestDTO);


		return ResponseEntity.ok(clResponseDTOLista);

	}

	@GetMapping("/cl/reportes/generales/sincronizaciones")
	public ResponseEntity<?> consultaCLGeneralEnvio(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long  fechaFin
			) {

		CLRequestDTO clRequestDTO = new CLRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			clRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			clRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<ReporteGeneralLCResponseDTO> clResponseDTOLista = new ArrayList<ReporteGeneralLCResponseDTO>();

		clResponseDTOLista =reporteGeneralLineaService.consultaCLGeneralEnvio(idLinea,clRequestDTO);


		return ResponseEntity.ok(clResponseDTOLista);

	}




	@GetMapping("/pet/reportes/individuales/cargas")
	public ResponseEntity<?> consultaPETCarga(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
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
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin
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
		petRequestDTO.setIdLineaNegocio(idLinea);
		petRequestDTO.setIdCampana(idCampana);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<PETResponseCargaDTO> petResponseDTOLista = new ArrayList<PETResponseCargaDTO>();

		petResponseDTOLista =reporteIndividualCampanaService.consultaPETCarga(petRequestDTO);




		return ResponseEntity.ok(petResponseDTOLista);
	}




	@GetMapping("/pet/reportes/individuales/validaciones")
	public ResponseEntity<?> consultaPETValidacion(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
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
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin,
			@RequestParam(required = false) Long idMapeo
			
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
		petRequestDTO.setIdLineaNegocio(idLinea);
		petRequestDTO.setIdCampana(idCampana);
		petRequestDTO.setIdMapeoCampana(idMapeo);
		


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();

		
			petResponseDTOLista =reporteIndividualCampanaService.consultaPETValidacion(petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reportes/individuales/sincronizaciones")
	public ResponseEntity<?> consultaPETEnvio(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
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
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin,
			@RequestParam(required = false) Long idMapeo,
			@RequestParam(required = false) String riid 
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
		petRequestDTO.setIdLineaNegocio(idLinea);
		petRequestDTO.setIdCampana(idCampana);
		petRequestDTO.setIdMapeoCampana(idMapeo);
		petRequestDTO.setRiid(riid);


		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>();

	
			petResponseDTOLista =reporteIndividualCampanaService.consultaPETEnvio(petRequestDTO);

		return ResponseEntity.ok(petResponseDTOLista);
	}


	@GetMapping("/pet/reportes/generales/cargas")
	public ResponseEntity<?> consultaPETGeneralCarga(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();




		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETCargaLineaNegocio(idLinea,idCampana, petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reportes/generales/validaciones")
	public ResponseEntity<?> consultaPETValidacion(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();




		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETGeneralValidacion(idLinea,idCampana,petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

	@GetMapping("/pet/reportes/generales/envio")
	public ResponseEntity<?> consultaPETEnvio(@RequestParam(required = false) Long idLinea,
			@RequestParam(required = false) Long idCampana,
			@RequestParam(required = false) Long fechaInicio,
			@RequestParam(required = false) Long fechaFin
			) {


		PETRequestDTO petRequestDTO = new PETRequestDTO();

		if (fechaInicio!=null && fechaFin !=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			petRequestDTO.setFechaInicio(Instant.ofEpochMilli(fechaInicio).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
			petRequestDTO.setFechaFin(Instant.ofEpochMilli(fechaFin).atZone(ZoneId.of("America/Mexico_City")).toLocalDate());
		}


		List<ReporteGeneralPETResponseDTO> petResponseDTOLista = new ArrayList<ReporteGeneralPETResponseDTO>();


		petResponseDTOLista =reporteGeneralCampanaService.consultaPETEnvioLineaNegocio(idLinea,idCampana,petRequestDTO);


		return ResponseEntity.ok(petResponseDTOLista);
	}

}
