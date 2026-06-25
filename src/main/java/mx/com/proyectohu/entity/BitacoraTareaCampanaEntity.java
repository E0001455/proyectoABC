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
@Table(name="SYNONMID_TTABCTRA_BITACORA_TAREA_CAMPANA" )
@SequenceGenerator(name = "SEQ_BITACORA_TAREA_CAMPANA_GEN",sequenceName = "SYNONMID_SEQ_TTABCTRA_BITACORA_TAREA_CAMPANA",allocationSize = 1)
public class BitacoraTareaCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_TAREA_CAMPANA_GEN")
	@Column(name = "ID_BITACORA_TAREA_CAMPANA")
	private Long 	idBitacoraTareaCampana;
	
	@Column(name = "ID_TAREA_CAMPANA")
	private Long 	idTareaCampana;
	
	@Column(name = "ID_ESTATUS_TAREA")
	private Long 	idEstatusTarea;
	
	@Column(name = "DETALLE")
	private String 	detalle;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp 	fechaCreacion;

	/**
	 * @return the idBitacoraTareaCampana
	 */
	public Long getIdBitacoraTareaCampana() {
		return idBitacoraTareaCampana;
	}

	/**
	 * @param idBitacoraTareaCampana the idBitacoraTareaCampana to set
	 */
	public void setIdBitacoraTareaCampana(Long idBitacoraTareaCampana) {
		this.idBitacoraTareaCampana = idBitacoraTareaCampana;
	}

	/**
	 * @return the idTareaCampana
	 */
	public Long getIdTareaCampana() {
		return idTareaCampana;
	}

	/**
	 * @param idTareaCampana the idTareaCampana to set
	 */
	public void setIdTareaCampana(Long idTareaCampana) {
		this.idTareaCampana = idTareaCampana;
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
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	
}
