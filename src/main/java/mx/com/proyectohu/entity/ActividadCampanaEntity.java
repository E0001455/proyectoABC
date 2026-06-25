package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="SYNONMID_TTABCCFG_ACTIVIDAD_CAMPANA" )
public class ActividadCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private LlaveActividadCampana llaveActividadCampana;
	
	@Column(name = "ID_EJECUCION")
	private Long 	idEjecucion;
	
	@Column(name = "ID_USUARIO")
	private Long 	idUsuario;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp 	fechaCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long 	idUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp 	fechaUltModificacion;
	


	/**
	 * @return the llaveActividadCampana
	 */
	public LlaveActividadCampana getLlaveActividadCampana() {
		return llaveActividadCampana;
	}

	/**
	 * @param llaveActividadCampana the llaveActividadCampana to set
	 */
	public void setLlaveActividadCampana(LlaveActividadCampana llaveActividadCampana) {
		this.llaveActividadCampana = llaveActividadCampana;
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

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	public void setFechaUltModificacion(Timestamp fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}


	
	
	
}
