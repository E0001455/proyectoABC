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
	
	@Column(name = "ID_MAPEO_CAMPANA")
	private Long 	idMapeoCampana;
	
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
	private Date 	fdFechaInicio;
	
	@Column(name = "FDFECHAFIN")
	private Date 	fdFechaFin;
	
	@Column(name = "FINREGISTROS")
	private Integer finRegistros;
	
	@Column(name = "FINPROCESADOS")
	private Integer finProcesados;
	
	@Column(name = "FIDICTAMINACION")
	private Boolean	fiDictaminacion;
	
	@Column(name = "FIPORCENTAJEERROR")
	private Integer finPorcentajeError;
	
	@Column(name = "FDFECHACREACION")
	private Date 	fechaCreacion;
	
	@Column(name = "FDFECHAULTMODIFICACION")
	private Date 	fechaUltModificacion;

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
	 * @return the idMapeoCampana
	 */
	public Long getIdMapeoCampana() {
		return idMapeoCampana;
	}

	/**
	 * @param idMapeoCampana the idMapeoCampana to set
	 */
	public void setIdMapeoCampana(Long idMapeoCampana) {
		this.idMapeoCampana = idMapeoCampana;
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
	public Date getFdFechaInicio() {
		return fdFechaInicio;
	}

	/**
	 * @param fdFechaInicio the fdFechaInicio to set
	 */
	public void setFdFechaInicio(Date fdFechaInicio) {
		this.fdFechaInicio = fdFechaInicio;
	}

	/**
	 * @return the fdFechaFin
	 */
	public Date getFdFechaFin() {
		return fdFechaFin;
	}

	/**
	 * @param fdFechaFin the fdFechaFin to set
	 */
	public void setFdFechaFin(Date fdFechaFin) {
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
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaUltModificacion
	 */
	public Date getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Date fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	
	
}
