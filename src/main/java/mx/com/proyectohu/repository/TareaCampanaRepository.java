package mx.com.proyectohu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoCampanaRecordDTO;
import mx.com.proyectohu.dto.ReporteGeneralCampanaRecordDTO;
import mx.com.proyectohu.entity.TareaCampanaEntity;




@Repository
public interface  TareaCampanaRepository extends JpaRepository<TareaCampanaEntity, Long> {

	@Query(value = """


			SELECT 
			new mx.com.proyectohu.dto.ReporteGeneralCampanaRecordDTO(
			tep.idTareaCampana,
			tep.idCampana,
			tep.lineaDeNegocio,
			tep.nombreCampana,
			COUNT(DISTINCT tep.idExtensionPerfil),
			MAX(tbep.fechaCreacion) 
			)
			FROM 
			ExtensionPerfilEntity tep INNER JOIN 
			BitacoraExtencionPerfilEntity tbep ON 
			tep.idExtensionPerfil = tbep.extensionPerfilEntity.idExtensionPerfil
			WHERE tbep.estatus.id = (
			SELECT e.id 
			FROM EstatusABCEntity e 
			WHERE e.codigo = 'CRB'
			)
			AND(:idCampana IS NULL OR tep.idCampana = :idCampana)
			AND(:idLineaNegocio IS NULL OR tep.lineaDeNegocio = :idLineaNegocio)
			AND tbep.fechaCreacion BETWEEN 
			:fechaInicio AND 
			:fechaFin
			GROUP BY 
			tep.idTareaCampana,
			tep.idCampana,
			tep.lineaDeNegocio,
			tep.nombreCampana 


			""")
	public 		List<ReporteGeneralCampanaRecordDTO> obtenerTareasCargaXFechas(
			@Param("idLineaNegocio") String idlineaNegocio,	
			@Param("idCampana") Long idCampana,	
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);


	@Query(value = """
			SELECT 
			T
			FROM TareaCampanaEntity T
			WHERE 1=1
			AND T.idActividad= (SELECT A.id FROM ABCCatActividad A WHERE codigo='VLD')
			AND(:idLineaNegocio IS NULL OR T.MapeoCampana.idABCCatLineaNegocio = :idLineaNegocio)
			AND(:idCampana IS NULL OR T.MapeoCampana.idABCCatCampana = :idCampana)
			AND (:fechaInicio IS NULL OR T.fdFechaFin >= :fechaInicio)
			   AND (:fechaFin IS NULL OR T.fdFechaFin <= :fechaFin)

			""")
	public 	List<TareaCampanaEntity> obtenerTareasValidacionXFechas(
			@Param("idLineaNegocio") Long idlineaNegocio,	
			@Param("idCampana") Long idCampana,	
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);

	@Query(value = """
			SELECT 
			T
			FROM TareaCampanaEntity T
			WHERE 1=1
			AND T.idActividad= (SELECT A.id FROM ABCCatActividad A WHERE codigo='ENV')
			AND(:idLineaNegocio IS NULL OR T.MapeoCampana.idABCCatLineaNegocio = :idLineaNegocio)
			AND(:idCampana IS NULL OR T.MapeoCampana.idABCCatCampana = :idCampana)
			AND (:fechaInicio IS NULL OR T.fdFechaFin >= :fechaInicio)
			   AND (:fechaFin IS NULL OR T.fdFechaFin <= :fechaFin)

			""")
	public 	List<TareaCampanaEntity> obtenerTareasEnvioXFechas(
			@Param("idLineaNegocio") Long idlineaNegocio,	
			@Param("idCampana") Long idCampana,	
			@Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin
			);

	@Query(value = """
			SELECT 
			TCATCL.nombre
			FROM TareaCampanaEntity TTL
			INNER JOIN ABCMapeoCampanaColumnaEntity TCL
			ON TTL.MapeoCampana.idABCConfigMapeoCampana = TCL.llaveMapeoCampanaColumna.idABCConfigMapeoCampana
			INNER JOIN ABCCatColumnaCampanaEntity TCATCL
			ON TCATCL.id = TCL.llaveMapeoCampanaColumna.idABCCatColumna
			WHERE TTL.idTareaCampana =:idTareaCampana

			""")
	List<String> obtenerColumnasXidTarea(
			@Param("idTareaCampana") Long idTareaCampana
			);


}
