package mx.com.proyectohu.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.ABCMapeoLineaColumnaRepository;
import mx.com.proyectohu.dto.MapeoLineaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoLineaColumna;
import mx.com.proyectohu.mapper.MapeoLineasColumnaMapper;

@Service
public class MapeoLineaColumnaService {

	@Autowired
	public ABCMapeoLineaColumnaRepository abcMapeoLineaColumnaRepository;

	@Autowired
	public MapeoLineasColumnaMapper   mapeoLineasColumnaMapper;

	


	public Long  registrarMapeoLineaColumna(Long idMapeoLineaNegocio, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = new ABCMapeoLineaColumnaEntity();
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(idMapeoLineaNegocio);
		llaveMapeoLineaColumna.setIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
		
		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
		
		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {
			return	idMapeoLineaNegocio=null;
		}

		abcMapeoLineaColumnaEntity.setLlaveMapeoLineaColumna(llaveMapeoLineaColumna);;
		abcMapeoLineaColumnaEntity.setBolActivo(true);
		abcMapeoLineaColumnaEntity.setBolCarga(true);
		abcMapeoLineaColumnaEntity.setBolValidacion(true);
		abcMapeoLineaColumnaEntity.setBolEnvio(true);
		abcMapeoLineaColumnaEntity.setRegex(mapeoLineaColumnaRequestDTO.getRegex());
		abcMapeoLineaColumnaEntity.setFecCreacion(new Date());
		abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
		abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());

		idMapeoLineaNegocio = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity).getLlaveMapeoLineaColumna().getIdABCConfigMapeoLinea();


		return	idMapeoLineaNegocio;	

	}

	public MapeoLineaColumnaResponseDTO consultarMapeoLineaColumna(Long id, Long idABCCatColumna) {
		MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(id);
		llaveMapeoLineaColumna.setIdABCCatColumna(idABCCatColumna);

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);

		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntityOptional.get());

		}else {
			mapeoLineaColumnaResponseDTO = null;
		}


		return mapeoLineaColumnaResponseDTO;
	}


	public List<MapeoLineaColumnaResponseDTO>  consultarMapeosLineaColumna(Long id, Long idABCCatColumna){
		List<MapeoLineaColumnaResponseDTO> mapeoLineaColumnaResponseDTOLista = new ArrayList<MapeoLineaColumnaResponseDTO>();

		if (id==0 && idABCCatColumna==null ) {
			List<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityLista = abcMapeoLineaColumnaRepository.findAll();


			if(!abcMapeoLineaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity: abcMapeoLineaColumnaEntityLista) {
					MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
					mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntity);
					mapeoLineaColumnaResponseDTOLista.add(mapeoLineaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityLista = abcMapeoLineaColumnaRepository.findByLlaveMapeoLineaColumna_IdABCConfigMapeoLinea(id);


			if(!abcMapeoLineaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity: abcMapeoLineaColumnaEntityLista) {
					MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
					mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntity);
					mapeoLineaColumnaResponseDTOLista.add(mapeoLineaColumnaResponseDTO);


				}

			}

		}

		return mapeoLineaColumnaResponseDTOLista;

	}
	
	public MapeoLineaColumnaResponseDTO actualizarMapeoLineaColumna(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {

		MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCCatColumna());

		
		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = 	abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
			

		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();
			

			abcMapeoLineaColumnaEntity.setBolCarga(mapeoLineaColumnaRequestDTO.getBolCarga());
			abcMapeoLineaColumnaEntity.setBolValidacion(mapeoLineaColumnaRequestDTO.getBolValidacion());
			abcMapeoLineaColumnaEntity.setBolEnvio(mapeoLineaColumnaRequestDTO.getBolEnvio());
			abcMapeoLineaColumnaEntity.setRegex(mapeoLineaColumnaRequestDTO.getRegex());
			abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
			abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());

			abcMapeoLineaColumnaEntity= abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);

			mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntity);

		}else {
			mapeoLineaColumnaResponseDTO=null;
		}


		return mapeoLineaColumnaResponseDTO;


	}
	


	public Boolean activar(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Boolean activado= false;
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCCatColumna());


		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();

			if (!abcMapeoLineaColumnaEntity.getBolActivo()) {

				abcMapeoLineaColumnaEntity.setBolActivo(true);
				abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
				abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());
				abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);
				activado=true;
			}
		}

		return activado;
	}

	public Boolean desactivar(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Boolean desactivado= false;
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCCatColumna());

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional =  abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();

			if (abcMapeoLineaColumnaEntity.getBolActivo()) {

				abcMapeoLineaColumnaEntity.setBolActivo(false);
				abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
				abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());
				abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}

	 


}
