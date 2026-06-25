package mx.com.proyectohu.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HorarioActividadEmpresaRequestDTO {
	

	private Long 		idUsuario;
	
	@JsonProperty("horarios")
	private List<HorarioEmpresaDTO> HorarioEmpresaDTO;

	
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the horarioEmpresaDTO
	 */
	public List<HorarioEmpresaDTO> getHorarioEmpresaDTO() {
		return HorarioEmpresaDTO;
	}

	/**
	 * @param horarioEmpresaDTO the horarioEmpresaDTO to set
	 */
	public void setHorarioEmpresaDTO(List<HorarioEmpresaDTO> horarioEmpresaDTO) {
		HorarioEmpresaDTO = horarioEmpresaDTO;
	}

	
	
	
	
	

}
