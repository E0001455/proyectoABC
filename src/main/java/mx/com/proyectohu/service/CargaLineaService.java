package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;






@Service
public class CargaLineaService {


	@Autowired
	public CargaLineaDAO cargaLineaDAO;
	
	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaLineaRepository tareaLineaRepository;
	
	public void ejecutarCargaListaContacto(Long idTareaLinea ) {
		
		TareaLineaEntity tareaLineaEntity = new TareaLineaEntity(); 
		
		tareaLineaEntity = tareaLineaRepository.findById(idTareaLinea).get();
		
		String lineaNegocio = lineaNegocioRepository.findById(tareaLineaEntity.getMapeoLinea().getIdABCCatLineaNegocio()).get().getNombre();
		
		cargaLineaDAO.ejecutarSPCargaListaContacto(lineaNegocio,idTareaLinea);
		
		
		
	}
}
