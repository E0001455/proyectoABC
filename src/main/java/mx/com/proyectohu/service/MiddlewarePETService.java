package mx.com.proyectohu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.com.proyectohu.client.AsyncUpdatePETClient;
import mx.com.proyectohu.client.TokenClient;
import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.dto.MiddlewarePETDTO;
import mx.com.proyectohu.repository.ListaContactoRepository;

@Service
public class MiddlewarePETService {
	
	@Autowired
	public TokenClient tokenClient;
	
	@Autowired
	public AsyncUpdatePETClient asyncUpdatePETClient;
	
	@Autowired
	public ListaContactoRepository listaContactoRepository;
	
	
	public String llamarToken() {
		String token="";
		
		token=tokenClient.conseguirToken();
		
		
		
		return token;
		
	}
	public String llamarAsynUpdatePET(MiddlewarePETDTO middlewarePETDTO,String lineaNegocio) {
		String token="";
		
		token = llamarToken();
		
		String response = asyncUpdatePETClient.llamadoAsyncUpdatePET(token, middlewarePETDTO,lineaNegocio);
		
		
		return response;
		
	}

}
