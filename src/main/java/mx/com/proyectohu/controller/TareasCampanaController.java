package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.dto.TareaCampanaRequestDTO;
import mx.com.proyectohu.dto.TareaCampanaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaService;
import mx.com.proyectohu.service.TareaCampanaService;

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
public class TareasCampanaController {

	@Autowired
	public TareaCampanaService tareaCampanaService;



	@PostMapping("lineas/{idLinea}/campanas/{idCampana}/tareas")
	public ResponseEntity<?> registrarNuevaTareaCampana(@PathVariable Long idLinea,@PathVariable Long idCampana, @RequestBody TareaCampanaRequestDTO tareaCampanaRequestDTO ) {

	
		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();


		tareaCampanaResponseDTO.setIdCFGTareaCampana(tareaCampanaService.registrarTareaCampana(idLinea,idCampana,tareaCampanaRequestDTO));

		return ResponseEntity.ok(tareaCampanaResponseDTO);
	}


	@GetMapping("/lineas/campanas/tareas")
	public ResponseEntity<?> consultarTareasCampanas() {


			List<TareaCampanaResponseDTO> tareaCampanaResponseDTOLista = new ArrayList<TareaCampanaResponseDTO>();

			tareaCampanaResponseDTOLista = tareaCampanaService.consultarTareasCampana();

			return ResponseEntity.ok(tareaCampanaResponseDTOLista);
		

	}

	@PutMapping("/campanas/tareas")
	public ResponseEntity<?> actualizarTareaCampana(@RequestBody TareaCampanaRequestDTO tareaCampanaRequestDTO) {

		TareaCampanaResponseDTO tareaCampanaResponseDTO= tareaCampanaService.actualizarTareaCampana(tareaCampanaRequestDTO);

		
		if (tareaCampanaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",tareaCampanaResponseDTO.getIdCFGTareaCampana()));
	}


	@PatchMapping("/campanas/tareas/activar")
	public ResponseEntity<?> activar(@RequestBody TareaCampanaRequestDTO tareaCampanaRequestDTO) {
		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();
		tareaCampanaResponseDTO = tareaCampanaService.activar(tareaCampanaRequestDTO);

		if (tareaCampanaResponseDTO.getIdCFGTareaCampana() !=null) {
			return ResponseEntity.ok(tareaCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/campanas/tareas/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody TareaCampanaRequestDTO tareaCampanaRequestDTO){
		TareaCampanaResponseDTO tareaCampanaResponseDTO = new TareaCampanaResponseDTO();
		tareaCampanaResponseDTO = tareaCampanaService.desactivar(tareaCampanaRequestDTO);

		if (tareaCampanaResponseDTO.getIdCFGTareaCampana() !=null) {
			return ResponseEntity.ok(tareaCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
