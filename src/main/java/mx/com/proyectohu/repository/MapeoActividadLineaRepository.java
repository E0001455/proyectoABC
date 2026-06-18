package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ActividadMapeoLineaEntity;

@Repository
public interface  MapeoActividadLineaRepository extends JpaRepository<ActividadMapeoLineaEntity,Long> {


//	public  ActividadMapeoLineaEntity findByLlaveActividadMapeoLinea_idActividadLinea(Long idActividadLinea);



}
