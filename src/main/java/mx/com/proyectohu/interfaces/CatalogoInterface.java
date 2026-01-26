package mx.com.proyectohu.interfaces;

import java.util.Date;

public interface CatalogoInterface {
	
	
	public Long getId();
	
	public void setBolActivo(Boolean bolActivo);
	
	public void setCodigo(String codigo);

    public void setNombre(String nombre);

    public void setFecCreacion(Date fecCreacion);
    
    public void setFecUltModificacion(Date fecUltModificacion);
   
	
	

}
