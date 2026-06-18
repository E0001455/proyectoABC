package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveActividadLinea implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column(name = "ID_ACTIVIDAD_MAPEO_LINEA")
	private Long 	idActividadMapeoLinea;

	@Column(name = "ID_ACTIVIDAD")
	private Long 	idActividad;

	
	
	
	
	

	public LlaveActividadLinea() {}

	public LlaveActividadLinea(Long idActividadMapeoLinea, Long idActividad) {
		this.idActividadMapeoLinea = idActividadMapeoLinea;
		this.idActividad = idActividad;
	}
	
	


	

	public Long getIdActividadMapeoLinea() {
		return idActividadMapeoLinea;
	}

	public void setIdActividadMapeoLinea(Long idActividadMapeoLinea) {
		this.idActividadMapeoLinea = idActividadMapeoLinea;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LlaveActividadLinea)) return false;
		LlaveActividadLinea that = (LlaveActividadLinea) o;
		return Objects.equals(idActividadMapeoLinea, that.idActividadMapeoLinea)
				&& Objects.equals(idActividad, that.idActividad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividadMapeoLinea, idActividad);
	}
}



