package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveTareaMapeoLinea implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_LINEA")
	    private Long idABCConfigMapeoLinea;

	    @Column(name = "ID_CFG_TAREA_LINEA")
	    private Long idCFGTareaLinea;

	    public LlaveTareaMapeoLinea() {}

	    public LlaveTareaMapeoLinea(Long idABCConfigMapeoLinea, Long idABCCatColumna) {
	        this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	        this.idCFGTareaLinea = idCFGTareaLinea;
	    }


	    public Long getIdABCConfigMapeoLinea() {
			return idABCConfigMapeoLinea;
		}

		public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
			this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
		}

		

		/**
		 * @return the idCFGTareaLinea
		 */
		public Long getIdCFGTareaLinea() {
			return idCFGTareaLinea;
		}

		/**
		 * @param idCFGTareaLinea the idCFGTareaLinea to set
		 */
		public void setIdCFGTareaLinea(Long idCFGTareaLinea) {
			this.idCFGTareaLinea = idCFGTareaLinea;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveTareaMapeoLinea)) return false;
	        LlaveTareaMapeoLinea that = (LlaveTareaMapeoLinea) o;
	        return Objects.equals(idABCConfigMapeoLinea, that.idABCConfigMapeoLinea)
	            && Objects.equals(idCFGTareaLinea, that.idCFGTareaLinea);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoLinea, idCFGTareaLinea);
	    }
	}



