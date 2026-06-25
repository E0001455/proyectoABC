package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadCampanaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;
import mx.com.proyectohu.entity.LlaveActividadCampana;

@Repository
public interface  ActividadCampanaRepository extends JpaRepository<ActividadCampanaEntity, LlaveActividadCampana> {
	
	
	
	
	public  List<ActividadCampanaEntity> findByLlaveActividadCampana_IdActividadMapeoCampana(Long idActividadMapeoCampana);
	
	


	
}
