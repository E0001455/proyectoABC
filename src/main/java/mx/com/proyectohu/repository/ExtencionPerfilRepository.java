package mx.com.proyectohu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ExtensionPerfilEntity;

@Repository
public interface  ExtencionPerfilRepository extends JpaRepository<ExtensionPerfilEntity, Long> {

	
	@Query("""
		    SELECT DISTINCT l
		    FROM ExtensionPerfilEntity l
		    JOIN BitacoraExtencionPerfilEntity b 
		        ON b.extensionPerfilEntity.id = l.id
		    JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE e.codigo = 'CRG'
		    AND (:noLote IS NULL OR l.numLote = :noLote)
		    AND (:idCliente IS NULL OR l.customerId = :idCliente)
		    AND (:idAfore IS NULL OR l.idAfore = :idAfore)
		    AND (:idClienteAhorrador IS NULL OR l.idClienteAhorrador = :idClienteAhorrador)
		    AND (:idPrestamoPensionado IS NULL OR l.idPrestamoPensionado = :idPrestamoPensionado)
		    AND (:idSusceptiblePrestamo IS NULL OR l.idSusceptiblePrestamo = :idSusceptiblePrestamo)
		    AND (:idBajaCambio IS NULL OR l.idBajaCambio = :idBajaCambio)
		    AND (:idComunicacion IS NULL OR l.idComunicacion = :idComunicacion)
		    AND (:idPersona IS NULL OR l.idpersona = :idPersona)
		    AND (:nombre IS NULL OR l.firstName = :nombre)
		    AND (:apellido IS NULL OR l.lastName = :apellido)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ExtensionPerfilEntity> buscarExtencionPerfilConBitacora(
		    @Param("noLote") String noLote,
		    @Param("idCliente") String idCliente,
		    @Param("idAfore") String idAfore,
		    @Param("idClienteAhorrador") String idClienteAhorrador,
		    @Param("idPrestamoPensionado") String idPrestamoPensionado,
		    @Param("idSusceptiblePrestamo") String idSusceptiblePrestamo,
		    @Param("idBajaCambio") String idBajaCambio,
		    @Param("idComunicacion") String idComunicacion,
		    @Param("idPersona") String idPersona,
		    @Param("nombre") String nombre,
		    @Param("apellido") String apellido,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	
	@Query("""
		    SELECT  DISTINCT l
		    FROM ExtensionPerfilEntity l
		    LEFT JOIN BitacoraExtencionPerfilEntity b 
		        ON b.extensionPerfilEntity.id = l.id
		     JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE 1=1
		    AND(:lineaNegocio IS NULL OR l.lineaDeNegocio = :lineaNegocio)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ExtensionPerfilEntity> buscarPorLineaNegocioYFechas(
		    @Param("lineaNegocio") String lineaNegocio,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	@Query("""
			SELECT DISTINCT l
		    FROM ExtensionPerfilEntity l
		    JOIN BitacoraExtencionPerfilEntity b 
		        ON b.extensionPerfilEntity.id = l.id
		    JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE  e.codigo = 'CRG'
		    AND (:noLote IS NULL OR l.numLote = :noLote)
		    AND (:idCliente IS NULL OR l.customerId = :idCliente)
		    AND (:idAfore IS NULL OR l.idAfore = :idAfore)
		    AND (:idClienteAhorrador IS NULL OR l.idClienteAhorrador = :idClienteAhorrador)
		    AND (:idPrestamoPensionado IS NULL OR l.idPrestamoPensionado = :idPrestamoPensionado)
		    AND (:idSusceptiblePrestamo IS NULL OR l.idSusceptiblePrestamo = :idSusceptiblePrestamo)
		    AND (:idBajaCambio IS NULL OR l.idBajaCambio = :idBajaCambio)
		    AND (:idComunicacion IS NULL OR l.idComunicacion = :idComunicacion)
		    AND (:idPersona IS NULL OR l.idpersona = :idPersona)
		    AND (:nombre IS NULL OR l.firstName = :nombre)
		    AND (:apellido IS NULL OR l.lastName = :apellido)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
			
		""")
		List<ExtensionPerfilEntity> consultarValidacion(
				  @Param("noLote") String noLote,
				    @Param("idCliente") String idCliente,
				    @Param("idAfore") String idAfore,
				    @Param("idClienteAhorrador") String idClienteAhorrador,
				    @Param("idPrestamoPensionado") String idPrestamoPensionado,
				    @Param("idSusceptiblePrestamo") String idSusceptiblePrestamo,
				    @Param("idBajaCambio") String idBajaCambio,
				    @Param("idComunicacion") String idComunicacion,
				    @Param("idPersona") String idPersona,
				    @Param("nombre") String nombre,
				    @Param("apellido") String apellido,
				    @Param("fechaInicio") LocalDateTime fechaInicio,
				    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	
	@Query("""
			
			 SELECT DISTINCT l
		    FROM ExtensionPerfilEntity l
		    LEFT JOIN BitacoraExtencionPerfilEntity b 
		        ON b.extensionPerfilEntity.id = l.id
		     JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
		WHERE  e.codigo = 'APR' or e.codigo = 'RCH'
		    AND(:lineaNegocio IS NULL OR l.lineaDeNegocio = :lineaNegocio)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
			
		

		""")
		List<ExtensionPerfilEntity> consultarValidacionXLineaNegocioYFechas(
		    @Param("lineaNegocio") String lineaNegocio,
		    @Param("fechaInicio") LocalDate fechaInicio,
		    @Param("fechaFin") LocalDate fechaFin
		);



}
