package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
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



	@PostMapping("lineas/{idLinea}/campanas/{idCampana}/actividades")
	public ResponseEntity<?> registrarNuevaActividadCampana(@PathVariable Long idLinea,@PathVariable Long idCampana, @RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO ) {

	
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();


		actividadCampanaResponseDTO.setIdActividadCampana(actividadCampanaService.registrarActividadCampana(idLinea,idCampana,actividadCampanaRequestDTO));

		return ResponseEntity.ok(actividadCampanaResponseDTO);
	}


	@GetMapping("/lineas/campanas/actividades")
	public ResponseEntity<?> consultarActividadesCampanas() {


			List<ActividadCampanaResponseDTO> actividadCampanaResponseDTOLista = new ArrayList<ActividadCampanaResponseDTO>();

			actividadCampanaResponseDTOLista = actividadCampanaService.consultarActividadesCampana();

			return ResponseEntity.ok(actividadCampanaResponseDTOLista);
		

	}

	@PutMapping("/lineas/campanas/actividades")
	public ResponseEntity<?> actualizarActividadCampana(@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO) {

		ActividadCampanaResponseDTO actividadCampanaResponseDTO= actividadCampanaService.actualizarActividadCampana(actividadCampanaRequestDTO);

		
		if (actividadCampanaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",actividadCampanaResponseDTO.getIdActividadCampana()));
	}


	@PatchMapping("/lineas/campanas/actividades/activar")
	public ResponseEntity<?> activar(@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO) {
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.activar(actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/campanas/actividades/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody ActividadCampanaRequestDTO actividadCampanaRequestDTO){
		ActividadCampanaResponseDTO actividadCampanaResponseDTO = new ActividadCampanaResponseDTO();
		actividadCampanaResponseDTO = actividadCampanaService.desactivar(actividadCampanaRequestDTO);

		if (actividadCampanaResponseDTO.getIdActividadCampana() !=null) {
			return ResponseEntity.ok(actividadCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
