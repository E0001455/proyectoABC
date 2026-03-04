package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CampanaColumnaDTO {
	
    private Long idABCConfigMapeoCampana;
	
	@JsonProperty("tipo")
	private CatColumna catColumna;
	
	@JsonProperty("esRequerido")
	private Boolean finRequerido;	
	
	private String regex;
	
	@JsonProperty("valor")
	private CatValorDTO catValorDTO;

	
	
	
	
	




	/**
	 * @return the idABCConfigMapeoCampana
	 */
	public Long getIdABCConfigMapeoCampana() {
		return idABCConfigMapeoCampana;
	}






	/**
	 * @param idABCConfigMapeoCampana the idABCConfigMapeoCampana to set
	 */
	public void setIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana) {
		this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
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
