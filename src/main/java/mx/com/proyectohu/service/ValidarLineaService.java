package mx.com.proyectohu.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;
import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.MapeoActividadLineaRepository;
import mx.com.proyectohu.repository.TareaLineaRepository;






@Service
public class ValidarLineaService {


	@Autowired
	public ValidarLineaDAO validarLineaDAO;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaLineaRepository tareaLineaRepository;

	@Autowired
	public MapeoActividadLineaRepository mapeoActividadLineaRepository;

	@Autowired
	public ABCConfigMapeoLineaRepository abcConfigMapeoLineaRepository;



	public void ejecutarValidarListaContacto(Long idTareaLinea) {

		TareaLineaEntity tareaLineaEntity = new TareaLineaEntity(); 

		tareaLineaEntity = tareaLineaRepository.findById(idTareaLinea).get();

		ActividadMapeoLineaEntity actividadMapeoLineaEntity=mapeoActividadLineaRepository.findById(tareaLineaEntity.getIdActividadMapeoLinea()).get();

		Optional<ABCConfigMapeoLineaEntity> abcConfigMapeoLineaEntityOptional = abcConfigMapeoLineaRepository.findById(actividadMapeoLineaEntity.getIdMapeoLinea());

		String lineaNegocio = lineaNegocioRepository.findById(abcConfigMapeoLineaEntityOptional.get().getIdABCCatLineaNegocio()).get().getNombre();



		validarLineaDAO.ejecutarSPValidaListaContacto(lineaNegocio,idTareaLinea);



	}
}
