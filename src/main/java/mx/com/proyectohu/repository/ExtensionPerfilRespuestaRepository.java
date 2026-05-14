package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ExtensionPerfilRespuestaEntity;
import mx.com.proyectohu.entity.ListaContactoRespuestaEntity;
import mx.com.proyectohu.entity.LlaveExtensionPerfilRespuesta;
import mx.com.proyectohu.entity.LlaveListaContactoRespuesta;

@Repository
public interface  ExtensionPerfilRespuestaRepository extends JpaRepository<ExtensionPerfilRespuestaEntity, LlaveExtensionPerfilRespuesta> {

	
	

}
