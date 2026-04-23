package mx.com.proyectohu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MiddlewareDTO;
import mx.com.proyectohu.service.MiddlewareService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/profuturo/api/v1")
public class MiddlewareCLController {
	@Autowired
	public MiddlewareService middlewareService;
	
	@PostMapping("/middleware/{lineaNegocio}")
	public ResponseEntity<?> postMethodName(@PathVariable String lineaNegocio, @RequestBody MiddlewareDTO middlewareDTO) {
		
		String response = middlewareService.llamarAsynUpdateCL(middlewareDTO,lineaNegocio);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	

}
