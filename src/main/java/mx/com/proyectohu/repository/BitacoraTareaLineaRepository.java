package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;


@Repository
public interface  BitacoraTareaLineaRepository extends JpaRepository<BitacoraTareaLineaEntity, Long> {
	

	
	public List<BitacoraTareaLineaEntity>  findByidTareaLinea(Long idTareaLinea);
	


	

}
