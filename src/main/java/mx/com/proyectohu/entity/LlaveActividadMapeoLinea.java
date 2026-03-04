package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveActividadMapeoLinea implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_LINEA")
	    private Long idABCConfigMapeoLinea;

	    @Column(name = "ID_ACTIVIDAD_LINEA")
	    private Long idActividadLinea;

	    public LlaveActividadMapeoLinea() {}

	    public LlaveActividadMapeoLinea(Long idABCConfigMapeoLinea, Long idABCCatColumna) {
	        this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	        this.idActividadLinea = idActividadLinea;
	    }


	    public Long getIdABCConfigMapeoLinea() {
			return idABCConfigMapeoLinea;
		}

		public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
			this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
		}

		/**
		 * @return the idActividadLinea
		 */
		public Long getIdActividadLinea() {
			return idActividadLinea;
		}

		/**
		 * @param idActividadLinea the idActividadLinea to set
		 */
		public void setIdActividadLinea(Long idActividadLinea) {
			this.idActividadLinea = idActividadLinea;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveActividadMapeoLinea)) return false;
	        LlaveActividadMapeoLinea that = (LlaveActividadMapeoLinea) o;
	        return Objects.equals(idABCConfigMapeoLinea, that.idABCConfigMapeoLinea)
	            && Objects.equals(idActividadLinea, that.idActividadLinea);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoLinea, idActividadLinea);
	    }
	}



