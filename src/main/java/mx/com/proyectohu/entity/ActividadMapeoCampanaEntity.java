package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TTABCCFG_ACTIVIDAD_MAPEO_CAMPANA")
public class ActividadMapeoCampanaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveActividadMapeoCampana llaveActividadMapeoCampana;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FDFECHACREACION")
	private Date fecCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Date fecUltModificacion;



	
	/**
	 * @return the llaveActividadMapeoCampana
	 */
	public LlaveActividadMapeoCampana getLlaveActividadMapeoCampana() {
		return llaveActividadMapeoCampana;
	}

	/**
	 * @param llaveActividadMapeoCampana the llaveActividadMapeoCampana to set
	 */
	public void setLlaveActividadMapeoCampana(LlaveActividadMapeoCampana llaveActividadMapeoCampana) {
		this.llaveActividadMapeoCampana = llaveActividadMapeoCampana;
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
	 * @return the fecCreacion
	 */
	public Date getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	/**
	 * @return the idABCUsuarioUltModificacion
	 */
	public Long getIdABCUsuarioUltModificacion() {
		return idABCUsuarioUltModificacion;
	}

	/**
	 * @param idABCUsuarioUltModificacion the idABCUsuarioUltModificacion to set
	 */
	public void setIdABCUsuarioUltModificacion(Long idABCUsuarioUltModificacion) {
		this.idABCUsuarioUltModificacion = idABCUsuarioUltModificacion;
	}

	/**
	 * @return the fecUltModificacion
	 */
	public Date getFecUltModificacion() {
		return fecUltModificacion;
	}

	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Date fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}
	


	
	
	
}
