package mx.com.proyectohu.dto;

import java.util.Date;



public class MapeoCampanaColumnaResponseDTO {
	
	
	
	private LlaveMapeoCampanaColumnaDTO llaveMapeoCampanaColumna;
	private Boolean	bolActivo;
	private Boolean bolCarga;
	private Boolean bolValidacion;
	private Boolean	bolEnvio;
	private String  regex;
	private Date 	fecCreacion;
	private Long 	idABCUsuarioUltModificacion;
	private Date 	fecUltModificacion;
	
	
	
	
	
	/**
	 * @return the llaveMapeoCampanaColumna
	 */
	public LlaveMapeoCampanaColumnaDTO getLlaveMapeoCampanaColumna() {
		return llaveMapeoCampanaColumna;
	}
	/**
	 * @param llaveMapeoCampanaColumna the llaveMapeoCampanaColumna to set
	 */
	public void setLlaveMapeoCampanaColumna(LlaveMapeoCampanaColumnaDTO llaveMapeoCampanaColumna) {
		this.llaveMapeoCampanaColumna = llaveMapeoCampanaColumna;
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
