package mx.com.proyectohu.repository;

import org.apache.commons.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.TareaLineaEntity;





@Repository
public interface  TareaCronRepository extends JpaRepository<TareaLineaEntity, Long> {
	
	
	@Procedure(procedureName = "SPREGISTRARTAREA")
	public void ejecutarSP();
	

}
