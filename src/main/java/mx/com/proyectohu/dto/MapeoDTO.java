package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MapeoDTO {
	
	@JsonAlias("id")
	private Long 	idABCConfigMapeoLinea;
	private String 	nombre;
	private String 	descripcion;
	
	@JsonAlias("validar")
	private Boolean bolValidacion;
	
	@JsonAlias("enviar")	
	private Boolean bolEnvio;
	
	
	
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
	/**
	 * @return the bolValidacion
	 */
	public Boolean getBolValidacion() {
		return bolValidacion;
	}
	/**
	 * @param bolValidacion the bolValidacion to set
	 */
	public void setBolValidacion(Boolean bolValidacion) {
		this.bolValidacion = bolValidacion;
	}
	/**
	 * @return the bolEnvio
	 */
	public Boolean getBolEnvio() {
		return bolEnvio;
	}
	/**
	 * @param bolEnvio the bolEnvio to set
	 */
	public void setBolEnvio(Boolean bolEnvio) {
		this.bolEnvio = bolEnvio;
	}
	
	
	
	
	

}
