package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.proyectohu.entity.ActividadMapeoEmpresaEntity;

@Repository
public interface  MapeoActividadEmpresaRepository extends JpaRepository<ActividadMapeoEmpresaEntity,Long> {



	public  List<ActividadMapeoEmpresaEntity> findAllByOrderByIdMapeoEmpresa();

}
