package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoEmpresaRequestDTO;
import mx.com.proyectohu.dto.MapeoEmpresaResponseDTO;
import mx.com.proyectohu.service.MapeoEmpresaService;

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
public class MapeoEmpresasController {

	@Autowired
	public MapeoEmpresaService mapeoEmpresaService;



	@PostMapping("/empresas/mapeos")
	public ResponseEntity<?> registrarNuevaEmpresa(@RequestBody MapeoEmpresaRequestDTO mapeoEmpresaRequestDTO ) {


				Long idMapeoEmpresa = mapeoEmpresaService.registrarEmpresa(mapeoEmpresaRequestDTO);

		return ResponseEntity.ok(Map.of("id",idMapeoEmpresa));
	}
	


	@GetMapping("/empresas/mapeos")
	public ResponseEntity<?> consultarMapeosEmpresa() {


			List<MapeoEmpresaResponseDTO> mapeoEmpresaResponseDTOLista = new ArrayList<MapeoEmpresaResponseDTO>();

			mapeoEmpresaResponseDTOLista = mapeoEmpresaService.consultarMapeosEmpresas();

			return ResponseEntity.ok(mapeoEmpresaResponseDTOLista);
		 
 
	}
	


	@PutMapping("/empresas/mapeos/{idMapeo}")
	public ResponseEntity<?> actualizarMapeoEmpresa(@PathVariable Long idMapeo,  @RequestBody  MapeoEmpresaRequestDTO mapeoEmpresaRequestDTO) {

		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO= mapeoEmpresaService.actualizarMapeoEmpresa(idMapeo,mapeoEmpresaRequestDTO);

		
		if (mapeoEmpresaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",mapeoEmpresaResponseDTO.getIdMapeoEmpresa()));
	}

	
	@PatchMapping("/empresas/mapeos/{idMapeo}/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idMapeo){
		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();
		mapeoEmpresaResponseDTO = mapeoEmpresaService.desactivar(idMapeo);

		if (mapeoEmpresaResponseDTO.getIdMapeoEmpresa() !=null) {
			return ResponseEntity.ok(Map.of("id",mapeoEmpresaResponseDTO.getIdMapeoEmpresa()));
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/empresas/mapeos/{idMapeo}/activar")
	public ResponseEntity<?> activar(@PathVariable Long idMapeo) {
		MapeoEmpresaResponseDTO mapeoEmpresaResponseDTO = new MapeoEmpresaResponseDTO();
		mapeoEmpresaResponseDTO = mapeoEmpresaService.activar(idMapeo);

		if (mapeoEmpresaResponseDTO.getIdMapeoEmpresa() !=null) {
			return ResponseEntity.ok(Map.of("id",mapeoEmpresaResponseDTO.getIdMapeoEmpresa()));
		}else {
			return ResponseEntity.notFound().build();
		}


	}












}
