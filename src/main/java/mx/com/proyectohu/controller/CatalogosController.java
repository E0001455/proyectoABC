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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class CatalogosController {

	@Autowired
	public CatalogosService catalogosService;

	@GetMapping("/catalogos/{codigo}")
	public ResponseEntity<?> consultarCatalogo(@PathVariable String codigo) {

		Collection<List<CatalogosResponseDTO>>  catalogosResponseDTOlista;


		catalogosResponseDTOlista=catalogosService.obtenerCatalogoCache(codigo);



		return ResponseEntity.ok(catalogosResponseDTOlista);


	}

	@PostMapping("/catalogos/{codigo}")
	public ResponseEntity<?> registrarCatalogo(@PathVariable String codigo,@RequestBody CatalogosRequestDTO catalogosRequestDTO) {

		Long idCatalogo=null;


		idCatalogo=catalogosService.registrarCatalogo(codigo,catalogosRequestDTO);

		if(idCatalogo==null){
			return ResponseEntity.badRequest().build();

		}else {
			return ResponseEntity.ok("Operacion exitosa");

		}


	}

	@PutMapping("/catalogos/{codigo}")
	public ResponseEntity<?> actualizar(@PathVariable String codigo,@RequestBody CatalogosRequestDTO catalogosRequestDTO) {

		Long idCatalogo=null;


		idCatalogo=catalogosService.actualizar(codigo,catalogosRequestDTO);


		return ResponseEntity.ok("operacion exitosa");


	}

	@PostMapping("/catalogos/{codigo}/recarga")
	public ResponseEntity<?> recargarCatalogo(@PathVariable String codigo) {

		Boolean catalogoActivado= false;


		catalogoActivado = catalogosService.activarCatalogo(codigo);

		if(catalogoActivado) {
			return ResponseEntity.ok("creado");
		}else {
			return ResponseEntity.notFound().build();
		}




	}



}
