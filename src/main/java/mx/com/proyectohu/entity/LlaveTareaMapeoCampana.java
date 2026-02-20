package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveTareaMapeoCampana implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_CAMPANA")
	    private Long idABCConfigMapeoCampana;

	    @Column(name = "ID_CFG_TAREA_CAMPANA")
	    private Long idCFGTareaCampana;

	    public LlaveTareaMapeoCampana() {}

	    public LlaveTareaMapeoCampana(Long idABCConfigMapeoCampana, Long idABCCatColumna) {
	        this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
	        this.idCFGTareaCampana = idCFGTareaCampana;
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
		 * @return the idCFGTareaCampana
		 */
		public Long getIdCFGTareaCampana() {
			return idCFGTareaCampana;
		}

		/**
		 * @param idCFGTareaCampana the idCFGTareaCampana to set
		 */
		public void setIdCFGTareaCampana(Long idCFGTareaCampana) {
			this.idCFGTareaCampana = idCFGTareaCampana;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveTareaMapeoCampana)) return false;
	        LlaveTareaMapeoCampana that = (LlaveTareaMapeoCampana) o;
	        return Objects.equals(idABCConfigMapeoCampana, that.idABCConfigMapeoCampana)
	            && Objects.equals(idCFGTareaCampana, that.idCFGTareaCampana);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoCampana, idCFGTareaCampana);
	    }
	}



