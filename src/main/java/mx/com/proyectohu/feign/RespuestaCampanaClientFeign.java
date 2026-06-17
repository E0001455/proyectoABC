package mx.com.proyectohu.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "respuestacampana", url = "${respuesta.campana.url}")
public interface RespuestaCampanaClientFeign {
	
	@PostMapping("/pet/tareas/{idTarea}/respuestas/ejecutar")
	public String respuestaExtensionPerfil(@PathVariable Long idTarea);

}
