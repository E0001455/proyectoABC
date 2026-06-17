package mx.com.proyectohu.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "respuestalinea", url = "${respuesta.linea.url}")
public interface RespuestaLineaClientFeign {
	
	@PostMapping("/cl/tareas/{idTarea}/respuestas/ejecutar")
	public String respuestaListaContacto(@PathVariable Long idTarea);

}
