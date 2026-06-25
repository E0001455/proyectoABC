package mx.com.proyectohu.component;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnvioLineaDAO {


	private final JdbcTemplate jdbcTemplate;

	public EnvioLineaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Map<String, Object>>  obtenerDatosXColumnas(List<String> columnas,String lineaNegocio) {
		List<Map<String, Object>> tabla = null;

		String sql = "SELECT TEP.ID_LISTA_CONTACTO , " + String.join(", ", columnas) + " FROM SYNONMID_TTABCTRA_LISTA_CONTACTO TEP "
				+"INNER JOIN SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP ON TEP.ID_LISTA_CONTACTO = TBEP.ID_LISTA_CONTACTO INNER JOIN TCABCCAT_ESTATUS_ABC E_APA "
				+"	    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'APA'   AND FCLINEA_DE_NEGOCIO='"+lineaNegocio+"' AND NOT EXISTS ( "
				+ "   SELECT 1 FROM SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV "
				+     "  ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC  "
				+ " WHERE TBEP2.ID_LISTA_CONTACTO = TEP.ID_LISTA_CONTACTO "
				+ "  AND E_ENV.FCCODIGO IN ('ENR','REA','APR','RCR')"
				+"	) ORDER BY TEP.ID_LISTA_CONTACTO" ;
		tabla= jdbcTemplate.queryForList(sql);

		return tabla;


	}


	public List<Long>  obtenerids(String lineaNegocio) {
		List<Long> tabla = null;

		String sql = "SELECT TEP.ID_LISTA_CONTACTO" + " FROM SYNONMID_TTABCTRA_LISTA_CONTACTO TEP "
				+"INNER JOIN SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP ON TEP.ID_LISTA_CONTACTO = TBEP.ID_LISTA_CONTACTO INNER JOIN TCABCCAT_ESTATUS_ABC E_APA "
				+"	    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'APA'   AND FCLINEA_DE_NEGOCIO='"+lineaNegocio+"'  	AND NOT EXISTS ( "
				+ "   SELECT 1 FROM SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV "
				+     "  ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC  "
				+ " WHERE TBEP2.ID_LISTA_CONTACTO = TEP.ID_LISTA_CONTACTO "
				+ "  AND E_ENV.FCCODIGO IN ('ENR','REA','APR','RCR')"
				+"	) ORDER BY TEP.ID_LISTA_CONTACTO" ;

		tabla= jdbcTemplate.queryForList(sql,Long.class);

		return tabla;


	}
	
	
	public List<Long>  obtenerTareaRespuesta(String lista) {
		List<Long> tabla = null;

		String sql = "SELECT ID_TAREA_LINEA FROM SYNONMID_TTABCTRA_RESPUESTA_TAREA_LINEA TRTL\r\n"
				+ "INNER JOIN SYNONMID_TTABCTRA_LISTA_CONTACTO_RESPUESTA TLCR\r\n"
				+ "ON TRTL.ID_RESPUESTA_TAREA_LINEA= TLCR.ID_RESPUESTA_TAREA_LINEA\r\n"
				+ "WHERE TLCR.ID_LISTA_CONTACTO IN ("+ lista +") GROUP BY ID_TAREA_LINEA \r\n"
				+ "" ;

		tabla= jdbcTemplate.queryForList(sql,Long.class);

		return tabla;


	}
	
	
	
	public List<Long>  obteneridsRespuesta(String lineaNegocio) {
		List<Long> tabla = null;

		String sql = "SELECT TEP.ID_LISTA_CONTACTO" + " FROM SYNONMID_TTABCTRA_LISTA_CONTACTO TEP "
				+"INNER JOIN SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP ON TEP.ID_LISTA_CONTACTO = TBEP.ID_LISTA_CONTACTO INNER JOIN TCABCCAT_ESTATUS_ABC E_APA "
				+"	    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'ENR'   AND FCLINEA_DE_NEGOCIO='"+lineaNegocio+"'  	AND NOT EXISTS ( "
				+ "   SELECT 1 FROM SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV "
				+     "  ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC  "
				+ " WHERE TBEP2.ID_LISTA_CONTACTO = TEP.ID_LISTA_CONTACTO "
				+ "  AND E_ENV.FCCODIGO IN ('RCR','APR')"
				+"	) ORDER BY TEP.ID_LISTA_CONTACTO" ;

		tabla= jdbcTemplate.queryForList(sql,Long.class);

		return tabla;


	}



	public int insertarBitacoraListaContacto(Long idListaContacto, Long idTareaLinea) {

		String sql = "INSERT INTO SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO " +
				"(ID_BITACORA_LISTA_CONTACTO, "
				+ " ID_TAREA_LINEA, "
				+ "ID_LISTA_CONTACTO, "
				+ "ID_ESTATUS_ABC, "
				+ "FCDETALLE, "
				+ "FDFECHACREACION) " +
				"VALUES (SYNONMID_SEQ_TTABCTRA_BITACORA_LISTA_CONTACTO.nextval,"  
				+
				"?,?, (SELECT ID_ESTATUS_ABC FROM TCABCCAT_ESTATUS_ABC WHERE FCCODIGO= 'ENR'), EMPTY_CLOB(), SYSDATE)";

		return jdbcTemplate.update(
				sql,
				idTareaLinea,
				idListaContacto

				);
	}


	public int insertarBitacoraListaContactoEnviado(Long idListaContacto, String respuesta, Long idTarea ) {
		String codigo="";

		if (respuesta.contains("MERGEFAILED")) {

			codigo="RCR";

		}else {

			codigo="APR";

		}


		String sql = "INSERT INTO SYNONMID_TTABCTRA_BITACORA_LISTA_CONTACTO " +
				"(ID_BITACORA_LISTA_CONTACTO, "
				+ " ID_TAREA_LINEA, "
				+ "ID_LISTA_CONTACTO, "
				+ "ID_ESTATUS_ABC, "
				+ "FCDETALLE, "
				+ "FDFECHACREACION) " + 
				"VALUES (SYNONMID_SEQ_TTABCTRA_BITACORA_LISTA_CONTACTO.nextval,"  
				+
				"?,?, (SELECT ID_ESTATUS_ABC FROM TCABCCAT_ESTATUS_ABC WHERE FCCODIGO= '"+ codigo +"'), ?, SYSDATE)";

		return jdbcTemplate.update(
				sql,
				idTarea,
				idListaContacto,
				respuesta

				);
	}


}
