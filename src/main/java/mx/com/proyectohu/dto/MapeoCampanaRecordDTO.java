package mx.com.proyectohu.dto;

import java.sql.Timestamp;





public record MapeoCampanaRecordDTO(
		Long 	idABCConfigMapeoCampana,
		Long 	idABCCatLineaNegocio,
		Long 	idABCCatCampana,
		Boolean bolActivo,
		String 	nombre,
		String 	descripcion,
		Timestamp 	fecCreacion,
		Timestamp 	fecUltModificacion,
		Boolean bolValidacion,
		Boolean bolEnvio,
		Boolean fiDictaminacion,
		Integer fiPorcentajeError,
		Long 	columnas
		) {



}


