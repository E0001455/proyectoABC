package mx.com.proyectohu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class LlaveExtensionPerfilRespuesta implements Serializable {

	  
	private static final long serialVersionUID = 1L;

		@Column(name = "ID_EXTENSION_PERFIL")
	    private Long idExtensionPerfil;

	    @Column(name = "ID_RESPUESTA_TAREA_CAMPANA")
	    private Long idRespuestaTareaCampana;

	    public LlaveExtensionPerfilRespuesta() {}

	    public LlaveExtensionPerfilRespuesta(Long idExtensionPerfil, Long idRespuestaTareaCampana) {
	        this.idExtensionPerfil = idExtensionPerfil;
	        this.idRespuestaTareaCampana = idRespuestaTareaCampana;
	    }

		

		/**
		 * @return the idExtensionPerfil
		 */
		public Long getIdExtensionPerfil() {
			return idExtensionPerfil;
		}

		/**
		 * @param idExtensionPerfil the idExtensionPerfil to set
		 */
		public void setIdExtensionPerfil(Long idExtensionPerfil) {
			this.idExtensionPerfil = idExtensionPerfil;
		}

		/**
		 * @return the idRespuestaTareaCampana
		 */
		public Long getIdRespuestaTareaCampana() {
			return idRespuestaTareaCampana;
		}

		/**
		 * @param idRespuestaTareaCampana the idRespuestaTareaCampana to set
		 */
		public void setIdRespuestaTareaCampana(Long idRespuestaTareaCampana) {
			this.idRespuestaTareaCampana = idRespuestaTareaCampana;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LlaveExtensionPerfilRespuesta)) return false;
	        LlaveExtensionPerfilRespuesta that = (LlaveExtensionPerfilRespuesta) o;
	        return Objects.equals(idExtensionPerfil, that.idExtensionPerfil)
	            && Objects.equals(idRespuestaTareaCampana, that.idRespuestaTareaCampana);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idExtensionPerfil, idRespuestaTareaCampana);
	    }
	}



