package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveTareaHorarioCampana implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_CFG_TAREA_CAMPANA")
	    private Long idCFGTareaCampana;

	    @Column(name = "ID_DIA")
	    private Long idDia;

	    @Column(name = "ID_HORA")
	    private Long idHora;

	    public LlaveTareaHorarioCampana() {}

	    public LlaveTareaHorarioCampana(Long idCFGTareaCampana, Long idDia, Long idHora) {
	        this.idCFGTareaCampana = idCFGTareaCampana;
	        this.idDia = idDia;
	        this.idHora = idHora;
	    }


	 
		
		
	

		public Long getIdCFGTareaCampana() {
			return idCFGTareaCampana;
		}

		public void setIdCFGTareaCampana(Long idCFGTareaCampana) {
			this.idCFGTareaCampana = idCFGTareaCampana;
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
	        if (!(o instanceof LlaveTareaHorarioCampana)) return false;
	        LlaveTareaHorarioCampana that = (LlaveTareaHorarioCampana) o;
	        return Objects.equals(idCFGTareaCampana, that.idCFGTareaCampana)
	            && Objects.equals(idDia, that.idDia)
	            && Objects.equals(idHora, that.idHora);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idCFGTareaCampana, idDia,idHora);
	    }
	}



