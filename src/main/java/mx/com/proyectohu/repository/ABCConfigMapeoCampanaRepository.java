package mx.com.proyectohu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoCampanaRecordDTO;
import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import java.util.List;




@Repository
public interface  ABCConfigMapeoCampanaRepository extends JpaRepository<ABCConfigMapeoCampanaEntity, Long> {
	
	
	@Query("""
			SELECT 
			new mx.com.proyectohu.dto.MapeoCampanaRecordDTO(
			ACMP.idABCConfigMapeoCampana,
			ACMP.idABCCatLineaNegocio,
			ACMP.idABCCatCampana,
			ACMP.bolActivo,
			ACMP.nombre ,
			ACMP.descripcion,
			ACMP.fecCreacion,
			ACMP.fecUltModificacion,
			ACMP.bolValidacion,
			ACMP.bolEnvio,
			ACMP.fiDictaminacion,
			ACMP.fiPorcentajeError,
			COUNT(AMLC.llaveMapeoCampanaColumna.idABCConfigMapeoCampana),
			ACMP.respuesta
			)
			FROM  
			ABCConfigMapeoCampanaEntity ACMP LEFT JOIN  
			ABCMapeoCampanaColumnaEntity AMLC ON 
			ACMP.idABCConfigMapeoCampana = AMLC.llaveMapeoCampanaColumna.idABCConfigMapeoCampana
			GROUP BY 
			ACMP.idABCConfigMapeoCampana,
			ACMP.idABCCatLineaNegocio,
			ACMP.idABCCatCampana,
			ACMP.bolActivo,
			ACMP.nombre,
			ACMP.descripcion,
			ACMP.fecCreacion,
			ACMP.fecUltModificacion,
			ACMP.bolValidacion,
			ACMP.bolEnvio,
			ACMP.fiDictaminacion,
			ACMP.fiPorcentajeError,
			ACMP.respuesta
			""" )
	public List<MapeoCampanaRecordDTO> consultarMapeoCampanasColumnas();


}
