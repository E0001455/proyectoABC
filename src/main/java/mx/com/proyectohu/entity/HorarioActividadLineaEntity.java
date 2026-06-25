package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="SYNONMID_TTABCCFG_HORARIO_LINEA" )
public class HorarioActividadLineaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveHorarioActividadLinea llaveHorarioActividadLinea;
	
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
	 * @return the llaveHorarioActividadLinea
	 */
	public LlaveHorarioActividadLinea getLlaveHorarioActividadLinea() {
		return llaveHorarioActividadLinea;
	}

	/**
	 * @param llaveHorarioActividadLinea the llaveHorarioActividadLinea to set
	 */
	public void setLlaveHorarioActividadLinea(LlaveHorarioActividadLinea llaveHorarioActividadLinea) {
		this.llaveHorarioActividadLinea = llaveHorarioActividadLinea;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Boolean getBolActivo() {
		return bolActivo;
	}

	public void setBolActivo(Boolean bolActivo) {
		this.bolActivo = bolActivo;
	}



	public Long getIdUsuarioUltModificacion() {
		return idUsuarioUltModificacion;
	}

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
