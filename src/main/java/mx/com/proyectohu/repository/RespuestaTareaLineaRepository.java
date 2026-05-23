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
	

		@Query(value ="SELECT TLCR.ID_LISTA_CONTACTO FROM TTABCTRA_RESPUESTA_TAREA_LINEA TRTL "
				+ "				INNER JOIN TTABCTRA_LISTA_CONTACTO_RESPUESTA TLCR  "
				+ "				ON TRTL.ID_RESPUESTA_TAREA_LINEA = TLCR.ID_RESPUESTA_TAREA_LINEA "
				+ "                  INNER JOIN TTABCTRA_BITACORA_LISTA_CONTACTO TBLC "
				+ "                  ON TBLC.ID_LISTA_CONTACTO = TLCR.ID_LISTA_CONTACTO "
				+ "                 INNER JOIN TCABCCAT_ESTATUS_ABC TEA "
				+ "                ON TBLC.ID_ESTATUS_ABC = TEA.ID_ESTATUS_ABC  "
				+ "				WHERE TRTL.ID_RESPUESTA_TAREA_LINEA =:id  "
				+ "               AND  TEA.FCCODIGO = 'ENR' "
				+ "                AND NOT EXISTS (  "
				+ "				  SELECT 1 FROM TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV  "
				+ "     ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC   "
				+ "				WHERE TBEP2.ID_LISTA_CONTACTO = TLCR.ID_LISTA_CONTACTO  "
				+ "				  AND E_ENV.FCCODIGO IN ('APR','RCR') "
				+ "					) "
				+ "                ORDER BY TLCR.ID_LISTA_CONTACTO ", nativeQuery = true)
		public 	List<Long> findIdListaContactos(@Param("id") Long idRespuestaLinea);
		
}
