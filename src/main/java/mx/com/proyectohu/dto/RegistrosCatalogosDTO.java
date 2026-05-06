package mx.com.proyectohu.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrosCatalogosDTO {
	

	

	private Long 	id;
	
	@JsonProperty("codigo")
	private String 	fcCodigo;
	
	@JsonProperty("nombre")
	private String 	fcNombre;
	
	
	@JsonProperty("esRequerido")
	private Boolean 	fiRequerido;
	
	
	
	/**
	 * @return the fiRequerido
	 */
	public Boolean getFiRequerido() {
		return fiRequerido;
	}
	/**
	 * @param fiRequerido the fiRequerido to set
	 */
	public void setFiRequerido(Boolean fiRequerido) {
		this.fiRequerido = fiRequerido;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the fcCodigo
	 */
	public String getFcCodigo() {
		return fcCodigo;
	}
	/**
	 * @param fcCodigo the fcCodigo to set
	 */
	public void setFcCodigo(String fcCodigo) {
		this.fcCodigo = fcCodigo;
	}
	/**
	 * @return the fcNombre
	 */
	public String getFcNombre() {
		return fcNombre;
	}
	/**
	 * @param fcNombre the fcNombre to set
	 */
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}
	
	
	
}
