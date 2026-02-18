package mx.com.proyectohu.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.dto.RegistrosCatalogosDTO;




@Component
public class CatalogosDAO {
	
	
	private final JdbcTemplate jdbcTemplate;

	public CatalogosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
	public String  obtenerNombreColumnaId(String nombreTabla) {
		String idNombreColumna =null;
		
		String sql = "SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME ='"+ nombreTabla + "' AND COLUMN_ID = 1";

		idNombreColumna= jdbcTemplate.queryForObject(sql, String.class);
		
		return idNombreColumna;
		
		
	}
	
	public  List<RegistrosCatalogosDTO>  obtenerCatalogoRegistro(String idNombreColumna, String nombreTabla) {
		 List<RegistrosCatalogosDTO>  catalogosResponseDTOLista= new ArrayList<RegistrosCatalogosDTO>();
		
		 String sql = "SELECT " +idNombreColumna+" AS ID ,FCCODIGO,FCNOMBRE FROM "
		 + nombreTabla+ " WHERE FIACTIVO = 1";

		  catalogosResponseDTOLista= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RegistrosCatalogosDTO.class));
		
		return catalogosResponseDTOLista;
	}
	
	
	
	public  List<CatalogosResponseDTO>  obtenerCatalogo(String idNombreColumna, String nombreTabla) {
		 List<CatalogosResponseDTO>  catalogosResponseDTOLista= new ArrayList<CatalogosResponseDTO>();
		
		 String sql = "SELECT " +idNombreColumna+" AS ID ,FIACTIVO,FCCODIGO,FCNOMBRE,FDFECHACREACION,FDFECHAULTMODIFICACION FROM "
		 + nombreTabla+ " WHERE FIACTIVO = 1";

		  catalogosResponseDTOLista= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CatalogosResponseDTO.class));
		
		return catalogosResponseDTOLista;
	}
	
	
	public void  activarCatalogo(String nombreTabla) {
		
		
		 String sql = "UPDATE "+ nombreTabla +" SET FIACTIVO = 1";
		
		 jdbcTemplate.update(sql);
		
		
	}
	
	public void  actualizarCatalogo(String nombreTabla,String codigo, String nombre,String idNombreColumna,Long id) {
		
		
		 String sql = "UPDATE "+ nombreTabla +" SET FIACTIVO='" +codigo+"', FCNOMBRE='"+nombre+"', FDFECHACREACION=SYSDATE, FDFECHAULTMODIFICACION=SYSDATE"
		 		+ " WHERE "+idNombreColumna+" = "+id;
		
		 jdbcTemplate.update(sql);
		
		
	}

}
