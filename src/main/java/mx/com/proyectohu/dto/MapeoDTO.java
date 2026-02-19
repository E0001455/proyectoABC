package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	
	public static class Ejecucion {
		
		@JsonProperty("id")
		private Long idEjecucion;

		/**
		 * @return the idEjecucion
		 */
		public Long getIdEjecucion() {
			return idEjecucion;
		}

		/**
		 * @param idEjecucion the idEjecucion to set
		 */
		public void setIdEjecucion(Long idEjecucion) {
			this.idEjecucion = idEjecucion;
		}

	}
	
	public static class Actividad {
		
		@JsonProperty("id")
		private Long idActividad;

		/**
		 * @return the idActividad
		 */
		public Long getIdActividad() {
			return idActividad;
		}

		/**
		 * @param idActividad the idActividad to set
		 */
		public void setIdActividad(Long idActividad) {
			this.idActividad = idActividad;
		}



	}	
	
	
	

}
