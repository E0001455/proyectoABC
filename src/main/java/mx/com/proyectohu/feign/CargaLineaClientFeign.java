package mx.com.proyectohu.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(name = "cargalinea", url="${carga.linea.url}")
public interface CargaLineaClientFeign {
	

	
	@PostMapping("/cl/tareas/{idTarea}/cargas/ejecutar")
	public String cargaListaContacto(@PathVariable Long idTarea);

}
