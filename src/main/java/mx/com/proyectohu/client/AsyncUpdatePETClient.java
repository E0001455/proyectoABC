package mx.com.proyectohu.client;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.dto.MiddlewarePETDTO;

@Service
public class AsyncUpdatePETClient {



	private final HttpClient httpClient;
	
	@Value("${async.update.pet.afore.url}")
	public String asyncUpdatePETAforeUrl;
	
	
	@Value("${async.update.pet.sofom.url}")
	public String asyncUpdatePETSofomUrl;
	
	
	@Value("${async.update.pet.pensiones.url}")
	public String asyncUpdatePETPensionesUrl;

	
	@Value("${async.update.pet.prospectos.url}")
	public String asyncUpdatePETProspectosUrl;
	
	

	public AsyncUpdatePETClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamadoAsyncUpdatePET(String token,  MiddlewarePETDTO middlewarePETDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= "";
		String response=null;
		
		if (lineaNegocio.equals("AFORE")) {
			url = url + asyncUpdatePETAforeUrl;
		}
		if (lineaNegocio.equals("SOFOM")) {
			url =url +  asyncUpdatePETSofomUrl;
		}
		if (lineaNegocio.equals("PENSIONES")) {
			url = url + asyncUpdatePETPensionesUrl;
		}
		if (lineaNegocio.equals("PROSPECTOS")) {
			url = url + asyncUpdatePETProspectosUrl;
		}

		WebClient webClient = WebClient.builder()
		        .defaultHeader("Connection", "close")
		        .build();

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
