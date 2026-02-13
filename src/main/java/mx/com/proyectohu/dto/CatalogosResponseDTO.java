package mx.com.proyectohu.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogosResponseDTO {
	
	private String codigo;
	
	@JsonProperty("nombre")
	private String nombreCatalogo;
	@JsonProperty("registros")
	private List<RegistrosCatalogosDTO> registrosCatalogosDTOLista;
	
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombreCatalogo
	 */
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	/**
	 * @param nombreCatalogo the nombreCatalogo to set
	 */
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	/**
	 * @return the registrosCatalogosDTOLista
	 */
	public List<RegistrosCatalogosDTO> getRegistrosCatalogosDTOLista() {
		return registrosCatalogosDTOLista;
	}
	/**
	 * @param registrosCatalogosDTOLista the registrosCatalogosDTOLista to set
	 */
	public void setRegistrosCatalogosDTOLista(List<RegistrosCatalogosDTO> registrosCatalogosDTOLista) {
		this.registrosCatalogosDTOLista = registrosCatalogosDTOLista;
	}

	
	
	
	

}
