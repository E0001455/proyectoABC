package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveActividadCampana implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column(name = "ID_ACTIVIDAD_MAPEO_CAMPANA")
	private Long 	idActividadMapeoCampana;

	@Column(name = "ID_ACTIVIDAD")
	private Long 	idActividad;

	
	
	
	
	

	public LlaveActividadCampana() {}

	public LlaveActividadCampana(Long idActividadMapeoCampana, Long idActividad) {
		this.idActividadMapeoCampana = idActividadMapeoCampana;
		this.idActividad = idActividad;
	}
	
	
	public Long getIdActividadMapeoCampana() {
		return idActividadMapeoCampana;
	}

	public void setIdActividadMapeoCampana(Long idActividadMapeoCampana) {
		this.idActividadMapeoCampana = idActividadMapeoCampana;
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
		if (!(o instanceof LlaveActividadCampana)) return false;
		LlaveActividadCampana that = (LlaveActividadCampana) o;
		return Objects.equals(idActividadMapeoCampana, that.idActividadMapeoCampana)
				&& Objects.equals(idActividad, that.idActividad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividadMapeoCampana, idActividad);
	}
}



