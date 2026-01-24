package mx.com.proyectohu.mapper;

import org.mapstruct.Mapper;

import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;

@Mapper(componentModel = "spring")
public interface MapeoLineasMapper {
	
	MapeoLineaResponseDTO  llenarDTO(ABCConfigMapeoLineaEntity entity);

}
