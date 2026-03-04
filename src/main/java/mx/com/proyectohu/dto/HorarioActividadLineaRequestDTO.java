package mx.com.proyectohu.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HorarioActividadLineaRequestDTO {
	

	private Long 		idUsuario;
	
	@JsonProperty("horarios")
	private List<HorarioLineaDTO> HorarioLineaDTO;

	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<HorarioLineaDTO> getHorarioLineaDTO() {
		return HorarioLineaDTO;
	}

	public void setHorarioLineaDTO(List<HorarioLineaDTO> horarioLineaDTO) {
		HorarioLineaDTO = horarioLineaDTO;
	}
	

	
	
	

}
