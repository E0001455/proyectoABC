package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveHorarioActividadCampana implements Serializable {

	  
	private static final long serialVersionUID = 1L;
	
	
		@Column(name = "ID_ACTIVIDAD_MAPEO_CAMPANA")
		private Long 	idActividadMapeoCampana;

		@Column(name = "ID_ACTIVIDAD")
	    private Long idActividad;

	    @Column(name = "ID_DIA")
	    private Long idDia;

	    @Column(name = "ID_HORA")
	    private Long idHora;

	    public LlaveHorarioActividadCampana() {}

	    public LlaveHorarioActividadCampana(Long idActividadMapeoCampana,Long idActividad, Long idDia, Long idHora) {
	    	 this.idActividadMapeoCampana = idActividadMapeoCampana;
	    	this.idActividad = idActividad;
	        this.idDia = idDia;
	        this.idHora = idHora;
	    }

	    
		
		/**
		 * @return the idActividadMapeoCampana
		 */
		public Long getIdActividadMapeoCampana() {
			return idActividadMapeoCampana;
		}

		/**
		 * @param idActividadMapeoCampana the idActividadMapeoCampana to set
		 */
		public void setIdActividadMapeoCampana(Long idActividadMapeoCampana) {
			this.idActividadMapeoCampana = idActividadMapeoCampana;
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

		public Long getIdDia() {
			return idDia;
		}

		public void setIdDia(Long idDia) {
			this.idDia = idDia;
		}

		public Long getIdHora() {
			return idHora;
		}

		public void setIdHora(Long idHora) {
			this.idHora = idHora;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveHorarioActividadCampana)) return false;
	        LlaveHorarioActividadCampana that = (LlaveHorarioActividadCampana) o;
	        return Objects.equals(idActividadMapeoCampana, that.idActividadMapeoCampana)
	        	&& Objects.equals(idActividad, that.idActividad)
	            && Objects.equals(idDia, that.idDia)
	            && Objects.equals(idHora, that.idHora);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idActividadMapeoCampana,idActividad, idDia,idHora);
	    }
	}



