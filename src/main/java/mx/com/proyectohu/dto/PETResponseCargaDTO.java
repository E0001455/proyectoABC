package mx.com.proyectohu.dto;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;



public class PETResponseCargaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    private Long idExtensionPerfil;
   
    
	@JsonProperty("lineaNegocio")
    private String lineaDeNegocio;
	
    @JsonProperty("noLote")
    private String numLote;
    
    @JsonProperty("idCliente")
    private String customerId;
    
    private String idAfore;
    
    @JsonProperty("afore")
    private String descripcionDeAfore;
    
    
    private String idClienteAhorrador;
    
    private String idPrestamoPensionado;
    private String idSusceptiblePrestamo;
    private String idBajaCambio;
    private String idComunicacion;
    private String idPersona;
    
    @JsonProperty("nombre")
    private String firstName;
    
    @JsonProperty("apellido")
    private String lastName;
    
    private String correo;
    private String telefono;
    private String siefore;
    private String segmento;
    private String regimen;
    private String tipoPension;
    private String grupoPago;
    private String fechaBajaCambio;
    
    @JsonProperty("regimenIMSS")
    private String regimenImss;
    private String segmentoAfo;
    private String edad;
    private String genero;
    private String ligaRsaldos;
    private String segmentoPre;
    private String domicilioPreferente;
    private String empresa;
    private String segmentoProy;
    private String paterno;
    private String ligaTitular;
    private String instituto;
    private String trabajador;
    private String entidad;
    private String mediosDigitales;
    private String apertura;
    private String numeroHijos;
    private String masy65;
    private String menores;
    private String cuentaMenor1;
    private String nombreHijo1;
    private String ligaHijo1;
    private String cuentaMenor2;
    private String nombreHijo2;
    private String ligaHijo2;
    private String cuentaMenor3;
    private String nombreHijo3;
    private String ligaHijo3;
    private String cuentaMenor4;
    private String nombreHijo4;
    private String ligaHijo4;
    private String cuentaMenor5;
    private String nombreHijo5;
    private String ligaHijo5;
    private String cuentaMenor6;
    private String nombreHijo6;
    private String ligaHijo6;
    private String perfil;
    private String hijos;
    private String estatusExp;
    private String sucursal;
    private String domSucursal;
    private String campana;
   
    
 
    private Long fecha;
  
   
  

 
  
	public String getIdAfore() {
        return idAfore;
    }

    public void setIdAfore(String idAfore) {
        this.idAfore = idAfore;
    }

    public String getDescripcionDeAfore() {
        return descripcionDeAfore;
    }

    public void setDescripcionDeAfore(String descripcionDeAfore) {
        this.descripcionDeAfore = descripcionDeAfore;
    }

    public String getSiefore() {
        return siefore;
    }

    public void setSiefore(String siefore) {
        this.siefore = siefore;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
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

    public String getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(String tipoPension) {
        this.tipoPension = tipoPension;
    }

    public String getGrupoPago() {
        return grupoPago;
    }

    public void setGrupoPago(String grupoPago) {
        this.grupoPago = grupoPago;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }
  
    public String getIdBajaCambio() {
        return idBajaCambio;
    }

    public void setIdBajaCambio(String idBajaCambio) {
        this.idBajaCambio = idBajaCambio;
    }

    public String getFechaBajaCambio() {
        return fechaBajaCambio;
    }

    public void setFechaBajaCambio(String fechaBajaCambio) {
        this.fechaBajaCambio = fechaBajaCambio;
    }

    public String getRegimenImss() {
        return regimenImss;
    }

    public void setRegimenImss(String regimenImss) {
        this.regimenImss = regimenImss;
    }

    public String getSegmentoAfo() {
        return segmentoAfo;
    }

    public void setSegmentoAfo(String segmentoAfo) {
        this.segmentoAfo = segmentoAfo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLigaRsaldos() {
        return ligaRsaldos;
    }

    public void setLigaRsaldos(String ligaRsaldos) {
        this.ligaRsaldos = ligaRsaldos;
    }

    public String getLineaDeNegocio() {
        return lineaDeNegocio;
    }

    public void setLineaDeNegocio(String lineaDeNegocio) {
        this.lineaDeNegocio = lineaDeNegocio;
    }

    public String getSegmentoPre() {
        return segmentoPre;
    }

    public void setSegmentoPre(String segmentoPre) {
        this.segmentoPre = segmentoPre;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdComunicacion() {
        return idComunicacion;
    }

    public void setIdComunicacion(String idComunicacion) {
        this.idComunicacion = idComunicacion;
    }

    public String getDomicilioPreferente() {
        return domicilioPreferente;
    }

    public void setDomicilioPreferente(String domicilioPreferente) {
        this.domicilioPreferente = domicilioPreferente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSegmentoProy() {
        return segmentoProy;
    }

    public void setSegmentoProy(String segmentoProy) {
        this.segmentoProy = segmentoProy;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getLigaTitular() {
        return ligaTitular;
    }

    public void setLigaTitular(String ligaTitular) {
        this.ligaTitular = ligaTitular;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getMediosDigitales() {
        return mediosDigitales;
    }

    public void setMediosDigitales(String mediosDigitales) {
        this.mediosDigitales = mediosDigitales;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(String numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public String getMasy65() {
        return masy65;
    }

    public void setMasy65(String masy65) {
        this.masy65 = masy65;
    }

    public String getMenores() {
        return menores;
    }

    public void setMenores(String menores) {
        this.menores = menores;
    }

    public String getCuentaMenor1() {
        return cuentaMenor1;
    }

    public void setCuentaMenor1(String cuentaMenor1) {
        this.cuentaMenor1 = cuentaMenor1;
    }

    public String getNombreHijo1() {
        return nombreHijo1;
    }

    public void setNombreHijo1(String nombreHijo1) {
        this.nombreHijo1 = nombreHijo1;
    }

    public String getLigaHijo1() {
        return ligaHijo1;
    }

    public void setLigaHijo1(String ligaHijo1) {
        this.ligaHijo1 = ligaHijo1;
    }

    public String getCuentaMenor2() {
        return cuentaMenor2;
    }

    public void setCuentaMenor2(String cuentaMenor2) {
        this.cuentaMenor2 = cuentaMenor2;
    }

    public String getNombreHijo2() {
        return nombreHijo2;
    }

    public void setNombreHijo2(String nombreHijo2) {
        this.nombreHijo2 = nombreHijo2;
    }

    public String getLigaHijo2() {
        return ligaHijo2;
    }

    public void setLigaHijo2(String ligaHijo2) {
        this.ligaHijo2 = ligaHijo2;
    }

    public String getCuentaMenor3() {
        return cuentaMenor3;
    }

    public void setCuentaMenor3(String cuentaMenor3) {
        this.cuentaMenor3 = cuentaMenor3;
    }

    public String getNombreHijo3() {
        return nombreHijo3;
    }

    public void setNombreHijo3(String nombreHijo3) {
        this.nombreHijo3 = nombreHijo3;
    }

    public String getLigaHijo3() {
        return ligaHijo3;
    }

    public void setLigaHijo3(String ligaHijo3) {
        this.ligaHijo3 = ligaHijo3;
    }

    public String getCuentaMenor4() {
        return cuentaMenor4;
    }

    public void setCuentaMenor4(String cuentaMenor4) {
        this.cuentaMenor4 = cuentaMenor4;
    }

    public String getNombreHijo4() {
        return nombreHijo4;
    }

    public void setNombreHijo4(String nombreHijo4) {
        this.nombreHijo4 = nombreHijo4;
    }

    public String getLigaHijo4() {
        return ligaHijo4;
    }

    public void setLigaHijo4(String ligaHijo4) {
        this.ligaHijo4 = ligaHijo4;
    }

    public String getCuentaMenor5() {
        return cuentaMenor5;
    }

    public void setCuentaMenor5(String cuentaMenor5) {
        this.cuentaMenor5 = cuentaMenor5;
    }

    public String getNombreHijo5() {
        return nombreHijo5;
    }

    public void setNombreHijo5(String nombreHijo5) {
        this.nombreHijo5 = nombreHijo5;
    }

    public String getLigaHijo5() {
        return ligaHijo5;
    }

    public void setLigaHijo5(String ligaHijo5) {
        this.ligaHijo5 = ligaHijo5;
    }

    public String getCuentaMenor6() {
        return cuentaMenor6;
    }

    public void setCuentaMenor6(String cuentaMenor6) {
        this.cuentaMenor6 = cuentaMenor6;
    }

    public String getNombreHijo6() {
        return nombreHijo6;
    }

    public void setNombreHijo6(String nombreHijo6) {
        this.nombreHijo6 = nombreHijo6;
    }

    public String getLigaHijo6() {
        return ligaHijo6;
    }

    public void setLigaHijo6(String ligaHijo6) {
        this.ligaHijo6 = ligaHijo6;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public String getEstatusExp() {
        return estatusExp;
    }

    public void setEstatusExp(String estatusExp) {
        this.estatusExp = estatusExp;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getDomSucursal() {
        return domSucursal;
    }

    public void setDomSucursal(String domSucursal) {
        this.domSucursal = domSucursal;
    }



	/**
	 * @return the fecha
	 */
	public Long getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}

	/**
	 * @return the idExtensionPerfil
	 */
	public Long getIdExtensionPerfil() {
		return idExtensionPerfil;
	}

	/**
	 * @param idExtensionPerfil the idExtensionPerfil to set
	 */
	public void setIdExtensionPerfil(Long idExtensionPerfil) {
		this.idExtensionPerfil = idExtensionPerfil;
	}

	


}