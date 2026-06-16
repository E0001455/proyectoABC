package mx.com.proyectohu.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.entity.TareaCampanaEntity;
import mx.com.proyectohu.repository.TareaCampanaRepository;
import mx.com.proyectohu.util.FechaUtil;


@Service
public class DictaminarCampanaService {

	@Autowired
	public TareaCampanaRepository  tareaCampanaRepository;

	

	
	public void actualizarTarea(Long idTareaLinea) {
		Optional<TareaCampanaEntity> tareaCampanaEntityOptional =  tareaCampanaRepository.findById(idTareaLinea);

		if (tareaCampanaEntityOptional.isPresent()) {
			TareaCampanaEntity tareaCampanaEntity = tareaCampanaEntityOptional.get();

			tareaCampanaEntity.setFiDictaminado(true);
			tareaCampanaEntity.setFdFechaDictaminado(FechaUtil.obtenerFechaActual());


			tareaCampanaEntity = tareaCampanaRepository.save(tareaCampanaEntity);
		}
			
	}
		
		
}
