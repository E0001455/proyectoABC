package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;
import mx.com.proyectohu.component.ValidarCampanaDAO;
import mx.com.proyectohu.component.ValidarLineaDAO;






@Service
public class ValidarCampanaService {


	@Autowired
	public ValidarCampanaDAO validarCampanaDAO;

	
	public void ejecutarValidarExtencionPerfil(String lineaNegocio,  Long idTareaLinea) {
		
		validarCampanaDAO.ejecutarSPValidarExtencionPerfil(lineaNegocio,idTareaLinea);
		
		
		
	}
}
