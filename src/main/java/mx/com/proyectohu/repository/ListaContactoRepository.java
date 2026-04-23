package mx.com.proyectohu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.ListaContactoEntity;

@Repository
public interface  ListaContactoRepository extends JpaRepository<ListaContactoEntity, Long> {

	
	@Query("""
		    SELECT DISTINCT l
		    FROM ListaContactoEntity l
		    JOIN BitacoraListaContactoEntity b 
		        ON b.listaContacto.id = l.id
		    JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE e.codigo = 'CRG'
		    AND (:riid IS NULL OR l.riid = :riid)
		    AND (:nombre IS NULL OR l.nombre = :nombre)
		    AND (:apellidoPaterno IS NULL OR l.apellidoPaterno = :apellidoPaterno)
		    AND (:correo IS NULL OR l.emailAddress = :correo)
		    AND (:telefono IS NULL OR l.mobileNumber = :telefono)
		    AND (:noCuenta IS NULL OR l.numeroDeCuenta = :noCuenta)
		    AND (:nss IS NULL OR l.nss = :nss)
		    AND (:curp IS NULL OR l.curp = :curp)
		    AND (:rfc IS NULL OR l.rfc = :rfc)
		    AND (:poliza IS NULL OR l.poliza = :poliza)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ListaContactoEntity> buscarContactosConBitacora(
		    @Param("riid") String riid,
		    @Param("nombre") String nombre,
		    @Param("apellidoPaterno") String apellidoPaterno,
		    @Param("correo") String correo,
		    @Param("telefono") String telefono,
		    @Param("noCuenta") String noCuenta,
		    @Param("nss") String nss,
		    @Param("curp") String curp,
		    @Param("rfc") String rfc,
		    @Param("poliza") String poliza,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	
	@Query("""
		    SELECT DISTINCT l
		    FROM ListaContactoEntity l
		    LEFT JOIN BitacoraListaContactoEntity b 
		        ON b.listaContacto.id = l.id
		     JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE 1=1
		    AND(:lineaNegocio IS NULL OR l.lineaDeNegocio = :lineaNegocio)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ListaContactoEntity> buscarPorLineaNegocioYFechas(
		    @Param("lineaNegocio") String lineaNegocio,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	@Query("""
		    SELECT DISTINCT l
		    FROM ListaContactoEntity l
		    JOIN BitacoraListaContactoEntity b 
		        ON b.listaContacto.id = l.id
		    JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE  e.codigo = 'CRG' 
		    AND (:riid IS NULL OR l.riid = :riid)
		    AND (:nombre IS NULL OR l.nombre = :nombre)
		    AND (:apellidoPaterno IS NULL OR l.apellidoPaterno = :apellidoPaterno)
		    AND (:correo IS NULL OR l.emailAddress = :correo)
		    AND (:telefono IS NULL OR l.mobileNumber = :telefono)
		    AND (:noCuenta IS NULL OR l.numeroDeCuenta = :noCuenta)
		    AND (:nss IS NULL OR l.nss = :nss)
		    AND (:curp IS NULL OR l.curp = :curp)
		    AND (:rfc IS NULL OR l.rfc = :rfc)
		    AND (:poliza IS NULL OR l.poliza = :poliza)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ListaContactoEntity> consultarValidacion(
		    @Param("riid") String riid,
		    @Param("nombre") String nombre,
		    @Param("apellidoPaterno") String apellidoPaterno,
		    @Param("correo") String correo,
		    @Param("telefono") String telefono,
		    @Param("noCuenta") String noCuenta,
		    @Param("nss") String nss,
		    @Param("curp") String curp,
		    @Param("rfc") String rfc,
		    @Param("poliza") String poliza,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	
	@Query("""
		    SELECT DISTINCT l
		    FROM ListaContactoEntity l
		    JOIN BitacoraListaContactoEntity b 
		        ON b.listaContacto.id = l.id
		    JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE  e.codigo = 'CRG' 
		    AND (:riid IS NULL OR l.riid = :riid)
		    AND (:nombre IS NULL OR l.nombre = :nombre)
		    AND (:apellidoPaterno IS NULL OR l.apellidoPaterno = :apellidoPaterno)
		    AND (:correo IS NULL OR l.emailAddress = :correo)
		    AND (:telefono IS NULL OR l.mobileNumber = :telefono)
		    AND (:noCuenta IS NULL OR l.numeroDeCuenta = :noCuenta)
		    AND (:nss IS NULL OR l.nss = :nss)
		    AND (:curp IS NULL OR l.curp = :curp)
		    AND (:rfc IS NULL OR l.rfc = :rfc)
		    AND (:poliza IS NULL OR l.poliza = :poliza)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ListaContactoEntity> consultarEnvio(
		    @Param("riid") String riid,
		    @Param("nombre") String nombre,
		    @Param("apellidoPaterno") String apellidoPaterno,
		    @Param("correo") String correo,
		    @Param("telefono") String telefono,
		    @Param("noCuenta") String noCuenta,
		    @Param("nss") String nss,
		    @Param("curp") String curp,
		    @Param("rfc") String rfc,
		    @Param("poliza") String poliza,
		    @Param("fechaInicio") LocalDateTime fechaInicio,
		    @Param("fechaFin") LocalDateTime fechaFin
		);
	
	
	@Query("""
		    SELECT DISTINCT l
		    FROM ListaContactoEntity l
		    LEFT JOIN BitacoraListaContactoEntity b 
		        ON b.listaContacto.id = l.id
		     JOIN EstatusABCEntity e
			     ON b.estatus.id = e.id
			WHERE  e.codigo = 'APR' or e.codigo = 'RCH'
		    AND(:lineaNegocio IS NULL OR l.lineaDeNegocio = :lineaNegocio)
		    AND (:fechaInicio IS NULL OR b.fechaCreacion >= :fechaInicio)
		    AND (:fechaFin IS NULL OR b.fechaCreacion <= :fechaFin)
		""")
		List<ListaContactoEntity> consultarValidacionXLineaNegocioYFechas(
		    @Param("lineaNegocio") String lineaNegocio,
		    @Param("fechaInicio") LocalDate fechaInicio,
		    @Param("fechaFin") LocalDate fechaFin
		);

	

}
