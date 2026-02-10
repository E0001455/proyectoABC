package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BitacoraUsuarioRequestDTO {
	
	
	@JsonAlias("idUsuario")
	private Long 	idABCUsuario;
	
	@JsonAlias("bitacora")
	private BitacoraDTO bitacoraDTO;
	
	
	
	
	/**
	 * @return the bitacoraDTO
	 */
	public BitacoraDTO getBitacoraDTO() {
		return bitacoraDTO;
	}
	/**
	 * @param bitacoraDTO the bitacoraDTO to set
	 */
	public void setBitacoraDTO(BitacoraDTO bitacoraDTO) {
		this.bitacoraDTO = bitacoraDTO;
	}
	/**
	 * @return the idABCUsuario
	 */
	public Long getIdABCUsuario() {
		return idABCUsuario;
	}
	/**
	 * @param idABCUsuario the idABCUsuario to set
	 */
	public void setIdABCUsuario(Long idABCUsuario) {
		this.idABCUsuario = idABCUsuario;
	}
	
	
	
	
	
	

}
