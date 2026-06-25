package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.HorarioActividadLineaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaResponseDTO;
import mx.com.proyectohu.service.HorarioActividadLineaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class HorarioActividadLineaController {

	@Autowired
	public HorarioActividadLineaService horarioActividadLineaService;



	@PostMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadLinea(@PathVariable Long idActividad, @PathVariable Long idTipo, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {

		horarioActividadLineaService.registrarHorarioActividadLinea(idActividad,idTipo, horarioActividadLineaRequestDTO);

		return ResponseEntity.ok("creado");
	}


	@GetMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> consultarHorariosActividadesLinea(@PathVariable Long idActividad,@PathVariable Long idTipo) {


			List<HorarioActividadLineaResponseDTO> horarioActividadLineaResponseDTO = new ArrayList<HorarioActividadLineaResponseDTO>();

			horarioActividadLineaResponseDTO = horarioActividadLineaService.consultarHorariosActividadesLinea(idActividad,idTipo);

			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
	}
	
	
	@PatchMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad, @PathVariable Long idTipo,  @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {
		
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();
		horarioActividadLineaResponseDTO = horarioActividadLineaService.activar(idActividad,idTipo,horarioActividadLineaRequestDTO);

		if (horarioActividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/lineas/actividades/{idActividad}/tipos/{idTipo}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @PathVariable Long idTipo, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO){
		HorarioActividadLineaResponseDTO horarioActividadLineaResponseDTO = new HorarioActividadLineaResponseDTO();
		horarioActividadLineaResponseDTO = horarioActividadLineaService.desactivar(idActividad,idTipo,horarioActividadLineaRequestDTO);

		if (horarioActividadLineaResponseDTO.getIdActividadLinea() !=null) {
			return ResponseEntity.ok(horarioActividadLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}








}
