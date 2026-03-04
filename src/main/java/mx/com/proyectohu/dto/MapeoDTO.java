package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapeoDTO {

	@JsonProperty("id")
	private Long 	idABCConfigMapeoLinea;

	private String 	nombre;
	private String 	descripcion;


	@JsonProperty("validar")
	private Boolean bolValidacion;

	@JsonProperty("enviar")	
	private Boolean bolEnvio;

	@JsonProperty("dictaminar")	
	private Boolean fiDictaminacion;
	
	@JsonProperty("porcentajeError")	
	private Integer fiPorcentajeError;


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
	/**
	 * @return the fiDictaminacion
	 */
	public Boolean getFiDictaminacion() {
		return fiDictaminacion;
	}
	/**
	 * @param fiDictaminacion the fiDictaminacion to set
	 */
	public void setFiDictaminacion(Boolean fiDictaminacion) {
		this.fiDictaminacion = fiDictaminacion;
	}
	/**
	 * @return the fiPorcentajeError
	 */
	public Integer getFiPorcentajeError() {
		return fiPorcentajeError;
	}
	/**
	 * @param fiPorcentajeError the fiPorcentajeError to set
	 */
	public void setFiPorcentajeError(Integer fiPorcentajeError) {
		this.fiPorcentajeError = fiPorcentajeError;
	}

}	




