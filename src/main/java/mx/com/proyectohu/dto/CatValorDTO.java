package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CatValorDTO {

	@JsonProperty("tipo")
	private TipoValor tipoValor;
	
	@JsonProperty("cadena")
	private CatCadenaDTO catCadenaDTO;
	
	
	@JsonProperty("numero")
	private CatNumeroDTO catNumeroDTO;






	/**
	 * @return the tipoValor
	 */
	public TipoValor getTipoValor() {
		return tipoValor;
	}






	/**
	 * @param tipoValor the tipoValor to set
	 */
	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}






	/**
	 * @return the catCadenaDTO
	 */
	public CatCadenaDTO getCatCadenaDTO() {
		return catCadenaDTO;
	}






	/**
	 * @param catCadenaDTO the catCadenaDTO to set
	 */
	public void setCatCadenaDTO(CatCadenaDTO catCadenaDTO) {
		this.catCadenaDTO = catCadenaDTO;
	}






	/**
	 * @return the catNumeroDTO
	 */
	public CatNumeroDTO getCatNumeroDTO() {
		return catNumeroDTO;
	}






	/**
	 * @param catNumeroDTO the catNumeroDTO to set
	 */
	public void setCatNumeroDTO(CatNumeroDTO catNumeroDTO) {
		this.catNumeroDTO = catNumeroDTO;
	}






	public static class TipoValor {
		@JsonProperty("id")
		private Long idABCCatValor;

		/**
		 * @return the idABCCatValor
		 */
		public Long getIdABCCatValor() {
			return idABCCatValor;
		}

		/**
		 * @param idABCCatValor the idABCCatValor to set
		 */
		public void setIdABCCatValor(Long idABCCatValor) {
			this.idABCCatValor = idABCCatValor;
		}





	}





}
