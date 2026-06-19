
package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapeoEmpresaColumnaRequestDTO {
	

	
	private Long idUsuario;
	
	@JsonProperty("columna")
	private EmpresaColumnaDTO empresaColumnaDTO;
	
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
	 * @return the empresaColumnaDTO
	 */
	public EmpresaColumnaDTO getEmpresaColumnaDTO() {
		return empresaColumnaDTO;
	}
	/**
	 * @param empresaColumnaDTO the empresaColumnaDTO to set
	 */
	public void setEmpresaColumnaDTO(EmpresaColumnaDTO empresaColumnaDTO) {
		this.empresaColumnaDTO = empresaColumnaDTO;
	}
	
	

}
