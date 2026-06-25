package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadDTO {
	
	
	private Ejecucion 	ejecucion;
	
	@JsonProperty("tipo")
	private Actividad actividad;
	
	
	
	private Boolean activo;
	
	
	private Long fechaCreacion;
	
	
	private Long  fechaUltimaModificacion;
	
	
	
	

	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Long getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaUltimaModificacion
	 */
	public Long getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	/**
	 * @param fechaUltimaModificacion the fechaUltimaModificacion to set
	 */
	public void setFechaUltimaModificacion(Long fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}
	
	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	/**
	 * @return the ejecucion
	 */
	public Ejecucion getEjecucion() {
		return ejecucion;
	}
	/**
	 * @param ejecucion the ejecucion to set
	 */
	public void setEjecucion(Ejecucion ejecucion) {
		this.ejecucion = ejecucion;
	}
	/**
	 * @return the actividad
	 */
	public Actividad getActividad() {
		return actividad;
	}
	/**
	 * @param actividad the actividad to set
	 */
	
	

	
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
