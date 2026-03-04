package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadLineaRequestDTO {
	
	@JsonProperty("actividad")
	private ActividadDTO	actividadDTO;
	
	private Long 		idUsuario;

	

	/**
	 * @return the actividadDTO
	 */
	public ActividadDTO getActividadDTO() {
		return actividadDTO;
	}

	/**
	 * @param actividadDTO the actividadDTO to set
	 */
	public void setActividadDTO(ActividadDTO actividadDTO) {
		this.actividadDTO = actividadDTO;
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
