package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoCampanaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.LlaveTareaHorarioCampana;
import mx.com.proyectohu.entity.TareaHorarioCampanaEntity;
import mx.com.proyectohu.entity.TareaCampanaEntity;

@Repository
public interface  TareaHorarioCampanaRepository extends JpaRepository<TareaHorarioCampanaEntity, LlaveTareaHorarioCampana> {

	
	public  List<TareaHorarioCampanaEntity> findByLlaveTareaHorarioCampana_idCFGTareaCampana(Long idCFGTareaCampana);

	

}
