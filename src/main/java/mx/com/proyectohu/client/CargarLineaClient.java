package mx.com.proyectohu.client;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.feign.CargaLineaClientFeign;

@Service
public class CargarLineaClient {


/*
	private final HttpClient httpClient;
	
	@Value("${carga.linea.url}")
	public String cargaLineaURL;


	public CargarLineaClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamarCargaLinea(String lineaNegocio, Long idTareaLinea){
		Integer statusCode=null;
		String body=null;
		String url= cargaLineaURL;
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
    public CargaLineaClientFeign cargaLineaClientFeign;
	
	public String llamarCargaLinea(String lineaNegocio, Long idTareaLinea){
	
	Map<String, Object>  body= new HashMap<String, Object>(); 
		
		body.put("lineaNegocio", lineaNegocio);
		body.put("idTareaLinea", idTareaLinea);
		
		String respuesta =cargaLineaClientFeign.cargaListaContacto(idTareaLinea);
		
		
		return respuesta.toString();
	}

}
