package mx.com.proyectohu.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;

@Repository
public interface  ABCMapeoLineaColumnaRepository extends JpaRepository<ABCMapeoLineaColumnaEntity, Long> {


	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ABC_MAPEO_LINEA_COLUMNA VALUES "
			+ "(?1, ?2, ?3, ?4, ?5, ?6, ?7,"
			+ " ?8, ?9,?10)", nativeQuery = true)
	public void insertarMapeoLineaColumna( 	Long idABCConfigMapeoLinea,
			Long idABCCatColumna,
			Boolean bolActivo,
			Boolean bolCarga,
			Boolean bolValidacion,
			Boolean bolEnvio,
			String regex,
			Date fecCreacion,
			Long idABCUsuarioUltModificacion,
			Date fecUltModificacion);
	
	
	@Modifying
	@Transactional
	@Query(
	    value = "UPDATE ABC_MAPEO_LINEA_COLUMNA SET " +
	            "BOL_ACTIVO = ?3, " +
	            "BOL_CARGA = ?4, " +
	            "BOL_VALIDACION = ?5, " +
	            "BOL_ENVIO = ?6, " +
	            "REGEX = ?7, " +
	            "FEC_CREACION = ?8, " +
	            "ID_ABC_USUARIO_ULT_MODIFICACION = ?9, " +
	            "FEC_ULT_MODIFICACION = ?10 " +
	            "WHERE ID_ABC_CONFIG_MAPEO_LINEA = ?1 " +
	            "AND ID_ABC_CAT_COLUMNA = ?2",
	    nativeQuery = true
	)
	void updateMapeoLineaColumna(
	        Long idABCConfigMapeoLinea,
	        Long idABCCatColumna,
	        Boolean bolActivo,
	        Boolean bolCarga,
	        Boolean bolValidacion,
	        Boolean bolEnvio,
	        String regex,
	        Date fecCreacion,
	        Long idABCUsuarioUltModificacion,
	        Date fecUltModificacion
	);



	public  Optional<ABCMapeoLineaColumnaEntity> findByIdABCConfigMapeoLineaAndIdABCCatColumna(Long idABCConfigMapeoLinea, Long idABCCatColumna);

	public  List<ABCMapeoLineaColumnaEntity> findByIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea);



}
