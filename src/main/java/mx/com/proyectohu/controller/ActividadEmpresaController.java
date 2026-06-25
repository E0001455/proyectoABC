package mx.com.proyectohu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyectohu.dto.ActividadEmpresaRequestDTO;
import mx.com.proyectohu.dto.ActividadEmpresaResponseDTO;
import mx.com.proyectohu.dto.ActividadesRequestDTO;
import mx.com.proyectohu.service.ActividadEmpresaService;

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
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profuturo/api/v1")
public class ActividadEmpresaController {

	@Autowired
	public ActividadEmpresaService actividadEmpresaService;


	@PostMapping("/empresas/actividades")
	public ResponseEntity<?> registrarNuevaActividadEmpresa(@RequestBody ActividadEmpresaRequestDTO actividadEmpresaRequestDTO ) {

	
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();


		actividadEmpresaResponseDTO.setIdActividadEmpresa(actividadEmpresaService.registrarActividadEmpresa(actividadEmpresaRequestDTO));

		return ResponseEntity.ok(actividadEmpresaResponseDTO);
	}

	
	@GetMapping("/empresas/actividades")
	public ResponseEntity<?> consultarActividadesEmpresa() {


			List<ActividadEmpresaResponseDTO> actividadEmpresaResponseDTOLista = new ArrayList<ActividadEmpresaResponseDTO>();

			actividadEmpresaResponseDTOLista = actividadEmpresaService.consultarActividadesEmpresa();

			return ResponseEntity.ok(actividadEmpresaResponseDTOLista);
		

	}
	
	@PutMapping("/empresas/actividades/{idActividad}")
	public ResponseEntity<?> actualizarActividadEmpresa(@PathVariable Long idActividad, @RequestBody ActividadesRequestDTO actividadesRequestDTO) {

		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO= actividadEmpresaService.actualizarActividadEmpresa(idActividad,actividadesRequestDTO);

		
		if (actividadEmpresaResponseDTO==null) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(Map.of("id",actividadEmpresaResponseDTO.getIdActividadEmpresa()));
	}

	@PatchMapping("/empresas/actividades/{idActividad}/activar")
	public ResponseEntity<?> activarActividadMapeo(@PathVariable Long idActividad,@RequestBody ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		actividadEmpresaResponseDTO = actividadEmpresaService.activarActividadMapeo(idActividad,actividadEmpresaRequestDTO);

		if (actividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(actividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/empresas/actividades/{idActividad}/desactivar")
	public ResponseEntity<?> desactivarActividadMapeo(@PathVariable Long idActividad, @RequestBody ActividadEmpresaRequestDTO actividadEmpresaRequestDTO){
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		actividadEmpresaResponseDTO = actividadEmpresaService.desactivarActividadMapeo(idActividad,actividadEmpresaRequestDTO);

		if (actividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(actividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}

	@PatchMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/activar")
	public ResponseEntity<?> activar(@PathVariable Long idActividad,@PathVariable Long idTipo, @RequestBody ActividadEmpresaRequestDTO actividadEmpresaRequestDTO) {
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		actividadEmpresaResponseDTO = actividadEmpresaService.activar(idActividad,idTipo,actividadEmpresaRequestDTO);

		if (actividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(actividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}


	}



	@PatchMapping("/empresas/actividades/{idActividad}/tipos/{idTipo}/desactivar")
	public ResponseEntity<?> desactivar(@PathVariable Long idActividad, @PathVariable Long idTipo,@RequestBody ActividadEmpresaRequestDTO actividadEmpresaRequestDTO){
		ActividadEmpresaResponseDTO actividadEmpresaResponseDTO = new ActividadEmpresaResponseDTO();
		actividadEmpresaResponseDTO = actividadEmpresaService.desactivar(idActividad,idTipo,actividadEmpresaRequestDTO);

		if (actividadEmpresaResponseDTO.getIdActividadEmpresa() !=null) {
			return ResponseEntity.ok(actividadEmpresaResponseDTO);
		}else {
			return ResponseEntity.notFound().build();
		}

	}







}
