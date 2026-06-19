package mx.com.proyectohu.dto;



import com.fasterxml.jackson.annotation.JsonAlias;

public class MapeoEmpresaRequestDTO {
	
	@JsonAlias("mapeo")
	private MapeoEmpresaDTO	mapeoEmpresaDTO;
	private Long 		idUsuario;
	

	
	/**
	 * @return the mapeoEmpresaDTO
	 */
	public MapeoEmpresaDTO getMapeoEmpresaDTO() {
		return mapeoEmpresaDTO;
	}
	/**
	 * @param mapeoEmpresaDTO the mapeoEmpresaDTO to set
	 */
	public void setMapeoEmpresaDTO(MapeoEmpresaDTO mapeoEmpresaDTO) {
		this.mapeoEmpresaDTO = mapeoEmpresaDTO;
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
