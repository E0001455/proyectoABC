package mx.com.proyectohu.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.component.CargaLineaDAO;
import mx.com.proyectohu.component.ValidarLineaDAO;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;
import mx.com.proyectohu.repository.TareaLineaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class DictaminarLineaService {

	@Autowired
	public TareaLineaRepository  tareaLineaRepository;

	

	
	public void actualizarTarea(Long idTareaLinea) {
		Optional<TareaLineaEntity> tareaLineaEntityOptional =  tareaLineaRepository.findById(idTareaLinea);

		if (tareaLineaEntityOptional.isPresent()) {
			TareaLineaEntity tareaLineaEntity = tareaLineaEntityOptional.get();

			tareaLineaEntity.setFiDictaminado(true);
			tareaLineaEntity.setFdFechaDictaminado(FechaUtil.obtenerFechaActual());


			tareaLineaEntity = tareaLineaRepository.save(tareaLineaEntity);
		}
			
	}
		
		
}
