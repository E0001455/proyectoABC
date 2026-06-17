package mx.com.proyectohu.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "enviolinea", url = "${envio.linea.url}")
public interface EnvioLineaClientFeign {
	
	@PostMapping("/cl/tareas/{idTarea}/envios/ejecutar")
	public String envioListaContacto(@PathVariable Long idTarea);

}
