package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadLineaRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.service.MapeoLineaService;
import mx.com.proyectohu.service.ActividadLineaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class ActividadLineaController {

	@Autowired
	public ActividadLineaService actividadLineaService;


	@PostMapping("/lineas/actividades")
	public ResponseEntity<?> registrarNuevaActividadLinea(@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO ) {

	
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		actividadLineaResponseDTO.setIdActividadLinea(actividadLineaService.registrarActividadLinea(actividadLineaRequestDTO));

		return ResponseEntity.ok(actividadLineaResponseDTO);
	}

	
	@GetMapping("/lineas/actividades")
	public ResponseEntity<?> consultarActividadesLineas() {


			List<ActividadLineaResponseDTO> actividadLineaResponseDTOLista = new ArrayList<ActividadLineaResponseDTO>();

			actividadLineaResponseDTOLista = actividadLineaService.consultarActividadesLinea();

			return ResponseEntity.ok(actividadLineaResponseDTOLista);
		

	}
	
	@PutMapping("/lineas/actividades/{idActividad}")
	public ResponseEntity<?> actualizarActividadLinea(@PathVariable Long idActividad, @RequestBody ActividadesRequestDTO actividadesRequestDTO) {

		ActividadLineaResponseDTO actividadLineaResponseDTO= actividadLineaService.actualizarActividadLinea(idActividad,actividadesRequestDTO);

		
		if (actividadLineaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",actividadLineaResponseDTO.getIdActividadLinea()));
	}

	@PatchMapping("/lineas/actividades/{idActividad}/activar")
	public ResponseEntity<?> activarActividadMapeo(@PathVariable Long idActividad,@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.activarActividadMapeo(idActividad,actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/actividades/{idActividad}/desactivar")
	public ResponseEntity<?> desactivarActividadMapeo(@PathVariable Long idActividad, @RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO){
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.desactivarActividadMapeo(idActividad,actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad,@PathVariable Long idTipo, @RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.activar(idActividad,idTipo,actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @PathVariable Long idTipo,@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO){
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.desactivar(idActividad,idTipo,actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}







}
