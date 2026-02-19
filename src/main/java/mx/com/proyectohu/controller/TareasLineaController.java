package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.TareaLineaRequestDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaService;
import mx.com.proyectohu.service.TareaLineaService;

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
public class TareasLineaController {

	@Autowired
	public TareaLineaService tareaLineaService;



	@PostMapping("/lineas/{id}/tareas")
	public ResponseEntity<?> registrarNuevaTareaLinea(@PathVariable Long id, @RequestBody TareaLineaRequestDTO tareaLineaRequestDTO ) {

	
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();


		tareaLineaResponseDTO.setIdCFGTareaLinea(tareaLineaService.registrarTareaLinea(id,tareaLineaRequestDTO));

		return ResponseEntity.ok(tareaLineaResponseDTO);
	}


	@GetMapping("/lineas/tareas")
	public ResponseEntity<?> consultarTareasLineas() {


			List<TareaLineaResponseDTO> tareaLineaResponseDTOLista = new ArrayList<TareaLineaResponseDTO>();

			tareaLineaResponseDTOLista = tareaLineaService.consultarTareasLinea();

			return ResponseEntity.ok(tareaLineaResponseDTOLista);
		

	}

	@PutMapping("/lineas/tareas")
	public ResponseEntity<?> actualizarMapeoLinea(@RequestBody TareaLineaRequestDTO tareaLineaRequestDTO) {

		TareaLineaResponseDTO tareaLineaResponseDTO= tareaLineaService.actualizarTareaLinea(tareaLineaRequestDTO);

		
		if (tareaLineaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",tareaLineaResponseDTO.getIdCFGTareaLinea()));
	}


	@PatchMapping("/lineas/tareas/activar")
	public ResponseEntity<?> activar(@RequestBody TareaLineaRequestDTO tareaLineaRequestDTO) {
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();
		tareaLineaResponseDTO = tareaLineaService.activar(tareaLineaRequestDTO);

		if (tareaLineaResponseDTO.getIdCFGTareaLinea() !=null) {
			return ResponseEntity.ok(tareaLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/tareas/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody TareaLineaRequestDTO tareaLineaRequestDTO){
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();
		tareaLineaResponseDTO = tareaLineaService.desactivar(tareaLineaRequestDTO);

		if (tareaLineaResponseDTO.getIdCFGTareaLinea() !=null) {
			return ResponseEntity.ok(tareaLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
