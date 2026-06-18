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
@Table(name="TTABCCFG_ACTIVIDAD_MAPEO_LINEA")
@SequenceGenerator(name = "SEQ_ACTIVIDAD_LINEA_MAPEO_GEN",sequenceName = "SEQ_TTABCCFG_ACTIVIDAD_MAPEO_LINEA",allocationSize = 1)
public class ActividadMapeoLineaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDAD_LINEA_MAPEO_GEN")
	@Column(name = "ID_ACTIVIDAD_MAPEO_LINEA")
	private Long 	idActividadMapeoLinea;
	
	@Column(name = "ID_MAPEO_LINEA")
	private Long 	idMapeoLinea;
	
	@Column(name = "ID_USUARIO")
	private Long 	idUsuario;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fecCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp fecUltModificacion;

	public Long getIdActividadMapeoLinea() {
		return idActividadMapeoLinea;
	}

	public void setIdActividadMapeoLinea(Long idActividadMapeoLinea) {
		this.idActividadMapeoLinea = idActividadMapeoLinea;
	}

	public Long getIdMapeoLinea() {
		return idMapeoLinea;
	}

	public void setIdMapeoLinea(Long idMapeoLinea) {
		this.idMapeoLinea = idMapeoLinea;
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

	public Timestamp getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public Long getIdABCUsuarioUltModificacion() {
		return idABCUsuarioUltModificacion;
	}

	public void setIdABCUsuarioUltModificacion(Long idABCUsuarioUltModificacion) {
		this.idABCUsuarioUltModificacion = idABCUsuarioUltModificacion;
	}

	public Timestamp getFecUltModificacion() {
		return fecUltModificacion;
	}

	public void setFecUltModificacion(Timestamp fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}

	
}
