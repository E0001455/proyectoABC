package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaColumnaService;

import java.util.ArrayList;
import java.util.List;

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
	

	
	@PostMapping("/campanas/mapeos/{id}/columnas")
	public ResponseEntity<?> registrarNuevaCampana(@PathVariable Long id,@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		
		
		Long idMapeoCampanaColumna;
		idMapeoCampanaColumna = mapeoCampanaColumnaService.registrarMapeoCampanaColumna(id,mapeoCampanaColumnaRequestDTO);
		
		if(idMapeoCampanaColumna==null) {
			return ResponseEntity.notFound().build();
		}
		
		
		
		return ResponseEntity.ok(idMapeoCampanaColumna);
	}
	
	@GetMapping("/campanas/mapeos/{id}/columnas")
	public ResponseEntity<?> consultarMapeosCampana(@PathVariable Long id, MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		
		if(id > 0 && mapeoCampanaColumnaRequestDTO.getIdABCCatColumna()!=null) {
			MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
			mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaService.consultarMapeoCampanaColumna(id,mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
			if (mapeoCampanaColumnaResponseDTO==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(mapeoCampanaColumnaResponseDTO);
			
		}else {
			List<MapeoCampanaColumnaResponseDTO> mapeoCampanaColumnaResponseDTOLista = new ArrayList<MapeoCampanaColumnaResponseDTO>();
			
			mapeoCampanaColumnaResponseDTOLista = mapeoCampanaColumnaService.consultarMapeosCampanaColumna(id,mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
			
			return ResponseEntity.ok(mapeoCampanaColumnaResponseDTOLista);
		}
		
	}
	
	@PutMapping("/campanas/mapeos/columnas")
	public ResponseEntity<?> actualizarMapeoCampana(@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		
		MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO= mapeoCampanaColumnaService.actualizarMapeoCampanaColumna(mapeoCampanaColumnaRequestDTO);
		
		
		if (mapeoCampanaColumnaResponseDTO==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(mapeoCampanaColumnaResponseDTO);
	}
	
	@PatchMapping("/campanas/mapeos/columnas/activar")
	public ResponseEntity<?> activar(@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		
		Boolean activado = mapeoCampanaColumnaService.activar(mapeoCampanaColumnaRequestDTO);
		
		if (activado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	
	
	@PatchMapping("/campanas/mapeos/columnas/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO){
		
	Boolean desactivado = mapeoCampanaColumnaService.desactivar(mapeoCampanaColumnaRequestDTO);
		
		if (desactivado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	

	
	


	
	
}
