package mx.com.proyectohu.dto;



import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PETRequestDTO {
	
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

	   



}
