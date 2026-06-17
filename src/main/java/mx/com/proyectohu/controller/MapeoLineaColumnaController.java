package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import mx.com.proyectohu.dto.LineaColumnaDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaColumnaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class MapeoLineaColumnaController {

	@Autowired
	public MapeoLineaColumnaService mapeoLineaColumnaService;



	@PostMapping("/lineas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> registrarNuevaLinea(@PathVariable Long idMapeo,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		Long idMapeoLineaNegocio;
		idMapeoLineaNegocio = mapeoLineaColumnaService.registrarMapeoLineaColumna(idMapeo,mapeoLineaColumnaRequestDTO);

		if (idMapeoLineaNegocio==null) {
			return ResponseEntity.notFound().build();
		}


		return ResponseEntity.ok(Map.of("id",idMapeoLineaNegocio));
	}


	@GetMapping("/lineas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> consultarMapeosLinea(@PathVariable Long idMapeo, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long IdABCCatColumna = null;
		
			List<MapeoLineaColumnaResponseDTO> mapeoLineaColumnaResponseDTOLista = new ArrayList<MapeoLineaColumnaResponseDTO>();

			mapeoLineaColumnaResponseDTOLista = mapeoLineaColumnaService.consultarMapeosLineaColumna(idMapeo,IdABCCatColumna);

			return ResponseEntity.ok(mapeoLineaColumnaResponseDTOLista);
		

	}

	@PutMapping("/lineas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> actualizarMapeoLinea(@PathVariable Long idMapeo,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(idMapeo);

		Long idMapeoLineaNegocio;

		idMapeoLineaNegocio= mapeoLineaColumnaService.actualizarMapeoLineaColumna(mapeoLineaColumnaRequestDTO);


		if (idMapeoLineaNegocio==null) {
			return ResponseEntity.notFound().build();

		}


		return ResponseEntity.ok("operacion exitosa");
	}


	@PatchMapping("/lineas/mapeos/{idMapeo}/columnas/activar")
	public ResponseEntity<?> activar(@PathVariable Long idMapeo,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(idMapeo);

		Boolean activado = mapeoLineaColumnaService.activar(mapeoLineaColumnaRequestDTO);

		if (activado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/mapeos/{idMapeo}/columnas/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idMapeo,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO){
		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(idMapeo);
	
		Boolean desactivado = mapeoLineaColumnaService.desactivar(mapeoLineaColumnaRequestDTO);

		if (desactivado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
