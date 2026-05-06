package mx.com.proyectohu.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TareaCampanaDTO {
	
	@JsonProperty("id")
	private Long 	idCFGTareaCampana;

	@JsonProperty("actividad")
	private CatActividad catActividad;
	
	@JsonProperty("ejecucion")
	private CatEjecucion catEjecucion; 
	
	@JsonProperty("dia")
	private DiaDTO diaDTO;
	
	@JsonProperty("hora")
	private HoraDTO horaDTO;
	
	@JsonProperty("estatus")
	private List<BitacoraTareaCampanaDTO> bitacoraTareaCampana;
	
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
	 * @return the idCFGTareaCampana
	 */
	public Long getIdCFGTareaCampana() {
		return idCFGTareaCampana;
	}


	/**
	 * @param idCFGTareaCampana the idCFGTareaCampana to set
	 */
	public void setIdCFGTareaCampana(Long idCFGTareaCampana) {
		this.idCFGTareaCampana = idCFGTareaCampana;
	}


	/**
	 * @return the bitacoraTareaCampana
	 */
	public List<BitacoraTareaCampanaDTO> getBitacoraTareaCampana() {
		return bitacoraTareaCampana;
	}


	/**
	 * @param bitacoraTareaCampana the bitacoraTareaCampana to set
	 */
	public void setBitacoraTareaCampana(List<BitacoraTareaCampanaDTO> bitacoraTareaCampana) {
		this.bitacoraTareaCampana = bitacoraTareaCampana;
	}


	/**
	 * @return the catActividad
	 */
	public CatActividad getCatActividad() {
		return catActividad;
	}


	/**
	 * @param catActividad the catActividad to set
	 */
	public void setCatActividad(CatActividad catActividad) {
		this.catActividad = catActividad;
	}


	/**
	 * @return the catEjecucion
	 */
	public CatEjecucion getCatEjecucion() {
		return catEjecucion;
	}


	/**
	 * @param catEjecucion the catEjecucion to set
	 */
	public void setCatEjecucion(CatEjecucion catEjecucion) {
		this.catEjecucion = catEjecucion;
	}


	/**
	 * @return the diaDTO
	 */
	public DiaDTO getDiaDTO() {
		return diaDTO;
	}


	/**
	 * @param diaDTO the diaDTO to set
	 */
	public void setDiaDTO(DiaDTO diaDTO) {
		this.diaDTO = diaDTO;
	}


	/**
	 * @return the horaDTO
	 */
	public HoraDTO getHoraDTO() {
		return horaDTO;
	}


	/**
	 * @param horaDTO the horaDTO to set
	 */
	public void setHoraDTO(HoraDTO horaDTO) {
		this.horaDTO = horaDTO;
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










	public static class CatActividad {

		@JsonProperty("id")
		private Long 	idActividad;

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

	}



	public static class CatEjecucion {

		@JsonProperty("id")
		private Long 	idEjecucion;

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

	}
	
	
	public static class CatEstatus {

		@JsonProperty("id")
		private Long 	idEstatus;

		/**
		 * @return the idEstatus
		 */
		public Long getIdEstatus() {
			return idEstatus;
		}

		/**
		 * @param idEstatus the idEstatus to set
		 */
		public void setIdEstatus(Long idEstatus) {
			this.idEstatus = idEstatus;
		}

		
	}

	

	
	
	

}
