package mx.com.proyectohu.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.feign.ValidaLineaClientFeign;

@Service
public class ValidarLineaClient {

/*

	private final HttpClient httpClient;
	
	@Value("${validacion.linea.url}")
	public String validaLineaURL;


	public ValidarLineaClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamarValidarLinea(String lineaNegocio, Long idTareaLinea){
		Integer statusCode=null;
		String body=null;
		String url= validaLineaURL;
		JSONObject json = new JSONObject();
		
		json.put("lineaNegocio", lineaNegocio);
		json.put("idTareaLinea", idTareaLinea);
		
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
    public ValidaLineaClientFeign validaLineaClientFeign;
	
	public String llamarValidarLinea(String lineaNegocio, Long idTareaLinea){
	
	Map<String, Object>  body= new HashMap<String, Object>(); 
		
		body.put("lineaNegocio", lineaNegocio);
		body.put("idTareaLinea", idTareaLinea);
		
		ResponseEntity<?> respuesta =validaLineaClientFeign.validaListaContacto(body);
		
		
		return respuesta.toString();
	}

}
