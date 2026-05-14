package mx.com.proyectohu.entity;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "TTABCTRA_EXTENSION_PERFIL")

public class ExtensionPerfilEntity implements Serializable {

    @Id
    @Column(name = "ID_EXTENSION_PERFIL", nullable = false)
    private Long idExtensionPerfil;

    @Column(name = "FCID_AFORE")
    private String idAfore;

    @Column(name = "FCDESCRIPCION_DE_AFORE")
    private String descripcionDeAfore;

    @Column(name = "FCSIEFORE")
    private String siefore;

    @Column(name = "FCSEGMENTO")
    private String segmento;

    @Column(name = "FCREGIMEN")
    private String regimen;

    @Column(name = "FCID_CLIENTE_AHORRADOR")
    private String idClienteAhorrador;

    @Column(name = "FCID_PRESTAMO_PENSIONADO")
    private String idPrestamoPensionado;

    @Column(name = "FCID_SUSCEPTIBLE_PRESTAMO")
    private String idSusceptiblePrestamo;

    @Column(name = "FCTIPO_PENSION")
    private String tipoPension;

    @Column(name = "FCGRUPO_PAGO")
    private String grupoPago;

    @Column(name = "FCCUSTOMER_ID_")
    private String customerId;

    @Column(name = "FCNUM_LOTE")
    private String numLote;

    @Column(name = "FCNOMBRE_CAMPANA")
    private String nombreCampana;

    @Column(name = "FCID_CAMPANA")
    private String idCampana;

    @Column(name = "FCID_BAJA_CAMBIO")
    private String idBajaCambio;

    @Column(name = "FCFECHA_BAJA_CAMBIO")
    private String fechaBajaCambio;

    @Column(name = "FCREGIMEN_IMSS")
    private String regimenImss;

    @Column(name = "FCSEGMENTO_AFO")
    private String segmentoAfo;

    @Column(name = "FCEDAD")
    private String edad;

    @Column(name = "FCGENERO")
    private String genero;

    @Column(name = "FCLIGA_RSALDOS")
    private String ligaRsaldos;

    @Column(name = "FCLINEA_DE_NEGOCIO")
    private String lineaDeNegocio;

    @Column(name = "FCSEGMENTO_PRE")
    private String segmentoPre;

    @Column(name = "FCFIRST_NAME")
    private String firstName;

    @Column(name = "FCLAST_NAME")
    private String lastName;

    @Column(name = "FCID_COMUNICACION")
    private String idComunicacion;

    @Column(name = "FCDOMICILIO_PREFERENTE")
    private String domicilioPreferente;

    @Column(name = "FCEMPRESA")
    private String empresa;

    @Column(name = "FCSEGMENTO_PROY")
    private String segmentoProy;

    @Column(name = "FCIDPERSONA")
    private String idpersona;

    @Column(name = "FCPATERNO")
    private String paterno;

    @Column(name = "FCLIGA_TITULAR")
    private String ligaTitular;

    @Column(name = "FCINSTITUTO")
    private String instituto;

    @Column(name = "FCTRABAJADOR")
    private String trabajador;

    @Column(name = "FCENTIDAD")
    private String entidad;

    @Column(name = "FCMEDIOS_DIGITALES")
    private String mediosDigitales;

    @Column(name = "FCAPERTURA")
    private String apertura;

    @Column(name = "FCNUMERO_HIJOS")
    private String numeroHijos;

    @Column(name = "FCMASY65")
    private String masy65;

    @Column(name = "FCMENORES")
    private String menores;

    @Column(name = "FCCUENTA_MENOR_1")
    private String cuentaMenor1;

    @Column(name = "FCNOMBRE_HIJO_1")
    private String nombreHijo1;

    @Column(name = "FCLIGA_HIJO_1")
    private String ligaHijo1;

    @Column(name = "FCCUENTA_MENOR_2")
    private String cuentaMenor2;

    @Column(name = "FCNOMBRE_HIJO_2")
    private String nombreHijo2;

    @Column(name = "FCLIGA_HIJO_2")
    private String ligaHijo2;

    @Column(name = "FCCUENTA_MENOR_3")
    private String cuentaMenor3;

    @Column(name = "FCNOMBRE_HIJO_3")
    private String nombreHijo3;

    @Column(name = "FCLIGA_HIJO_3")
    private String ligaHijo3;

    @Column(name = "FCCUENTA_MENOR_4")
    private String cuentaMenor4;

    @Column(name = "FCNOMBRE_HIJO_4")
    private String nombreHijo4;

    @Column(name = "FCLIGA_HIJO_4")
    private String ligaHijo4;

    @Column(name = "FCCUENTA_MENOR_5")
    private String cuentaMenor5;

    @Column(name = "FCNOMBRE_HIJO_5")
    private String nombreHijo5;

    @Column(name = "FCLIGA_HIJO_5")
    private String ligaHijo5;

    @Column(name = "FCCUENTA_MENOR_6")
    private String cuentaMenor6;

    @Column(name = "FCNOMBRE_HIJO_6")
    private String nombreHijo6;

    @Column(name = "FCLIGA_HIJO_6")
    private String ligaHijo6;

    @Column(name = "FCPERFIL")
    private String perfil;

    @Column(name = "FCHIJOS")
    private String hijos;

    @Column(name = "FCESTATUS_EXP")
    private String estatusExp;

    @Column(name = "FCSUCURSAL")
    private String sucursal;

    @Column(name = "FCDOM_SUCURSAL")
    private String domSucursal;
    
    @Column(name = "FCEMAIL_ADDRESS_")
    private String correo;
    
    @Column(name = "FCMOBILE_NUMBER_")
    private String telefono;
    
    
    @Column(name = "FCRIID_")
    private String riid;
    
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

	@OneToMany(mappedBy = "extensionPerfilEntity", fetch = FetchType.LAZY)
    private List<BitacoraExtencionPerfilEntity> bitacoras;
    
	public Long getIdExtensionPerfil() {
		return idExtensionPerfil;
	}

	public void setIdExtensionPerfil(Long idExtensionPerfil) {
		this.idExtensionPerfil = idExtensionPerfil;
	}


	
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

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
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

	public String getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
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

	public List<BitacoraExtencionPerfilEntity> getBitacoras() {
		return bitacoras;
	}

	public void setBitacoras(List<BitacoraExtencionPerfilEntity> bitacoras) {
		this.bitacoras = bitacoras;
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