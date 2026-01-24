package mx.com.proyectohu.mapper;

import org.mapstruct.Mapper;

import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;



@Mapper(componentModel = "spring")
public interface MapeoCampanaColumnaMapper {
	
	MapeoCampanaColumnaResponseDTO  llenarDTO(ABCMapeoCampanaColumnaEntity entity);

}
