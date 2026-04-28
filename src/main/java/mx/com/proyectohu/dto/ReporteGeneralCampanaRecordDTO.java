package mx.com.proyectohu.dto;

import java.time.LocalDateTime;
import java.util.Date;




public record ReporteGeneralCampanaRecordDTO(
		Long idTareaCampana,
		String idCampana,
		String lineaDeNegocio,
		String nombreCampana,
		Long registros,
		LocalDateTime  fecha 
		
		) {



}


