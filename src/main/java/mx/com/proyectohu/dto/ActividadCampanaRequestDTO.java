package mx.com.proyectohu.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActividadCampanaRequestDTO {
	
	@JsonProperty("mapeo")
	private MapeoCampanaDTO	mapeoCampanaDTO;
	
	@JsonAlias("actividades")
	private List<ActividadDTO>	actividadDTOLista;
	
	private Long 		idUsuario;
	



	/**
	 * @return the actividadDTOLista
	 */
	public List<ActividadDTO> getActividadDTOLista() {
		return actividadDTOLista;
	}
	/**
	 * @param actividadDTOLista the actividadDTOLista to set
	 */
	public void setActividadDTOLista(List<ActividadDTO> actividadDTOLista) {
		this.actividadDTOLista = actividadDTOLista;
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
	/**
	 * @return the mapeoCampanaDTO
	 */
	public MapeoCampanaDTO getMapeoCampanaDTO() {
		return mapeoCampanaDTO;
	}
	/**
	 * @param mapeoCampanaDTO the mapeoCampanaDTO to set
	 */
	public void setMapeoCampanaDTO(MapeoCampanaDTO mapeoCampanaDTO) {
		this.mapeoCampanaDTO = mapeoCampanaDTO;
	}
	
	
	

}
