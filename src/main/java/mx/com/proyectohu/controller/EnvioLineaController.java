package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.service.CargaLineaService;
import mx.com.proyectohu.service.EnvioLineaService;
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
public class EnvioLineaController {

	@Autowired
	public EnvioLineaService envioLineaService;
	

	@PostMapping("/cl/tareas/{idTarea}/envios/ejecutar")
	public ResponseEntity<?> envioListaContacto(@PathVariable Long idTarea) {

	
		
		try {
			envioLineaService.ejecutarEnvioListaContacto(idTarea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
