package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitacoraDTO {

	@JsonProperty("evento")
	private EventoDTO 	EventoDTO;

	@JsonProperty("objeto")
	private ObjetoDTO 	ObjetoDTO;
	
	@JsonProperty("columnaLinea")
	private ColumnaLineaDTO 	columnaLineaDTO;
	
	@JsonProperty("columnaCampana")
	private ColumnaCampanaDTO 	columnaCampanaDTO;

	
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
	 * @return the columnaLineaDTO
	 */
	public ColumnaLineaDTO getColumnaLineaDTO() {
		return columnaLineaDTO;
	}

	/**
	 * @param columnaLineaDTO the columnaLineaDTO to set
	 */
	public void setColumnaLineaDTO(ColumnaLineaDTO columnaLineaDTO) {
		this.columnaLineaDTO = columnaLineaDTO;
	}

	/**
	 * @return the columnaCampanaDTO
	 */
	public ColumnaCampanaDTO getColumnaCampanaDTO() {
		return columnaCampanaDTO;
	}

	/**
	 * @param columnaCampanaDTO the columnaCampanaDTO to set
	 */
	public void setColumnaCampanaDTO(ColumnaCampanaDTO columnaCampanaDTO) {
		this.columnaCampanaDTO = columnaCampanaDTO;
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

	public static class ColumnaLineaDTO {

		@JsonAlias("id")
		private Long idABCCatColumnaLinea;

		/**
		 * @return the idABCCatColumnaLinea
		 */
		public Long getIdABCCatColumnaLinea() {
			return idABCCatColumnaLinea;
		}

		/**
		 * @param idABCCatColumnaLinea the idABCCatColumnaLinea to set
		 */
		public void setIdABCCatColumnaLinea(Long idABCCatColumnaLinea) {
			this.idABCCatColumnaLinea = idABCCatColumnaLinea;
		}

		

	


	}
	
	public static class ColumnaCampanaDTO {

		@JsonAlias("id")
		private Long idABCCatColumnaCampana;

		/**
		 * @return the idABCCatColumnaCampana
		 */
		public Long getIdABCCatColumnaCampana() {
			return idABCCatColumnaCampana;
		}

		/**
		 * @param idABCCatColumnaCampana the idABCCatColumnaCampana to set
		 */
		public void setIdABCCatColumnaCampana(Long idABCCatColumnaCampana) {
			this.idABCCatColumnaCampana = idABCCatColumnaCampana;
		}

	

	


	}



}
