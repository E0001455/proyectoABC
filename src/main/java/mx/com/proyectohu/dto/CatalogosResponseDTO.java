package mx.com.proyectohu.dto;

import java.util.Date;

public class CatalogosResponseDTO {
	
	

	private Long id;
	private Boolean bolActivo;
	private String 	codigo;
	private String 	nombre;
	private Date 	fecCreacion;
	private Date 	fecUltModificacion;
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the bolActivo
	 */
	public Boolean getBolActivo() {
		return bolActivo;
	}
	/**
	 * @param bolActivo the bolActivo to set
	 */
	public void setBolActivo(Boolean bolActivo) {
		this.bolActivo = bolActivo;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fecCreacion
	 */
	public Date getFecCreacion() {
		return fecCreacion;
	}
	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	/**
	 * @return the fecUltModificacion
	 */
	public Date getFecUltModificacion() {
		return fecUltModificacion;
	}
	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Date fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}

	

	
	
	
	
	
	
	

}
