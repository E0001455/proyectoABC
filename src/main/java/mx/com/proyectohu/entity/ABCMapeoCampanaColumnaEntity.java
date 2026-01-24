package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ABC_MAPEO_CAMPANA_COLUMNA")
public class ABCMapeoCampanaColumnaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ABC_CONFIG_MAPEO_CAMPANA")
	private Long idABCConfigMapeoCampana;
	
	@Column(name = "ID_ABC_CAT_COLUMNA")
	private Long idABCCatColumna;
	
	@Column(name = "BOL_ACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "BOL_CARGA")
	private Boolean bolCarga;
	
	@Column(name = "BOL_VALIDACION")
	private Boolean bolValidacion;
	
	@Column(name = "BOL_ENVIO")
	private Boolean bolEnvio;
	
	@Column(name = "REGEX")
	private String regex;
	
	@Column(name = "FEC_CREACION")
	private Date fecCreacion;
	
	@Column(name = "ID_ABC_USUARIO_ULT_MODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FEC_ULT_MODIFICACION")
	private Date fecUltModificacion;
	
	
	

	

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
	 * @return the idABCCatColumna
	 */
	public Long getIdABCCatColumna() {
		return idABCCatColumna;
	}

	/**
	 * @param idABCCatColumna the idABCCatColumna to set
	 */
	public void setIdABCCatColumna(Long idABCCatColumna) {
		this.idABCCatColumna = idABCCatColumna;
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
	 * @return the bolCarga
	 */
	public Boolean getBolCarga() {
		return bolCarga;
	}

	/**
	 * @param bolCarga the bolCarga to set
	 */
	public void setBolCarga(Boolean bolCarga) {
		this.bolCarga = bolCarga;
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

	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * @param regex the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
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
