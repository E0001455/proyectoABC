package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.BitacoraUsuarioRequestDTO;
import mx.com.proyectohu.service.BitacoraUsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class BitacoraUsuarioController {
	
	@Autowired
	public BitacoraUsuarioService bitacoraUsuarioService;
	
	
	
	@PostMapping("/bitacoras/eventos")
	public ResponseEntity<?> registrarBitacoraUsuario(@RequestBody BitacoraUsuarioRequestDTO bitacoraUsuarioRequestDTO ) {
		
				
		Long idBitacoraUsuario;
		idBitacoraUsuario=bitacoraUsuarioService.registrarBitacoraUsuario(bitacoraUsuarioRequestDTO);
		
		return ResponseEntity.ok(idBitacoraUsuario);
	}
	
	

	


	
	
}
