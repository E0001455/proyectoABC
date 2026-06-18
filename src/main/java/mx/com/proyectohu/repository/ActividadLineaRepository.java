package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.LlaveActividadLinea;

@Repository
public interface  ActividadLineaRepository extends JpaRepository<ActividadLineaEntity, LlaveActividadLinea> {


	

}
