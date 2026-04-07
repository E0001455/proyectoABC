package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.service.CargaLineaService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class CargaLineaController {

	@Autowired
	public CargaLineaService cargaLineaService;


		
	@PostMapping("/carga/lista/contacto")
	public ResponseEntity<?> cargarListaContacto(@RequestBody Map<String, Object> body) {
		
		String lineaNegocio = (String) body.get("lineaNegocio");
		Long idTareaLinea = Long.parseLong(body.get("idTareaLinea").toString());

		cargaLineaService.ejecutarCargaListaContacto(lineaNegocio,idTareaLinea);
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
