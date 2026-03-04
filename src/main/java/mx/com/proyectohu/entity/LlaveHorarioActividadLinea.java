package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveHorarioActividadLinea implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_ACTIVIDAD_LINEA")
	    private Long idActividadLinea;

	    @Column(name = "ID_DIA")
	    private Long idDia;

	    @Column(name = "ID_HORA")
	    private Long idHora;

	    public LlaveHorarioActividadLinea() {}

	    public LlaveHorarioActividadLinea(Long idActividadLinea, Long idDia, Long idHora) {
	        this.idActividadLinea = idActividadLinea;
	        this.idDia = idDia;
	        this.idHora = idHora;
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
	        if (!(o instanceof LlaveHorarioActividadLinea)) return false;
	        LlaveHorarioActividadLinea that = (LlaveHorarioActividadLinea) o;
	        return Objects.equals(idActividadLinea, that.idActividadLinea)
	            && Objects.equals(idDia, that.idDia)
	            && Objects.equals(idHora, that.idHora);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idActividadLinea, idDia,idHora);
	    }
	}



