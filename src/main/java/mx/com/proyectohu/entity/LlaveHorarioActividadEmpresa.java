package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveHorarioActividadEmpresa implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column(name = "ID_ACTIVIDAD_MAPEO_EMPRESA")
	private Long 	idActividadMapeoEmpresa;

	@Column(name = "ID_ACTIVIDAD")
	private Long idActividad;

	@Column(name = "ID_DIA")
	private Long idDia;

	@Column(name = "ID_HORA")
	private Long idHora;

	public LlaveHorarioActividadEmpresa() {}

	public LlaveHorarioActividadEmpresa(Long idActividadMapeoEmpresa, Long idActividad, Long idDia, Long idHora) {
		this.idActividadMapeoEmpresa = idActividadMapeoEmpresa;
		this.idActividad = idActividad;
		this.idDia = idDia;
		this.idHora = idHora;
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

	/**
	 * @return the idDia
	 */
	public Long getIdDia() {
		return idDia;
	}

	/**
	 * @param idDia the idDia to set
	 */
	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	/**
	 * @return the idHora
	 */
	public Long getIdHora() {
		return idHora;
	}

	/**
	 * @param idHora the idHora to set
	 */
	public void setIdHora(Long idHora) {
		this.idHora = idHora;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LlaveHorarioActividadEmpresa)) return false;
		LlaveHorarioActividadEmpresa that = (LlaveHorarioActividadEmpresa) o;
		return Objects.equals(idActividadMapeoEmpresa, that.idActividadMapeoEmpresa)
				&& Objects.equals(idActividad, that.idActividad)
				&& Objects.equals(idDia, that.idDia)
				&& Objects.equals(idHora, that.idHora);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividadMapeoEmpresa,idActividad, idDia,idHora);
	}
}



