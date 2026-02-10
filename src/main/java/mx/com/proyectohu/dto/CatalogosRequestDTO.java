package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogosRequestDTO {
	@JsonProperty("registro")
	private RegistroDTO registroDTO;
	
	private Long idUsuario;

	/**
	 * @return the registroDTO
	 */
	public RegistroDTO getRegistroDTO() {
		return registroDTO;
	}

	/**
	 * @param registroDTO the registroDTO to set
	 */
	public void setRegistroDTO(RegistroDTO registroDTO) {
		this.registroDTO = registroDTO;
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


	
	
	
	
	
	
}
