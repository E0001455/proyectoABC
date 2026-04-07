package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;
import mx.com.proyectohu.component.ValidarLineaDAO;






@Service
public class ValidarLineaService {


	@Autowired
	public ValidarLineaDAO validarLineaDAO;

	
	public void ejecutarValidarListaContacto(String lineaNegocio,  Long idTareaLinea) {
		
		validarLineaDAO.ejecutarSPValidaListaContacto(lineaNegocio,idTareaLinea);
		
		
		
	}
}
