package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class Llavelineacolumna implements Serializable {

	    @Column(name = "ID_ABC_CONFIG_MAPEO_LINEA")
	    private Long idABCConfigMapeoLinea;

	    @Column(name = "ID_ABC_CAT_COLUMNA")
	    private Long idABCCatColumna;

	    public Llavelineacolumna() {}

	    public Llavelineacolumna(Long idABCConfigMapeoLinea, Long idABCCatColumna) {
	        this.idABCConfigMapeoLinea = idABCConfigMapeoLinea;
	        this.idABCCatColumna = idABCCatColumna;
	    }


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Llavelineacolumna)) return false;
	        Llavelineacolumna that = (Llavelineacolumna) o;
	        return Objects.equals(idABCConfigMapeoLinea, that.idABCConfigMapeoLinea)
	            && Objects.equals(idABCCatColumna, that.idABCCatColumna);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idABCConfigMapeoLinea, idABCCatColumna);
	    }
	}



