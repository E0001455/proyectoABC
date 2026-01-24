package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoLineaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.service.MapeoLineaColumnaService;

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
		
		return ResponseEntity.ok(idMapeoLineaNegocio);
	}
	
	
	@GetMapping("/lineas/mapeos/{id}/columnas")
	public ResponseEntity<?> consultarMapeosLinea(@PathVariable Long id, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		
		if(id > 0 && mapeoLineaColumnaRequestDTO.getIdABCCatColumna()!=null) {
			MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
			mapeoLineaColumnaResponseDTO = mapeoLineaColumnaService.consultarMapeoLineaColumna(id,mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
			if (mapeoLineaColumnaResponseDTO==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(mapeoLineaColumnaResponseDTO);
			
		}else {
			List<MapeoLineaColumnaResponseDTO> mapeoLineaColumnaResponseDTOLista = new ArrayList<MapeoLineaColumnaResponseDTO>();
			
			mapeoLineaColumnaResponseDTOLista = mapeoLineaColumnaService.consultarMapeosLineaColumna(id,mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
			
			return ResponseEntity.ok(mapeoLineaColumnaResponseDTOLista);
		}
		
	}
	
	@PutMapping("/lineas/mapeos/columnas")
	public ResponseEntity<?> actualizarMapeoLinea(@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		
		MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO= mapeoLineaColumnaService.actualizarMapeoLineaColumna(mapeoLineaColumnaRequestDTO);
		
		
		if (mapeoLineaColumnaResponseDTO==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(mapeoLineaColumnaResponseDTO);
	}
	
	
	@PatchMapping("/lineas/mapeos/columnas/activar")
	public ResponseEntity<?> activar(@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		
		Boolean activado = mapeoLineaColumnaService.activar(mapeoLineaColumnaRequestDTO);
		
		if (activado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	
	
	@PatchMapping("/lineas/mapeos/columnas/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO){
		
	Boolean desactivado = mapeoLineaColumnaService.desactivar(mapeoLineaColumnaRequestDTO);
		
		if (desactivado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	


	
	
}
