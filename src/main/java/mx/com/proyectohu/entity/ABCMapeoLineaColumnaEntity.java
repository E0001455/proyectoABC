package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TTABCCFG_COLUMNA_LINEA")
public class ABCMapeoLineaColumnaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveMapeoLineaColumna llaveMapeoLineaColumna;
	
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "ID_VALOR")
	private Long idABCCatValor;
	
	@Column(name = "ID_CADENA")
	private Long idABCCatCadena;
	
	@Column(name = "ID_NUMERO")
	private Long idABCCatNumero;
	
	@Column(name = "ID_FECHA")
	private Long idFecha;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FIREQUERIDO")
	private Boolean fiRequerido;
	
	@Column(name = "FCREGEX")
	private String regex;
	
	@Column(name = "FINOMINIMO")
	private Long numMinimo;
	
	@Column(name = "FINOMAXIMO")
	private Long numMaximo;
	
	@Column(name = "FINOENTEROS")
	private Long numEnteros;
	
	@Column(name = "FINODECIMALES")
	private Long numDecimales;
	
	@Column(name = "FDFECHACREACION")
	private Date fecCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Date fecUltModificacion;

	/**
	 * @return the llaveMapeoLineaColumna
	 */
	public LlaveMapeoLineaColumna getLlaveMapeoLineaColumna() {
		return llaveMapeoLineaColumna;
	}

	/**
	 * @param llaveMapeoLineaColumna the llaveMapeoLineaColumna to set
	 */
	public void setLlaveMapeoLineaColumna(LlaveMapeoLineaColumna llaveMapeoLineaColumna) {
		this.llaveMapeoLineaColumna = llaveMapeoLineaColumna;
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
	 * @return the idABCCatValor
	 */
	public Long getIdABCCatValor() {
		return idABCCatValor;
	}

	/**
	 * @param idABCCatValor the idABCCatValor to set
	 */
	public void setIdABCCatValor(Long idABCCatValor) {
		this.idABCCatValor = idABCCatValor;
	}

	/**
	 * @return the idABCCatCadena
	 */
	public Long getIdABCCatCadena() {
		return idABCCatCadena;
	}

	/**
	 * @param idABCCatCadena the idABCCatCadena to set
	 */
	public void setIdABCCatCadena(Long idABCCatCadena) {
		this.idABCCatCadena = idABCCatCadena;
	}

	/**
	 * @return the idABCCatNumero
	 */
	public Long getIdABCCatNumero() {
		return idABCCatNumero;
	}

	/**
	 * @param idABCCatNumero the idABCCatNumero to set
	 */
	public void setIdABCCatNumero(Long idABCCatNumero) {
		this.idABCCatNumero = idABCCatNumero;
	}

	/**
	 * @return the idFecha
	 */
	public Long getIdFecha() {
		return idFecha;
	}

	/**
	 * @param idFecha the idFecha to set
	 */
	public void setIdFecha(Long idFecha) {
		this.idFecha = idFecha;
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
	 * @return the fiRequerido
	 */
	public Boolean getFiRequerido() {
		return fiRequerido;
	}

	/**
	 * @param fiRequerido the fiRequerido to set
	 */
	public void setFiRequerido(Boolean fiRequerido) {
		this.fiRequerido = fiRequerido;
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
	 * @return the numMinimo
	 */
	public Long getNumMinimo() {
		return numMinimo;
	}

	/**
	 * @param numMinimo the numMinimo to set
	 */
	public void setNumMinimo(Long numMinimo) {
		this.numMinimo = numMinimo;
	}

	/**
	 * @return the numMaximo
	 */
	public Long getNumMaximo() {
		return numMaximo;
	}

	/**
	 * @param numMaximo the numMaximo to set
	 */
	public void setNumMaximo(Long numMaximo) {
		this.numMaximo = numMaximo;
	}

	/**
	 * @return the numEnteros
	 */
	public Long getNumEnteros() {
		return numEnteros;
	}

	/**
	 * @param numEnteros the numEnteros to set
	 */
	public void setNumEnteros(Long numEnteros) {
		this.numEnteros = numEnteros;
	}

	/**
	 * @return the numDecimales
	 */
	public Long getNumDecimales() {
		return numDecimales;
	}

	/**
	 * @param numDecimales the numDecimales to set
	 */
	public void setNumDecimales(Long numDecimales) {
		this.numDecimales = numDecimales;
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
