package mx.com.proyectohu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import java.util.List;




@Repository
public interface  ABCConfigMapeoCampanaRepository extends JpaRepository<ABCConfigMapeoCampanaEntity, Long> {
	
	
	
	public  List<ABCConfigMapeoCampanaEntity> findByIdABCCatLineaNegocioAndIdABCCatCampana(Long idABCCatLineaNegocio, Long idABCCatCampana);
	
	public  List<ABCConfigMapeoCampanaEntity> findByIdABCCatLineaNegocio(Long idABCCatLineaNegocio);

}
