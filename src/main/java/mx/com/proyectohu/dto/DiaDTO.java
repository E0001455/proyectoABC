package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiaDTO {
	
	
	@JsonProperty("id")
	private Long idDia;
	
	@JsonProperty("hora")
	private HoraDTO HoraDTO;

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	/**
	 * @return the horaDTO
	 */
	public HoraDTO getHoraDTO() {
		return HoraDTO;
	}

	/**
	 * @param horaDTO the horaDTO to set
	 */
	public void setHoraDTO(HoraDTO horaDTO) {
		HoraDTO = horaDTO;
	}

	
	

}
