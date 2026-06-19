package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.EmpresaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoEmpresaColumna;

@Repository
public interface  EmpresaColumnaRepository extends JpaRepository<EmpresaColumnaEntity, LlaveMapeoEmpresaColumna> {


	public  List<EmpresaColumnaEntity> findByLlaveMapeoEmpresaColumna_IdMapeoEmpresa(Long idMapeoEmpresa );

	



}
