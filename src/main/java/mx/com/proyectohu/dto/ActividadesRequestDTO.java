package mx.com.proyectohu.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadesRequestDTO {
	
	
	public List<ActividadDTO> actividadDTOList;
	
	public Long idUsuario;
	@JsonProperty("actividades")
	public List<ActividadDTO> getActividadDTOList() {
		return actividadDTOList;
	}

	public void setActividadDTOList(List<ActividadDTO> actividadDTOList) {
		this.actividadDTOList = actividadDTOList;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	


	

}
