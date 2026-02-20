package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveTareaHorarioLinea;
import mx.com.proyectohu.entity.TareaHorarioLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;

@Repository
public interface  TareaHorarioLineaRepository extends JpaRepository<TareaHorarioLineaEntity, LlaveTareaHorarioLinea> {

	
	public  List<TareaHorarioLineaEntity> findByLlaveTareaHorarioLinea_idCFGTareaLinea(Long idCFGTareaLinea);

	

}
