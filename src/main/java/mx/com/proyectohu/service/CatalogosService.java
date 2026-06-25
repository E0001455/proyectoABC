package mx.com.proyectohu.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mx.com.proyectohu.repository.CatalogosRepository;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.component.CatalogosDAO;
import mx.com.proyectohu.component.CatalogosMapComponent;
import mx.com.proyectohu.dto.CatalogosRequestDTO;
import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.dto.RegistrosCatalogosDTO;
import mx.com.proyectohu.entity.CatalogosEntity;
import mx.com.proyectohu.interfaces.CatalogoInterface;



@Service
public class CatalogosService {

	@Autowired
	public CatalogosRepository catalogosRepository;

	@Autowired
	public CatalogosDAO catalogosDAO;



	@Autowired
	public CatalogosMapComponent catalogosMapComponent;

	@PersistenceContext
	private EntityManager entityManager;

	private final  Map<String,CatalogosResponseDTO> catalogCacheSimple = new HashMap<String,CatalogosResponseDTO>();
	
	private final Map<String, Map<String, List<CatalogosResponseDTO>>> catalogCache = new HashMap<String, Map<String,List<CatalogosResponseDTO>>>();



	public synchronized Collection<CatalogosResponseDTO> obtenerCatalogoCache() {


		if (!catalogCacheSimple.isEmpty()) {
			return catalogCacheSimple.values();
		}

		Map<String,CatalogosResponseDTO> catalogo = consultarCatalogoBD();
		
		catalogCacheSimple.putAll(catalogo);
		
		return catalogo.values();
	}


	public Map<String, CatalogosResponseDTO>  consultarCatalogoBD() {

		Map<String,CatalogosResponseDTO>  catalogosResponseDTOmap= new HashMap<String, CatalogosResponseDTO>();

		List<CatalogosResponseDTO>  catalogosResponseDTOLista= new ArrayList<CatalogosResponseDTO>();
		List<RegistrosCatalogosDTO> registrosCatalogosDTOLista = new ArrayList<RegistrosCatalogosDTO>();
		//Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo();

		Iterable<CatalogosEntity> catalogosEntityIterable = catalogosRepository.findAll();

		for(CatalogosEntity catalogosEntity:catalogosEntityIterable) {
	

			if(catalogosEntity.getBolActivo()) {

				String idNombreColumna = catalogosDAO.obtenerNombreColumnaId(catalogosEntity.getNombre());

				if (idNombreColumna.equals(null)) {

					continue;

				}



				registrosCatalogosDTOLista = catalogosDAO.obtenerCatalogoRegistro(idNombreColumna, catalogosEntity.getNombre());
				
				CatalogosResponseDTO catalogosResponseDTO = new CatalogosResponseDTO();
				
				catalogosResponseDTO.setCodigo(catalogosEntity.getCodigo());
				catalogosResponseDTO.setNombreCatalogo(catalogosEntity.getNombre().trim().replaceAll("TCABCCAT_", ""));
				
				catalogosResponseDTO.setRegistrosCatalogosDTOLista(registrosCatalogosDTOLista);
			
				
				catalogosResponseDTOmap.put(catalogosEntity.getNombre(), catalogosResponseDTO);
			
			}
		}


		return catalogosResponseDTOmap;
	}









	public synchronized Collection<List<CatalogosResponseDTO>> obtenerCatalogoCache(String codigo) {


		if (catalogCache.containsKey(codigo)) {
			return catalogCache.get(codigo).values();
		}

		Map<String, List<CatalogosResponseDTO>> catalogo = consultarCatalogoBD(codigo);
		catalogCache.put(codigo, catalogo);

		return catalogo.values();
	}


	public Map<String, List<CatalogosResponseDTO>>  consultarCatalogoBD(String codigo) {

		Map<String, List<CatalogosResponseDTO>>  catalogosResponseDTOmap= new HashMap<String, List<CatalogosResponseDTO>>();
		List<CatalogosResponseDTO>  catalogosResponseDTOLista= new ArrayList<CatalogosResponseDTO>();

		Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo(codigo);

		if(catalogosEntity.get().getBolActivo()) {

			String idNombreColumna = catalogosDAO.obtenerNombreColumnaId(catalogosEntity.get().getNombre());

			if (idNombreColumna.equals(null)) {

				return catalogosResponseDTOmap;

			}



			catalogosResponseDTOLista = catalogosDAO.obtenerCatalogo(idNombreColumna, catalogosEntity.get().getNombre());

			catalogosResponseDTOmap.put(catalogosEntity.get().getNombre(), catalogosResponseDTOLista);

		}


		return catalogosResponseDTOmap;
	}

	@Transactional
	public Long registrarCatalogo(String codigo, CatalogosRequestDTO catalogosRequestDTO) {
		Long idCatalogo=null;
		CatalogoInterface catalogoInterface=null;


		Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo(codigo);

		if(catalogosEntity.get().getBolActivo()) {

			String idNombreColumna = catalogosDAO.obtenerNombreColumnaId(catalogosEntity.get().getNombre());

			if (idNombreColumna.equals(null)) {

				return idCatalogo=null;

			}


			Class<? extends CatalogoInterface> claseEntidad =  catalogosMapComponent.obtenerNombreTabla(catalogosEntity.get().getNombre());



			if (claseEntidad==null) {
				return idCatalogo=null;
			}

			try {
				catalogoInterface= claseEntidad.getDeclaredConstructor().newInstance();	
				catalogoInterface.setBolActivo(false);
				catalogoInterface.setCodigo(catalogosRequestDTO.getRegistroDTO().getCodigo());
				catalogoInterface.setNombre(catalogosRequestDTO.getRegistroDTO().getNombre());
			
				catalogoInterface.setFecCreacion(FechaUtil.obtenerFechaActual());
				catalogoInterface.setFecUltModificacion(FechaUtil.obtenerFechaActual());



				entityManager.persist(catalogoInterface);

				idCatalogo= catalogoInterface.getId();

			} catch (Exception e) {
				throw new RuntimeException("Error cargando la entidad " + claseEntidad.getName(), e);
			}



		}
		return idCatalogo;

	}

	@Transactional
	public Long actualizar(String codigo, CatalogosRequestDTO catalogosRequestDTO) {
		Long idCatalogo=null;
		CatalogoInterface catalogoInterface=null;


		Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo(codigo);

		if(catalogosEntity.get().getBolActivo()) {

			String idNombreColumna = catalogosDAO.obtenerNombreColumnaId(catalogosEntity.get().getNombre());

			if (idNombreColumna.equals(null)) {

				return idCatalogo=null;

			}


			Class<? extends CatalogoInterface> claseEntidad =  catalogosMapComponent.obtenerNombreTabla(catalogosEntity.get().getNombre());



			if (claseEntidad==null) {
				return idCatalogo=null;
			}

			try {



				catalogosDAO.actualizarCatalogo(catalogosEntity.get().getNombre(),
						catalogosRequestDTO.getRegistroDTO().getCodigo(),catalogosRequestDTO.getRegistroDTO().getNombre(),idNombreColumna,catalogosRequestDTO.getRegistroDTO().getId());

				idCatalogo= catalogosRequestDTO.getRegistroDTO().getId();



			} catch (Exception e) {
				throw new RuntimeException("Error cargando la entidad " + claseEntidad.getName(), e);
			}



		}
		return idCatalogo;

	}


	public synchronized Boolean activarCatalogo(String codigo) {
		Boolean catalogoActivado=false;

		Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo(codigo);

		if(catalogosEntity.get().getBolActivo()) {

			String idNombreColumna = catalogosDAO.obtenerNombreColumnaId(catalogosEntity.get().getNombre());

			if (idNombreColumna.equals(null)) {

				return catalogoActivado;

			}

			catalogosDAO.activarCatalogo(catalogosEntity.get().getNombre());
			Map<String, CatalogosResponseDTO> catalogo = consultarCatalogoBD();

			catalogCacheSimple.putAll(catalogo);
			catalogoActivado=true;

		}
		return catalogoActivado;

	}


}
