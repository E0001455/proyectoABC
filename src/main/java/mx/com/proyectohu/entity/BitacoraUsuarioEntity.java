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
@Table(name="ABC_BITACORA_USUARIO" )
@SequenceGenerator(name = "mapeo_seq_gen",sequenceName = "ABC_SEQ_BITACORA_USUARIO",allocationSize = 1)
public class BitacoraUsuarioEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapeo_seq_gen")
	@Column(name = "ID_ABC_BITACORA_USUARIO")
	private Long 	idABCBitacoraUsuario;
	
	@Column(name = "ID_ABC_USUARIO")
	private Long 	idABCUsuario;
	
	@Column(name = "ID_ABC_CAT_EVENTO")
	private Long 	idABCCatEvento;
	
	@Column(name = "ID_ABC_CAT_OBJETO")
	private Long idABCCatObjeto;
	
	@Column(name = "ID_ABC_CAT_COLUMNA")
	private Long 	idABCCatColumna;
	
	@Column(name = "DETALLE")
	private String 	detalle;
	
	@Column(name = "IP")
	private String ip;
	
	@Column(name = "NAVEGADOR")
	private String 	navegador;
	
	@Column(name = "FEC_CREACION")
	private Date 	fecCreacion;
	
	@Column(name = "FEC_ULT_MODIFICACION")
	private Date 	fecUltModificacion;

	/**
	 * @return the idABCBitacoraUsuario
	 */
	public Long getIdABCBitacoraUsuario() {
		return idABCBitacoraUsuario;
	}

	/**
	 * @param idABCBitacoraUsuario the idABCBitacoraUsuario to set
	 */
	public void setIdABCBitacoraUsuario(Long idABCBitacoraUsuario) {
		this.idABCBitacoraUsuario = idABCBitacoraUsuario;
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
	 * @return the idABCCatEvento
	 */
	public Long getIdABCCatEvento() {
		return idABCCatEvento;
	}

	/**
	 * @param idABCCatEvento the idABCCatEvento to set
	 */
	public void setIdABCCatEvento(Long idABCCatEvento) {
		this.idABCCatEvento = idABCCatEvento;
	}

	/**
	 * @return the idABCCatObjeto
	 */
	public Long getIdABCCatObjeto() {
		return idABCCatObjeto;
	}

	/**
	 * @param idABCCatObjeto the idABCCatObjeto to set
	 */
	public void setIdABCCatObjeto(Long idABCCatObjeto) {
		this.idABCCatObjeto = idABCCatObjeto;
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
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the navegador
	 */
	public String getNavegador() {
		return navegador;
	}

	/**
	 * @param navegador the navegador to set
	 */
	public void setNavegador(String navegador) {
		this.navegador = navegador;
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
