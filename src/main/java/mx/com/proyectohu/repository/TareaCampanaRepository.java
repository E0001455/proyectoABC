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
			TCATCL.nombre
			FROM TareaCampanaEntity TTL
			INNER JOIN ActividadMapeoCampanaEntity AMC
			ON AMC.idActividadMapeoCampana = TTL.idActividadMapeoCampana
			INNER JOIN ABCMapeoCampanaColumnaEntity TCL
			ON AMC.idMapeoCampana = TCL.llaveMapeoCampanaColumna.idABCConfigMapeoCampana
			INNER JOIN ABCCatColumnaCampanaEntity TCATCL
			ON TCATCL.id = TCL.llaveMapeoCampanaColumna.idABCCatColumna
			WHERE TTL.idTareaCampana =:idTareaCampana

			""")
	List<String> obtenerColumnasXidTarea(
			@Param("idTareaCampana") Long idTareaCampana
			);


}
