package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCCatLineaNegocioEntity;


@Repository
public interface  LineaNegocioRepository extends JpaRepository<ABCCatLineaNegocioEntity, Long> {

	
	

	

}
