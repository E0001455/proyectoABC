package mx.com.proyectohu.dto;



import com.fasterxml.jackson.annotation.JsonAlias;

public class TareaLineaRequestDTO {
	
	@JsonAlias("mapeo")
	private TareaDTO	tareaDTO;
	private Long 		idUsuario;
	

	/**
	 * @return the tareaDTO
	 */
	public TareaDTO getTareaDTO() {
		return tareaDTO;
	}
	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
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
