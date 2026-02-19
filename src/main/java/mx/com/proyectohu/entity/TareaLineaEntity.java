package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCCFG_TAREA_LINEA" )
@SequenceGenerator(name = "SEQ_TAREA_LINEA_GEN",sequenceName = "SEQ_TTABCCFG_TAREA_LINEA",allocationSize = 1)
public class TareaLineaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAREA_LINEA_GEN")
	@Column(name = "ID_CFG_TAREA_LINEA")
	private Long 	idCFGTareaLinea;
	
	@Column(name = "ID_USUARIO")
	private Long 	idUsuario;
	
	@Column(name = "ID_LINEA_NEGOCIO")
	private Long 	idLineaNegocio;
	
	@Column(name = "ID_ACTIVIDAD")
	private Long 	idActividad;
	
	@Column(name = "ID_EJECUCION")
	private Long 	idEjecucion;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FDFECHACREACION")
	private Date 	fechaCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long 	idUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Date 	fechaUltModificacion;

	/**
	 * @return the idCFGTareaLinea
	 */
	public Long getIdCFGTareaLinea() {
		return idCFGTareaLinea;
	}

	/**
	 * @param idCFGTareaLinea the idCFGTareaLinea to set
	 */
	public void setIdCFGTareaLinea(Long idCFGTareaLinea) {
		this.idCFGTareaLinea = idCFGTareaLinea;
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
	 * @return the idLineaNegocio
	 */
	public Long getIdLineaNegocio() {
		return idLineaNegocio;
	}

	/**
	 * @param idLineaNegocio the idLineaNegocio to set
	 */
	public void setIdLineaNegocio(Long idLineaNegocio) {
		this.idLineaNegocio = idLineaNegocio;
	}

	/**
	 * @return the idActividad
	 */
	public Long getIdActividad() {
		return idActividad;
	}

	/**
	 * @param idActividad the idActividad to set
	 */
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	/**
	 * @return the idEjecucion
	 */
	public Long getIdEjecucion() {
		return idEjecucion;
	}

	/**
	 * @param idEjecucion the idEjecucion to set
	 */
	public void setIdEjecucion(Long idEjecucion) {
		this.idEjecucion = idEjecucion;
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
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the idUsuarioUltModificacion
	 */
	public Long getIdUsuarioUltModificacion() {
		return idUsuarioUltModificacion;
	}

	/**
	 * @param idUsuarioUltModificacion the idUsuarioUltModificacion to set
	 */
	public void setIdUsuarioUltModificacion(Long idUsuarioUltModificacion) {
		this.idUsuarioUltModificacion = idUsuarioUltModificacion;
	}

	/**
	 * @return the fechaUltModificacion
	 */
	public Date getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Date fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	
	
	
	
	
}
