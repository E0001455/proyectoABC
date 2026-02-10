package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatCadenaDTO {
	
	@JsonProperty("tipo")
	private TipoCadena tipoCadena;
	
	@JsonProperty("minimo")
	private Long numMinimo;
	
	@JsonProperty("maximo")
	private Long numMaximo;

	
	
	
	
	
	/**
	 * @return the tipoCadena
	 */
	public TipoCadena getTipoCadena() {
		return tipoCadena;
	}






	/**
	 * @param tipoCadena the tipoCadena to set
	 */
	public void setTipoCadena(TipoCadena tipoCadena) {
		this.tipoCadena = tipoCadena;
	}






	/**
	 * @return the numMinimo
	 */
	public Long getNumMinimo() {
		return numMinimo;
	}






	/**
	 * @param numMinimo the numMinimo to set
	 */
	public void setNumMinimo(Long numMinimo) {
		this.numMinimo = numMinimo;
	}






	/**
	 * @return the numMaximo
	 */
	public Long getNumMaximo() {
		return numMaximo;
	}






	/**
	 * @param numMaximo the numMaximo to set
	 */
	public void setNumMaximo(Long numMaximo) {
		this.numMaximo = numMaximo;
	}






	public static class TipoCadena {
		@JsonProperty("id")
		private Long idABCCatCadena;

		/**
		 * @return the idABCCatCadena
		 */
		public Long getIdABCCatCadena() {
			return idABCCatCadena;
		}

		/**
		 * @param idABCCatCadena the idABCCatCadena to set
		 */
		public void setIdABCCatCadena(Long idABCCatCadena) {
			this.idABCCatCadena = idABCCatCadena;
		}

	
	
	}
	

	
	
}
