package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapeoCampanaColumnaRequestDTO {
	
	private Long idUsuario;
	
	@JsonProperty("columna")
	private CampanaColumnaDTO campanaColumnaDTO;

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


	
}
