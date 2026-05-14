package mx.com.proyectohu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.RespuestaTareaCampanaEntity;

@Repository
public interface  RespuestaTareaCampanaRepository extends JpaRepository<RespuestaTareaCampanaEntity, Long> {
	
	
	@Query(value ="SELECT ID_RESPUESTA_TAREA_CAMPANA, FCREQUESTID  FROM TTABCTRA_RESPUESTA_TAREA_CAMPANA TRTC WHERE TRUNC(TRTC.FDFECHACREACION) = TRUNC(SYSDATE) ORDER BY ID_RESPUESTA_TAREA_CAMPANA ", nativeQuery = true)
	public 	List<Object[]> findRequestId();


	@Query(value ="SELECT ID_EXTENSION_PERFIL FROM TTABCTRA_RESPUESTA_TAREA_CAMPANA TRTL\r\n"
			+ "INNER JOIN TTABCTRA_EXTENSION_PERFIL_RESPUESTA TLCR \r\n"
			+ "ON TRTL.ID_RESPUESTA_TAREA_CAMPANA = TLCR.ID_RESPUESTA_TAREA_CAMPANA\r\n"
			+ "WHERE TRTL.ID_RESPUESTA_TAREA_CAMPANA =:id ORDER BY ID_EXTENSION_PERFIL ", nativeQuery = true)
	public 	List<Long> findIdListaContactos(@Param("id") Long idRespuestaCampana);

	
	

}
