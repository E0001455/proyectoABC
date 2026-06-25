package mx.com.proyectohu.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SYNONMID_TTABCTRA_BITACORA_EXTENSION_PERFIL")
public class BitacoraExtencionPerfilEntity {

    @Id
    @Column(name = "ID_BITACORA_EXTENSION_PERFIL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EXTENSION_PERFIL", nullable = false)
    private ExtensionPerfilEntity extensionPerfilEntity;

    @ManyToOne
    @JoinColumn(name = "ID_ESTATUS_ABC")
    private EstatusABCEntity estatus;

    @Column(name = "FDFECHACREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "FCDETALLE")
    private String detalle;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExtensionPerfilEntity getExtensionPerfilEntity() {
		return extensionPerfilEntity;
	}

	public void setExtensionPerfilEntity(ExtensionPerfilEntity extensionPerfilEntity) {
		this.extensionPerfilEntity = extensionPerfilEntity;
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