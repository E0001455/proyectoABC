package mx.com.proyectohu.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapeoEmpresaResponseDTO {
	
	@JsonProperty("id")
	private Long 	idMapeoEmpresa;

	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("nombre")
	private String 	nombre;
	
	@JsonProperty("descripcion")
	private String 	descripcion;
	
	@JsonProperty("columnas")
	private Integer columnas;
	
	@JsonProperty("fechaCreacion")
	private Long 	fecCreacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Long 	fecUltModificacion;
	
	

	

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

	/**
	 * @return the bolActivo
	 */
	public Boolean getBolActivo() {
		return bolActivo;
	}

	/**
	 * @param bolActivo the bolActivo to set
	 */
	public void setBolActivo(Boolean bolActivo) {
		this.bolActivo = bolActivo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the columnas
	 */
	public Integer getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(Integer columnas) {
		this.columnas = columnas;
	}

	/**
	 * @return the fecCreacion
	 */
	public Long getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Long fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	/**
	 * @return the fecUltModificacion
	 */
	public Long getFecUltModificacion() {
		return fecUltModificacion;
	}

	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Long fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}
	
	
	

}
