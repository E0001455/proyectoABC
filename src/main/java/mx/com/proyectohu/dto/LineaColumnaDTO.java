package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class LineaColumnaDTO {


	private Long idABCConfigMapeoLinea;
	
	@JsonProperty("tipo")
	private CatColumna catColumna;
	
	private String regex;
	
	@JsonProperty("valor")
	private CatValorDTO catValorDTO;
	
	@JsonProperty("esRequerido")
	private Boolean  fiRequerido;
	
	
	
	
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
	/**
	 * @return the idABCConfigMapeoLinea
	 */
	public Long getIdABCConfigMapeoLinea() {
		return idABCConfigMapeoLinea;
	}
	/**
	 * @param idABCConfigMapeoLinea the idABCConfigMapeoLinea to set
	 */
	public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
		this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	}

	/**
	 * @return the fiRequerido
	 */
	public Boolean getFiRequerido() {
		return fiRequerido;
	}
	/**
	 * @param fiRequerido the fiRequerido to set
	 */
	public void setFiRequerido(Boolean fiRequerido) {
		this.fiRequerido = fiRequerido;
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

	
	

	




}
