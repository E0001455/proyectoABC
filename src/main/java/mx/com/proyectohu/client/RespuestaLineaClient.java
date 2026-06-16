package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import mx.com.proyectohu.ProyectoApplication;
import mx.com.proyectohu.feign.RespuestaLineaClientFeign;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RespuestaLineaClient {

 //   private final ProyectoApplication proyectoApplication;

/*

	private final HttpClient httpClient;
	
	@Value("${respuesta.linea.url}")
	public String respuestaListaContactoURL;
	
//	@Autowired
//	public EnvioLineaClientFeign envioLineaClientFeign;


	public RespuestaLineaClient(ProyectoApplication proyectoApplication) {
		this.httpClient = HttpClient.newHttpClient();
		this.proyectoApplication = proyectoApplication;
	}



	public String llamarRespuestaLinea(String lineaNegocio, Long idTareaLinea){
		Integer statusCode=null;
		String body=null;
		String url= respuestaListaContactoURL;
		JSONObject json = new JSONObject();
		

		json.put("lineaNegocio", lineaNegocio);
		json.put("idTareaLinea", idTareaLinea);
		
		
	/*	Map<String, Object>  body= new HashMap<String, Object>(); 
		
		body.put("lineaNegocio", lineaNegocio);
		body.put("idTareaLinea", idTareaLinea);
		
		ResponseEntity<?> respuesta =envioLineaClientFeign.envioListaContacto(body);
		
		
		
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
	public RespuestaLineaClientFeign respuestaLineaClientFeign;
    
    
	public String llamarRespuestaLinea(String lineaNegocio, Long idTareaLinea){
	
			
			Map<String, Object>  body= new HashMap<String, Object>(); 
				
				body.put("lineaNegocio", lineaNegocio);
				body.put("idTareaLinea", idTareaLinea);
				
				ResponseEntity<?> respuesta =respuestaLineaClientFeign.respuestaListaContacto(body);
				
				
				return respuesta.toString();
			
	}
	




}
