package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaService;

import mx.com.proyectohu.service.ActividadCampanaService;
import mx.com.proyectohu.service.HorarioActividadCampanaService;

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
public class HorarioActividadCampanaController {

	
	@Autowired
	public HorarioActividadCampanaService horarioActividadCampanaService;



	@PostMapping("/campanas/actividades/{idActividad}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadCampana(@PathVariable Long idActividad, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {

		horarioActividadCampanaService.registrarHorarioActividadCampana(idActividad,horarioActividadCampanaRequestDTO);
		
		return ResponseEntity.ok("creado");
	}


	@GetMapping("/campanas/actividades/{idActividad}/horarios")
	public ResponseEntity<?> consultarHorariosActividadCampanas(@PathVariable Long idActividad) {

			List<HorarioActividadCampanaResponseDTO> horarioActividadCampanaResponseDTOLista = new ArrayList<HorarioActividadCampanaResponseDTO>();

			horarioActividadCampanaResponseDTOLista = horarioActividadCampanaService.consultarHorariosActividadCampanas(idActividad);
		
			return ResponseEntity.ok(horarioActividadCampanaResponseDTOLista);
		

	}
	
	@PatchMapping("/campanas/actividades/{idActividad}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {
		
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
		horarioActividadCampanaResponseDTO = horarioActividadCampanaService.activar(idActividad,horarioActividadCampanaRequestDTO);

		if (horarioActividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(horarioActividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}


	@PatchMapping("/campanas/actividades/{idActividad}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO){
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
		horarioActividadCampanaResponseDTO = horarioActividadCampanaService.desactivar(idActividad,horarioActividadCampanaRequestDTO);

		if (horarioActividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(horarioActividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}








}
