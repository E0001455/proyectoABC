package mx.com.proyectohu.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;

@Service
public class MiddlewarePETClient {



	@Value("${middleware.pet.url}")
	public String middlewarePETUrl;


	public String llamadoAsyncUpdatePET(MiddlewarePETDTO middlewarePETDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= middlewarePETUrl;
		String response = null;

		WebClient webClient = WebClient.create();

		response = webClient.post()
			    .uri(middlewarePETUrl + "/{lineaNegocio}", lineaNegocio)
			    .bodyValue(middlewarePETDTO)
			    .retrieve()
			    .bodyToMono(String.class)
			    .block();

		System.out.print(response);

		return response;

	}
}
