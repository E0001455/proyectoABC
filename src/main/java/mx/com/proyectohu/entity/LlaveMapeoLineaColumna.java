package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveMapeoLineaColumna implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_ABC_CONFIG_MAPEO_LINEA")
	    private Long idABCConfigMapeoLinea;

	    @Column(name = "ID_ABC_CAT_COLUMNA")
	    private Long idABCCatColumna;

	    public LlaveMapeoLineaColumna() {}

	    public LlaveMapeoLineaColumna(Long idABCConfigMapeoLinea, Long idABCCatColumna) {
	        this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	        this.idABCCatColumna = idABCCatColumna;
	    }


	    public Long getIdABCConfigMapeoLinea() {
			return idABCConfigMapeoLinea;
		}

		public void setIdABCConfigMapeoLinea(Long idABCConfigMapeoLinea) {
			this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
		}

		public Long getIdABCCatColumna() {
			return idABCCatColumna;
		}

		public void setIdABCCatColumna(Long idABCCatColumna) {
			this.idABCCatColumna = idABCCatColumna;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveMapeoLineaColumna)) return false;
	        LlaveMapeoLineaColumna that = (LlaveMapeoLineaColumna) o;
	        return Objects.equals(idABCConfigMapeoLinea, that.idABCConfigMapeoLinea)
	            && Objects.equals(idABCCatColumna, that.idABCCatColumna);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoLinea, idABCCatColumna);
	    }
	}



