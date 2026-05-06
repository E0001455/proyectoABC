package mx.com.proyectohu.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapeoLineaResponseDTO {
	
	@JsonProperty("id")
	private Long 	idABCConfigMapeoLinea;
	

	
	@JsonProperty("linea")
	private CatLineaNegocio 	catLineaNegocio;
	
	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("nombre")
	private String 	nombre;
	
	@JsonProperty("descripcion")
	private String 	descripcion;
	
	@JsonProperty("fechaCreacion")
	private Timestamp 	fecCreacion;
	
	private Long 	idABCUsuarioUltModificacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Timestamp 	fecUltModificacion;
	
	@JsonProperty("columnas")
	private Integer columnas;
	
	@JsonProperty("validar")
	private Boolean bolValidacion;
	
	@JsonProperty("enviar")
	private Boolean bolEnvio;
	
	@JsonProperty("dictaminar")	
	private Boolean fiDictaminacion;
	
	@JsonProperty("porcentajeError")	
	private Integer fiPorcentajeError;
	
	
	/**
	 * @return the idABCConfigMapeoLinea
	 */
	public Long getIdABCConfigMapeoLinea() {
		return idABCConfigMapeoLinea;
	}
	/**
	 * @param idABCConfigMapeoLinea the idABCConfigMapeoLinea to set
	 */
	public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
		this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	/**
	 * @return the idABCUsuarioUltModificacion
	 */
	public Long getIdABCUsuarioUltModificacion() {
		return idABCUsuarioUltModificacion;
	}
	/**
	 * @param idABCUsuarioUltModificacion the idABCUsuarioUltModificacion to set
	 */
	public void setIdABCUsuarioUltModificacion(Long idABCUsuarioUltModificacion) {
		this.idABCUsuarioUltModificacion = idABCUsuarioUltModificacion;
	}

	/**
	 * @return the fecCreacion
	 */
	public Timestamp getFecCreacion() {
		return fecCreacion;
	}
	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	/**
	 * @return the fecUltModificacion
	 */
	public Timestamp getFecUltModificacion() {
		return fecUltModificacion;
	}
	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Timestamp fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}
	/**
	 * @return the columnas
	 */
	public Integer getColumnas() {
		return columnas;
	}
	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(Integer columnas) {
		this.columnas = columnas;
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





	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class CatLineaNegocio {

		@JsonProperty("id")
		private Long idABCConfigMapeoLinea;
		
		@JsonProperty("campana")
		private CatCampana  catCampana;

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

		/**
		 * @return the idABCConfigMapeoLinea
		 */
		public Long getIdABCConfigMapeoLinea() {
			return idABCConfigMapeoLinea;
		}

		/**
		 * @param idABCConfigMapeoLinea the idABCConfigMapeoLinea to set
		 */
		public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
			this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
		}

		
		
		
	}
	
	public static class CatCampana {

		@JsonProperty("id")
		private Long 	idABCCatCampana;

		/**
		 * @return the idABCCatCampana
		 */
		public Long getIdABCCatCampana() {
			return idABCCatCampana;
		}

		/**
		 * @param idABCCatCampana the idABCCatCampana to set
		 */
		public void setIdABCCatCampana(Long idABCCatCampana) {
			this.idABCCatCampana = idABCCatCampana;
		}
		
		

	
		
		
		
	}

	

}
