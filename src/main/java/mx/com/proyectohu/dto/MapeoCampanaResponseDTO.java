package mx.com.proyectohu.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapeoCampanaResponseDTO {
	
	
	@JsonProperty("id")
	private Long 	idABCConfigMapeoCampana;
	
	private Long 	idABCUsuario;
	
	private Long 	idABCCatLineaNegocio;
	
	private Long 	idABCCatCampana;
	
	private Boolean bolActivo;
	
	@JsonProperty("nombre")
	private String 	nombre;
	
	@JsonProperty("descripcion")
	private String 	descripcion;
	
	@JsonProperty("fechaCreacion")
	private Date 	fecCreacion;
	
	private Long 	idABCUsuarioUltModificacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Date 	fecUltModificacion;
	
	@JsonProperty("columnas")
	private Integer columnas;
	
	@JsonProperty("validar")
	private Boolean bolValidacion;
	
	@JsonProperty("envio")
	private Boolean bolEnvio;
	
	
	/**
	 * @return the idABCConfigMapeoCampana
	 */
	public Long getIdABCConfigMapeoCampana() {
		return idABCConfigMapeoCampana;
	}
	/**
	 * @param idABCConfigMapeoCampana the idABCConfigMapeoCampana to set
	 */
	public void setIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana) {
		this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
	}
	/**
	 * @return the idABCUsuario
	 */
	public Long getIdABCUsuario() {
		return idABCUsuario;
	}
	/**
	 * @param idABCUsuario the idABCUsuario to set
	 */
	public void setIdABCUsuario(Long idABCUsuario) {
		this.idABCUsuario = idABCUsuario;
	}
	/**
	 * @return the idABCCatLineaNegocio
	 */
	public Long getIdABCCatLineaNegocio() {
		return idABCCatLineaNegocio;
	}
	/**
	 * @param idABCCatLineaNegocio the idABCCatLineaNegocio to set
	 */
	public void setIdABCCatLineaNegocio(Long idABCCatLineaNegocio) {
		this.idABCCatLineaNegocio = idABCCatLineaNegocio;
	}
	/**
	 * @return the idABCCatCampana
	 */
	public Long getIdABCCatCampana() {
		return idABCCatCampana;
	}
	/**
	 * @param idABCCatCampana the idABCCatCampana to set
	 */
	public void setIdABCCatCampana(Long idABCCatCampana) {
		this.idABCCatCampana = idABCCatCampana;
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
	 * @return the fecCreacion
	 */
	public Date getFecCreacion() {
		return fecCreacion;
	}
	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	/**
	 * @return the idABCUsuarioUltModificacion
	 */
	public Long getIdABCUsuarioUltModificacion() {
		return idABCUsuarioUltModificacion;
	}
	/**
	 * @param idABCUsuarioUltModificacion the idABCUsuarioUltModificacion to set
	 */
	public void setIdABCUsuarioUltModificacion(Long idABCUsuarioUltModificacion) {
		this.idABCUsuarioUltModificacion = idABCUsuarioUltModificacion;
	}
	/**
	 * @return the fecUltModificacion
	 */
	public Date getFecUltModificacion() {
		return fecUltModificacion;
	}
	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Date fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
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
	 * @return the bolValidacion
	 */
	public Boolean getBolValidacion() {
		return bolValidacion;
	}
	/**
	 * @param bolValidacion the bolValidacion to set
	 */
	public void setBolValidacion(Boolean bolValidacion) {
		this.bolValidacion = bolValidacion;
	}
	/**
	 * @return the bolEnvio
	 */
	public Boolean getBolEnvio() {
		return bolEnvio;
	}
	/**
	 * @param bolEnvio the bolEnvio to set
	 */
	public void setBolEnvio(Boolean bolEnvio) {
		this.bolEnvio = bolEnvio;
	}
	

	

	

}
