package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveMapeoCampanaColumna implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_CAMPANA")
	    private Long idABCConfigMapeoCampana;

	    @Column(name = "ID_COLUMNA_CAMPANA")
	    private Long idABCCatColumna;

	    public LlaveMapeoCampanaColumna() {}

	    public LlaveMapeoCampanaColumna(Long idABCConfigMapeoCampana, Long idABCCatColumna) {
	        this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
	        this.idABCCatColumna = idABCCatColumna;
	    }


	    public Long getIdABCConfigMapeoCampana() {
			return idABCConfigMapeoCampana;
		}

		public void setIdABCConfigMapeoCampana(Long idABCConfigMapeoCampana) {
			this.idABCConfigMapeoCampana = idABCConfigMapeoCampana;
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
	        if (!(o instanceof LlaveMapeoCampanaColumna)) return false;
	        LlaveMapeoCampanaColumna that = (LlaveMapeoCampanaColumna) o;
	        return Objects.equals(idABCConfigMapeoCampana, that.idABCConfigMapeoCampana)
	            && Objects.equals(idABCCatColumna, that.idABCCatColumna);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoCampana, idABCCatColumna);
	    }
	}



