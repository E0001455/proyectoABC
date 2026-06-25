package mx.com.proyectohu.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.ValidarCampanaDAO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoCampanaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;
import mx.com.proyectohu.repository.LineaNegocioRepository;
import mx.com.proyectohu.repository.MapeoActividadCampanaRepository;
import mx.com.proyectohu.repository.TareaCampanaRepository;






@Service
public class ValidarCampanaService {


	@Autowired
	public ValidarCampanaDAO validarCampanaDAO;

	@Autowired
	public LineaNegocioRepository lineaNegocioRepository;

	@Autowired
	public TareaCampanaRepository tareaCampanaRepository;

	@Autowired
	public MapeoActividadCampanaRepository mapeoActividadCampanaRepository;
	
	
	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;

	public void ejecutarValidarExtencionPerfil(Long idTareaCampana) {

		TareaCampanaEntity tareaCampanaEntity = new TareaCampanaEntity(); 

		tareaCampanaEntity = tareaCampanaRepository.findById(idTareaCampana).get();

		ActividadMapeoCampanaEntity actividadMapeoCampanaEntity=mapeoActividadCampanaRepository.findById(tareaCampanaEntity.getIdActividadMapeoCampana()).get();

		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(actividadMapeoCampanaEntity.getIdMapeoCampana());

		String lineaNegocio = lineaNegocioRepository.findById(abcConfigMapeoCampanaEntityOptional.get().getIdABCCatLineaNegocio()).get().getNombre();


		validarCampanaDAO.ejecutarSPValidarExtencionPerfil(lineaNegocio,idTareaCampana);



	}
}
