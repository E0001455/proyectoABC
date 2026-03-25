package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.BitacoraTareaCampanaEntity;
import mx.com.proyectohu.entity.BitacoraTareaLineaEntity;
import mx.com.proyectohu.entity.TareaLineaEntity;


@Repository
public interface  BitacoraTareaCampanaRepository extends JpaRepository<BitacoraTareaCampanaEntity, Long> {
	

	
	public List<BitacoraTareaCampanaEntity>  findByidTareaCampana(Long idTareaCampana);
	


	

}
