package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import mx.com.proyectohu.dto.CatCadenaDTO.TipoCadena;

public class CatNumeroDTO {
	
	
	@JsonProperty("tipo")
	private TipoNumero tipoNumero;
	
	@JsonProperty("enteros")
	private Long numEnteros;
	
	@JsonProperty("decimales")
	private Long numDecimales;
	
	
	
	/**
	 * @return the tipoNumero
	 */
	public TipoNumero getTipoNumero() {
		return tipoNumero;
	}



	/**
	 * @param tipoNumero the tipoNumero to set
	 */
	public void setTipoNumero(TipoNumero tipoNumero) {
		this.tipoNumero = tipoNumero;
	}



	/**
	 * @return the numEnteros
	 */
	public Long getNumEnteros() {
		return numEnteros;
	}



	/**
	 * @param numEnteros the numEnteros to set
	 */
	public void setNumEnteros(Long numEnteros) {
		this.numEnteros = numEnteros;
	}



	/**
	 * @return the numDecimales
	 */
	public Long getNumDecimales() {
		return numDecimales;
	}



	/**
	 * @param numDecimales the numDecimales to set
	 */
	public void setNumDecimales(Long numDecimales) {
		this.numDecimales = numDecimales;
	}



	public static class TipoNumero {
		@JsonProperty("id")
		private Long idABCCatNumero;

		/**
		 * @return the idABCCatNumero
		 */
		public Long getIdABCCatNumero() {
			return idABCCatNumero;
		}

		/**
		 * @param idABCCatNumero the idABCCatNumero to set
		 */
		public void setIdABCCatNumero(Long idABCCatNumero) {
			this.idABCCatNumero = idABCCatNumero;
		}

		
		

	
	
	}

}
