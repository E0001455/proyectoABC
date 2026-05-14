package mx.com.proyectohu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.PollingStatusClient;
import mx.com.proyectohu.client.TokenClient;

@Service
public class RespuestaCLService {

	@Autowired
	public TokenClient tokenClient;

	@Autowired
	public PollingStatusClient pollingStatusClient;




	public String llamarToken() {
		String token="";

		token=tokenClient.conseguirToken();

		return token;

	}

	public String llamarPollingStatus( String respuesta) {
		String token="";

		token = llamarToken();

		String response = pollingStatusClient.llamadoPollingStatus(token, respuesta);


		return response;

	}

}
