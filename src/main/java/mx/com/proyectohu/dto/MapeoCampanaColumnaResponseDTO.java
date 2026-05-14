package mx.com.proyectohu.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;





public class MapeoCampanaColumnaResponseDTO {
	
	
	
	@JsonProperty("tipo")
	private CatColumna catColumna;
	
	@JsonProperty("valor")
	private CatValorDTO catValorDTO;

	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("fechaCreacion")
	private Long fecCreacion;
	
	@JsonProperty("fechaUltimaModificacion")
	private Long fecUltModificacion;
	
	private String regex;
	
	@JsonProperty("esRequerido")
	private Boolean finRequerido;

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
	public Long getFecCreacion() {
		return fecCreacion;
	}

	/**
	 * @param fecCreacion the fecCreacion to set
	 */
	public void setFecCreacion(Long fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	/**
	 * @return the fecUltModificacion
	 */
	public Long getFecUltModificacion() {
		return fecUltModificacion;
	}

	/**
	 * @param fecUltModificacion the fecUltModificacion to set
	 */
	public void setFecUltModificacion(Long fecUltModificacion) {
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
