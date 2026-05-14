package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveListaContactoRespuesta implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_LISTA_CONTACTO")
	    private Long idListaContacto;

	    @Column(name = "ID_RESPUESTA_TAREA_LINEA")
	    private Long idRespuestaTareaLinea;

	    public LlaveListaContactoRespuesta() {}

	    public LlaveListaContactoRespuesta(Long idListaContacto, Long idRespuestaTareaLinea) {
	        this.idListaContacto = idListaContacto;
	        this.idRespuestaTareaLinea = idRespuestaTareaLinea;
	    }

		
		/**
		 * @return the idListaContacto
		 */
		public Long getIdListaContacto() {
			return idListaContacto;
		}

		/**
		 * @param idListaContacto the idListaContacto to set
		 */
		public void setIdListaContacto(Long idListaContacto) {
			this.idListaContacto = idListaContacto;
		}

		/**
		 * @return the idRespuestaTareaLinea
		 */
		public Long getIdRespuestaTareaLinea() {
			return idRespuestaTareaLinea;
		}

		/**
		 * @param idRespuestaTareaLinea the idRespuestaTareaLinea to set
		 */
		public void setIdRespuestaTareaLinea(Long idRespuestaTareaLinea) {
			this.idRespuestaTareaLinea = idRespuestaTareaLinea;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveListaContactoRespuesta)) return false;
	        LlaveListaContactoRespuesta that = (LlaveListaContactoRespuesta) o;
	        return Objects.equals(idListaContacto, that.idListaContacto)
	            && Objects.equals(idRespuestaTareaLinea, that.idRespuestaTareaLinea);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idListaContacto, idRespuestaTareaLinea);
	    }
	}



