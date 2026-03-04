package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCCFG_HORARIO_LINEA" )
public class HorarioActividadLineaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveHorarioActividadLinea llaveHorarioActividadLinea;
	
	@Column(name = "ID_USUARIO")
	private Long 	idUsuario;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FDFECHACREACION")
	private Date 	fechaCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long 	idUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Date 	fechaUltModificacion;


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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getIdUsuarioUltModificacion() {
		return idUsuarioUltModificacion;
	}

	public void setIdUsuarioUltModificacion(Long idUsuarioUltModificacion) {
		this.idUsuarioUltModificacion = idUsuarioUltModificacion;
	}

	public Date getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	public void setFechaUltModificacion(Date fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}


	
}
