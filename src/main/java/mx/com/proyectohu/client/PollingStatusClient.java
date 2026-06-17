package mx.com.proyectohu.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PollingStatusClient {


	@Value("${polling.status.url}")
	public String pollingStatuseUrl;


	public String llamadoPollingStatus(String token,  String respuesta){

		String url = pollingStatuseUrl;
		String response=null;


		WebClient webClient = WebClient.create();

		response = webClient.get()
				.uri(url+ "/{respuesta}", respuesta)
				.header("Authorization", token)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		return response;

	}
}
