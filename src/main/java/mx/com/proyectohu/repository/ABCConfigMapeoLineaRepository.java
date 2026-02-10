package mx.com.proyectohu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;

@Repository
public interface  ABCConfigMapeoLineaRepository extends JpaRepository<ABCConfigMapeoLineaEntity, Long> {


	@Query("""
			SELECT 
			new mx.com.proyectohu.dto.MapeoLineaRecordDTO(
			ACMP.idABCConfigMapeoLinea,
			ACMP.idABCCatLineaNegocio,
			ACMP.bolActivo,
			ACMP.nombre ,
			ACMP.descripcion,
			ACMP.fecCreacion,
			ACMP.fecUltModificacion,
			ACMP.bolValidacion,
			ACMP.bolEnvio,
			COUNT(AMLC.llaveMapeoLineaColumna.idABCConfigMapeoLinea) 
			)
			FROM  
			ABCConfigMapeoLineaEntity ACMP LEFT JOIN  
			ABCMapeoLineaColumnaEntity AMLC ON 
			ACMP.idABCConfigMapeoLinea = AMLC.llaveMapeoLineaColumna.idABCConfigMapeoLinea
			GROUP BY 
			ACMP.idABCConfigMapeoLinea,
			ACMP.idABCCatLineaNegocio,
			ACMP.bolActivo,
			ACMP.nombre,
			ACMP.descripcion,
			ACMP.fecCreacion,
			ACMP.fecUltModificacion,
			ACMP.bolValidacion,
			ACMP.bolEnvio
			""" )
	public List<MapeoLineaRecordDTO> consultarMapeoLineasColumnas();

}
