package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.HorarioActividadLineaRequestDTO;
import mx.com.proyectohu.service.HorarioActividadLineaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class HorarioActividadLineaController {

	@Autowired
	public HorarioActividadLineaService horarioActividadLineaService;



	@PostMapping("/lineas/actividades/{idActividadMapeo}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadLinea(@PathVariable Long idActividadMapeo, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {

		horarioActividadLineaService.registrarHorarioActividadLinea(idActividadMapeo,horarioActividadLineaRequestDTO);

		return ResponseEntity.ok("creado");
	}

/*
	@GetMapping("/lineas/actividades/{idActividad}/horarios")
	public ResponseEntity<?> consultarHorariosActividadesLinea(@PathVariable Long idActividad) {


			List<HorarioActividadLineaResponseDTO> horarioActividadLineaResponseDTO = new ArrayList<HorarioActividadLineaResponseDTO>();

			horarioActividadLineaResponseDTO = horarioActividadLineaService.consultarHorariosActividadesLinea(idActividad);

			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
	}
	
	@PatchMapping("/lineas/actividades/{idActividad}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {
		
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();
		horarioActividadLineaResponseDTO = horarioActividadLineaService.activar(idActividad,horarioActividadLineaRequestDTO);

		if (horarioActividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/lineas/actividades/{idActividad}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO){
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();
		horarioActividadLineaResponseDTO = horarioActividadLineaService.desactivar(idActividad,horarioActividadLineaRequestDTO);

		if (horarioActividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

*/






}
