package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveActividadMapeoCampana implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_CAMPANA")
	    private Long idABCConfigMapeoCampana;

	    @Column(name = "ID_ACTIVIDAD_CAMPANA")
	    private Long idActividadCampana;

	    public LlaveActividadMapeoCampana() {}

	    public LlaveActividadMapeoCampana(Long idABCConfigMapeoCampana, Long idABCCatColumna) {
	        this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
	        this.idActividadCampana = idActividadCampana;
	    }


		/**
		 * @return the idABCConfigMapeoCampana
		 */
		public Long getIdABCConfigMapeoCampana() {
			return idABCConfigMapeoCampana;
		}

		/**
		 * @param idABCConfigMapeoCampana the idABCConfigMapeoCampana to set
		 */
		public void setIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana) {
			this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
		}

	

		/**
		 * @return the idActividadCampana
		 */
		public Long getIdActividadCampana() {
			return idActividadCampana;
		}

		/**
		 * @param idActividadCampana the idActividadCampana to set
		 */
		public void setIdActividadCampana(Long idActividadCampana) {
			this.idActividadCampana = idActividadCampana;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveActividadMapeoCampana)) return false;
	        LlaveActividadMapeoCampana that = (LlaveActividadMapeoCampana) o;
	        return Objects.equals(idABCConfigMapeoCampana, that.idABCConfigMapeoCampana)
	            && Objects.equals(idActividadCampana, that.idActividadCampana);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoCampana, idActividadCampana);
	    }
	}



