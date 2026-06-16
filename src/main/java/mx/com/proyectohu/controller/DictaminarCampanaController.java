package mx.com.proyectohu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.service.DictaminarCampanaService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class DictaminarCampanaController {
	
	@Autowired
	public DictaminarCampanaService dictaminarCampanaService;
	
	@PostMapping("/campanas/tareas/{idTarea}/envios/dictaminar")
	public ResponseEntity<?> dictaminarPet(@PathVariable Long idTarea) {
		
		dictaminarCampanaService.actualizarTarea(idTarea);
		
		return ResponseEntity.ok("Dictaminado");
	}
	
	
	
	
	
	

}
