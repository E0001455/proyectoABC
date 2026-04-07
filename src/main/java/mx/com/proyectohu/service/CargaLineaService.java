package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;






@Service
public class CargaLineaService {


	@Autowired
	public CargaLineaDAO cargaLineaDAO;

	
	public void ejecutarCargaListaContacto(String lineaNegocio, Long idTareaLinea ) {
		
		cargaLineaDAO.ejecutarSPCargaListaContacto(lineaNegocio,idTareaLinea);
		
		
		
	}
}
