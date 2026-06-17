package mx.com.proyectohu.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "validarcampana", url = "${validacion.campana.url}")
public interface ValidaCampanaClientFeign {
	
	@PostMapping("/pet/tareas/{idTarea}/validaciones/ejecutar")
	public String validarExtensionPerfil(@PathVariable Long idTarea);

}
