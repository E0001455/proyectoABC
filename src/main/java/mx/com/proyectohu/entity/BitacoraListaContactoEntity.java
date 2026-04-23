package mx.com.proyectohu.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TTABCTRA_BITACORA_LISTA_CONTACTO")
public class BitacoraListaContactoEntity {

    @Id
    @Column(name = "ID_BITACORA_LISTA_CONTACTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_LISTA_CONTACTO", nullable = false)
    private ListaContactoEntity listaContacto;

    @ManyToOne
    @JoinColumn(name = "ID_ESTATUS_ABC")
    private EstatusABCEntity estatus;

    @Column(name = "FDFECHACREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "DETALLE")
    private String detalle;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ListaContactoEntity getListaContacto() {
		return listaContacto;
	}

	public void setListaContacto(ListaContactoEntity listaContacto) {
		this.listaContacto = listaContacto;
	}



	public EstatusABCEntity getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusABCEntity estatus) {
		this.estatus = estatus;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	

   
}