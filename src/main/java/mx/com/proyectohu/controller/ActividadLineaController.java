package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadLineaRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO;
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


	@PostMapping("/lineas/{id}/actividades")
	public ResponseEntity<?> registrarNuevaActividadLinea(@PathVariable Long id, @RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO ) {

	
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();


		actividadLineaResponseDTO.setIdActividadLinea(actividadLineaService.registrarActividadLinea(id,actividadLineaRequestDTO));

		return ResponseEntity.ok(actividadLineaResponseDTO);
	}


	@GetMapping("/lineas/actividades")
	public ResponseEntity<?> consultarActividadesLineas() {


			List<ActividadLineaResponseDTO> actividadLineaResponseDTOLista = new ArrayList<ActividadLineaResponseDTO>();

			actividadLineaResponseDTOLista = actividadLineaService.consultarActividadesLinea();

			return ResponseEntity.ok(actividadLineaResponseDTOLista);
		

	}

	@PutMapping("/lineas/actividades")
	public ResponseEntity<?> actualizarActividadLinea(@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO) {

		ActividadLineaResponseDTO actividadLineaResponseDTO= actividadLineaService.actualizarActividadLinea(actividadLineaRequestDTO);

		
		if (actividadLineaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",actividadLineaResponseDTO.getIdActividadLinea()));
	}


	@PatchMapping("/lineas/actividades/activar")
	public ResponseEntity<?> activar(@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO) {
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.activar(actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/actividades/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody ActividadLineaRequestDTO actividadLineaRequestDTO){
		ActividadLineaResponseDTO actividadLineaResponseDTO = new ActividadLineaResponseDTO();
		actividadLineaResponseDTO = actividadLineaService.desactivar(actividadLineaRequestDTO);

		if (actividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(actividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
