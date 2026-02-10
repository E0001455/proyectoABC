package mx.com.proyectohu.dto;

import java.util.Date;




public record MapeoLineaRecordDTO(
		Long 	idABCConfigMapeoLinea,
		Long 	idABCCatLineaNegocio,
		Boolean bolActivo,
		String 	nombre,
		String 	descripcion,
		Date 	fecCreacion,
		Date 	fecUltModificacion,
		Boolean bolValidacion,
		Boolean bolEnvio,
		Long columnas
		) {



}


