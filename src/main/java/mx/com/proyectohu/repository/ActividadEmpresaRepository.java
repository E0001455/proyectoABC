package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ActividadEmpresaEntity;
import mx.com.proyectohu.entity.LlaveActividadEmpresa;



@Repository
public interface  ActividadEmpresaRepository extends JpaRepository<ActividadEmpresaEntity, LlaveActividadEmpresa> {
	
	
	public  List<ActividadEmpresaEntity> findByLlaveActividadEmpresa_IdActividadMapeoEmpresa(Long idActividadMapeoEmpresa);


	

}
