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
@Table(name="SYNONMID_TTABCTRA_RESPUESTA_TAREA_LINEA" )
@SequenceGenerator(name = "SEQ_RESPUESTA_TAREA_LINEA_GEN",sequenceName = "SYNONMID_SEQ_TTABCTRA_RESPUESTA_TAREA_LINEA",allocationSize = 1)
public class RespuestaTareaLineaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESPUESTA_TAREA_LINEA_GEN")
	@Column(name = "ID_RESPUESTA_TAREA_LINEA")
	private Long 	idRespuestaTareaLinea;
	
	@Column(name = "ID_TAREA_LINEA")
	private Long 	idTareaLinea;
	
	@Column(name = "FCREQUESTID")
	private String 	requestId;
	
	@Column(name = "FCDETALLE")
	private String  detalle;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fechaCreacion;
	
	@Column(name = "FINOREGISTROS")
	private Integer totalRegistros;
	

	/**
	 * @return the idRespuestaTareaLinea
	 */
	public Long getIdRespuestaTareaLinea() {
		return idRespuestaTareaLinea;
	}

	/**
	 * @param idRespuestaTareaLinea the idRespuestaTareaLinea to set
	 */
	public void setIdRespuestaTareaLinea(Long idRespuestaTareaLinea) {
		this.idRespuestaTareaLinea = idRespuestaTareaLinea;
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
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	/**
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}

	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	
	
	


}
