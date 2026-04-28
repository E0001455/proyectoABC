package mx.com.proyectohu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MiddlewareDTO;
import mx.com.proyectohu.service.MiddlewarePETService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/profuturo/api/v1")
public class MiddlewarePETController {
	@Autowired
	public MiddlewarePETService middlewarePETService;
	
	@PostMapping("/pet/middleware/{lineaNegocio}")
	public ResponseEntity<?> postMethodName(@PathVariable String lineaNegocio, @RequestBody MiddlewareDTO middlewareDTO) {
		
		String response = middlewarePETService.llamarAsynUpdatePET(middlewareDTO,lineaNegocio);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	

}
