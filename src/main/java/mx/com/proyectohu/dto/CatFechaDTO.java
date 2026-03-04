package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFechaDTO {
	
	@JsonProperty("tipo")
	private TipoFecha tipoFecha;

	
	/**
	 * @return the tipoFecha
	 */
	public TipoFecha getTipoFecha() {
		return tipoFecha;
	}


	/**
	 * @param tipoFecha the tipoFecha to set
	 */
	public void setTipoFecha(TipoFecha tipoFecha) {
		this.tipoFecha = tipoFecha;
	}


	public static class TipoFecha {
		@JsonProperty("id")
		private Long idCatFecha;

		/**
		 * @return the idCatFecha
		 */
		public Long getIdCatFecha() {
			return idCatFecha;
		}

		/**
		 * @param idCatFecha the idCatFecha to set
		 */
		public void setIdCatFecha(Long idCatFecha) {
			this.idCatFecha = idCatFecha;
		}
		
		

	}
	
}
