package mx.com.proyectohu.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.dto.RegistrosCatalogosDTO;




@Component
public class EnvioCampanaDAO {


	private final JdbcTemplate jdbcTemplate;

	public EnvioCampanaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Map<String, Object>>  obtenerDatosXColumnas(List<String> columnas) {
		List<Map<String, Object>> tabla = null;

		String sql = "SELECT TEP.ID_EXTENSION_PERFIL , " + String.join(", ", columnas) + " FROM TTABCTRA_EXTENSION_PERFIL TEP "
				+"INNER JOIN TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP ON TEP.ID_EXTENSION_PERFIL = TBEP.ID_EXTENSION_PERFIL INNER JOIN TCABCCAT_ESTATUS_ABC E_APA"
				+"	    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'APA' 	AND NOT EXISTS ("
				+ "  SELECT 1 FROM TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV"
				+     " ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC "
				+ "WHERE TBEP2.ID_EXTENSION_PERFIL = TEP.ID_EXTENSION_PERFIL"
				+ " AND E_ENV.FCCODIGO = 'ENR'"
				+"	)  ORDER BY TEP.ID_EXTENSION_PERFIL" ;

		tabla= jdbcTemplate.queryForList(sql);

		return tabla;


	}


	public List<Long>  obtenerids() {
		List<Long> tabla = null;

		String sql = "SELECT TEP.ID_EXTENSION_PERFIL" + " FROM TTABCTRA_EXTENSION_PERFIL TEP "
				+"INNER JOIN TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP ON TEP.ID_EXTENSION_PERFIL = TBEP.ID_EXTENSION_PERFIL INNER JOIN TCABCCAT_ESTATUS_ABC E_APA"
				+"	    ON TBEP.ID_ESTATUS_ABC = E_APA.ID_ESTATUS_ABC WHERE E_APA.FCCODIGO = 'APA' 	AND NOT EXISTS ("
				+ "  SELECT 1 FROM TTABCTRA_BITACORA_EXTENSION_PERFIL TBEP2 INNER JOIN TCABCCAT_ESTATUS_ABC E_ENV"
				+     " ON TBEP2.ID_ESTATUS_ABC = E_ENV.ID_ESTATUS_ABC "
				+ "WHERE TBEP2.ID_EXTENSION_PERFIL = TEP.ID_EXTENSION_PERFIL"
				+ " AND E_ENV.FCCODIGO = 'ENR'"
				+"	)  ORDER BY TEP.ID_EXTENSION_PERFIL"  ;

		tabla= jdbcTemplate.queryForList(sql,Long.class);

		return tabla;


	}


	public int insertarBitacoraExtensionPerfil(Long idExtensionPerfil,Long idTareaCampana) {

		String sql = "INSERT INTO TTABCTRA_BITACORA_EXTENSION_PERFIL " +
				"(ID_BITACORA_EXTENSION_PERFIL, "
				+" ID_TAREA_CAMPANA, "
				+ "ID_EXTENSION_PERFIL, "
				+ "ID_ESTATUS_ABC, "
				+ "FCDETALLE, "
				+ "FDFECHACREACION) " +
				"VALUES (SEQ_TTABCTRA_BITACORA_EXTENSION_PERFIL.nextval, "
				+ 
				"?,?, (SELECT ID_ESTATUS_ABC FROM TCABCCAT_ESTATUS_ABC WHERE FCCODIGO= 'ENR'), EMPTY_CLOB(), SYSDATE)";

		return jdbcTemplate.update(
				sql,
				idTareaCampana,
				idExtensionPerfil

				);

	}

	public int insertarBitacoraExtensionPerfilEnviado(Long idExtensionPerfil,String respuesta,Long idTarea) {

		String codigo="";

		if (respuesta.contains("MERGEFAILED")) {

			codigo="RCR";

		}else {

			codigo="APR";

		}

		String sql = "INSERT INTO TTABCTRA_BITACORA_EXTENSION_PERFIL " +
				"(ID_BITACORA_EXTENSION_PERFIL, "
				+" ID_TAREA_CAMPANA, "
				+ "ID_EXTENSION_PERFIL, "
				+ "ID_ESTATUS_ABC, "
				+ "FCDETALLE, "
				+ "FDFECHACREACION) " +
				"VALUES (SEQ_TTABCTRA_BITACORA_EXTENSION_PERFIL.nextval, "
				+ 
				"?,?, (SELECT ID_ESTATUS_ABC FROM TCABCCAT_ESTATUS_ABC WHERE FCCODIGO= '"+ codigo +"'), ?, SYSDATE)";

		return jdbcTemplate.update(
				sql,
				idTarea,
				idExtensionPerfil,
				respuesta
				);

	}

}
