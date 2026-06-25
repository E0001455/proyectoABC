package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveActividadEmpresa implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column(name = "ID_ACTIVIDAD_MAPEO_EMPRESA")
	private Long 	idActividadMapeoEmpresa;

	@Column(name = "ID_ACTIVIDAD")
	private Long 	idActividad;

	
	
	
	
	

	public LlaveActividadEmpresa() {}

	public LlaveActividadEmpresa(Long idActividadMapeoEmpresa, Long idActividad) {
		this.idActividadMapeoEmpresa = idActividadMapeoEmpresa;
		this.idActividad = idActividad;
	}
	
	


	

	

	/**
	 * @return the idActividadMapeoEmpresa
	 */
	public Long getIdActividadMapeoEmpresa() {
		return idActividadMapeoEmpresa;
	}

	/**
	 * @param idActividadMapeoEmpresa the idActividadMapeoEmpresa to set
	 */
	public void setIdActividadMapeoEmpresa(Long idActividadMapeoEmpresa) {
		this.idActividadMapeoEmpresa = idActividadMapeoEmpresa;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LlaveActividadEmpresa)) return false;
		LlaveActividadEmpresa that = (LlaveActividadEmpresa) o;
		return Objects.equals(idActividadMapeoEmpresa, that.idActividadMapeoEmpresa)
				&& Objects.equals(idActividad, that.idActividad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividadMapeoEmpresa, idActividad);
	}
}



