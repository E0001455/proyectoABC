package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoLineaColumna;
import mx.com.proyectohu.entity.LlaveTareaMapeoCampana;
import mx.com.proyectohu.entity.LlaveTareaMapeoLinea;
import mx.com.proyectohu.entity.TareaHorarioLineaEntity;
import mx.com.proyectohu.entity.TareaMapeoCampanaEntity;
import mx.com.proyectohu.entity.TareaMapeoLineaEntity;

@Repository
public interface  MapeoTareaCampanaRepository extends JpaRepository<TareaMapeoCampanaEntity, LlaveTareaMapeoCampana> {


	public  TareaMapeoCampanaEntity findByLlaveTareaMapeoCampana_idCFGTareaCampana(Long idABCConfigMapeoCampana);



}
