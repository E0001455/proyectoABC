package mx.com.proyectohu.component;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TareaLineaDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public String consultarTareas() {
        String json = null;

        try (Connection conn = dataSource.getConnection()) {

            String sql = "{call SP_CONSULTAR_TAREA_LINEA(?)}";
            try (CallableStatement cs = conn.prepareCall(sql)) {

                cs.registerOutParameter(1, java.sql.Types.CLOB);

                cs.execute();

                Clob clob = cs.getClob(1);
                if (clob != null) {
                    json = clob.getSubString(1, (int) clob.length());
                    clob.free();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
	}
	
	public String consultarTareasHoraEstatus(String codigoHora, String codigoEstatus) {
        String json = null;

        try (Connection conn = dataSource.getConnection()) {

            String sql = "{call SP_CONSULTAR_TAREA_LINEA(?,?,?)}";
            try (CallableStatement cs = conn.prepareCall(sql)) {

                cs.registerOutParameter(1, java.sql.Types.CLOB);
                cs.setString(2, codigoHora);
                cs.setString(3, codigoEstatus);

                cs.execute();

                Clob clob = cs.getClob(1);
                if (clob != null) {
                    json = clob.getSubString(1, (int) clob.length());
                    clob.free();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
	
}
	


