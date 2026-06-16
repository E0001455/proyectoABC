package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.dto.MiddlewareCLDTO;

@Service
public class MiddlewareCLClient {



	@Value("${middleware.cl.url}")
	public String middlewareCLUrl;


	public String llamadoAsyncUpdateCL (MiddlewareCLDTO middlewareCLDTO, String lineaNegocio){
		Integer statusCode=null;
		String body=null;
		String url= middlewareCLUrl;
		String response = null;

		WebClient webClient = WebClient.create();

		response = webClient.post()
			    .uri(middlewareCLUrl + "/{lineaNegocio}", lineaNegocio)
			    .bodyValue(middlewareCLDTO)
			    .retrieve()
			    .bodyToMono(String.class)
			    .block();


		return response;

	}
}
