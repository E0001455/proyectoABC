package mx.com.proyectohu.dto;



import com.fasterxml.jackson.annotation.JsonAlias;

public class MapeoLineaRequestDTO {
	
	@JsonAlias("mapeo")
	private MapeoDTO	mapeoDTO;
	private Long 		idUsuario;
	
	/**
	 * @return the mapeoDTO
	 */
	public MapeoDTO getMapeoDTO() {
		return mapeoDTO;
	}
	/**
	 * @param mapeoDTO the mapeoDTO to set
	 */
	public void setMapeoDTO(MapeoDTO mapeoDTO) {
		this.mapeoDTO = mapeoDTO;
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
