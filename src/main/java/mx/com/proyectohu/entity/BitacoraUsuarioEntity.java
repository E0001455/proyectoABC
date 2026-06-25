package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="SYNONMID_TTABCTRA_BITACORA_USUARIO" )
@SequenceGenerator(name = "SEQ_BITACORA_USUARIO_GEN",sequenceName = "SYNONMID_SEQ_TTABCTRA_BITACORA_USUARIO",allocationSize = 1)
public class BitacoraUsuarioEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_USUARIO_GEN")
	@Column(name = "ID_BITACORA_USUARIO")
	private Long 	idABCBitacoraUsuario;
	
	@Column(name = "ID_USUARIO")
	private Long 	idABCUsuario;
	
	@Column(name = "ID_EVENTO")
	private Long 	idABCCatEvento;
	
	@Column(name = "ID_OBJETO")
	private Long idABCCatObjeto;
	
	@Column(name = "ID_COLUMNA_LINEA")
	private Long 	idABCCatColumnaLinea;
	
	@Column(name = "ID_COLUMNA_CAMPANA")
	private Long 	idABCCatColumnaCampana;
	
	@Column(name = "DETALLE")
	private String 	detalle;
	
	@Column(name = "IP")
	private String ip;
	
	@Column(name = "NAVEGADOR")
	private String 	navegador;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp 	fecCreacion;
	

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
	 * @return the idABCCatColumnaLinea
	 */
	public Long getIdABCCatColumnaLinea() {
		return idABCCatColumnaLinea;
	}

	/**
	 * @param idABCCatColumnaLinea the idABCCatColumnaLinea to set
	 */
	public void setIdABCCatColumnaLinea(Long idABCCatColumnaLinea) {
		this.idABCCatColumnaLinea = idABCCatColumnaLinea;
	}


	/**
	 * @return the idABCCatColumnaCampana
	 */
	public Long getIdABCCatColumnaCampana() {
		return idABCCatColumnaCampana;
	}

	/**
	 * @param idABCCatColumnaCampana the idABCCatColumnaCampana to set
	 */
	public void setIdABCCatColumnaCampana(Long idABCCatColumnaCampana) {
		this.idABCCatColumnaCampana = idABCCatColumnaCampana;
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
	public Timestamp getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}




	
	
	
	
	
	


}
