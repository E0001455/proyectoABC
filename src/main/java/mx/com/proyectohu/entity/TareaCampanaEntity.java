package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCTRA_TAREA_CAMPANA" )
@SequenceGenerator(name = "SEQ_TAREA_CAMPANA_GEN",sequenceName = "SEQ_TTABCTRA_TAREA_CAMPANA",allocationSize = 1)
public class TareaCampanaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAREA_CAMPANA_GEN")
	@Column(name = "ID_TAREA_CAMPANA")
	private Long 	idTareaCampana;
	
	@ManyToOne
	@JoinColumn(name = "ID_MAPEO_CAMPANA")
	private ABCConfigMapeoCampanaEntity MapeoCampana;
	
	@Column(name = "ID_ACTIVIDAD_CAMPANA")
	private Long 	idActividadCampana;
	
	@Column(name = "ID_ACTIVIDAD")
	private Long 	idActividad;
	
	@Column(name = "ID_EJECUCION")
	private Long 	idEjecucion;
	
    @Column(name = "ID_DIA")
    private Long 	idDia;

    @Column(name = "ID_HORA")
    private Long 	idHora;
	
	@Column(name = "ID_ESTATUS_TAREA")
	private Long 	idEstatusTarea;
	
	@Column(name = "FDFECHAINICIO")
	private Timestamp 	fdFechaInicio;
	
	@Column(name = "FDFECHAFIN")
	private Timestamp 	fdFechaFin;
	
	@Column(name = "FINOREGISTROS")
	private Integer finRegistros;
	
	@Column(name = "FINOPROCESADOS")
	private Integer finProcesados;
	
	@Column(name = "FIDICTAMINAR")
	private Boolean	fiDictaminacion;
	
	@Column(name = "FIPORCENTAJEERROR")
	private Integer finPorcentajeError;
	
	@Column(name = "FINOAPROBADOS")
	private Integer registrosAprobados;
	
	@Column(name = "FINORECHAZADOS")
	private Integer registrosRechazados;
	
	@Column(name = "FIDICTAMINADO")
	private Boolean	fiDictaminado;
	
	@Column(name = "FDFECHADICTAMINADO")
	private Timestamp 	fdFechaDictaminado;
	

	/**
	 * @return the idTareaCampana
	 */
	public Long getIdTareaCampana() {
		return idTareaCampana;
	}

	/**
	 * @param idTareaCampana the idTareaCampana to set
	 */
	public void setIdTareaCampana(Long idTareaCampana) {
		this.idTareaCampana = idTareaCampana;
	}



	/**
	 * @return the mapeoCampana
	 */
	public ABCConfigMapeoCampanaEntity getMapeoCampana() {
		return MapeoCampana;
	}

	/**
	 * @param mapeoCampana the mapeoCampana to set
	 */
	public void setMapeoCampana(ABCConfigMapeoCampanaEntity mapeoCampana) {
		MapeoCampana = mapeoCampana;
	}

	/**
	 * @return the idActividadCampana
	 */
	public Long getIdActividadCampana() {
		return idActividadCampana;
	}

	/**
	 * @param idActividadCampana the idActividadCampana to set
	 */
	public void setIdActividadCampana(Long idActividadCampana) {
		this.idActividadCampana = idActividadCampana;
	}

	/**
	 * @return the idActividad
	 */
	public Long getIdActividad() {
		return idActividad;
	}

	/**
	 * @param idActividad the idActividad to set
	 */
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	/**
	 * @return the idEjecucion
	 */
	public Long getIdEjecucion() {
		return idEjecucion;
	}

	/**
	 * @param idEjecucion the idEjecucion to set
	 */
	public void setIdEjecucion(Long idEjecucion) {
		this.idEjecucion = idEjecucion;
	}

	/**
	 * @return the idDia
	 */
	public Long getIdDia() {
		return idDia;
	}

	/**
	 * @param idDia the idDia to set
	 */
	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	/**
	 * @return the idHora
	 */
	public Long getIdHora() {
		return idHora;
	}

	/**
	 * @param idHora the idHora to set
	 */
	public void setIdHora(Long idHora) {
		this.idHora = idHora;
	}

	/**
	 * @return the idEstatusTarea
	 */
	public Long getIdEstatusTarea() {
		return idEstatusTarea;
	}

	/**
	 * @param idEstatusTarea the idEstatusTarea to set
	 */
	public void setIdEstatusTarea(Long idEstatusTarea) {
		this.idEstatusTarea = idEstatusTarea;
	}

	
	/**
	 * @return the fdFechaInicio
	 */
	public Timestamp getFdFechaInicio() {
		return fdFechaInicio;
	}

	/**
	 * @param fdFechaInicio the fdFechaInicio to set
	 */
	public void setFdFechaInicio(Timestamp fdFechaInicio) {
		this.fdFechaInicio = fdFechaInicio;
	}

	/**
	 * @return the fdFechaFin
	 */
	public Timestamp getFdFechaFin() {
		return fdFechaFin;
	}

	/**
	 * @param fdFechaFin the fdFechaFin to set
	 */
	public void setFdFechaFin(Timestamp fdFechaFin) {
		this.fdFechaFin = fdFechaFin;
	}

	/**
	 * @return the finRegistros
	 */
	public Integer getFinRegistros() {
		return finRegistros;
	}

	/**
	 * @param finRegistros the finRegistros to set
	 */
	public void setFinRegistros(Integer finRegistros) {
		this.finRegistros = finRegistros;
	}

	/**
	 * @return the finProcesados
	 */
	public Integer getFinProcesados() {
		return finProcesados;
	}

	/**
	 * @param finProcesados the finProcesados to set
	 */
	public void setFinProcesados(Integer finProcesados) {
		this.finProcesados = finProcesados;
	}

	/**
	 * @return the fiDictaminacion
	 */
	public Boolean getFiDictaminacion() {
		return fiDictaminacion;
	}

	/**
	 * @param fiDictaminacion the fiDictaminacion to set
	 */
	public void setFiDictaminacion(Boolean fiDictaminacion) {
		this.fiDictaminacion = fiDictaminacion;
	}

	/**
	 * @return the finPorcentajeError
	 */
	public Integer getFinPorcentajeError() {
		return finPorcentajeError;
	}

	/**
	 * @param finPorcentajeError the finPorcentajeError to set
	 */
	public void setFinPorcentajeError(Integer finPorcentajeError) {
		this.finPorcentajeError = finPorcentajeError;
	}

	/**
	 * @return the registrosAprobados
	 */
	public Integer getRegistrosAprobados() {
		return registrosAprobados;
	}

	/**
	 * @param registrosAprobados the registrosAprobados to set
	 */
	public void setRegistrosAprobados(Integer registrosAprobados) {
		this.registrosAprobados = registrosAprobados;
	}

	/**
	 * @return the registrosRechazados
	 */
	public Integer getRegistrosRechazados() {
		return registrosRechazados;
	}

	/**
	 * @param registrosRechazados the registrosRechazados to set
	 */
	public void setRegistrosRechazados(Integer registrosRechazados) {
		this.registrosRechazados = registrosRechazados;
	}

	public Boolean getFiDictaminado() {
		return fiDictaminado;
	}

	public void setFiDictaminado(Boolean fiDictaminado) {
		this.fiDictaminado = fiDictaminado;
	}

	public Timestamp getFdFechaDictaminado() {
		return fdFechaDictaminado;
	}

	public void setFdFechaDictaminado(Timestamp fdFechaDictaminado) {
		this.fdFechaDictaminado = fdFechaDictaminado;
	}

	
	
	
	
}
