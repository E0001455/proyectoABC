package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCCatHora;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveHorarioActividadLinea;
import mx.com.proyectohu.entity.HorarioActividadLineaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;

@Repository
public interface  HorarioRepository extends JpaRepository<ABCCatHora, Long> {

	
	

	

}
