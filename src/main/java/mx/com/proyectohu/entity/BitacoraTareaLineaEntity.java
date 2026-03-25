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
@Table(name="TTABCTRA_BITACORA_TAREA_LINEA" )
@SequenceGenerator(name = "SEQ_BITACORA_TAREA_LINEA_GEN",sequenceName = "SEQ_TTABCTRA_BITACORA_TAREA_LINEA",allocationSize = 1)
public class BitacoraTareaLineaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_TAREA_LINEA_GEN")
	@Column(name = "ID_BITACORA_TAREA_LINEA")
	private Long 	idBitacoraTareaLinea;
	
	@Column(name = "ID_TAREA_LINEA")
	private Long 	idTareaLinea;
	
	@Column(name = "ID_ESTATUS_TAREA")
	private Long 	idEstatusTarea;
	
	@Column(name = "DETALLE")
	private String 	detalle;
	
	@Column(name = "FDFECHACREACION")
	private Date 	fechaCreacion;

	/**
	 * @return the idBitacoraTareaLinea
	 */
	public Long getIdBitacoraTareaLinea() {
		return idBitacoraTareaLinea;
	}

	/**
	 * @param idBitacoraTareaLinea the idBitacoraTareaLinea to set
	 */
	public void setIdBitacoraTareaLinea(Long idBitacoraTareaLinea) {
		this.idBitacoraTareaLinea = idBitacoraTareaLinea;
	}

	/**
	 * @return the idTareaLinea
	 */
	public Long getIdTareaLinea() {
		return idTareaLinea;
	}

	/**
	 * @param idTareaLinea the idTareaLinea to set
	 */
	public void setIdTareaLinea(Long idTareaLinea) {
		this.idTareaLinea = idTareaLinea;
	}

	/**
	 * @return the idEstatusTarea
	 */
	public Long getIdEstatusTarea() {
		return idEstatusTarea;
	}

	/**
	 * @param idEstatusTarea the idEstatusTarea to set
	 */
	public void setIdEstatusTarea(Long idEstatusTarea) {
		this.idEstatusTarea = idEstatusTarea;
	}

	

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	

	
	
	
}
