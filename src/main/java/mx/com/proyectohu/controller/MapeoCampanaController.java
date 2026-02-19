package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.service.MapeoCampanaService;

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
public class MapeoCampanaController {
	
	@Autowired
	public MapeoCampanaService mapeoCampanaService;
	
	
	
	@PostMapping("/lineas/{idLinea}/campanas/{idCampana}/mapeos")
	public ResponseEntity<?> registrarCampanaLinea(@PathVariable Long idLinea,@PathVariable Long idCampana, @RequestBody MapeoCampanaRequestDTO mapeoCampanaRequestDTO ) {
		
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO = new MapeoCampanaResponseDTO();
		mapeoCampanaResponseDTO.setIdABCConfigMapeoCampana(mapeoCampanaService.registrarCampana(idLinea,idCampana,mapeoCampanaRequestDTO));
		
		
		return ResponseEntity.ok(mapeoCampanaResponseDTO);
	}
	

	@GetMapping("/lineas/campanas/mapeos")
	public ResponseEntity<?> consultarMapeosCampana() {
		
		
			List<MapeoCampanaResponseDTO> mapeoCampanaResponseDTOlista = new ArrayList<MapeoCampanaResponseDTO>();
			
			mapeoCampanaResponseDTOlista = mapeoCampanaService.consultarMapeosCampana();
			
			if (mapeoCampanaResponseDTOlista.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapeoCampanaResponseDTOlista);
			}
			
			return ResponseEntity.ok(mapeoCampanaResponseDTOlista);
		}
		

	
	@PutMapping("/lineas/campanas/mapeos")
	public ResponseEntity<MapeoCampanaResponseDTO> actualizarMapeoLinea(@RequestBody MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
		
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO= mapeoCampanaService.actualizarMapeoCampana(mapeoCampanaRequestDTO);
		
		if (mapeoCampanaResponseDTO==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(mapeoCampanaResponseDTO);
	}
	
 @PatchMapping("/lineas/campanas/mapeos/activar")
	public ResponseEntity<?> activar(@RequestBody MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
	 MapeoCampanaResponseDTO mapeoCampanaResponseDTO = new MapeoCampanaResponseDTO();
	 mapeoCampanaResponseDTO = mapeoCampanaService.activar(mapeoCampanaRequestDTO);
		
		if (mapeoCampanaResponseDTO.getIdABCConfigMapeoCampana()!=null) {
			return ResponseEntity.ok(mapeoCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	
	
	@PatchMapping("/lineas/campanas/mapeos/desactivar")
	public ResponseEntity<?> desactivar(@RequestBody MapeoCampanaRequestDTO mapeoCampanaRequestDTO){
		 MapeoCampanaResponseDTO mapeoCampanaResponseDTO = new MapeoCampanaResponseDTO();
		 mapeoCampanaResponseDTO = mapeoCampanaService.desactivar(mapeoCampanaRequestDTO);
		 
		if (mapeoCampanaResponseDTO.getIdABCConfigMapeoCampana()!=null) {
			return ResponseEntity.ok(mapeoCampanaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	

	


	
	
}
