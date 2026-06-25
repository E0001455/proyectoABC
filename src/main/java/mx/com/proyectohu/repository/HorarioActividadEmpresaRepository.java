package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import mx.com.proyectohu.entity.HorarioActividadEmpresaEntity;
import mx.com.proyectohu.entity.LlaveHorarioActividadEmpresa;

@Repository
public interface  HorarioActividadEmpresaRepository extends JpaRepository<HorarioActividadEmpresaEntity, LlaveHorarioActividadEmpresa> {

	
	public  List<HorarioActividadEmpresaEntity> findByLlaveHorarioActividadEmpresa_IdActividadMapeoEmpresaAndLlaveHorarioActividadEmpresa_IdActividad(Long idActividadMapeo,Long idActividad);

	

}
