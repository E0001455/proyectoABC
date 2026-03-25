package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;
import mx.com.proyectohu.service.TareaCampanaService;
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

	@Autowired
	public TareaCampanaService tareaCampanaService;


/*	@PostMapping("/lineas/tareas")
	public ResponseEntity<?> registrarNuevaTareaLinea(@PathVariable Long idLinea, @RequestBody TareaLineaRequestDTO tareaLineaRequestDTO ) {

	
		TareaLineaResponseDTO tareaLineaResponseDTO = new TareaLineaResponseDTO();


		tareaLineaResponseDTO.setIdTareaLinea(tareaLineaService.registrarTareaLinea(idLinea,tareaLineaRequestDTO));

		return ResponseEntity.ok(tareaLineaResponseDTO);
	}

*/
	@GetMapping("/lineas/tareas")
	public ResponseEntity<?> consultarTareasLineas() {


			List<TareaLineaResponseDTO> tareaLineaResponseDTOLista = new ArrayList<TareaLineaResponseDTO>();

			tareaLineaResponseDTOLista = tareaLineaService.consultarTareasLinea();

			return ResponseEntity.ok(tareaLineaResponseDTOLista);
		

	}
	
	@GetMapping("/lineas/campanas/tareas")
	public ResponseEntity<?> consultarTareasCampanas() {


			List<TareaCampanaResponseDTO> tareaCampanaResponseDTOLista = new ArrayList<TareaCampanaResponseDTO>();

			tareaCampanaResponseDTOLista = tareaCampanaService.consultarTareasCampanas();

			return ResponseEntity.ok(tareaCampanaResponseDTOLista);
		

	}

}
