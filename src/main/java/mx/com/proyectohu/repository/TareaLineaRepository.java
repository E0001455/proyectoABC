package mx.com.proyectohu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.TareaLineaEntity;


@Repository
public interface  TareaLineaRepository extends JpaRepository<TareaLineaEntity, Long> {

	

	@Query(value = """
			SELECT 
			TCATCL.nombre
			FROM TareaLineaEntity TTL
			INNER JOIN ActividadMapeoLineaEntity AML
			ON AML.idActividadMapeoLinea = TTL.idActividadMapeoLinea
			INNER JOIN ABCMapeoLineaColumnaEntity TCL
			ON AML.idMapeoLinea = TCL.llaveMapeoLineaColumna.idABCConfigMapeoLinea
			INNER JOIN ABCCatColumnaLineaEntity TCATCL
			ON TCATCL.id = TCL.llaveMapeoLineaColumna.idABCCatColumna
			WHERE TTL.idTareaLinea =:idTareaLinea

			""")
	List<String> obtenerColumnasXidTarea(
			@Param("idTareaLinea") Long idTareaLinea
			);




}
