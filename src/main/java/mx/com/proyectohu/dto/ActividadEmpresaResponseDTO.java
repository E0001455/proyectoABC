package mx.com.proyectohu.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActividadEmpresaResponseDTO {

	@JsonProperty("id")
	private Long 	idActividadEmpresa;
	
	@JsonProperty("mapeo")
	private MapeoEmpresaDTO	mapeoEmpresaDTO;
	
	@JsonProperty("activo")
	private Boolean bolActivo;
	
	@JsonProperty("linea")
	private CatLineaNegocio catLineaNegocio;

	
	@JsonProperty("fechaCreacion")
	private Long 	fechaCreacion;

	@JsonProperty("fechaUltimaModificacion")
	private Long 	fechaUltModificacion;
	
	@JsonProperty("actividades")
	private List<ActividadDTO> actividadDTOLista;
	

	





	/**
	 * @return the mapeoEmpresaDTO
	 */
	public MapeoEmpresaDTO getMapeoEmpresaDTO() {
		return mapeoEmpresaDTO;
	}



	/**
	 * @param mapeoEmpresaDTO the mapeoEmpresaDTO to set
	 */
	public void setMapeoEmpresaDTO(MapeoEmpresaDTO mapeoEmpresaDTO) {
		this.mapeoEmpresaDTO = mapeoEmpresaDTO;
	}



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
	 * @return the catLineaNegocio
	 */
	public CatLineaNegocio getCatLineaNegocio() {
		return catLineaNegocio;
	}



	/**
	 * @param catLineaNegocio the catLineaNegocio to set
	 */
	public void setCatLineaNegocio(CatLineaNegocio catLineaNegocio) {
		this.catLineaNegocio = catLineaNegocio;
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

	
	/**
	 * @return the actividadDTOLista
	 */
	public List<ActividadDTO> getActividadDTOLista() {
		return actividadDTOLista;
	}



	/**
	 * @param actividadDTOLista the actividadDTOLista to set
	 */
	public void setActividadDTOLista(List<ActividadDTO> actividadDTOLista) {
		this.actividadDTOLista = actividadDTOLista;
	}










	public static class CatLineaNegocio {

		@JsonProperty("id")
		private Long idLineaNegocio;

		/**
		 * @return the idLineaNegocio
		 */
		public Long getIdLineaNegocio() {
			return idLineaNegocio;
		}

		/**
		 * @param idLineaNegocio the idLineaNegocio to set
		 */
		public void setIdLineaNegocio(Long idLineaNegocio) {
			this.idLineaNegocio = idLineaNegocio;
		}


		



	}

	public static class CatActividad {

		@JsonProperty("id")
		private Long 	idActividad;

		/**
		 * @return the idActividad
		 */
		public Long getIdActividad() {
			return idActividad;
		}

		/**
		 * @param idActividad the idActividad to set
		 */
		public void setIdActividad(Long idActividad) {
			this.idActividad = idActividad;
		}

		







	}



	public static class CatEjecucion {

		@JsonProperty("id")
		private Long 	idEjecucion;

		/**
		 * @return the idEjecucion
		 */
		public Long getIdEjecucion() {
			return idEjecucion;
		}

		/**
		 * @param idEjecucion the idEjecucion to set
		 */
		public void setIdEjecucion(Long idEjecucion) {
			this.idEjecucion = idEjecucion;
		}

		





	}
	



}
