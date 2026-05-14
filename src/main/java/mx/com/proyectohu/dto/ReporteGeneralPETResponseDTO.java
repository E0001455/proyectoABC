package mx.com.proyectohu.dto;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReporteGeneralPETResponseDTO {
	
	
	private Long  idTarea;

	@JsonProperty("lineaNegocio")
	private String  nombreLineaNegocio;
	
	@JsonProperty("campana")
	private String  nombreCampana;
	
	@JsonProperty("mapeo")
	private String	nombreMapeo;
	
	@JsonProperty("fecha")
	private Long 	fdFechaFin;
	
	@JsonProperty("registros")
	private Integer  totalRegistros;
	
	@JsonProperty("aprobados")
	private Integer  totalRegistrosAprobados;
	
	@JsonProperty("rechazados")
	private Integer  totalRegistrosRechazados;
	
	@JsonProperty("pendientes")
	private Integer  pendientes;

	
	/**
	 * @return the nombreLineaNegocio
	 */
	public String getNombreLineaNegocio() {
		return nombreLineaNegocio;
	}

	/**
	 * @param nombreLineaNegocio the nombreLineaNegocio to set
	 */
	public void setNombreLineaNegocio(String nombreLineaNegocio) {
		this.nombreLineaNegocio = nombreLineaNegocio;
	}

	/**
	 * @return the nombreMapeo
	 */
	public String getNombreMapeo() {
		return nombreMapeo;
	}

	/**
	 * @param nombreMapeo the nombreMapeo to set
	 */
	public void setNombreMapeo(String nombreMapeo) {
		this.nombreMapeo = nombreMapeo;
	}


	

	/**
	 * @return the fdFechaFin
	 */
	public Long getFdFechaFin() {
		return fdFechaFin;
	}

	/**
	 * @param fdFechaFin the fdFechaFin to set
	 */
	public void setFdFechaFin(Long fdFechaFin) {
		this.fdFechaFin = fdFechaFin;
	}

	/**
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}

	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	/**
	 * @return the totalRegistrosAprobados
	 */
	public Integer getTotalRegistrosAprobados() {
		return totalRegistrosAprobados;
	}

	/**
	 * @param totalRegistrosAprobados the totalRegistrosAprobados to set
	 */
	public void setTotalRegistrosAprobados(Integer totalRegistrosAprobados) {
		this.totalRegistrosAprobados = totalRegistrosAprobados;
	}

	/**
	 * @return the totalRegistrosRechazados
	 */
	public Integer getTotalRegistrosRechazados() {
		return totalRegistrosRechazados;
	}

	/**
	 * @param totalRegistrosRechazados the totalRegistrosRechazados to set
	 */
	public void setTotalRegistrosRechazados(Integer totalRegistrosRechazados) {
		this.totalRegistrosRechazados = totalRegistrosRechazados;
	}

	/**
	 * @return the nombreCampana
	 */
	public String getNombreCampana() {
		return nombreCampana;
	}

	/**
	 * @param nombreCampana the nombreCampana to set
	 */
	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public Integer getPendientes() {
		return pendientes;
	}

	public void setPendientes(Integer pendientes) {
		this.pendientes = pendientes;
	}

	/**
	 * @return the idTarea
	 */
	public Long getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	
	
	
	


}
