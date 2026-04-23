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
public class EnvioLineaDAO {
	
	
	private final JdbcTemplate jdbcTemplate;

	public EnvioLineaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
	public List<Map<String, Object>>  obtenerDatosXColumnas(List<String> columnas) {
		List<Map<String, Object>> tabla = null;
		
		String sql = "SELECT " + String.join(", ", columnas) + " FROM TTABCTRA_LISTA_CONTACTO WHERE ID_ESTATUS_ABC = 8 ";

		tabla= jdbcTemplate.queryForList(sql);
		
		return tabla;
		
		
	}
	
	
	public void  actualizarEstatusBitacora(Boolean real) {
		
		
		String sql = "UPDATE TTABCTRA_LISTA_CONTACTO SET ID_ESTATUS_ABC=10 where ID_ESTATUS_ABC=8 ";

		jdbcTemplate.update(sql);
		
	
		
		
	}
	

}
