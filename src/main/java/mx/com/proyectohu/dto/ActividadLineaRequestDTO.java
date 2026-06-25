package mx.com.proyectohu.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadLineaRequestDTO {
	
	@JsonProperty("mapeo")
	private MapeoDTO	mapeoDTO;
	
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
