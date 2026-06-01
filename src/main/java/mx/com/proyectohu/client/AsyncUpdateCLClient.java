package mx.com.proyectohu.client;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.dto.MiddlewareCLDTO;

@Service
public class AsyncUpdateCLClient {



	private final HttpClient httpClient;
	
	@Value("${responsys.url.base}")
	public String responsysBase;
	
	@Value("${responsys.url.api}")
	public String responsysUrlApi;

	@Value("${async.update.cl.afore.url}")
	public String asyncUpdateCLAforeUrl;

	@Value("${async.update.cl.sofom.url}")
	public String asyncUpdateCLSofomUrl;
	
	@Value("${async.update.cl.pensiones.url}")
	public String asyncUpdateCLPensionesUrl;
	
	@Value("${async.update.cl.prospectos.url}")
	public String asyncUpdateCLProspectosUrl;
	
	

	public AsyncUpdateCLClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String llamadoAsyncUpdateCL (String token,  MiddlewareCLDTO middlewareDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= responsysBase+responsysUrlApi;
		String response=null;
		
		if (lineaNegocio.equals("AFORE")) {
			url = url + asyncUpdateCLAforeUrl;
		}
		if (lineaNegocio.equals("SOFOM")) {
			url = url + asyncUpdateCLSofomUrl;
		}
		if (lineaNegocio.equals("PENSIONES")) {
			url = url + asyncUpdateCLPensionesUrl;
		}
		if (lineaNegocio.equals("PROSPECTOS")) {
			url = url + asyncUpdateCLPensionesUrl;
		}


		WebClient webClient = WebClient.builder()
		        .defaultHeader("Connection", "close")
		        .build();

			 response = webClient.post()
			        .uri(url)
			        .header("Authorization", token)
			        .bodyValue(middlewareDTO)
			        .retrieve()
			        .bodyToMono(String.class)
			        .block();

			 System.out.println(response);				
		
		
	
		
		return response;

	}
}
