package mx.com.proyectohu.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadEmpresaRequestDTO {
	
	@JsonProperty("mapeo")
	private MapeoEmpresaDTO	mapeoEmpresaDTO;
	
	@JsonProperty("actividades")
	private List<ActividadDTO>	actividadDTOlista;
	
	private Long 		idUsuario;

	

	

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
	 * @return the actividadDTOlista
	 */
	public List<ActividadDTO> getActividadDTOlista() {
		return actividadDTOlista;
	}

	/**
	 * @param actividadDTOlista the actividadDTOlista to set
	 */
	public void setActividadDTOlista(List<ActividadDTO> actividadDTOlista) {
		this.actividadDTOlista = actividadDTOlista;
	}
	
	
	
	
}
