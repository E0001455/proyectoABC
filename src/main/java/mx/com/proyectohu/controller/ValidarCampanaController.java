package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.service.CargaLineaService;
import mx.com.proyectohu.service.ValidarCampanaService;
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
public class ValidarCampanaController {

	@Autowired
	public ValidarCampanaService validarCampanaService;
	

	@PostMapping("/pet/tareas/{idTarea}/validaciones/ejecutar")
	public ResponseEntity<?> validarExtensionPerfil(@PathVariable Long idTarea) {

		
		validarCampanaService.ejecutarValidarExtencionPerfil(idTarea);
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
