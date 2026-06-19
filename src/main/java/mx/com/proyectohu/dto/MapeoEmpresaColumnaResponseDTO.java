package mx.com.proyectohu.dto;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import mx.com.proyectohu.dto.EmpresaColumnaDTO.CatColumna;



public class MapeoEmpresaColumnaResponseDTO {
	
	
	@JsonProperty("tipo")
	private CatColumna catColumna;


	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("esRequerido")
	private Boolean finRequerido;
	
	@JsonProperty("fechaCreacion")
	private Long fecCreacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Long fecUltModificacion;
	

	

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
	 * @return the fecCreacion
	 */
	public Long getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Long fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	/**
	 * @return the fecUltModificacion
	 */
	public Long getFecUltModificacion() {
		return fecUltModificacion;
	}

	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Long fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}

	/**
	 * @return the finRequerido
	 */
	public Boolean getFinRequerido() {
		return finRequerido;
	}

	/**
	 * @param finRequerido the finRequerido to set
	 */
	public void setFinRequerido(Boolean finRequerido) {
		this.finRequerido = finRequerido;
	}

	/**
	 * @return the catColumna
	 */
	public CatColumna getCatColumna() {
		return catColumna;
	}

	/**
	 * @param catColumna the catColumna to set
	 */
	public void setCatColumna(CatColumna catColumna) {
		this.catColumna = catColumna;
	}	
	
	

}


