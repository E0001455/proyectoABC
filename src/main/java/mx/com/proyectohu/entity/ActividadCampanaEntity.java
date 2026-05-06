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
@Table(name="TTABCCFG_ACTIVIDAD_CAMPANA" )
@SequenceGenerator(name = "SEQ_ACTIVIDAD_CAMPANA_GEN",sequenceName = "SEQ_TTABCCFG_ACTIVIDAD_CAMPANA",allocationSize = 1)
public class ActividadCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDAD_CAMPANA_GEN")
	@Column(name = "ID_ACTIVIDAD_CAMPANA")
	private Long 	idActividadCampana;
	
	@Column(name = "ID_USUARIO")
	private Long 	idUsuario;
	
	@Column(name = "ID_LINEA_NEGOCIO")
	private Long 	idLineaNegocio;
	
	@Column(name = "ID_CAMPANA")
	private Long 	idCampana;
	
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
	 * @return the idActividadCampana
	 */
	public Long getIdActividadCampana() {
		return idActividadCampana;
	}

	/**
	 * @param idActividadCampana the idActividadCampana to set
	 */
	public void setIdActividadCampana(Long idActividadCampana) {
		this.idActividadCampana = idActividadCampana;
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
	 * @return the idCampana
	 */
	public Long getIdCampana() {
		return idCampana;
	}

	/**
	 * @param idCampana the idCampana to set
	 */
	public void setIdCampana(Long idCampana) {
		this.idCampana = idCampana;
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
