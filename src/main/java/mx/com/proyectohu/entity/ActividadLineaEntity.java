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
@Table(name="TTABCCFG_ACTIVIDAD_LINEA" )
@SequenceGenerator(name = "SEQ_ACTIVIDAD_LINEA_GEN",sequenceName = "SEQ_TTABCCFG_ACTIVIDAD_LINEA",allocationSize = 1)
public class ActividadLineaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDAD_LINEA_GEN")
	@Column(name = "ID_ACTIVIDAD_LINEA")
	private Long 	idActividadLinea;
	
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
	private Timestamp 	fechaCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long 	idUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp 	fechaUltModificacion;

	


	/**
	 * @return the idActividadLinea
	 */
	public Long getIdActividadLinea() {
		return idActividadLinea;
	}

	/**
	 * @param idActividadLinea the idActividadLinea to set
	 */
	public void setIdActividadLinea(Long idActividadLinea) {
		this.idActividadLinea = idActividadLinea;
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
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaUltModificacion
	 */
	public Timestamp getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Timestamp fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	
	
	
	
	
}
