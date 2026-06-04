package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCCatEjecucion;


@Repository
public interface  EjecucionRepository extends JpaRepository<ABCCatEjecucion, Long> {

	
	

	

}
