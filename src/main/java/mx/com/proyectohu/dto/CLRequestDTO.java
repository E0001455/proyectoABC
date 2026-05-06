package mx.com.proyectohu.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CLRequestDTO {
	
	 private String customerID;
	    private String nombre;
	    private String apellidoPaterno;
	    private String correo;
	    private String telefono;
	    private String noCuenta;
	    private String nss;
	    private String curp;
	    private String rfc;
	    private String poliza;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate fechaInicio;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate fechaFin;

	    private String tipoActividad;
	    private String tipoConsulta;
	   

	    /**
		 * @return the tipoActividad
		 */
		public String getTipoActividad() {
			return tipoActividad;
		}

		/**
		 * @param tipoActividad the tipoActividad to set
		 */
		public void setTipoActividad(String tipoActividad) {
			this.tipoActividad = tipoActividad;
		}

	
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellidoPaterno() {
	        return apellidoPaterno;
	    }

	    public void setApellidoPaterno(String apellidoPaterno) {
	        this.apellidoPaterno = apellidoPaterno;
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

	    public String getNoCuenta() {
	        return noCuenta;
	    }

	    public void setNoCuenta(String noCuenta) {
	        this.noCuenta = noCuenta;
	    }

	    public String getNss() {
	        return nss;
	    }

	    public void setNss(String nss) {
	        this.nss = nss;
	    }

	    public String getCurp() {
	        return curp;
	    }

	    public void setCurp(String curp) {
	        this.curp = curp;
	    }

	    public String getRfc() {
	        return rfc;
	    }

	    public void setRfc(String rfc) {
	        this.rfc = rfc;
	    }

	    public String getPoliza() {
	        return poliza;
	    }

	    public void setPoliza(String poliza) {
	        this.poliza = poliza;
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

		public String getTipoConsulta() {
			return tipoConsulta;
		}

		public void setTipoConsulta(String tipoConsulta) {
			this.tipoConsulta = tipoConsulta;
		}

		public String getCustomerID() {
			return customerID;
		}

		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}

	


}
