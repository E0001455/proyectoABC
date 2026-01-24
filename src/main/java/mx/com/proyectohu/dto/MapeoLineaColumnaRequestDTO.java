package mx.com.proyectohu.dto;

public class MapeoLineaColumnaRequestDTO {
	
	private Long idABCConfigMapeoLinea;
	private Long idABCCatColumna;
	private Boolean bolCarga;
	private Boolean bolValidacion;
	private Boolean bolEnvio;
	private Long idUsuario;
	private String regex;
	
	
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
	 * @return the idABCConfigMapeoLinea
	 */
	public Long getIdABCConfigMapeoLinea() {
		return idABCConfigMapeoLinea;
	}
	/**
	 * @param idABCConfigMapeoLinea the idABCConfigMapeoLinea to set
	 */
	public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
		this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
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
