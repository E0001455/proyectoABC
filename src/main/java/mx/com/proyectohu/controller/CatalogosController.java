package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.component.CatalogosDAO;
import mx.com.proyectohu.dto.CatalogosRequestDTO;
import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.service.CatalogosService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class CatalogosController {

	@Autowired
	public CatalogosService catalogosService;

	@GetMapping("/catalogos")
	public ResponseEntity<?> consultarCatalogo(@RequestParam String codigo) {

		Collection<List<CatalogosResponseDTO>>  catalogosResponseDTOlista;


		catalogosResponseDTOlista=catalogosService.obtenerCatalogoCache(codigo);



		return ResponseEntity.ok(catalogosResponseDTOlista);


	}

	@PostMapping("/catalogos")
	public ResponseEntity<?> registrarCatalogo(@RequestParam String codigo,@RequestBody CatalogosRequestDTO catalogosRequestDTO) {

		Long idCatalogo=null;


		idCatalogo=catalogosService.registrarCatalogo(codigo,catalogosRequestDTO);


		return ResponseEntity.ok(idCatalogo);


	}
	
	@PostMapping("/catalogos/recarga")
	public ResponseEntity<?> recargarCatalogo(@RequestParam String codigo) {

		Boolean catalogoActivado= false;


		catalogoActivado = catalogosService.activarCatalogo(codigo);

		if(catalogoActivado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}

		


	}



}
