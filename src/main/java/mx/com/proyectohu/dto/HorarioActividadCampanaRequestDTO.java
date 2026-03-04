package mx.com.proyectohu.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HorarioActividadCampanaRequestDTO {
	

	private Long 		idUsuario;
	
	@JsonProperty("horarios")
	private List<HorarioCampanaDTO> HorarioCampanaDTO;

	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<HorarioCampanaDTO> getHorarioCampanaDTO() {
		return HorarioCampanaDTO;
	}

	public void setHorarioCampanaDTO(List<HorarioCampanaDTO> horarioCampanaDTO) {
		HorarioCampanaDTO = horarioCampanaDTO;
	}

	

	
	
	

}
