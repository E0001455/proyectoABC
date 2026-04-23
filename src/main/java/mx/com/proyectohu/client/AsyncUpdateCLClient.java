package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.dto.MiddlewareDTO;

@Service
public class AsyncUpdateCLClient {



	private final HttpClient httpClient;

	@Value("${async.update.cl.afore.url}")
	public String asyncUpdateCLAforeUrl;
	
	@Autowired
	public EnvioLineaDAO envioLineaDAO;


	public AsyncUpdateCLClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamadoAsyncUpdateCL (String token,  MiddlewareDTO middlewareDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= null;
		String response=null;
		
		if (lineaNegocio.equals("AFORE")) {
			url = asyncUpdateCLAforeUrl;
		}



				

			WebClient webClient = WebClient.create();

			 response = webClient.post()
			        .uri(url)
			        .header("Authorization", token)
			        .bodyValue(middlewareDTO)
			        .retrieve()
			        .bodyToMono(String.class)
			        .block();

			 System.out.print(response);				
		
		
		if (response!=null) {
			envioLineaDAO.actualizarEstatusBitacora(true);
		}
		
		return response;

	}
}
