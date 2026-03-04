package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadLineaResponseDTO;
import mx.com.proyectohu.dto.ActividadLineaRequestDTO;
import mx.com.proyectohu.dto.ActividadLineaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaService;
import mx.com.proyectohu.service.HorarioActividadLineaService;
import mx.com.proyectohu.service.ActividadLineaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class HorarioActividadLineaController {

	@Autowired
	public HorarioActividadLineaService horarioActividadLineaService;



	@PostMapping("/lineas/actividades/{idActividad}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadLinea(@PathVariable Long idActividad, @RequestBody HorarioActividadLineaRequestDTO horarioActividadLineaRequestDTO) {

		horarioActividadLineaService.registrarHorarioActividadLinea(idActividad,horarioActividadLineaRequestDTO);

		return ResponseEntity.ok("creado");
	}


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








}
