package mx.com.proyectohu.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;



public class MapeoLineaColumnaResponseDTO {
	
	@JsonProperty("columna")
	private LineaColumnaDTO lineaColumnaDTO;

	private Long idUsuario;
	
	private Boolean bolActivo;
	
	@JsonProperty("fechaCreacion")
	private Date fecCreacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Date fecUltModificacion;
	
	
	
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
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the lineaColumnaDTO
	 */
	public LineaColumnaDTO getLineaColumnaDTO() {
		return lineaColumnaDTO;
	}
	/**
	 * @param lineaColumnaDTO the lineaColumnaDTO to set
	 */
	public void setLineaColumnaDTO(LineaColumnaDTO lineaColumnaDTO) {
		this.lineaColumnaDTO = lineaColumnaDTO;
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


