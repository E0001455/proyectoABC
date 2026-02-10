package mx.com.proyectohu.dto;

import java.util.Date;




public record MapeoCampanaRecordDTO(
		Long 	idABCConfigMapeoCampana,
		Long 	idABCCatLineaNegocio,
		Long 	idABCCatCampana,
		Boolean bolActivo,
		String 	nombre,
		String 	descripcion,
		Date 	fecCreacion,
		Date 	fecUltModificacion,
		Boolean bolValidacion,
		Boolean bolEnvio,
		Long 	columnas
		) {



}


