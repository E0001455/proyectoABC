package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.service.CargaLineaService;
import mx.com.proyectohu.service.ValidarLineaService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class ValidarLineaController {

	@Autowired
	public ValidarLineaService validarLineaService;
	

	@PostMapping("/cl/tareas/{idTarea}/validaciones/ejecutar")
	public ResponseEntity<?> validarListaContacto(@PathVariable Long idTarea) {

		validarLineaService.ejecutarValidarListaContacto(idTarea);
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
