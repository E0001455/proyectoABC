package mx.com.proyectohu.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "enviocampana", url = "${envio.campana.url}")
public interface EnvioCampanaClientFeign {
	
	@PostMapping("/pet/tareas/{idTarea}/envios/ejecutar")
	public String envioExtensionPerfil(@PathVariable Long idTarea);

}
