package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import mx.com.proyectohu.ProyectoApplication;
import mx.com.proyectohu.feign.RespuestaCampanaClientFeign;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RespuestaCampanaClient {
	
	/*

    private final ProyectoApplication proyectoApplication;



	private final HttpClient httpClient;
	
	@Value("${respuesta.campana.url}")
	public String respuestaExtensionPerfilURL;
	
//	@Autowired
//	public EnvioLineaClientFeign envioLineaClientFeign;


	public RespuestaCampanaClient(ProyectoApplication proyectoApplication) {
		this.httpClient = HttpClient.newHttpClient();
		this.proyectoApplication = proyectoApplication;
	}



	public String llamarRespuestaCampana(String lineaNegocio, Long idTareaLinea){
		Integer statusCode=null;
		String body=null;
		String url= respuestaExtensionPerfilURL;
		JSONObject json = new JSONObject();
		

		json.put("lineaNegocio", lineaNegocio);
		json.put("idTareaCampana", idTareaLinea);
		
		
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
	public RespuestaCampanaClientFeign respuestaCampanaClientFeign;
	
	public String llamarRespuestaCampana(String lineaNegocio, Long idTareaCampana){
		Map<String, Object>  body= new HashMap<String, Object>(); 

		body.put("lineaNegocio", lineaNegocio);
		body.put("idTareaCampana", idTareaCampana);

		String respuesta =respuestaCampanaClientFeign.respuestaExtensionPerfil(idTareaCampana);


		return respuesta.toString();
	}



}
