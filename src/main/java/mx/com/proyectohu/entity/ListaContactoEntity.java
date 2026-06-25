package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYNONMID_TTABCTRA_LISTA_CONTACTO")

public class ListaContactoEntity implements Serializable {

    @Id
    @Column(name = "ID_LISTA_CONTACTO", nullable = false)
    private Long idListaContacto;

    @Column(name = "FCRIID_")
    private String riid;

    @Column(name = "FCNOMBRE")
    private String nombre;

    @Column(name = "FCAPELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "FCAPELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "FCEMAIL_ADDRESS_")
    private String emailAddress;

    @Column(name = "FCMOBILE_NUMBER_")
    private String mobileNumber;

    @Column(name = "FCMOBILE_COUNTRY_")
    private String mobileCountry;

    @Column(name = "FCLINEA_DE_NEGOCIO")
    private String lineaDeNegocio;

    @Column(name = "FCNUMERO_DE_CUENTA")
    private String numeroDeCuenta;

    @Column(name = "FCNSS")
    private String nss;

    @Column(name = "FCCURP")
    private String curp;

    @Column(name = "FCRFC")
    private String rfc;

    @Column(name = "FCDATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "FCPOSTAL_STREET_1_")
    private String postalStreet1;

    @Column(name = "FCPOSTAL_STREET_2_")
    private String postalStreet2;

    @Column(name = "FCCITY_")
    private String city;

    @Column(name = "FCSTATE_")
    private String state;

    @Column(name = "FCPOSTAL_CODE_")
    private String postalCode;

    @Column(name = "FCPOLIZA")
    private String poliza;

    @Column(name = "FCSUSPENSION_LOGICA")
    private String suspensionLogica;

    @Column(name = "FCUSUARIO_PRUEBA")
    private String usuarioPrueba;

    @Column(name = "FCGENERO")
    private String genero;
    
    @Column(name = "FCCUSTOMER_ID_")
    private String customerid;
    
    @OneToMany(mappedBy = "listaContacto", fetch = FetchType.LAZY)
    private List<BitacoraListaContactoEntity> bitacoras;

    

	public Long getIdListaContacto() {
		return idListaContacto;
	}

	public void setIdListaContacto(Long idListaContacto) {
		this.idListaContacto = idListaContacto;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileCountry() {
		return mobileCountry;
	}

	public void setMobileCountry(String mobileCountry) {
		this.mobileCountry = mobileCountry;
	}

	public String getLineaDeNegocio() {
		return lineaDeNegocio;
	}

	public void setLineaDeNegocio(String lineaDeNegocio) {
		this.lineaDeNegocio = lineaDeNegocio;
	}

	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPostalStreet1() {
		return postalStreet1;
	}

	public void setPostalStreet1(String postalStreet1) {
		this.postalStreet1 = postalStreet1;
	}

	public String getPostalStreet2() {
		return postalStreet2;
	}

	public void setPostalStreet2(String postalStreet2) {
		this.postalStreet2 = postalStreet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getSuspensionLogica() {
		return suspensionLogica;
	}

	public void setSuspensionLogica(String suspensionLogica) {
		this.suspensionLogica = suspensionLogica;
	}

	public String getUsuarioPrueba() {
		return usuarioPrueba;
	}

	public void setUsuarioPrueba(String usuarioPrueba) {
		this.usuarioPrueba = usuarioPrueba;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<BitacoraListaContactoEntity> getBitacoras() {
		return bitacoras;
	}

	public void setBitacoras(List<BitacoraListaContactoEntity> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
    
    
    
    
}