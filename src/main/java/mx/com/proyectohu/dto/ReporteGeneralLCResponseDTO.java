package mx.com.proyectohu.dto;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReporteGeneralLCResponseDTO {

	@JsonProperty("lineaNegocio")
	private String  nombreLineaNegocio;
	
	@JsonProperty("mapeo")
	private String	nombreMapeo;
	
	@JsonProperty("fecha")
	private LocalDate 	fdFechaFin;
	
	@JsonProperty("registros")
	private Integer  totalRegistros;
	
	@JsonProperty("aprobados")
	private Integer  totalRegistrosAprobados;
	
	@JsonProperty("rechazados")
	private Integer  totalRegistrosRechazados;

	
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
	 * @return the fdFechaFin
	 */
	public LocalDate getFdFechaFin() {
		return fdFechaFin;
	}

	/**
	 * @param fdFechaFin the fdFechaFin to set
	 */
	public void setFdFechaFin(LocalDate fdFechaFin) {
		this.fdFechaFin = fdFechaFin;
	}

	
	
	


}
