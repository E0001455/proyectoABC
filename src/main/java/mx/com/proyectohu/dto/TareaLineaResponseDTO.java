package mx.com.proyectohu.dto;


import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class TareaLineaResponseDTO {

	@JsonProperty("linea")
	private CatLineaNegocio catLineaNegocio;
	
	@JsonProperty("mapeo")
	private MapeoDTO	mapeoDTO;
	
	@JsonProperty("tarea")
	private List<TareaDTO>   tareaDTO;
	
	@JsonProperty("fechaInicio")
	private Timestamp 	fdFechaInicio;
	
	@JsonProperty("fechaFin")
	private Timestamp 	fdFechaFin;
	
	@JsonProperty("registros")
	private Integer finRegistros;
	
	@JsonProperty("procesados")
	private Integer finProcesados;
	
	@JsonProperty("dictaminar")
	private Boolean fiDictaminacion;
	
	
	@JsonProperty("fechaCreacion")
	private Timestamp 	fechaCreacion;




	/**
	 * @return the tareaDTO
	 */
	public List<TareaDTO> getTareaDTO() {
		return tareaDTO;
	}



	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(List<TareaDTO> tareaDTO) {
		this.tareaDTO = tareaDTO;
	}



	/**
	 * @return the mapeoDTO
	 */
	public MapeoDTO getMapeoDTO() {
		return mapeoDTO;
	}



	/**
	 * @param mapeoDTO the mapeoDTO to set
	 */
	public void setMapeoDTO(MapeoDTO mapeoDTO) {
		this.mapeoDTO = mapeoDTO;
	}



	/**
	 * @return the catLineaNegocio
	 */
	public CatLineaNegocio getCatLineaNegocio() {
		return catLineaNegocio;
	}



	/**
	 * @param catLineaNegocio the catLineaNegocio to set
	 */
	public void setCatLineaNegocio(CatLineaNegocio catLineaNegocio) {
		this.catLineaNegocio = catLineaNegocio;
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
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}



	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}










	public static class CatLineaNegocio {

		@JsonProperty("id")
		private Long idLineaNegocio;

		/**
		 * @return the idLineaNegocio
		 */
		public Long getIdLineaNegocio() {
			return idLineaNegocio;
		}

		/**
		 * @param idLineaNegocio the idLineaNegocio to set
		 */
		public void setIdLineaNegocio(Long idLineaNegocio) {
			this.idLineaNegocio = idLineaNegocio;
		}

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




}
