package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;

@Repository
public interface  MapeoActividadLineaRepository extends JpaRepository<ActividadMapeoLineaEntity,Long> {



	public  List<ActividadMapeoLineaEntity> findAllByOrderByIdMapeoLinea();

}
