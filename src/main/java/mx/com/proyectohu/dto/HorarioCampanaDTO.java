package mx.com.proyectohu.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HorarioCampanaDTO {
	
	@JsonAlias("id")
	private Long 	idActividadCampana;

	private Dia 	dia;
	
	

	/**
	 * @return the idActividadCampana
	 */
	public Long getIdActividadCampana() {
		return idActividadCampana;
	}

	/**
	 * @param idActividadCampana the idActividadCampana to set
	 */
	public void setIdActividadCampana(Long idActividadCampana) {
		this.idActividadCampana = idActividadCampana;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public static class Dia {
		
		@JsonProperty("id")
		private Long idDia;
		
		private Hora hora;

		public Long getIdDia() {
			return idDia;
		}

		public void setIdDia(Long idDia) {
			this.idDia = idDia;
		}

		public Hora getHora() {
			return hora;
		}

		public void setHora(Hora hora) {
			this.hora = hora;
		}

		

	}
	
	public static class Hora {
		
		@JsonProperty("id")
		private Long idHora;

		public Long getIdHora() {
			return idHora;
		}

		public void setIdHora(Long idHora) {
			this.idHora = idHora;
		}

		


	}	
	
	
	

}
