package mx.com.proyectohu.dto;




import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CLResponseDTO {
	
	private Long idTarea;
	   private String lineaNegocio;
	    private String riid;
	    private String nombre;
	    private String apellidoPaterno;
	    private String apellidoMaterno;
	    private String correo;
	    private String telefono1;
	    private String telefono2;
	    private String noCuenta;
	    private String nss;
	    private String curp;
	    private String rfc;
	    private String poliza;
	    private String fechaNacimiento;
	    private String cp;
	    private String calle1;
	    private String calle2;
	    private String ciudad;
	    private String estado;
	    private String genero;
	    private String prueba;
	    private String suspension;
	    private String estatus;
	    private String detalle;
	    
	    private String customerID;
	    private Timestamp fecha;

	 
	   

	    public String getLineaNegocio() {
	        return lineaNegocio;
	    }

	    public void setLineaNegocio(String lineaNegocio) {
	        this.lineaNegocio = lineaNegocio;
	    }

	    public String getRiid() {
	        return riid;
	    }

	    public void setRiid(String riid) {
	        this.riid = riid;
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

	    public String getApellidoMaterno() {
	        return apellidoMaterno;
	    }

	    public void setApellidoMaterno(String apellidoMaterno) {
	        this.apellidoMaterno = apellidoMaterno;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public String getTelefono1() {
	        return telefono1;
	    }

	    public void setTelefono1(String telefono1) {
	        this.telefono1 = telefono1;
	    }

	    public String getTelefono2() {
	        return telefono2;
	    }

	    public void setTelefono2(String telefono2) {
	        this.telefono2 = telefono2;
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

	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public String getCp() {
	        return cp;
	    }

	    public void setCp(String cp) {
	        this.cp = cp;
	    }

	    public String getCalle1() {
	        return calle1;
	    }

	    public void setCalle1(String calle1) {
	        this.calle1 = calle1;
	    }

	    public String getCalle2() {
	        return calle2;
	    }

	    public void setCalle2(String calle2) {
	        this.calle2 = calle2;
	    }

	    public String getCiudad() {
	        return ciudad;
	    }

	    public void setCiudad(String ciudad) {
	        this.ciudad = ciudad;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public String getPrueba() {
	        return prueba;
	    }

	    public void setPrueba(String prueba) {
	        this.prueba = prueba;
	    }

	    public String getSuspension() {
	        return suspension;
	    }

	    public void setSuspension(String suspension) {
	        this.suspension = suspension;
	    }


	

		public String getCustomerID() {
			return customerID;
		}

		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}

		public Timestamp getFecha() {
			return fecha;
		}

		public void setFecha(Timestamp fecha) {
			this.fecha = fecha;
		}

		public String getEstatus() {
			return estatus;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}

		public String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			this.detalle = detalle;
		}

		/**
		 * @return the idTarea
		 */
		public Long getIdTarea() {
			return idTarea;
		}

		/**
		 * @param idTarea the idTarea to set
		 */
		public void setIdTarea(Long idTarea) {
			this.idTarea = idTarea;
		}
		
		
	    
	    
	}