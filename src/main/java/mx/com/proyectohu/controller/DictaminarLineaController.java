package mx.com.proyectohu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;
import mx.com.proyectohu.service.DictaminarLineaService;
import mx.com.proyectohu.service.MiddlewarePETService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class DictaminarLineaController {
	
	@Autowired
	public DictaminarLineaService dictaminarLineaService;
	
	@PostMapping("/lineas/tareas/{idTarea}/envios/dictaminar")
	public ResponseEntity<?> dictaminarCl(@PathVariable Long idTarea) {
		
		 dictaminarLineaService.actualizarTarea(idTarea);
		
		return ResponseEntity.ok("Dictaminado");
	}
	
	
	
	
	
	

}
