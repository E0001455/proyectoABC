package mx.com.proyectohu.dto;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;



public class MapeoLineaColumnaResponseDTO {
	
	@JsonProperty("tipo")
	private CatColumna catColumna;
	
	@JsonProperty("valor")
	private CatValorDTO catValorDTO;

	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("fechaCreacion")
	private Timestamp fecCreacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Timestamp fecUltModificacion;
	
	private String regex;
	
	@JsonProperty("esRequerido")
	private Boolean finRequerido;	
	
	
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
	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}
	/**
	 * @param regex the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}
	/**
	 * @return the finRequerido
	 */
	public Boolean getFinRequerido() {
		return finRequerido;
	}
	/**
	 * @param finRequerido the finRequerido to set
	 */
	public void setFinRequerido(Boolean finRequerido) {
		this.finRequerido = finRequerido;
	}
	/**
	 * @return the catValorDTO
	 */
	public CatValorDTO getCatValorDTO() {
		return catValorDTO;
	}
	/**
	 * @param catValorDTO the catValorDTO to set
	 */
	public void setCatValorDTO(CatValorDTO catValorDTO) {
		this.catValorDTO = catValorDTO;
	}
	
	
	
	
	/**
	 * @return the catColumna
	 */
	public CatColumna getCatColumna() {
		return catColumna;
	}
	/**
	 * @param catColumna the catColumna to set
	 */
	public void setCatColumna(CatColumna catColumna) {
		this.catColumna = catColumna;
	}




	public static class CatColumna {

		@JsonProperty("id")
		private Long idABCCatColumna;

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

	}
	
	
	

}


