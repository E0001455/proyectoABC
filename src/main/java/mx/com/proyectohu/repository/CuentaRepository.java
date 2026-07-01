package mx.com.proyectohu.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.CuentaEntity;

@Repository
public interface  CuentaRepository extends JpaRepository<CuentaEntity, Long > {
	
	
	

}
