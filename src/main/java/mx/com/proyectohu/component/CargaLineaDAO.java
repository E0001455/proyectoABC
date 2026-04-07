package mx.com.proyectohu.component;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargaLineaDAO {

	@Autowired
	private DataSource dataSource;

	public void ejecutarSPCargaListaContacto(String lineaNegocio,Long idTareaLinea) {


		try (Connection conn = dataSource.getConnection()) {

			String sql = "{call SP_CARGA_LISTA_CONTACTO(?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.setString(1,lineaNegocio);
				cs.setLong(2,idTareaLinea);

				cs.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}



