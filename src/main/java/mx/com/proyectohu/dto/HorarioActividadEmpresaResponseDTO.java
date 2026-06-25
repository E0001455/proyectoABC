package mx.com.proyectohu.dto;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HorarioActividadEmpresaResponseDTO {
	
	
	@JsonProperty("id")
	private Long 	idActividadEmpresa;


	private Dia 	dia;
	
	@JsonProperty("activo")
	private Boolean bolActivo;
	
	
	private Long 	fechaCreacion;
	
	@JsonProperty("fechaUltimaModificacion")	
	private Long 	fechaUltModificacion;


	
	
	
	

	

	/**
	 * @return the idActividadEmpresa
	 */
	public Long getIdActividadEmpresa() {
		return idActividadEmpresa;
	}

	/**
	 * @param idActividadEmpresa the idActividadEmpresa to set
	 */
	public void setIdActividadEmpresa(Long idActividadEmpresa) {
		this.idActividadEmpresa = idActividadEmpresa;
	}

	/**
	 * @return the bolActivo
	 */
	public Boolean getBolActivo() {
		return bolActivo;
	}

	/**
	 * @param bolActivo the bolActivo to set
	 */
	public void setBolActivo(Boolean bolActivo) {
		this.bolActivo = bolActivo;
	}

	

	
	/**
	 * @return the fechaCreacion
	 */
	public Long getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaUltModificacion
	 */
	public Long getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Long fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
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
