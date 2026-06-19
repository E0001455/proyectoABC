package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import mx.com.proyectohu.dto.EmpresaColumnaDTO;
import mx.com.proyectohu.dto.MapeoEmpresaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoEmpresaColumnaResponseDTO;
import mx.com.proyectohu.service.MapeoEmpresaColumnaService;

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
public class MapeoEmpresaColumnaController {

	@Autowired
	public MapeoEmpresaColumnaService mapeoEmpresaColumnaService;



	@PostMapping("/empresas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> registrarNuevaEmpresa(@PathVariable Long idMapeo,@RequestBody MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {


		Long idMapeoEmpresaNegocio;
		idMapeoEmpresaNegocio = mapeoEmpresaColumnaService.registrarMapeoEmpresaColumna(idMapeo,mapeoEmpresaColumnaRequestDTO);

		if (idMapeoEmpresaNegocio==null) {
			return ResponseEntity.notFound().build();
		}


		return ResponseEntity.ok("creado");
	}

	@GetMapping("/empresas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> consultarMapeosEmpresa(@PathVariable Long idMapeo, MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		Long IdABCCatColumna = null;
		
			List<MapeoEmpresaColumnaResponseDTO> mapeoEmpresaColumnaResponseDTOLista = new ArrayList<MapeoEmpresaColumnaResponseDTO>();

			mapeoEmpresaColumnaResponseDTOLista = mapeoEmpresaColumnaService.consultarMapeoEmpresaColumna(idMapeo);

			return ResponseEntity.ok(mapeoEmpresaColumnaResponseDTOLista);
		

	}

	@PutMapping("/empresas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> actualizarMapeoEmpresa(@PathVariable Long idMapeo,@RequestBody MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {


		Long idMapeoEmpresaNegocio;

		idMapeoEmpresaNegocio= mapeoEmpresaColumnaService.actualizarMapeoEmpresaColumna(idMapeo,mapeoEmpresaColumnaRequestDTO);


		if (idMapeoEmpresaNegocio==null) {
			return ResponseEntity.notFound().build();

		}


		return ResponseEntity.ok("operacion exitosa");
	}


	@PatchMapping("/empresas/mapeos/{idMapeo}/columnas/activar")
	public ResponseEntity<?> activar(@PathVariable Long idMapeo,@RequestBody MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		

		Boolean activado = mapeoEmpresaColumnaService.activar(idMapeo,mapeoEmpresaColumnaRequestDTO);

		if (activado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/empresas/mapeos/{idMapeo}/columnas/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idMapeo,@RequestBody MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO){
	
	
		Boolean desactivado = mapeoEmpresaColumnaService.desactivar(idMapeo,mapeoEmpresaColumnaRequestDTO);

		if (desactivado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
