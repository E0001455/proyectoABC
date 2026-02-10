package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitacoraDTO {

	@JsonProperty("evento")
	private EventoDTO 	EventoDTO;

	@JsonProperty("objeto")
	private ObjetoDTO 	ObjetoDTO;
	
	@JsonProperty("columna")
	private ColumnaDTO 	columnaDTO;
	

	
	private String 		detalle;
	private String 		ip;
	private String 		navegador;





	/**
	 * @return the eventoDTO
	 */
	public EventoDTO getEventoDTO() {
		return EventoDTO;
	}

	/**
	 * @param eventoDTO the eventoDTO to set
	 */
	public void setEventoDTO(EventoDTO eventoDTO) {
		EventoDTO = eventoDTO;
	}

	/**
	 * @return the objetoDTO
	 */
	public ObjetoDTO getObjetoDTO() {
		return ObjetoDTO;
	}

	/**
	 * @param objetoDTO the objetoDTO to set
	 */
	public void setObjetoDTO(ObjetoDTO objetoDTO) {
		ObjetoDTO = objetoDTO;
	}



	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the navegador
	 */
	public String getNavegador() {
		return navegador;
	}

	/**
	 * @param navegador the navegador to set
	 */
	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}


	/**
	 * @return the columnaDTO
	 */
	public ColumnaDTO getColumnaDTO() {
		return columnaDTO;
	}

	/**
	 * @param columnaDTO the columnaDTO to set
	 */
	public void setColumnaDTO(ColumnaDTO columnaDTO) {
		this.columnaDTO = columnaDTO;
	}




	public static class ObjetoDTO {

		@JsonAlias("id")
		private Long idABCCatObjeto;

		/**
		 * @return the idABCCatObjeto
		 */
		public Long getIdABCCatObjeto() {
			return idABCCatObjeto;
		}

		/**
		 * @param idABCCatObjeto the idABCCatObjeto to set
		 */
		public void setIdABCCatObjeto(Long idABCCatObjeto) {
			this.idABCCatObjeto = idABCCatObjeto;
		}



	}

	public static class ColumnaDTO {

		@JsonAlias("id")
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
