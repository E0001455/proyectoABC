package mx.com.proyectohu.util;

import java.sql.Timestamp;

public class FechaUtil {
	
	public static Timestamp obtenerFechaActual() {
        return new Timestamp(System.currentTimeMillis());
    }

}
