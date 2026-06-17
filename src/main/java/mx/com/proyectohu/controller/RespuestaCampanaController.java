package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.com.proyectohu.service.PETRespuestaCronService;

	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class RespuestaCampanaController {

	@Autowired
	public PETRespuestaCronService petRespuestaCronService;
	

	@PostMapping("/pet/tareas/{idTarea}/respuestas/ejecutar")
	public ResponseEntity<?> respuestaExtensionPerfil(@PathVariable Long idTarea) {

		
	
		try {
			petRespuestaCronService.ejecutarVerificacionRespuesta(idTarea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return ResponseEntity.ok("ejecucion correcta");
		

	}

}
