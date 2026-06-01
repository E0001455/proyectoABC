package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.service.CLRespuestaCronService;
import mx.com.proyectohu.service.CargaLineaService;
import mx.com.proyectohu.service.EnvioLineaService;
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
public class RespuestaLineaController {

	@Autowired
	public CLRespuestaCronService clRespuestaCronService;
	

	@PostMapping("/respuesta/lista/contacto")
	public ResponseEntity<?> respuestaListaContacto(@RequestBody Map<String, Object> body) {

		
		Long idTareaLinea = Long.parseLong(body.get("idTareaLinea").toString());
		String lineaNegocio = (String) body.get("lineaNegocio");
		
		try {
			clRespuestaCronService.ejecutarVerificacionRespuesta(lineaNegocio,idTareaLinea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
