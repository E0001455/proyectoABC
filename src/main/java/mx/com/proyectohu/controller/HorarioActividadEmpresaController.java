package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.HorarioActividadEmpresaRequestDTO;
import mx.com.proyectohu.dto.HorarioActividadEmpresaResponseDTO;
import mx.com.proyectohu.service.HorarioActividadEmpresaService;

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
public class HorarioActividadEmpresaController {

	@Autowired
	public HorarioActividadEmpresaService horarioActividadEmpresaService;



	@PostMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> registrarNuevoHorarioActividadEmpresa(@PathVariable Long idActividad, @PathVariable Long idTipo, @RequestBody HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO) {

		horarioActividadEmpresaService.registrarHorarioActividadEmpresa(idActividad,idTipo, horarioActividadEmpresaRequestDTO);

		return ResponseEntity.ok("creado");
	}


	@GetMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/horarios")
	public ResponseEntity<?> consultarHorariosActividadesEmpresa(@PathVariable Long idActividad,@PathVariable Long idTipo) {


			List<HorarioActividadEmpresaResponseDTO> horarioActividadEmpresaResponseDTO = new ArrayList<HorarioActividadEmpresaResponseDTO>();

			horarioActividadEmpresaResponseDTO = horarioActividadEmpresaService.consultarHorariosActividadesEmpresa(idActividad,idTipo);

			return ResponseEntity.ok(horarioActividadEmpresaResponseDTO);
	}
	
	
	@PatchMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/horarios/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad, @PathVariable Long idTipo,  @RequestBody HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO) {
		
		HorarioActividadEmpresaResponseDTO horarioActividadEmpresaResponseDTO = new HorarioActividadEmpresaResponseDTO();
		horarioActividadEmpresaResponseDTO = horarioActividadEmpresaService.activar(idActividad,idTipo,horarioActividadEmpresaRequestDTO);

		if (horarioActividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(horarioActividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/horarios/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @PathVariable Long idTipo, @RequestBody HorarioActividadEmpresaRequestDTO horarioActividadEmpresaRequestDTO){
		HorarioActividadEmpresaResponseDTO horarioActividadEmpresaResponseDTO = new HorarioActividadEmpresaResponseDTO();
		horarioActividadEmpresaResponseDTO = horarioActividadEmpresaService.desactivar(idActividad,idTipo,horarioActividadEmpresaRequestDTO);

		if (horarioActividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(horarioActividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}








}
