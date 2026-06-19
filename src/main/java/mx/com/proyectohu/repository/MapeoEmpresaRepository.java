package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.MapeoEmpresaEntity;

@Repository
public interface  MapeoEmpresaRepository extends JpaRepository<MapeoEmpresaEntity, Long> {


	

}
