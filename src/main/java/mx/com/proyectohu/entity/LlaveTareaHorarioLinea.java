package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveTareaHorarioLinea implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_CFG_TAREA_LINEA")
	    private Long idCFGTareaLinea;

	    @Column(name = "ID_DIA")
	    private Long idDia;

	    @Column(name = "ID_HORA")
	    private Long idHora;

	    public LlaveTareaHorarioLinea() {}

	    public LlaveTareaHorarioLinea(Long idCFGTareaLinea, Long idDia, Long idHora) {
	        this.idCFGTareaLinea = idCFGTareaLinea;
	        this.idDia = idDia;
	        this.idHora = idHora;
	    }


	 
		
		
		public Long getIdCFGTareaLinea() {
			return idCFGTareaLinea;
		}

		public void setIdCFGTareaLinea(Long idCFGTareaLinea) {
			this.idCFGTareaLinea = idCFGTareaLinea;
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
	        if (!(o instanceof LlaveTareaHorarioLinea)) return false;
	        LlaveTareaHorarioLinea that = (LlaveTareaHorarioLinea) o;
	        return Objects.equals(idCFGTareaLinea, that.idCFGTareaLinea)
	            && Objects.equals(idDia, that.idDia)
	            && Objects.equals(idHora, that.idHora);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idCFGTareaLinea, idDia,idHora);
	    }
	}



