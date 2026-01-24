package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MapeoDTO {
	
	@JsonAlias("id")
	private Long 	idABCConfigMapeoLinea;
	private String 	nombre;
	private String 	descripcion;
	
	
	
	public Long getIdABCConfigMapeoLinea() {
		return idABCConfigMapeoLinea;
	}
	public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
		this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
