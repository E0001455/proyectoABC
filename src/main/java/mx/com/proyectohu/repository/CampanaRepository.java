package mx.com.proyectohu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCCatCampanaEntity;


@Repository
public interface  CampanaRepository extends JpaRepository<ABCCatCampanaEntity, Long> {

	
	

	

}
