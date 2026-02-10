package mx.com.proyectohu.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;



public class MapeoCampanaColumnaResponseDTO {
	
	
	
	@JsonProperty("columna")
	private CampanaColumnaDTO campanaColumnaDTO;

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
	 * @return the campanaColumnaDTO
	 */
	public CampanaColumnaDTO getCampanaColumnaDTO() {
		return campanaColumnaDTO;
	}
	/**
	 * @param campanaColumnaDTO the campanaColumnaDTO to set
	 */
	public void setCampanaColumnaDTO(CampanaColumnaDTO campanaColumnaDTO) {
		this.campanaColumnaDTO = campanaColumnaDTO;
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
