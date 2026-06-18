package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoCampanaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.LlaveHorarioActividadCampana;
import mx.com.proyectohu.entity.HorarioActividadCampanaEntity;
import mx.com.proyectohu.entity.ActividadCampanaEntity;

@Repository
public interface  HorarioActividadCampanaRepository extends JpaRepository<HorarioActividadCampanaEntity, LlaveHorarioActividadCampana> {

	
	//public  List<HorarioActividadCampanaEntity> findByLlaveHorarioActividadCampana_idActividadCampana(Long idActividadCampana);

	

}
