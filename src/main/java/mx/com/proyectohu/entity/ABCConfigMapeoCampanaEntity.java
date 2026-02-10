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
@Table(name="ABC_CONFIG_MAPEO_CAMPANA" )
@SequenceGenerator(name = "mapeo_seq_gen",sequenceName = "ABC_SEQ_CONFIG_MAPEO_CAMPANA",allocationSize = 1)
public class ABCConfigMapeoCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapeo_seq_gen")
	@Column(name = "ID_ABC_CONFIG_MAPEO_CAMPANA")
	private Long 	idABCConfigMapeoCampana;
	
	@Column(name = "ID_ABC_USUARIO")
	private Long 	idABCUsuario;
	
	@Column(name = "ID_ABC_CAT_LINEA_NEGOCIO")
	private Long 	idABCCatLineaNegocio;
	
	@Column(name = "ID_ABC_CAT_CAMPANA")
	private Long 	idABCCatCampana;

	@Column(name = "BOL_ACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "NOMBRE")
	private String 	nombre;
	
	@Column(name = "DESCRIPCION")
	private String 	descripcion;
	
	@Column(name = "FEC_CREACION")
	private Date 	fecCreacion;
	
	@Column(name = "ID_ABC_USUARIO_ULT_MODIFICACION")
	private Long 	idABCUsuarioUltModificacion;
	
	@Column(name = "FEC_ULT_MODIFICACION")
	private Date 	fecUltModificacion;
	
	@Column(name = "BOL_VALIDACION")
	private Boolean bolValidacion;
	
	@Column(name = "BOL_ENVIO")
	private Boolean bolEnvio;
	

	/**
	 * @return the idABCConfigMapeoCampana
	 */
	public Long getIdABCConfigMapeoCampana() {
		return idABCConfigMapeoCampana;
	}

	/**
	 * @param idABCConfigMapeoCampana the idABCConfigMapeoCampana to set
	 */
	public void setIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana) {
		this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
	}

	/**
	 * @return the idABCUsuario
	 */
	public Long getIdABCUsuario() {
		return idABCUsuario;
	}

	/**
	 * @param idABCUsuario the idABCUsuario to set
	 */
	public void setIdABCUsuario(Long idABCUsuario) {
		this.idABCUsuario = idABCUsuario;
	}
	
	
	
	/**
	 * @return the idABCCatLineaNegocio
	 */
	public Long getIdABCCatLineaNegocio() {
		return idABCCatLineaNegocio;
	}

	/**
	 * @param idABCCatLineaNegocio the idABCCatLineaNegocio to set
	 */
	public void setIdABCCatLineaNegocio(Long idABCCatLineaNegocio) {
		this.idABCCatLineaNegocio = idABCCatLineaNegocio;
	}

	/**
	 * @return the idABCCatCampana
	 */
	public Long getIdABCCatCampana() {
		return idABCCatCampana;
	}

	/**
	 * @param idABCCatCampana the idABCCatCampana to set
	 */
	public void setIdABCCatCampana(Long idABCCatCampana) {
		this.idABCCatCampana = idABCCatCampana;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/**
	 * @return the bolValidacion
	 */
	public Boolean getBolValidacion() {
		return bolValidacion;
	}

	/**
	 * @param bolValidacion the bolValidacion to set
	 */
	public void setBolValidacion(Boolean bolValidacion) {
		this.bolValidacion = bolValidacion;
	}

	/**
	 * @return the bolEnvio
	 */
	public Boolean getBolEnvio() {
		return bolEnvio;
	}

	/**
	 * @param bolEnvio the bolEnvio to set
	 */
	public void setBolEnvio(Boolean bolEnvio) {
		this.bolEnvio = bolEnvio;
	}



	
	


}
