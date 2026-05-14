package mx.com.proyectohu.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.proyectohu.component.EnvioLineaDAO;
import mx.com.proyectohu.dto.MiddlewareCLDTO;

@Service
public class PollingStatusClient {

	@Value("${polling.status.url}")
	public String pollingStatuseUrl;



	public String llamadoPollingStatus(String token,  String respuesta){

		String response=null;


		WebClient webClient = WebClient.create();

		response = webClient.get()
				.uri(pollingStatuseUrl+ "/{respuesta}", respuesta)
				.header("Authorization", token)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		return response;

	}
}
