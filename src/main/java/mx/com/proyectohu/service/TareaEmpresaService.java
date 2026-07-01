package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.TareaEmpresaDAO;



@Service
public class TareaEmpresaService {


	@Autowired
	public TareaEmpresaDAO tareaEmpresaDAO;


	
	public String consultarTareasEmpresa() {
		
	String json= tareaEmpresaDAO.consultarTareas();
		
		
		return json;
	}
}
