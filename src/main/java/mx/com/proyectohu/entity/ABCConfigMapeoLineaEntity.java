package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCCFG_MAPEO_LINEA" )
@SequenceGenerator(name = "SEQ_MAPEO_LINE_GEN",sequenceName = "SEQ_TTABCCFG_MAPEO_LINEA",allocationSize = 1)
public class ABCConfigMapeoLineaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MAPEO_LINE_GEN")
	@Column(name = "ID_MAPEO_LINEA")
	private Long 	idABCConfigMapeoLinea;
	
	@Column(name = "ID_USUARIO")
	private Long 	idABCUsuario;
	
	@Column(name = "ID_LINEA_NEGOCIO")
	private Long 	idABCCatLineaNegocio;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FCNOMBRE")
	private String 	nombre;
	
	@Column(name = "FCDESCRIPCION")
	private String 	descripcion;
	
	@Column(name = "FIVALIDACION")
	private Boolean bolValidacion;
	
	@Column(name = "FIENVIO")
	private Boolean bolEnvio;
	
	@Column(name = "FIDICTAMINACION")
	private Boolean fiDictaminacion;
	
	@Column(name = "FIPORCENTAJEERROR")
	private Integer fiPorcentajeError;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp 	fecCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long 	idABCUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp 	fecUltModificacion;
	
	@Column(name = "FIRESPUESTA")
	private Boolean respuesta;
	

	
	
	/**
	 * @return the idABCConfigMapeoLinea
	 */
	public Long getIdABCConfigMapeoLinea() {
		return idABCConfigMapeoLinea;
	}
	/**
	 * @param idABCConfigMapeoLinea the idABCConfigMapeoLinea to set
	 */
	public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
		this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
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
	/**
	 * @return the fiDictaminacion
	 */
	public Boolean getFiDictaminacion() {
		return fiDictaminacion;
	}
	/**
	 * @param fiDictaminacion the fiDictaminacion to set
	 */
	public void setFiDictaminacion(Boolean fiDictaminacion) {
		this.fiDictaminacion = fiDictaminacion;
	}
	/**
	 * @return the fiPorcentajeError
	 */
	public Integer getFiPorcentajeError() {
		return fiPorcentajeError;
	}
	/**
	 * @param fiPorcentajeError the fiPorcentajeError to set
	 */
	public void setFiPorcentajeError(Integer fiPorcentajeError) {
		this.fiPorcentajeError = fiPorcentajeError;
	}
	public Timestamp getFecCreacion() {
		return fecCreacion;
	}
	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	public Timestamp getFecUltModificacion() {
		return fecUltModificacion;
	}
	public void setFecUltModificacion(Timestamp fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}
	public Boolean getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}
	
	
}
