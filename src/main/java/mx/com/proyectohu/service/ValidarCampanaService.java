package mx.com.proyectohu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.ValidarCampanaDAO;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;






@Service
public class ValidarCampanaService {


	@Autowired
	public ValidarCampanaDAO validarCampanaDAO;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;


	public void ejecutarValidarExtencionPerfil(Long idTareaCampana) {

		TareaCampanaEntity tareaCampanaEntity = new TareaCampanaEntity(); 

		tareaCampanaEntity = tareaCampanaRepository.findById(idTareaCampana).get();

		String lineaNegocio = lineaNegocioRepository.findById(tareaCampanaEntity.getMapeoCampana().getIdABCCatLineaNegocio()).get().getNombre();


		validarCampanaDAO.ejecutarSPValidarExtencionPerfil(lineaNegocio,idTareaCampana);



	}
}
