package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="SYNONMID_TTABCCFG_COLUMNA_EMPRESA")
public class EmpresaColumnaEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna;
	
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "FIACTIVO")
	private Boolean bolActivo;
	
	@Column(name = "FIREQUERIDO")
	private Boolean fiRequerido;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fecCreacion;
	
	@Column(name = "FIIDUSUARIOULTMODIFICACION")
	private Long idABCUsuarioUltModificacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Timestamp fecUltModificacion;
	

	/**
	 * @return the llaveMapeoEmpresaColumna
	 */
	public LlaveMapeoEmpresaColumna getLlaveMapeoEmpresaColumna() {
		return llaveMapeoEmpresaColumna;
	}

	/**
	 * @param llaveMapeoEmpresaColumna the llaveMapeoEmpresaColumna to set
	 */
	public void setLlaveMapeoEmpresaColumna(LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna) {
		this.llaveMapeoEmpresaColumna = llaveMapeoEmpresaColumna;
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
