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
@Table(name="ABC_CAT_COLUMNA;" )
@SequenceGenerator(name = "mapeo_seq_gen",sequenceName = "ABC_SEQ_CAT_COLUMNA",allocationSize = 1)
public class ABCCatCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapeo_seq_gen")
	@Column(name = "ID_ABC_CAT_COLUMNA")
	private Long 	idABCCatColumna;
	
	@Column(name = "BOL_ACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "CODIGO")
	private String 	codigo;
	
	@Column(name = "NOMBRE")
	private String 	nombre;
	
	@Column(name = "FEC_CREACION")
	private Date 	fecCreacion;
	
	@Column(name = "FEC_ULT_MODIFICACION")
	private Date 	fecUltModificacion;

	
	
	

	

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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	
	
	


}
