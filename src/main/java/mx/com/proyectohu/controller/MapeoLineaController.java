package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaService;

import java.util.ArrayList;
import java.util.List;

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
public class MapeoLineaController {

	@Autowired
	public MapeoLineaService mapeoLineaService;



	@PostMapping("/lineas/{idLinea}/mapeos")
	public ResponseEntity<?> registrarNuevaLinea(@PathVariable Long idLinea, @RequestBody MapeoLineaRequestDTO mapeoLineaRequestDTO ) {

		if (mapeoLineaRequestDTO.getMapeoDTO().getNombre().length() < 3 
				||mapeoLineaRequestDTO.getMapeoDTO().getNombre().length() > 30) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre debe tener mas de 3 caracteres hasta maximo 30 caracteres");
		}

		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();


		mapeoLineaResponseDTO.setIdABCConfigMapeoLinea(mapeoLineaService.registrarLineaNegocio(idLinea,mapeoLineaRequestDTO));

		return ResponseEntity.ok(mapeoLineaResponseDTO);
	}


	@GetMapping("/lineas/mapeos")
	public ResponseEntity<?> consultarMapeosLinea() {


			List<MapeoLineaResponseDTO> mapeoLineaResponseDTOLista = new ArrayList<MapeoLineaResponseDTO>();

			mapeoLineaResponseDTOLista = mapeoLineaService.consultarMapeosLinea();

			return ResponseEntity.ok(mapeoLineaResponseDTOLista);
		

	}

	@PutMapping("/lineas/mapeos")
	public ResponseEntity<?> actualizarMapeoLinea(@RequestBody MapeoLineaRequestDTO mapeoLineaRequestDTO) {

		MapeoLineaResponseDTO mapeoLineaResponseDTO= mapeoLineaService.actualizarMapeoLinea(mapeoLineaRequestDTO);

		if (mapeoLineaRequestDTO.getMapeoDTO().getNombre().length() < 3 
				||mapeoLineaRequestDTO.getMapeoDTO().getNombre().length() > 30) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre debe tener mas de 3 caracteres hasta maximo 30 caracteres");
		}

		if (mapeoLineaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(mapeoLineaResponseDTO);
	}


	@PatchMapping("/lineas/mapeos/activar")
	public ResponseEntity<?> activar(@RequestBody MapeoLineaRequestDTO mapeoLineaRequestDTO) {
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
		mapeoLineaResponseDTO = mapeoLineaService.activar(mapeoLineaRequestDTO);

		if (mapeoLineaResponseDTO.getIdABCConfigMapeoLinea() !=null) {
			return ResponseEntity.ok(mapeoLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/mapeos/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody MapeoLineaRequestDTO mapeoLineaRequestDTO){
		MapeoLineaResponseDTO mapeoLineaResponseDTO = new MapeoLineaResponseDTO();
		mapeoLineaResponseDTO = mapeoLineaService.desactivar(mapeoLineaRequestDTO);

		if (mapeoLineaResponseDTO.getIdABCConfigMapeoLinea() !=null) {
			return ResponseEntity.ok(mapeoLineaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
