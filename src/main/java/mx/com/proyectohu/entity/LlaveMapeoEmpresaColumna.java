package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveMapeoEmpresaColumna implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_MAPEO_EMPRESA")
	    private Long idMapeoEmpresa;

	    @Column(name = "ID_COLUMNA_EMPRESA")
	    private Long idColumnaEmpresa;

	    public LlaveMapeoEmpresaColumna() {}

	    public LlaveMapeoEmpresaColumna(Long idMapeoEmpresa, Long idColumnaEmpresa) {
	        this.idMapeoEmpresa = idMapeoEmpresa;
	        this.idColumnaEmpresa = idColumnaEmpresa;
	    }


	 

		/**
		 * @return the idMapeoEmpresa
		 */
		public Long getIdMapeoEmpresa() {
			return idMapeoEmpresa;
		}

		/**
		 * @param idMapeoEmpresa the idMapeoEmpresa to set
		 */
		public void setIdMapeoEmpresa(Long idMapeoEmpresa) {
			this.idMapeoEmpresa = idMapeoEmpresa;
		}

		/**
		 * @return the idColumnaEmpresa
		 */
		public Long getIdColumnaEmpresa() {
			return idColumnaEmpresa;
		}

		/**
		 * @param idColumnaEmpresa the idColumnaEmpresa to set
		 */
		public void setIdColumnaEmpresa(Long idColumnaEmpresa) {
			this.idColumnaEmpresa = idColumnaEmpresa;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveMapeoEmpresaColumna)) return false;
	        LlaveMapeoEmpresaColumna that = (LlaveMapeoEmpresaColumna) o;
	        return Objects.equals(idMapeoEmpresa, that.idMapeoEmpresa)
	            && Objects.equals(idColumnaEmpresa, that.idColumnaEmpresa);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idMapeoEmpresa, idColumnaEmpresa);
	    }
	}



