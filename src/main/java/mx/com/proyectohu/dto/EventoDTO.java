package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EventoDTO {


	@JsonAlias("id")
	private Long idABCCatEvento;

	/**
	 * @return the idABCCatEvento
	 */
	public Long getIdABCCatEvento() {
		return idABCCatEvento;
	}

	/**
	 * @param idABCCatEvento the idABCCatEvento to set
	 */
	public void setIdABCCatEvento(Long idABCCatEvento) {
		this.idABCCatEvento = idABCCatEvento;
	}




}


