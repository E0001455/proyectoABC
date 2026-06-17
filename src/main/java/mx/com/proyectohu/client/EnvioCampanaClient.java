package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.feign.EnvioCampanaClientFeign;

@Service
public class EnvioCampanaClient {

/*

	private final HttpClient httpClient;
	
	@Value("${envio.campana.url}")
	public String envioExtensionPerfilURL;


	public EnvioCampanaClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamarEnvioCampana(String lineaNegocio, Long idTareaCampana){
		Integer statusCode=null;
		String body=null;
		String url= envioExtensionPerfilURL;
		JSONObject json = new JSONObject();
		
		json.put("lineaNegocio", lineaNegocio);
		json.put("idTareaCampana", idTareaCampana);
		
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json.toString()))
					.build();

			HttpResponse<String> response;

			response = httpClient.send(request,	HttpResponse.BodyHandlers.ofString());

			statusCode = response.statusCode();
			body = response.body();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (statusCode == 200) {
			return body;
		} else {
			throw new RuntimeException("Error en la llamada: " + statusCode);
		}
		

	}
*/
	@Autowired
	public EnvioCampanaClientFeign envioCampanaClientFeign;

	public String llamarEnvioCampana(String lineaNegocio, Long idTareaCampana){
		
		Map<String, Object>  body= new HashMap<String, Object>(); 

		body.put("lineaNegocio", lineaNegocio);
		body.put("idTareaCampana", idTareaCampana);

		String respuesta =envioCampanaClientFeign.envioExtensionPerfil(idTareaCampana);


		return respuesta.toString();
	}


}
