package mx.com.proyectohu.entity;

import java.io.Serializable;
import java.sql.Timestamp;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="TTABCTRA_LISTA_CONTACTO_RESPUESTA" )
public class ListaContactoRespuestaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private LlaveListaContactoRespuesta  llaveListaContactoRespuesta;
	
	@Column(name = "FDFECHACREACION")
	private Timestamp fechaCreacion;

	/**
	 * @return the llaveListaContactoRespuesta
	 */
	public LlaveListaContactoRespuesta getLlaveListaContactoRespuesta() {
		return llaveListaContactoRespuesta;
	}

	/**
	 * @param llaveListaContactoRespuesta the llaveListaContactoRespuesta to set
	 */
	public void setLlaveListaContactoRespuesta(LlaveListaContactoRespuesta llaveListaContactoRespuesta) {
		this.llaveListaContactoRespuesta = llaveListaContactoRespuesta;
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
