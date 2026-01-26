package mx.com.proyectohu.component;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import mx.com.proyectohu.interfaces.CatalogoInterface;
import mx.com.proyectohu.notacion.CatalogoNotacion;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class CatalogosMapComponent {
	
	    private final Map<String, Class<? extends CatalogoInterface>> catalogosMap = new HashMap<>();

	    @PersistenceContext
	    private EntityManager entityManager;

	    @PostConstruct
	    public void init() {

	        Metamodel metamodel = entityManager.getMetamodel();

	        for (EntityType<?> entityType : metamodel.getEntities()) {

	            Class<?> claseEntidad = entityType.getJavaType();

	            
	            if (!claseEntidad.isAnnotationPresent(CatalogoNotacion.class)) {
	                continue;
	            }

	            
	            if (!CatalogoInterface.class.isAssignableFrom(claseEntidad)) {
	                throw new IllegalStateException(
	                		claseEntidad.getName() + " tiene @CatalogoNotacion pero no implementa CatalogoInterface"
	                );
	            }

	       
	            Table tabla = claseEntidad.getAnnotation(Table.class);
	            if (tabla == null || tabla.name().isBlank()) {
	                throw new IllegalStateException(
	                		claseEntidad.getName() + " tiene @CatalogoNotacion pero no tiene @Table(name)"
	                );
	            }

	            String nombreTabla = tabla.name().toUpperCase();

	            catalogosMap.put(nombreTabla, (Class<? extends CatalogoInterface>) claseEntidad);
	        }
	    }

	    public Class<? extends CatalogoInterface> obtenerNombreTabla(String nombreTabla) {
	        return catalogosMap.get(nombreTabla.toUpperCase());
	    }
	}

	
	
	
	


