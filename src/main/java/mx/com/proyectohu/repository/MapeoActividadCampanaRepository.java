package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ActividadMapeoCampanaEntity;

@Repository
public interface  MapeoActividadCampanaRepository extends JpaRepository<ActividadMapeoCampanaEntity, Long> {


	public  List<ActividadMapeoCampanaEntity> findAllByOrderByIdMapeoCampana();



}
