package mx.com.proyectohu.interfaces;

import java.sql.Timestamp;

public interface CatalogoInterface {
	
	
	public Long getId();
	
	public void setBolActivo(Boolean bolActivo);
	
	public void setCodigo(String codigo);

    public void setNombre(String nombre);

    public void setFecCreacion(Timestamp fecCreacion);
    
    public void setFecUltModificacion(Timestamp fecUltModificacion);
   
	
	

}
