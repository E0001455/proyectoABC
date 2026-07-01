package mx.com.proyectohu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.TareaCampanaDAO;



@Service
public class TareaCampanaService {

	
	@Autowired
	public TareaCampanaDAO tareaCampanaDAO;
	
	public String consultarTareasCampana() {
		
	String json= tareaCampanaDAO.consultarTareas();
		
		
		return json;
	}
}
