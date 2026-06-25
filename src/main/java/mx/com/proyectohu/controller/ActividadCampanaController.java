package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaRequestDTO;
import mx.com.proyectohu.dto.ActividadCampanaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaService;
import mx.com.proyectohu.service.ActividadCampanaService;

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
public class ActividadCampanaController {

	@Autowired
	public ActividadCampanaService actividadCampanaService;



	@PostMapping("/campanas/actividades")
	public ResponseEntity<?> registrarNuevaActividadCampana(@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO ) {

	
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaService.registrarActividadCampana(actividadCampanaRequestDTO));

		return ResponseEntity.ok(actividadCampanaResponseDTO);
	}


	@GetMapping("/campanas/actividades")
	public ResponseEntity<?> consultarActividadesCampanas() {


			List<ActividadCampanaResponseDTO> actividadCampanaResponseDTOLista = new ArrayList<ActividadCampanaResponseDTO>();

			actividadCampanaResponseDTOLista = actividadCampanaService.consultarActividadesCampana();

			return ResponseEntity.ok(actividadCampanaResponseDTOLista);
		

	}
	
	
	@PatchMapping("/Campanas/actividades/{idActividad}/activar")
	public ResponseEntity<?> activarActividadMapeo(@PathVariable Long idActividad,@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.activarActividadMapeo(idActividad,actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/Campanas/actividades/{idActividad}/desactivar")
	public ResponseEntity<?> desactivarActividadMapeo(@PathVariable Long idActividad, @RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO){
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.desactivarActividadMapeo(idActividad,actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	 
	@PutMapping("/campanas/actividades/{idActividad}")
	public ResponseEntity<?> actualizarActividadCampana(@PathVariable Long idActividad, @RequestBody ActividadesRequestDTO actividadesRequestDTO) {

		ActividadCampanaResponseDTO actividadCampanaResponseDTO= actividadCampanaService.actualizarActividadCampana(idActividad,actividadesRequestDTO);

		
		if (actividadCampanaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",actividadCampanaResponseDTO.getIdActividadCampana()));
	}


	@PatchMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad,@PathVariable Long idTipo,@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.activar(idActividad,idTipo,actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/campanas/actividades/{idActividad}/tipos/{idTipo}/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad,@PathVariable Long idTipo,@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO){
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.desactivar(idActividad,idTipo,actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
