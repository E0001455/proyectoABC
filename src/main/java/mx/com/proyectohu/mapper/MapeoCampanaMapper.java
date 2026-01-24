package mx.com.proyectohu.mapper;

import org.mapstruct.Mapper;

import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;


@Mapper(componentModel = "spring")
public interface MapeoCampanaMapper {
	
	MapeoCampanaResponseDTO  llenarCampanaDTO(ABCConfigMapeoCampanaEntity entity);

}