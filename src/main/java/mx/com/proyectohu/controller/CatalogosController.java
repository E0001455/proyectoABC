package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.service.CatalogosService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class CatalogosController {
	
	@Autowired
	public CatalogosService catalogosService;
	
	
	@GetMapping("/catalogos")
	public ResponseEntity<?> consultarMapeosCampana(@RequestParam String codigo) {
		List<CatalogosResponseDTO>  catalogosResponseDTOlista = new ArrayList<CatalogosResponseDTO>();
		
		
		catalogosResponseDTOlista=catalogosService.consultarCatalogo(codigo);
		
		
			return ResponseEntity.ok(catalogosResponseDTOlista);
		
		
	}

	
}
