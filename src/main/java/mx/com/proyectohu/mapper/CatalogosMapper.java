package mx.com.proyectohu.mapper;

import org.mapstruct.Mapper;

import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.entity.CatalogosEntity;

@Mapper(componentModel = "spring")
public interface CatalogosMapper {
	
	CatalogosResponseDTO  llenarDTO(CatalogosEntity entity);

}
