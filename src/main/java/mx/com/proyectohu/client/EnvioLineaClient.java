package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnvioLineaClient {



	private final HttpClient httpClient;
	
	@Value("${envio.linea.url}")
	public String envioListaContactoURL;


	public EnvioLineaClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamarEnvioLinea(String lineaNegocio, Long idTareaLinea){
		Integer statusCode=null;
		String body=null;
		String url= envioListaContactoURL;
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




}
