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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class ValidarLineaController {

	@Autowired
	public ValidarLineaService validarLineaService;
	

	@PostMapping("/valida/lista/contacto")
	public ResponseEntity<?> validarListaContacto(@RequestBody Map<String, Object> body) {

		String lineaNegocio = (String) body.get("lineaNegocio");
		Long idTareaLinea = Long.parseLong(body.get("idTareaLinea").toString());
		
		validarLineaService.ejecutarValidarListaContacto(lineaNegocio,idTareaLinea);
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
