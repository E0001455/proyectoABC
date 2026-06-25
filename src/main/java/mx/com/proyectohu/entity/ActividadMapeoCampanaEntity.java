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
@Table(name="SYNONMID_TTABCCFG_ACTIVIDAD_MAPEO_CAMPANA")
@SequenceGenerator(name = "SEQ_ACTIVIDAD_CAMPANA_MAPEO_GEN",sequenceName = "SYNONMID_SEQ_TTABCCFG_ACTIVIDAD_MAPEO_CAMPANA",allocationSize = 1)
public class ActividadMapeoCampanaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDAD_CAMPANA_MAPEO_GEN")
	@Column(name = "ID_ACTIVIDAD_MAPEO_CAMPANA")
	private Long 	idActividadMapeoCampana;
	
	@Column(name = "ID_MAPEO_CAMPANA")
	private Long 	idMapeoCampana;
	
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



	
	
	

	/**
	 * @return the idActividadMapeoCampana
	 */
	public Long getIdActividadMapeoCampana() {
		return idActividadMapeoCampana;
	}

	/**
	 * @param idActividadMapeoCampana the idActividadMapeoCampana to set
	 */
	public void setIdActividadMapeoCampana(Long idActividadMapeoCampana) {
		this.idActividadMapeoCampana = idActividadMapeoCampana;
	}

	/**
	 * @return the idMapeoCampana
	 */
	public Long getIdMapeoCampana() {
		return idMapeoCampana;
	}

	/**
	 * @param idMapeoCampana the idMapeoCampana to set
	 */
	public void setIdMapeoCampana(Long idMapeoCampana) {
		this.idMapeoCampana = idMapeoCampana;
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
	 * @return the fecCreacion
	 */
	public Timestamp getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	/**
	 * @return the fecUltModificacion
	 */
	public Timestamp getFecUltModificacion() {
		return fecUltModificacion;
	}

	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Timestamp fecUltModificacion) {
		this.fecUltModificacion = fecUltModificacion;
	}




	
	
	
}
