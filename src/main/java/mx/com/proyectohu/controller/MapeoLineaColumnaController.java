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



	@PostMapping("/lineas/mapeos/{id}/columnas")
	public ResponseEntity<?> registrarNuevaLinea(@PathVariable Long id,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		Long idMapeoLineaNegocio;
		idMapeoLineaNegocio = mapeoLineaColumnaService.registrarMapeoLineaColumna(id,mapeoLineaColumnaRequestDTO);

		if (idMapeoLineaNegocio==null) {
			return ResponseEntity.notFound().build();
		}


		return ResponseEntity.ok(Map.of("id",idMapeoLineaNegocio));
	}


	@GetMapping("/lineas/mapeos/{id}/columnas")
	public ResponseEntity<?> consultarMapeosLinea(@PathVariable Long id, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long IdABCCatColumna = null;
		if(id > 0 && IdABCCatColumna!=null) {
			MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
			mapeoLineaColumnaResponseDTO = mapeoLineaColumnaService.consultarMapeoLineaColumna(id,IdABCCatColumna);
			if (mapeoLineaColumnaResponseDTO==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(mapeoLineaColumnaResponseDTO);

		}else {
			List<MapeoLineaColumnaResponseDTO> mapeoLineaColumnaResponseDTOLista = new ArrayList<MapeoLineaColumnaResponseDTO>();

			mapeoLineaColumnaResponseDTOLista = mapeoLineaColumnaService.consultarMapeosLineaColumna(id,IdABCCatColumna);

			return ResponseEntity.ok(mapeoLineaColumnaResponseDTOLista);
		}

	}

	@PutMapping("/lineas/mapeos/{id}/columnas")
	public ResponseEntity<?> actualizarMapeoLinea(@PathVariable Long id,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(id);

		Long idMapeoLineaNegocio;

		idMapeoLineaNegocio= mapeoLineaColumnaService.actualizarMapeoLineaColumna(mapeoLineaColumnaRequestDTO);


		if (idMapeoLineaNegocio==null) {
			return ResponseEntity.notFound().build();

		}


		return ResponseEntity.ok("operacion exitosa");
	}


	@PatchMapping("/lineas/mapeos/{id}/columnas/activar")
	public ResponseEntity<?> activar(@PathVariable Long id,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(id);

		Boolean activado = mapeoLineaColumnaService.activar(mapeoLineaColumnaRequestDTO);

		if (activado) {
			return ResponseEntity.ok(Map.of("id",id));
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/lineas/mapeos/{id}/columnas/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long id,@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO){
		mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().setIdABCConfigMapeoLinea(id);
	
		Boolean desactivado = mapeoLineaColumnaService.desactivar(mapeoLineaColumnaRequestDTO);

		if (desactivado) {
			return ResponseEntity.ok(Map.of("id",id));
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
