package mx.com.proyectohu.dto;

import java.time.LocalDateTime;




public record ReporteGeneralCampanaRecordDTO(
		Long idTareaCampana,
		String idCampana,
		String lineaDeNegocio,
		String nombreCampana,
		Long registros,
		LocalDateTime  fecha 
		
		) {



}


