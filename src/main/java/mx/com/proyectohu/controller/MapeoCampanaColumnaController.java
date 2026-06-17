package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaColumnaService;

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
public class MapeoCampanaColumnaController {

	@Autowired
	public MapeoCampanaColumnaService mapeoCampanaColumnaService;



	@PostMapping("/campanas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> registrarNuevaCampana(@PathVariable Long idMapeo,@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {


		Long idMapeoCampanaColumna;
		idMapeoCampanaColumna = mapeoCampanaColumnaService.registrarMapeoCampanaColumna(idMapeo,mapeoCampanaColumnaRequestDTO);

		if(idMapeoCampanaColumna==null) {
			return ResponseEntity.notFound().build();
		}



		return ResponseEntity.ok(Map.of("id",idMapeoCampanaColumna));
	}

	@GetMapping("/campanas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> consultarMapeosCampana(@PathVariable Long idMapeo, MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Long IdABCCatColumna = null;
	
			List<MapeoCampanaColumnaResponseDTO> mapeoCampanaColumnaResponseDTOLista = new ArrayList<MapeoCampanaColumnaResponseDTO>();

			mapeoCampanaColumnaResponseDTOLista = mapeoCampanaColumnaService.consultarMapeosCampanaColumna(idMapeo,IdABCCatColumna);

			return ResponseEntity.ok(mapeoCampanaColumnaResponseDTOLista);
		

	}

	@PutMapping("/campanas/mapeos/{idMapeo}/columnas")
	public ResponseEntity<?> actualizarMapeoCampana(@PathVariable Long idMapeo,@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {


		mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().setIdABCConfigMapeoCampana(idMapeo);

		Long idMapeoCampana;

		 idMapeoCampana= mapeoCampanaColumnaService.actualizarMapeoCampanaColumna(mapeoCampanaColumnaRequestDTO);


		if (idMapeoCampana==null) {
			return ResponseEntity.notFound().build();

		}

	

		return ResponseEntity.ok("operacion exitosa");
	}

	@PatchMapping("/campanas/mapeos/{idMapeo}/columnas/activar")
	public ResponseEntity<?> activar(@PathVariable Long idMapeo,@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().setIdABCConfigMapeoCampana(idMapeo);
		Boolean activado = mapeoCampanaColumnaService.activar(mapeoCampanaColumnaRequestDTO);

		if (activado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/campanas/mapeos/{idMapeo}/columnas/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idMapeo,@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO){
		mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().setIdABCConfigMapeoCampana(idMapeo);
		Boolean desactivado = mapeoCampanaColumnaService.desactivar(mapeoCampanaColumnaRequestDTO);

		if (desactivado) {
			return ResponseEntity.ok(Map.of("id",idMapeo));
		}else {
			return ResponseEntity.notFound().build();
		}

	}








}
