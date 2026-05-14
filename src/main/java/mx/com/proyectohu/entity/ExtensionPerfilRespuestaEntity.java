package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.json.JSONObject;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCTRA_EXTENSION_PERFIL_RESPUESTA" )
public class ExtensionPerfilRespuestaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private LlaveExtensionPerfilRespuesta  llaveExtensionPerfilRespuesta;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fechaCreacion;

	/**
	 * @return the llaveExtensionPerfilRespuesta
	 */
	public LlaveExtensionPerfilRespuesta getLlaveExtensionPerfilRespuesta() {
		return llaveExtensionPerfilRespuesta;
	}

	/**
	 * @param llaveExtensionPerfilRespuesta the llaveExtensionPerfilRespuesta to set
	 */
	public void setLlaveExtensionPerfilRespuesta(LlaveExtensionPerfilRespuesta llaveExtensionPerfilRespuesta) {
		this.llaveExtensionPerfilRespuesta = llaveExtensionPerfilRespuesta;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



}
