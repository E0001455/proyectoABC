package mx.com.proyectohu.mapper;

import org.mapstruct.Mapper;

import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;


@Mapper(componentModel = "spring")
public interface MapeoLineasColumnaMapper {
	
	MapeoLineaColumnaResponseDTO  llenarDTO(ABCMapeoLineaColumnaEntity entity);

}
