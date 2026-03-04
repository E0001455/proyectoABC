	package mx.com.proyectohu.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import mx.com.proyectohu.entity.ABCCatActividad;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActividadCampanaResponseDTO {

	@JsonProperty("id")
	private Long 	idActividadCampana;
	
	@JsonProperty("mapeo")
	private MapeoDTO	mapeoDTO;
	
	@JsonProperty("linea")
	private CatLineaNegocio catLineaNegocio;
	
	@JsonProperty("tipo")
	private CatActividad catActividad;
	
	@JsonProperty("ejecucion")
	private CatEjecucion catEjecucion; 

	private Boolean bolActivo;

	@JsonProperty("fechaCreacion")
	private Date 	fechaCreacion;

	@JsonProperty("fechaUltimaModificacion")
	private Date 	fechaUltModificacion;



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
	 * @return the idActividadCampana
	 */
	public Long getIdActividadCampana() {
		return idActividadCampana;
	}



	/**
	 * @param idActividadCampana the idActividadCampana to set
	 */
	public void setIdActividadCampana(Long idActividadCampana) {
		this.idActividadCampana = idActividadCampana;
	}



	/**
	 * @return the catLineaNegocio
	 */
	public CatLineaNegocio getCatLineaNegocio() {
		return catLineaNegocio;
	}



	/**
	 * @param catLineaNegocio the catLineaNegocio to set
	 */
	public void setCatLineaNegocio(CatLineaNegocio catLineaNegocio) {
		this.catLineaNegocio = catLineaNegocio;
	}



	/**
	 * @return the catActividad
	 */
	public CatActividad getCatActividad() {
		return catActividad;
	}



	/**
	 * @param catActividad the catActividad to set
	 */
	public void setCatActividad(CatActividad catActividad) {
		this.catActividad = catActividad;
	}



	/**
	 * @return the catEjecucion
	 */
	public CatEjecucion getCatEjecucion() {
		return catEjecucion;
	}



	/**
	 * @param catEjecucion the catEjecucion to set
	 */
	public void setCatEjecucion(CatEjecucion catEjecucion) {
		this.catEjecucion = catEjecucion;
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
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	/**
	 * @return the fechaUltModificacion
	 */
	public Date getFechaUltModificacion() {
		return fechaUltModificacion;
	}



	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Date fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}





	public static class CatLineaNegocio {

		@JsonProperty("id")
		private Long idLineaNegocio;
		
		private CatCampana catCampana;

		/**
		 * @return the idLineaNegocio
		 */
		public Long getIdLineaNegocio() {
			return idLineaNegocio;
		}

		/**
		 * @param idLineaNegocio the idLineaNegocio to set
		 */
		public void setIdLineaNegocio(Long idLineaNegocio) {
			this.idLineaNegocio = idLineaNegocio;
		}


		/**
		 * @return the catCampana
		 */
		public CatCampana getCatCampana() {
			return catCampana;
		}

		/**
		 * @param catCampana the catCampana to set
		 */
		public void setCatCampana(CatCampana catCampana) {
			this.catCampana = catCampana;
		}


		public static class CatCampana {

			@JsonProperty("id")
			private Long idCampana;

			/**
			 * @return the idCampana
			 */
			public Long getIdCampana() {
				return idCampana;
			}

			/**
			 * @param idCampana the idCampana to set
			 */
			public void setIdCampana(Long idCampana) {
				this.idCampana = idCampana;
			}


		}
		
		



	}

	public static class CatActividad {

		@JsonProperty("id")
		private Long 	idActividad;

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



	public static class CatEjecucion {

		@JsonProperty("id")
		private Long 	idEjecucion;

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



}
