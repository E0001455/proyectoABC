package mx.com.proyectohu.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.repository.CatalogosRepository;
import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.entity.CatalogosEntity;
import mx.com.proyectohu.mapper.CatalogosMapper;


@Service
public class CatalogosService {

	@Autowired
	public CatalogosRepository catalogosRepository;
	
	@Autowired
	public CatalogosMapper   catalogosMapper;
	
	private final JdbcTemplate jdbcTemplate;

	public CatalogosService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public List<CatalogosResponseDTO>  consultarCatalogo(String codigo) {
		
		 List<CatalogosResponseDTO>  catalogosResponseDTOLista= new ArrayList<CatalogosResponseDTO>();
		
		Optional<CatalogosEntity> catalogosEntity = catalogosRepository.findByCodigo(codigo);
		
		if(catalogosEntity.get().getBolActivo()) {
			
			 String sql = "SELECT ID_"+catalogosEntity.get().getNombre()+" AS ID "+",BOL_ACTIVO,CODIGO,NOMBRE,FEC_CREACION,FEC_ULT_MODIFICACION FROM " + catalogosEntity.get().getNombre()+ " WHERE BOL_ACTIVO = 1";

			  catalogosResponseDTOLista= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CatalogosResponseDTO.class));
			 
	
		}
		

		return catalogosResponseDTOLista;
	}
	
	


}
