package mx.com.proyectohu.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PETRequestDTO {
	
		private Long idLineaNegocio;
		private Long idCampana;
		private String noLote;
	    private String idCliente;
	    private String idAfore;
	    private String idClienteAhorrador;
	    private String idPrestamoPensionado;
	    private String idSusceptiblePrestamo;
	    private String idBajaCambio;
	    private String idComunicacion;
	    private String idPersona;
	    private String nombre;
	    private String apellido;
	    private String correo;
	    private String telefono;
	    private String tipoActividad;
	    private String tipoConsulta;
	    private Long idMapeoCampana;
	    private String  riid; 
	    
	    
	    public String getTipoActividad() {
			return tipoActividad;
		}

		public void setTipoActividad(String tipoActividad) {
			this.tipoActividad = tipoActividad;
		}

		public String getTipoConsulta() {
			return tipoConsulta;
		}

		public void setTipoConsulta(String tipoConsulta) {
			this.tipoConsulta = tipoConsulta;
		}

		@JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate fechaInicio;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate fechaFin;

		public String getNoLote() {
			return noLote;
		}

		public void setNoLote(String noLote) {
			this.noLote = noLote;
		}

		public String getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(String idCliente) {
			this.idCliente = idCliente;
		}

		public String getIdAfore() {
			return idAfore;
		}

		public void setIdAfore(String idAfore) {
			this.idAfore = idAfore;
		}

		public String getIdClienteAhorrador() {
			return idClienteAhorrador;
		}

		public void setIdClienteAhorrador(String idClienteAhorrador) {
			this.idClienteAhorrador = idClienteAhorrador;
		}

		public String getIdPrestamoPensionado() {
			return idPrestamoPensionado;
		}

		public void setIdPrestamoPensionado(String idPrestamoPensionado) {
			this.idPrestamoPensionado = idPrestamoPensionado;
		}

		public String getIdSusceptiblePrestamo() {
			return idSusceptiblePrestamo;
		}

		public void setIdSusceptiblePrestamo(String idSusceptiblePrestamo) {
			this.idSusceptiblePrestamo = idSusceptiblePrestamo;
		}

		public String getIdBajaCambio() {
			return idBajaCambio;
		}

		public void setIdBajaCambio(String idBajaCambio) {
			this.idBajaCambio = idBajaCambio;
		}

		public String getIdComunicacion() {
			return idComunicacion;
		}

		public void setIdComunicacion(String idComunicacion) {
			this.idComunicacion = idComunicacion;
		}

		public String getIdPersona() {
			return idPersona;
		}

		public void setIdPersona(String idPersona) {
			this.idPersona = idPersona;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public LocalDate getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public LocalDate getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(LocalDate fechaFin) {
			this.fechaFin = fechaFin;
		}

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

		/**
		 * @return the idCampana
		 */
		public Long getIdCampana() {
			return idCampana;
		}

		/**
		 * @param idCampana the idCampana to set
		 */
		public void setIdCampana(Long idCampana) {
			this.idCampana = idCampana;
		}

		/**
		 * @return the idMapeoCampana
		 */
		public Long getIdMapeoCampana() {
			return idMapeoCampana;
		}

		/**
		 * @param idMapeoCampana the idMapeoCampana to set
		 */
		public void setIdMapeoCampana(Long idMapeoCampana) {
			this.idMapeoCampana = idMapeoCampana;
		}

		/**
		 * @return the riid
		 */
		public String getRiid() {
			return riid;
		}

		/**
		 * @param riid the riid to set
		 */
		public void setRiid(String riid) {
			this.riid = riid;
		}
		

	   



}
