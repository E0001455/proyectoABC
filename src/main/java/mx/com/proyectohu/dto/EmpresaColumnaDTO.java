package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EmpresaColumnaDTO {



	@JsonProperty("tipo")
	private CatColumna catColumna;
	
	
	@JsonProperty("esRequerido")
	private Boolean  fiRequerido;
	

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



}
