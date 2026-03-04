package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadDTO {
	
	@JsonAlias("id")
	private Long 	idActividadLineaCampana;

	private Ejecucion 	ejecucion;
	
	@JsonAlias("tipo")
	private Actividad actividad;
	
	@JsonAlias("mapeo")
	private MapeoDTO	mapeoDTO;
	
	
	
	/**
	 * @return the mapeoDTO
	 */
	public MapeoDTO getMapeoDTO() {
		return mapeoDTO;
	}
	/**
	 * @param mapeoDTO the mapeoDTO to set
	 */
	public void setMapeoDTO(MapeoDTO mapeoDTO) {
		this.mapeoDTO = mapeoDTO;
	}

	/**
	 * @return the idActividadLineaCampana
	 */
	public Long getIdActividadLineaCampana() {
		return idActividadLineaCampana;
	}
	/**
	 * @param idActividadLineaCampana the idActividadLineaCampana to set
	 */
	public void setIdActividadLineaCampana(Long idActividadLineaCampana) {
		this.idActividadLineaCampana = idActividadLineaCampana;
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
