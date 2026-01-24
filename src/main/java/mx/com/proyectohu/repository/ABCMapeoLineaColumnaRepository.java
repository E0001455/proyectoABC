package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoLineaColumna;

@Repository
public interface  ABCMapeoLineaColumnaRepository extends JpaRepository<ABCMapeoLineaColumnaEntity, LlaveMapeoLineaColumna> {


	public  List<ABCMapeoLineaColumnaEntity> findByLlavelineacolumna_IdABCConfigMapeoLinea(Long idABCConfigMapeoLinea );



}
