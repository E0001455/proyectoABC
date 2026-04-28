package mx.com.proyectohu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.client.AsyncUpdateCLClient;
import mx.com.proyectohu.client.TokenClient;
import mx.com.proyectohu.dto.MiddlewareDTO;
import mx.com.proyectohu.repository.ListaContactoRepository;

@Service
public class MiddlewareCLService {
	
	@Autowired
	public TokenClient tokenClient;
	
	@Autowired
	public AsyncUpdateCLClient asyncUpdateCLClient;
	
	@Autowired
	public ListaContactoRepository listaContactoRepository;
	
	
	public String llamarToken() {
		String token="";
		
		token=tokenClient.conseguirToken();
		
		
		
		return token;
		
	}
	public String llamarAsynUpdateCL(MiddlewareDTO middlewareDTO,String lineaNegocio) {
		String token="";
		
		token = llamarToken();
		
		String response = asyncUpdateCLClient.llamadoAsyncUpdateCL(token, middlewareDTO,lineaNegocio);
		
		
		return response;
		
	}

}
