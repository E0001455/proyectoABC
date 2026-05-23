package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.service.CargaLineaService;
import mx.com.proyectohu.service.EnvioCampanaService;
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
public class EnvioCampanaController {

	@Autowired
	public EnvioCampanaService envioCampanaService;
	

	@PostMapping("/envio/extencion/perfil")
	public ResponseEntity<?> envioExtensionPerfil(@RequestBody Map<String, Object> body) {

		String lineaNegocio = (String) body.get("lineaNegocio");
		Long idTareaCampana = Long.parseLong(body.get("idTareaCampana").toString());
		
		try {
			envioCampanaService.ejecutarEnvioExtensionPerfil(lineaNegocio,idTareaCampana);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
