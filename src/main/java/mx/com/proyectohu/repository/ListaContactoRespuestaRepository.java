package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ListaContactoRespuestaEntity;
import mx.com.proyectohu.entity.LlaveListaContactoRespuesta;

@Repository
public interface  ListaContactoRespuestaRepository extends JpaRepository<ListaContactoRespuestaEntity, LlaveListaContactoRespuesta> {

	
	

}
