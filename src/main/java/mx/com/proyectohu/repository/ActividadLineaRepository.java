package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.EmpresaColumnaEntity;
import mx.com.proyectohu.entity.LlaveActividadLinea;

@Repository
public interface  ActividadLineaRepository extends JpaRepository<ActividadLineaEntity, LlaveActividadLinea> {
	
	
	public  List<ActividadLineaEntity> findByLlaveActividadLinea_IdActividadMapeoLinea(Long idActividadMapeoLinea);

}
