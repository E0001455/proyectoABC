package mx.com.proyectohu.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "enviolinea", url = "http://localhost:8080")
public interface EnvioLineaClientFeign {
	
	@PostMapping("/profuturo/api/v1/envio/lista/contacto")
	public ResponseEntity<?> envioListaContacto(@RequestBody Map<String, Object> body);

}
