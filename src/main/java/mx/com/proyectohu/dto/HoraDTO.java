package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HoraDTO {
	
	
	@JsonProperty("id")
	private Long idHora;

	public Long getIdHora() {
		return idHora;
	}

	public void setIdHora(Long idHora) {
		this.idHora = idHora;
	}


}
