package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.TareaLineaDAO;


@Service
public class TareaLineaService {


	@Autowired
	public TareaLineaDAO tareaLineaDAO;


	
	public String consultarTareaslinea() {
		
	String json= tareaLineaDAO.consultarTareas();
		
		
		return json;
	}
}
