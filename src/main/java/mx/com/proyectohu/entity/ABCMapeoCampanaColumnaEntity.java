package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ABC_MAPEO_CAMPANA_COLUMNA")
public class ABCMapeoCampanaColumnaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveMapeoCampanaColumna llaveMapeoCampanaColumna;
	
	@Column(name = "BOL_ACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "REGEX")
	private String regex;
	
	@Column(name = "FEC_CREACION")
	private Date fecCreacion;
	
	@Column(name = "ID_ABC_USUARIO_ULT_MODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FEC_ULT_MODIFICACION")
	private Date fecUltModificacion;
	
	@Column(name = "ID_ABC_CAT_VALOR")
	private Long idABCCatValor;
	
	@Column(name = "ID_ABC_CAT_CADENA")
	private Long idABCCatCadena;
	
	@Column(name = "ID_ABC_CAT_NUMERO")
	private Long idABCCatNumero;
	
	@Column(name = "BOL_OBLIGATORIO")
	private Boolean bolObligatorio;
	
	@Column(name = "NUM_MINIMO")
	private Long numMinimo;
	
	@Column(name = "NUM_MAXIMO")
	private Long numMaximo;
	
	@Column(name = "NUM_ENTEROS")
	private Long numEnteros;
	
	@Column(name = "NUM_DECIMALES")
	private Long numDecimales;

	/**
	 * @return the llaveMapeoCampanaColumna
	 */
	public LlaveMapeoCampanaColumna getLlaveMapeoCampanaColumna() {
		return llaveMapeoCampanaColumna;
	}

	/**
	 * @param llaveMapeoCampanaColumna the llaveMapeoCampanaColumna to set
	 */
	public void setLlaveMapeoCampanaColumna(LlaveMapeoCampanaColumna llaveMapeoCampanaColumna) {
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
	 * @return the bolObligatorio
	 */
	public Boolean getBolObligatorio() {
		return bolObligatorio;
	}

	/**
	 * @param bolObligatorio the bolObligatorio to set
	 */
	public void setBolObligatorio(Boolean bolObligatorio) {
		this.bolObligatorio = bolObligatorio;
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
	                   
	                    
	               
	
	
}
