package mx.com.proyectohu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.proyectohu.entity.CatalogosEntity;



public interface CatalogosRepository extends JpaRepository<CatalogosEntity, Long> {
	
	
	public Optional<CatalogosEntity> findByCodigo(String codigo);
	       
	            
	                
	                
	          
	  


}
