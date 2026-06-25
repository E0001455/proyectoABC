package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TareasController {

	@Autowired
	public TareaLineaService tareaLineaService;

	@Autowired
	public TareaCampanaService tareaCampanaService;



	 
	@GetMapping(value="/lineas/tareas", produces = "application/json")
	public ResponseEntity<?> consultarTareasLineas() {
	
		String json = tareaLineaService.consultarTareaslinea();

		return ResponseEntity.ok(json);

	}

	@GetMapping(value="/campanas/tareas", produces = "application/json" )
	public ResponseEntity<?> consultarTareasCampanas() {
	

		String json = tareaCampanaService.consultarTareasCampana();

		return ResponseEntity.ok(json);


	}
	

}
