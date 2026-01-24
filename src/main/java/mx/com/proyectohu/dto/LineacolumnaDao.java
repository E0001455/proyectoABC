package mx.com.proyectohu.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;

public class LineacolumnaDao {
	
	private Connection connection;
	
	

	
	  public LineacolumnaDao(String url, String user, String password) 
	            throws SQLException {
	        Properties props = new Properties();
	        props.setProperty("user", user);
	        props.setProperty("password", password);
	        props.setProperty("oracle.jdbc.timezoneAsRegion", "false");
	        
	        connection = DriverManager.getConnection(url, props);

	  }        
	        public boolean actualizar(ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity) throws SQLException {
	        	
	        	 String sql = "UPDATE ABC_MAPEO_LINEA_COLUMNA SET BOL_CARGA=?,\r\n"
	 			 		+ "BOL_VALIDACION=?,\r\n"
	 			 		+ "BOL_ENVIO=?,\r\n"
	 			 		+ "REGEX=?,\r\n"
	 			 		+ "ID_ABC_USUARIO_ULT_MODIFICACION= ?,\r\n"
	 			 		+ "FEC_ULT_MODIFICACION= ?\r\n"
	 			 		+ "where ID_ABC_CONFIG_MAPEO_LINEA = ?\r\n"
	 			 		+ "and ID_ABC_CAT_COLUMNA=?";

	
	 try {
		 
		 java.sql.Date sqlDate = new java.sql.Date(abcMapeoLineaColumnaEntity.getFecUltModificacion().getTime());
		 
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, abcMapeoLineaColumnaEntity.getBolCarga());
			stmt.setBoolean(2, abcMapeoLineaColumnaEntity.getBolValidacion());
			stmt.setBoolean(3, abcMapeoLineaColumnaEntity.getBolEnvio());
			stmt.setString(4, abcMapeoLineaColumnaEntity.getRegex());
			stmt.setLong(5, abcMapeoLineaColumnaEntity.getIdABCUsuarioUltModificacion());
			stmt.setDate(6,sqlDate);
			stmt.setLong(7, abcMapeoLineaColumnaEntity.getIdABCConfigMapeoLinea());
			stmt.setLong(8, abcMapeoLineaColumnaEntity.getIdABCCatColumna());
			
			int rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return true;
		
	        }
	        
	        
	       

}
