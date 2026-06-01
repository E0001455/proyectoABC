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
public class TokenClient {



	private final HttpClient httpClient;
	
	@Value("${responsys.url.base}")
	public String responsysUrlBase;
	
	@Value("${token.url}")
	public String tokenUrl;

	@Value("${token.auth_type}")
	public String tokenauth_type;
	
	@Value("${token.user_name}")
	public String tokenuser_name;
	
	@Value("${token.password}")
	public String tokenpassword;

	public TokenClient() {
		this.httpClient = HttpClient.newHttpClient();
	}



	public String conseguirToken(){
		Integer statusCode=null;
		String body=null;
		String url= responsysUrlBase+tokenUrl;
		String token="";
		
		try {
			
			
			String form = "auth_type="+tokenauth_type
			        + "&user_name="+tokenuser_name
			        + "&password="+tokenpassword;

			HttpRequest request = HttpRequest.newBuilder()
			        .uri(URI.create(tokenUrl))
			        .header("Content-Type", "application/x-www-form-urlencoded")
			        .POST(HttpRequest.BodyPublishers.ofString(form))
			        .build();
			
			
			
			HttpResponse<String> response;

			response = httpClient.send(request,	HttpResponse.BodyHandlers.ofString());


			
			statusCode = response.statusCode();
			body = response.body();

			

			JSONObject json = new JSONObject(body);
			
			 token= json.getString("authToken");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (statusCode == 200) {
			return token;
		} else {
			throw new RuntimeException("Error en la llamada: " + statusCode);
		}
		

	}




}
