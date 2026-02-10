
package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapeoLineaColumnaRequestDTO {
	

	
	private Long idUsuario;
	
	@JsonProperty("columna")
	private LineaColumnaDTO LineaColumnaDTO;
	
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
	 * @return the lineaColumnaDTO
	 */
	public LineaColumnaDTO getLineaColumnaDTO() {
		return LineaColumnaDTO;
	}
	/**
	 * @param lineaColumnaDTO the lineaColumnaDTO to set
	 */
	public void setLineaColumnaDTO(LineaColumnaDTO lineaColumnaDTO) {
		LineaColumnaDTO = lineaColumnaDTO;
	}
	
	

}
