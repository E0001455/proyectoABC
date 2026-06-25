package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapeoEmpresaDTO {
  
	@JsonProperty("id")
	private Long idMapeoEmpresa;
	private String 	nombre;
	private String 	descripcion;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idMapeoEmpresa
	 */
	public Long getIdMapeoEmpresa() {
		return idMapeoEmpresa;
	}
	/**
	 * @param idMapeoEmpresa the idMapeoEmpresa to set
	 */
	public void setIdMapeoEmpresa(Long idMapeoEmpresa) {
		this.idMapeoEmpresa = idMapeoEmpresa;
	}


	



	
}	




