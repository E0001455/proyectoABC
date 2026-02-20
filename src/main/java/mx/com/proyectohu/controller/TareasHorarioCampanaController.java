package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;

import mx.com.proyectohu.dto.TareaCampanaRequestDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaService;

import mx.com.proyectohu.service.TareaCampanaService;

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
public class TareasHorarioCampanaController {

	/*
	@Autowired
	public TareaHorarioCampanaService tareaCampanaHorarioService;



	@PostMapping("/Campanas/tareas/{idTareaCampana}/horario")
	public ResponseEntity<?> registrarNuevaTareaCampanaHorario(@PathVariable Long idTareaCampana, @RequestBody TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO) {

	
	


		tareaCampanaHorarioService.registrarTareaCampanaHorario(idTareaCampana,tareaCampanaHorarioRequestDTO);

		return ResponseEntity.ok("creado");
	}


	@GetMapping("/Campanas/tareas/{idTareaCampana}/horarios")
	public ResponseEntity<?> consultarTareasCampanaHorarios(@PathVariable Long idTareaCampana) {


			List<TareaCampanaHorarioResponseDTO> tareaCampanaHorarioResponseDTO = new ArrayList<TareaCampanaHorarioResponseDTO>();

			tareaCampanaHorarioResponseDTO = tareaCampanaHorarioService.consultarTareasCampanaHorarios(idTareaCampana);

			return ResponseEntity.ok(tareaCampanaHorarioResponseDTO);
		

	}
	
	
	
	@PatchMapping("/Campanas/tareas/{idTareaCampana}/activar")
	public ResponseEntity<?> activar(@PathVariable Long idTareaCampana, @RequestBody TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO) {
		
		TareaCampanaHorarioResponseDTO tareaCampanaHorarioResponseDTO = new TareaCampanaHorarioResponseDTO();
		tareaCampanaHorarioResponseDTO = tareaCampanaHorarioService.activar(idTareaCampana,tareaCampanaHorarioRequestDTO);

		if (tareaCampanaHorarioResponseDTO.getIdCFGTareaCampana() !=null) {
			return ResponseEntity.ok(tareaCampanaHorarioResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/Campanas/tareas/{idTareaCampana}/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idTareaCampana, @RequestBody TareaCampanaHorarioRequestDTO tareaCampanaHorarioRequestDTO){
		TareaCampanaHorarioResponseDTO tareaCampanaHorarioResponseDTO = new TareaCampanaHorarioResponseDTO();
		tareaCampanaHorarioResponseDTO = tareaCampanaHorarioService.desactivar(idTareaCampana,tareaCampanaHorarioRequestDTO);

		if (tareaCampanaHorarioResponseDTO.getIdCFGTareaCampana() !=null) {
			return ResponseEntity.ok(tareaCampanaHorarioResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

*/






}
