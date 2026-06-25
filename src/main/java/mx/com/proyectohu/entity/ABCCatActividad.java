package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.com.proyectohu.interfaces.CatalogoInterface;
import mx.com.proyectohu.notacion.CatalogoNotacion;

@CatalogoNotacion
@Entity
@Table(name="SYNONMID_TCABCCAT_ACTIVIDAD")
@SequenceGenerator(name = "SEQ_ACTIVIDAD_GEN",sequenceName = "SYNONMID_SEQ_TCABCCAT_ACTIVIDAD",allocationSize = 1)
public class ABCCatActividad implements Serializable,CatalogoInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVIDAD_GEN")
	@Column(name = "ID_ACTIVIDAD")
	private Long 	id;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FCCODIGO")
	private String 	codigo;
	
	@Column(name = "FCNOMBRE")
	private String 	nombre;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp 	fecCreacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp 	fecUltModificacion;

	


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
