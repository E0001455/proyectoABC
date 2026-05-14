package mx.com.proyectohu.client;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;

@Service
public class AsyncUpdatePETClient {



	private final HttpClient httpClient;

	@Value("${async.update.pet.afore.url}")
	public String asyncUpdatePETAforeUrl;
	
	@Autowired
	public EnvioLineaDAO envioLineaDAO;


	public AsyncUpdatePETClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamadoAsyncUpdatePET(String token,  MiddlewarePETDTO middlewarePETDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= null;
		String response=null;
		
		if (lineaNegocio.equals("AFORE")) {
			url = asyncUpdatePETAforeUrl;
		}

			WebClient webClient = WebClient.create();

			 response = webClient.post()
			        .uri(url)
			        .header("Authorization", token)
			        .bodyValue(middlewarePETDTO)
			        .retrieve()
			        .bodyToMono(String.class)
			        .block();

			 System.out.println(response);				
		
		
		
		
		return response;

	}
}
