package mx.com.proyectohu.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.RespuestaTareaLineaEntity;

@Repository
public interface  RespuestaTareaLineaRepository extends JpaRepository<RespuestaTareaLineaEntity, Long> {
	
	@Query(value ="SELECT ID_RESPUESTA_TAREA_LINEA, FCREQUESTID FROM SYNONMID_TTABCTRA_RESPUESTA_TAREA_LINEA TRTC WHERE TRUNC(TRTC.FDFECHACREACION) = TRUNC(SYSDATE) ORDER BY ID_RESPUESTA_TAREA_LINEA ", nativeQuery = true)
		public 	List<Object[]> findRequestId();
	
		@Query(value ="SELECT DISTINCT(TRTL.ID_RESPUESTA_TAREA_LINEA), TRTL.FCREQUESTID\r\n"
				+ "FROM SYNONMID_TTABCTRA_LISTA_CONTACTO TEP \r\n"
				+ "				INNER JOIN SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP \r\n"
				+ "                ON TEP.ID_LISTA_CONTACTO = TBEP.ID_LISTA_CONTACTO \r\n"
				+ "                INNER JOIN SYNONMID_TTABCTRA_LISTA_CONTACTO_RESPUESTA TLCR\r\n"
				+ "                ON TLCR.ID_LISTA_CONTACTO= TEP.ID_LISTA_CONTACTO\r\n"
				+ "                INNER JOIN SYNONMID_TTABCTRA_RESPUESTA_TAREA_LINEA TRTL\r\n"
				+ "                ON TRTL.ID_RESPUESTA_TAREA_LINEA = TLCR.ID_RESPUESTA_TAREA_LINEA\r\n"
				+ "                INNER JOIN TCABCCAT_ESTATUS_ABC E_APA \r\n"
				+ "					    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'ENR'   \r\n"
				+ "                        AND FCLINEA_DE_NEGOCIO=:lineaNegocio AND NOT EXISTS ( \r\n"
				+ "				   SELECT 1 FROM SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV \r\n"
				+ "				  ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC  \r\n"
				+ "				 WHERE TBEP2.ID_LISTA_CONTACTO = TEP.ID_LISTA_CONTACTO \r\n"
				+ "              AND E_ENV.FCCODIGO IN ('RCR','APR')\r\n"
				+ "					) ORDER BY TRTL.ID_RESPUESTA_TAREA_LINEA ", nativeQuery = true)
		public 	List<Object[]> findRequestIdById(String lineaNegocio);

		@Query(value ="SELECT TLCR.ID_LISTA_CONTACTO FROM SYNONMID_TTABCTRA_RESPUESTA_TAREA_LINEA TRTL "
				+ "				INNER JOIN SYNONMID_TTABCTRA_LISTA_CONTACTO_RESPUESTA TLCR  "
				+ "				ON TRTL.ID_RESPUESTA_TAREA_LINEA = TLCR.ID_RESPUESTA_TAREA_LINEA "
				+ "                  INNER JOIN SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBLC "
				+ "                  ON TBLC.ID_LISTA_CONTACTO = TLCR.ID_LISTA_CONTACTO "
				+ "                 INNER JOIN TCABCCAT_ESTATUS_ABC TEA "
				+ "                ON TBLC.ID_ESTATUS_ABC = TEA.ID_ESTATUS_ABC  "
				+ "				WHERE TRTL.ID_RESPUESTA_TAREA_LINEA =:id  "
				+ "               AND  TEA.FCCODIGO = 'ENR' "
				+ "                AND NOT EXISTS (  "
				+ "				  SELECT 1 FROM SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV  "
				+ "     ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC   "
				+ "				WHERE TBEP2.ID_LISTA_CONTACTO = TLCR.ID_LISTA_CONTACTO  "
				+ "				  AND E_ENV.FCCODIGO IN ('APR','RCR') "
				+ "					) "
				+ "                ORDER BY TLCR.ID_LISTA_CONTACTO ", nativeQuery = true)
		public 	List<Long> findIdListaContactos(@Param("id") Long idRespuestaLinea);
		
}
