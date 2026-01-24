package mx.com.proyectohu.dto;

public class MapeoCampanaColumnaRequestDTO {
	
	private Long idABCConfigMapeoCampana;
	private Long idABCCatColumna;
	private Boolean bolCarga;
	private Boolean bolValidacion;
	private Boolean bolEnvio;
	private Long idUsuario;
	private String regex;
	
	
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

}
