package mx.com.proyectohu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.MiddlewareCLDTO;
import mx.com.proyectohu.service.MiddlewareCLService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/profuturo/api/v1")
public class MiddlewareCLController {
	@Autowired
	public MiddlewareCLService middlewareService;
	
	@PostMapping("/cl/middleware/{lineaNegocio}")
	public ResponseEntity<?> postMethodName(@PathVariable String lineaNegocio, @RequestBody MiddlewareCLDTO middlewareDTO) {
		
		String response = middlewareService.llamarAsynUpdateCL(middlewareDTO,lineaNegocio);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	

}
