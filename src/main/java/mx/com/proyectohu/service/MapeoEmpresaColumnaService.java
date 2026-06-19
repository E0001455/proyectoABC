package mx.com.proyectohu.service;


import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.dto.CatCadenaDTO;
import mx.com.proyectohu.dto.CatCadenaDTO.TipoCadena;
import mx.com.proyectohu.dto.CatFechaDTO;
import mx.com.proyectohu.dto.CatFechaDTO.TipoFecha;
import mx.com.proyectohu.dto.CatNumeroDTO.TipoNumero;
import mx.com.proyectohu.dto.CatNumeroDTO;
import mx.com.proyectohu.dto.CatValorDTO;
import mx.com.proyectohu.dto.CatValorDTO.TipoValor;
import mx.com.proyectohu.dto.EmpresaColumnaDTO.CatColumna;
import mx.com.proyectohu.dto.MapeoEmpresaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoEmpresaColumnaResponseDTO;
import mx.com.proyectohu.entity.EmpresaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoEmpresaColumna;
import mx.com.proyectohu.repository.EmpresaColumnaRepository;

@Service
public class MapeoEmpresaColumnaService {

	@Autowired
	public EmpresaColumnaRepository empresaColumnaRepository;



	public Long  registrarMapeoEmpresaColumna(Long idMapeoEmpresa, MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getCatColumna().getIdABCCatColumna();

		EmpresaColumnaEntity empresaColumnaEntity = new EmpresaColumnaEntity();
		LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna = new LlaveMapeoEmpresaColumna();

		llaveMapeoEmpresaColumna.setIdMapeoEmpresa(idMapeoEmpresa);
		llaveMapeoEmpresaColumna.setIdColumnaEmpresa(IdABCCatColumna);

		Optional<EmpresaColumnaEntity> abcMapeoEmpresaColumnaEntityOptional = empresaColumnaRepository.findById(llaveMapeoEmpresaColumna);

		if (abcMapeoEmpresaColumnaEntityOptional.isPresent()) {
			return	idMapeoEmpresa=null;
		}

		empresaColumnaEntity.setLlaveMapeoEmpresaColumna(llaveMapeoEmpresaColumna);
		empresaColumnaEntity.setIdUsuario(mapeoEmpresaColumnaRequestDTO.getIdUsuario());
		empresaColumnaEntity.setBolActivo(true);
		empresaColumnaEntity.setFiRequerido(mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getFiRequerido());
		empresaColumnaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		empresaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoEmpresaColumnaRequestDTO.getIdUsuario());
		empresaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

		idMapeoEmpresa = empresaColumnaRepository.save(empresaColumnaEntity).getLlaveMapeoEmpresaColumna().getIdMapeoEmpresa();


		return	idMapeoEmpresa;	

	}

	public List<MapeoEmpresaColumnaResponseDTO> consultarMapeoEmpresaColumna(Long idMapeoEmpresa) {

		List<MapeoEmpresaColumnaResponseDTO> mapeoEmpresaColumnaResponseDTOLista = new ArrayList<MapeoEmpresaColumnaResponseDTO>();
		MapeoEmpresaColumnaResponseDTO mapeoEmpresaColumnaResponseDTO = null;
		CatColumna catcolumna = null;
		List<EmpresaColumnaEntity> empresaColumnaEntityLista = empresaColumnaRepository.findByLlaveMapeoEmpresaColumna_IdMapeoEmpresa(idMapeoEmpresa);

		if (!empresaColumnaEntityLista.isEmpty()) {

			for(EmpresaColumnaEntity empresaColumnaEntity: empresaColumnaEntityLista) {
				mapeoEmpresaColumnaResponseDTO = new  MapeoEmpresaColumnaResponseDTO();
				catcolumna = new CatColumna();

				catcolumna.setIdABCCatColumna(empresaColumnaEntity.getLlaveMapeoEmpresaColumna().getIdColumnaEmpresa());

				mapeoEmpresaColumnaResponseDTO.setCatColumna(catcolumna);
				mapeoEmpresaColumnaResponseDTO.setBolActivo(empresaColumnaEntity.getBolActivo());
				mapeoEmpresaColumnaResponseDTO.setFinRequerido(empresaColumnaEntity.getFiRequerido());
				mapeoEmpresaColumnaResponseDTO.setFecCreacion(empresaColumnaEntity.getFecCreacion().getTime());
				mapeoEmpresaColumnaResponseDTO.setFecUltModificacion(empresaColumnaEntity.getFecUltModificacion().getTime());

				mapeoEmpresaColumnaResponseDTOLista.add(mapeoEmpresaColumnaResponseDTO);
			}

		}

		return mapeoEmpresaColumnaResponseDTOLista;
	}


	
	public Long actualizarMapeoEmpresaColumna(Long idMapeoEmpresa, MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		
		
		Long IdCatColumna = mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getCatColumna().getIdABCCatColumna();
		
		LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna = new LlaveMapeoEmpresaColumna();
		llaveMapeoEmpresaColumna.setIdMapeoEmpresa(idMapeoEmpresa);
		llaveMapeoEmpresaColumna.setIdColumnaEmpresa(IdCatColumna);
		Optional<EmpresaColumnaEntity> mapeoEmpresaColumnaEntityOptional = 	empresaColumnaRepository.findById(llaveMapeoEmpresaColumna);

		if (mapeoEmpresaColumnaEntityOptional.isPresent()) {

			EmpresaColumnaEntity empresaColumnaEntity = mapeoEmpresaColumnaEntityOptional.get();

		
			empresaColumnaEntity.setFiRequerido(mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getFiRequerido());
			empresaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoEmpresaColumnaRequestDTO.getIdUsuario());
			empresaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

			empresaColumnaEntity = empresaColumnaRepository.save(empresaColumnaEntity);

			idMapeoEmpresa= empresaColumnaEntity.getLlaveMapeoEmpresaColumna().getIdMapeoEmpresa();

		}else {
			idMapeoEmpresa=null;
		}


		return idMapeoEmpresa;


	}



	public Boolean activar(Long idMapeoEmpresa, MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		Long IdCatColumna = mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getCatColumna().getIdABCCatColumna();

		Boolean activado= false;
		LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna = new LlaveMapeoEmpresaColumna();

		llaveMapeoEmpresaColumna.setIdMapeoEmpresa(idMapeoEmpresa);
		llaveMapeoEmpresaColumna.setIdColumnaEmpresa(IdCatColumna);


		Optional<EmpresaColumnaEntity> mapeoEmpresaColumnaEntityOptional = empresaColumnaRepository.findById(llaveMapeoEmpresaColumna);
		if (mapeoEmpresaColumnaEntityOptional.isPresent()) {

			EmpresaColumnaEntity empresaColumnaEntity = mapeoEmpresaColumnaEntityOptional.get();

			if (!empresaColumnaEntity.getBolActivo()) {

				empresaColumnaEntity.setBolActivo(true);
				empresaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoEmpresaColumnaRequestDTO.getIdUsuario());
				empresaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				empresaColumnaEntity = empresaColumnaRepository.save(empresaColumnaEntity);
				activado=true;
			}
		}

		return activado;
	}

	public Boolean desactivar(Long idMapeoEmpresa, MapeoEmpresaColumnaRequestDTO mapeoEmpresaColumnaRequestDTO) {
		Long IdCatColumna = mapeoEmpresaColumnaRequestDTO.getEmpresaColumnaDTO().getCatColumna().getIdABCCatColumna();

		Boolean desactivado= false;
		LlaveMapeoEmpresaColumna llaveMapeoEmpresaColumna = new LlaveMapeoEmpresaColumna();

		llaveMapeoEmpresaColumna.setIdMapeoEmpresa(idMapeoEmpresa);
		llaveMapeoEmpresaColumna.setIdColumnaEmpresa(IdCatColumna);


		Optional<EmpresaColumnaEntity> mapeoEmpresaColumnaEntityOptional = empresaColumnaRepository.findById(llaveMapeoEmpresaColumna);
		
		if (mapeoEmpresaColumnaEntityOptional.isPresent()) {
			EmpresaColumnaEntity empresaColumnaEntity = mapeoEmpresaColumnaEntityOptional.get();

			if (empresaColumnaEntity.getBolActivo()) {

				empresaColumnaEntity.setBolActivo(false);
				empresaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoEmpresaColumnaRequestDTO.getIdUsuario());
				empresaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				empresaColumnaEntity = empresaColumnaRepository.save(empresaColumnaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}

	 


}
