package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.TareaLineaHorarioRequestDTO;
import mx.com.proyectohu.dto.TareaLineaHorarioResponseDTO;
import mx.com.proyectohu.dto.TareaLineaRequestDTO;
import mx.com.proyectohu.dto.TareaLineaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaService;
import mx.com.proyectohu.service.TareaHorarioLineaService;
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
public class TareasHorarioLineaController {

	@Autowired
	public TareaHorarioLineaService tareaLineaHorarioService;



	@PostMapping("/lineas/tareas/{idTareaLinea}/horarios")
	public ResponseEntity<?> registrarNuevaTareaLineaHorario(@PathVariable Long idTareaLinea, @RequestBody TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO) {

	
	


		tareaLineaHorarioService.registrarTareaLineaHorario(idTareaLinea,tareaLineaHorarioRequestDTO);

		return ResponseEntity.ok("creado");
	}


	@GetMapping("/lineas/tareas/{idTareaLinea}/horarios")
	public ResponseEntity<?> consultarTareasLineaHorarios(@PathVariable Long idTareaLinea) {


			List<TareaLineaHorarioResponseDTO> tareaLineaHorarioResponseDTO = new ArrayList<TareaLineaHorarioResponseDTO>();

			tareaLineaHorarioResponseDTO = tareaLineaHorarioService.consultarTareasLineaHorarios(idTareaLinea);

			return ResponseEntity.ok(tareaLineaHorarioResponseDTO);
		

	}
	
	
	
	@PatchMapping("/lineas/tareas/{idTareaLinea}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idTareaLinea, @RequestBody TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO) {
		
		TareaLineaHorarioResponseDTO tareaLineaHorarioResponseDTO = new TareaLineaHorarioResponseDTO();
		tareaLineaHorarioResponseDTO = tareaLineaHorarioService.activar(idTareaLinea,tareaLineaHorarioRequestDTO);

		if (tareaLineaHorarioResponseDTO.getIdCFGTareaLinea() !=null) {
			return ResponseEntity.ok(tareaLineaHorarioResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/tareas/{idTareaLinea}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idTareaLinea, @RequestBody TareaLineaHorarioRequestDTO tareaLineaHorarioRequestDTO){
		TareaLineaHorarioResponseDTO tareaLineaHorarioResponseDTO = new TareaLineaHorarioResponseDTO();
		tareaLineaHorarioResponseDTO = tareaLineaHorarioService.desactivar(idTareaLinea,tareaLineaHorarioRequestDTO);

		if (tareaLineaHorarioResponseDTO.getIdCFGTareaLinea() !=null) {
			return ResponseEntity.ok(tareaLineaHorarioResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}








}
