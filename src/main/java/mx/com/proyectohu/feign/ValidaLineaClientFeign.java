package mx.com.proyectohu.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "validarlinea", url = "${validacion.linea.url}")
public interface ValidaLineaClientFeign {
	
	@PostMapping("/cl/tareas/{idTarea}/validaciones/ejecutar")
	public String validaListaContacto(@PathVariable Long idTarea);

}
