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
	
	@Query(value ="SELECT DISTINCT(TEPR.ID_RESPUESTA_TAREA_CAMPANA),TRTC.FCREQUESTID\r\n"
			+ "FROM TTABCTRA_EXTENSION_PERFIL TEP \r\n"
			+ "		        INNER JOIN TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP \r\n"
			+ "                ON TBEP.ID_EXTENSION_PERFIL = TEP.ID_EXTENSION_PERFIL \r\n"
			+ "              INNER JOIN TTABCTRA_EXTENSION_PERFIL_RESPUESTA TEPR\r\n"
			+ "              ON TEPR.ID_EXTENSION_PERFIL = TBEP.ID_EXTENSION_PERFIL\r\n"
			+ "              INNER JOIN TTABCTRA_RESPUESTA_TAREA_CAMPANA TRTC\r\n"
			+ "              ON TRTC.ID_RESPUESTA_TAREA_CAMPANA= TEPR.ID_RESPUESTA_TAREA_CAMPANA\r\n"
			+ "                INNER JOIN TCABCCAT_ESTATUS_ABC TEA \r\n"
			+ "                ON TBEP.ID_ESTATUS_ABC = TEA.ID_ESTATUS_ABC  \r\n"
			+ "				WHERE   TEA.FCCODIGO = 'ENR' \r\n"
			+ "                AND FCLINEA_DE_NEGOCIO=:lineaNegocio AND NOT EXISTS (  \r\n"
			+ "				SELECT 1 FROM TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV  \r\n"
			+ "				ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC   \r\n"
			+ "				WHERE TBEP2.ID_EXTENSION_PERFIL = TEP.ID_EXTENSION_PERFIL  \r\n"
			+ "				AND E_ENV.FCCODIGO IN ('APR','RCR'))\r\n"
			+ "                ORDER BY TEPR.ID_RESPUESTA_TAREA_CAMPANA ", nativeQuery = true)
	public 	List<Object[]> findRequestIdById(String lineaNegocio);



	@Query(value ="SELECT TLCR.ID_EXTENSION_PERFIL FROM TTABCTRA_RESPUESTA_TAREA_CAMPANA TRTL "
			+ "								INNER JOIN TTABCTRA_EXTENSION_PERFIL_RESPUESTA TLCR  "
			+ "            		ON TRTL.ID_RESPUESTA_TAREA_CAMPANA = TLCR.ID_RESPUESTA_TAREA_CAMPANA "
			+ "			                  INNER JOIN TTABCTRA_BITACORA_EXTENSION_PERFIL TBLC "
			+ "				                  ON TBLC.ID_EXTENSION_PERFIL = TLCR.ID_EXTENSION_PERFIL "
			+ "				                 INNER JOIN TCABCCAT_ESTATUS_ABC TEA "
			+ "				                ON TBLC.ID_ESTATUS_ABC = TEA.ID_ESTATUS_ABC  "
			+ "								WHERE TRTL.ID_RESPUESTA_TAREA_CAMPANA =:id  "
			+ "				              AND  TEA.FCCODIGO = 'ENR' "
			+ "				                AND NOT EXISTS (  "
			+ "								  SELECT 1 FROM TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV  "
			+ "				     ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC   "
			+ "								WHERE TBEP2.ID_EXTENSION_PERFIL = TLCR.ID_EXTENSION_PERFIL  "
			+ "								  AND E_ENV.FCCODIGO IN ('APR','RCR') "
			+ "									) "
			+ "				                ORDER BY TLCR.ID_EXTENSION_PERFIL ", nativeQuery = true)
	public 	List<Long> findIdExtensionPerfil(@Param("id") Long idRespuestaCampana);

	
	

}
