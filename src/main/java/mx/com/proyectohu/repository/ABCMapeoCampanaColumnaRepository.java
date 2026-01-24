package mx.com.proyectohu.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;


@Repository
public interface  ABCMapeoCampanaColumnaRepository extends JpaRepository<ABCMapeoCampanaColumnaEntity, Long> {


	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ABC_MAPEO_CAMPANA_COLUMNA VALUES "
			+ "(?1, ?2, ?3, ?4, ?5, ?6, ?7,"
			+ " ?8, ?9,?10)", nativeQuery = true)
	public void insertarMapeoCampanaColumna( 	Long idABCConfigMapeoCampana,
			Long idABCCatColumna,
			Boolean bolActivo,
			Boolean bolCarga,
			Boolean bolValidacion,
			Boolean bolEnvio,
			String regex,
			Date fecCreacion,
			Long idABCUsuarioUltModificacion,
			Date fecUltModificacion);


	public  Optional<ABCMapeoCampanaColumnaEntity> findByIdABCConfigMapeoCampanaAndIdABCCatColumna(Long idABCConfigMapeoCampana, Long idABCCatColumna);

	public  List<ABCMapeoCampanaColumnaEntity> findByIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana);



}
