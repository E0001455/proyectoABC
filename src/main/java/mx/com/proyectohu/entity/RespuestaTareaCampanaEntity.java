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
@Table(name="TTABCTRA_RESPUESTA_TAREA_CAMPANA" )
@SequenceGenerator(name = "SEQ_RESPUESTA_TAREA_CAMPANA_GEN",sequenceName = "SEQ_TTABCTRA_RESPUESTA_TAREA_CAMPANA",allocationSize = 1)
public class RespuestaTareaCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESPUESTA_TAREA_CAMPANA_GEN")
	@Column(name = "ID_RESPUESTA_TAREA_CAMPANA")
	private Long 	idRespuestaTareaCampana;
	
	@Column(name = "ID_TAREA_CAMPANA")
	private Long 	idTareaCampana;
	
	@Column(name = "FCREQUESTID")
	private String 	requestId;
	
	@Column(name = "FCDETALLE")
	private String  detalle;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fechaCreacion;
	
	@Column(name = "FINOREGISTROS")
	private Integer totalRegistros;

	/**
	 * @return the idRespuestaTareaCampana
	 */
	public Long getIdRespuestaTareaCampana() {
		return idRespuestaTareaCampana;
	}

	/**
	 * @param idRespuestaTareaCampana the idRespuestaTareaCampana to set
	 */
	public void setIdRespuestaTareaCampana(Long idRespuestaTareaCampana) {
		this.idRespuestaTareaCampana = idRespuestaTareaCampana;
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
