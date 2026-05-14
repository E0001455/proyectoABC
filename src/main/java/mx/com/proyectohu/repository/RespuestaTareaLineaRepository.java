package mx.com.proyectohu.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;

@Repository
public interface  RespuestaTareaLineaRepository extends JpaRepository<RespuestaTareaLineaEntity, Long> {
	
	@Query(value ="SELECT ID_RESPUESTA_TAREA_LINEA, FCREQUESTID FROM TTABCTRA_RESPUESTA_TAREA_LINEA TRTC WHERE TRUNC(TRTC.FDFECHACREACION) = TRUNC(SYSDATE) ORDER BY ID_RESPUESTA_TAREA_LINEA ", nativeQuery = true)
		public 	List<Object[]> findRequestId();
	

		@Query(value ="SELECT ID_LISTA_CONTACTO FROM TTABCTRA_RESPUESTA_TAREA_LINEA TRTL\r\n"
				+ "INNER JOIN TTABCTRA_LISTA_CONTACTO_RESPUESTA TLCR \r\n"
				+ "ON TRTL.ID_RESPUESTA_TAREA_LINEA = TLCR.ID_RESPUESTA_TAREA_LINEA\r\n"
				+ "WHERE TRTL.ID_RESPUESTA_TAREA_LINEA =:id ORDER BY ID_LISTA_CONTACTO ", nativeQuery = true)
		public 	List<Long> findIdListaContactos(@Param("id") Long idRespuestaLinea);
		
}
