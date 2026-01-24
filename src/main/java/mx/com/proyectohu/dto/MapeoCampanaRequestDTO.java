package mx.com.proyectohu.dto;



import com.fasterxml.jackson.annotation.JsonAlias;

public class MapeoCampanaRequestDTO {
	
	@JsonAlias("mapeo")
	private MapeoCampanaDTO	mapeoCampanaDTO;
	private Long 		idUsuario;
	
	
	/**
	 * @return the mapeoCampanaDTO
	 */
	public MapeoCampanaDTO getMapeoCampanaDTO() {
		return mapeoCampanaDTO;
	}
	/**
	 * @param mapeoCampanaDTO the mapeoCampanaDTO to set
	 */
	public void setMapeoCampanaDTO(MapeoCampanaDTO mapeoCampanaDTO) {
		this.mapeoCampanaDTO = mapeoCampanaDTO;
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
