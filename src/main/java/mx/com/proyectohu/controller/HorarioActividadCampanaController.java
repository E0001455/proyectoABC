package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.HorarioActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadCampanaResponseDTO;
import mx.com.proyectohu.service.HorarioActividadCampanaService;

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
public class HorarioActividadCampanaController {

	@Autowired
	public HorarioActividadCampanaService horarioActividadCampanaService;


	
	@PostMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadCampana(@PathVariable Long idActividad,@PathVariable Long idTipo, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {

		horarioActividadCampanaService.registrarHorarioActividadCampana(idActividad,idTipo,horarioActividadCampanaRequestDTO);
		
		return ResponseEntity.ok("creado");
	}


	@GetMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> consultarHorariosActividadCampanas(@PathVariable Long idActividad,@PathVariable Long idTipo) {

			List<HorarioActividadCampanaResponseDTO> horarioActividadCampanaResponseDTOLista = new ArrayList<HorarioActividadCampanaResponseDTO>();

			horarioActividadCampanaResponseDTOLista = horarioActividadCampanaService.consultarHorariosActividadCampanas(idActividad,idTipo);
		
			return ResponseEntity.ok(horarioActividadCampanaResponseDTOLista);
		

	}
	
	@PatchMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad,@PathVariable Long idTipo, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO) {
		
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
		horarioActividadCampanaResponseDTO = horarioActividadCampanaService.activar(idActividad,idTipo, horarioActividadCampanaRequestDTO);

		if (horarioActividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(horarioActividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}


	@PatchMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad,@PathVariable Long idTipo, @RequestBody HorarioActividadCampanaRequestDTO horarioActividadCampanaRequestDTO){
		HorarioActividadCampanaResponseDTO horarioActividadCampanaResponseDTO = new HorarioActividadCampanaResponseDTO();
		horarioActividadCampanaResponseDTO = horarioActividadCampanaService.desactivar(idActividad,idTipo, horarioActividadCampanaRequestDTO);

		if (horarioActividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(horarioActividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}








}
