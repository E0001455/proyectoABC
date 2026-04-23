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
			T
			FROM TareaLineaEntity T
			WHERE 1=1
			AND T.idActividad= (SELECT A.id FROM ABCCatActividad A WHERE codigo='CAG' )
			AND(:idLineaNegocio IS NULL OR T.MapeoLinea.idABCCatLineaNegocio = :idLineaNegocio)
			AND (:fechaInicio IS NULL OR T.fdFechaFin >= :fechaInicio)
			   AND (:fechaFin IS NULL OR T.fdFechaFin <= :fechaFin)

			""")
	List<TareaLineaEntity> obtenerTareasCargaXFechas(
			@Param("idLineaNegocio") Long idlineaNegocio,		
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);


	@Query(value = """
			SELECT 
			T
			FROM TareaLineaEntity T
			WHERE 1=1
			AND T.idActividad= (SELECT A.id FROM ABCCatActividad A WHERE codigo='VLD' )
			AND(:idLineaNegocio IS NULL OR T.MapeoLinea.idABCCatLineaNegocio = :idLineaNegocio)
			AND (:fechaInicio IS NULL OR T.fdFechaFin >= :fechaInicio)
			   AND (:fechaFin IS NULL OR T.fdFechaFin <= :fechaFin)

			""")
	List<TareaLineaEntity> obtenerTareasValidacionXFechas(
			@Param("idLineaNegocio") Long idlineaNegocio,		
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);


	@Query(value = """
			SELECT 
			TCATCL.nombre
			FROM TareaLineaEntity TTL
			INNER JOIN ABCMapeoLineaColumnaEntity TCL
			ON TTL.MapeoLinea.idABCConfigMapeoLinea = TCL.llaveMapeoLineaColumna.idABCConfigMapeoLinea
			INNER JOIN ABCCatColumnaLineaEntity TCATCL
			ON TCATCL.id = TCL.llaveMapeoLineaColumna.idABCCatColumna
			WHERE TTL.idTareaLinea =:idTareaLinea

			""")
	List<String> obtenerColumnasXidTarea(
			@Param("idTareaLinea") Long idTareaLinea
			);
	
	
	
	@Query(value = """
			SELECT 
			T
			FROM TareaLineaEntity T
			WHERE 1=1
			AND T.idActividad= (SELECT A.id FROM ABCCatActividad A WHERE codigo='ENV' )
			AND(:idLineaNegocio IS NULL OR T.MapeoLinea.idABCCatLineaNegocio = :idLineaNegocio)
			AND (:fechaInicio IS NULL OR T.fdFechaFin >= :fechaInicio)
			   AND (:fechaFin IS NULL OR T.fdFechaFin <= :fechaFin)

			""")
	List<TareaLineaEntity> obtenerTareasEnvioXFechas(
			@Param("idLineaNegocio") Long idlineaNegocio,		
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);



}
