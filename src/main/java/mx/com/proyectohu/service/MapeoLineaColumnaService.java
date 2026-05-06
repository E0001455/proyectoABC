package mx.com.proyectohu.service;


import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.ABCMapeoLineaColumnaRepository;
import mx.com.proyectohu.util.FechaUtil;
import mx.com.proyectohu.dto.CatCadenaDTO;
import mx.com.proyectohu.dto.CatCadenaDTO.TipoCadena;
import mx.com.proyectohu.dto.CatFechaDTO;
import mx.com.proyectohu.dto.CatFechaDTO.TipoFecha;
import mx.com.proyectohu.dto.CatNumeroDTO.TipoNumero;
import mx.com.proyectohu.dto.CatNumeroDTO;
import mx.com.proyectohu.dto.CatValorDTO;
import mx.com.proyectohu.dto.CatValorDTO.TipoValor;
import mx.com.proyectohu.dto.MapeoLineaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO.CatColumna;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoLineaColumna;

@Service
public class MapeoLineaColumnaService {

	@Autowired
	public ABCMapeoLineaColumnaRepository abcMapeoLineaColumnaRepository;



	public Long  registrarMapeoLineaColumna(Long idMapeoLineaNegocio, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatColumna().getIdABCCatColumna();

		ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = new ABCMapeoLineaColumnaEntity();
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(idMapeoLineaNegocio);
		llaveMapeoLineaColumna.setIdABCCatColumna(IdABCCatColumna);

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);

		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {
			return	idMapeoLineaNegocio=null;
		}

		abcMapeoLineaColumnaEntity.setLlaveMapeoLineaColumna(llaveMapeoLineaColumna);
		abcMapeoLineaColumnaEntity.setIdUsuario(mapeoLineaColumnaRequestDTO.getIdUsuario());
		abcMapeoLineaColumnaEntity.setIdABCCatValor(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
		abcMapeoLineaColumnaEntity.setIdABCCatCadena(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
		abcMapeoLineaColumnaEntity.setIdABCCatNumero(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
		abcMapeoLineaColumnaEntity.setIdFecha(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatFechaDTO().getTipoFecha().getIdCatFecha());
		abcMapeoLineaColumnaEntity.setBolActivo(true);
		abcMapeoLineaColumnaEntity.setFiRequerido(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getFiRequerido());
		abcMapeoLineaColumnaEntity.setNumMinimo(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
		abcMapeoLineaColumnaEntity.setNumMaximo(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
		abcMapeoLineaColumnaEntity.setNumEnteros(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
		abcMapeoLineaColumnaEntity.setNumDecimales(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
		abcMapeoLineaColumnaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
		abcMapeoLineaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());

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



			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();



			CatColumna catColumna = new CatColumna();
			CatValorDTO catValorDTO = new CatValorDTO();
			CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
			CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
			TipoCadena tipoCadena = new TipoCadena();
			TipoNumero tipoNumero = new TipoNumero();
	

			tipoCadena.setIdABCCatCadena(abcMapeoLineaColumnaEntity.getIdABCCatCadena());
			tipoNumero.setIdABCCatNumero(abcMapeoLineaColumnaEntity.getIdABCCatNumero());

			catNumeroDTO.setTipoNumero(tipoNumero);

			catNumeroDTO.setNumDecimales(abcMapeoLineaColumnaEntity.getNumDecimales());
			catNumeroDTO.setNumEnteros(abcMapeoLineaColumnaEntity.getNumEnteros());

			catCadenaDTO.setTipoCadena(tipoCadena);

			catCadenaDTO.setNumMaximo(abcMapeoLineaColumnaEntity.getNumMaximo());
			catCadenaDTO.setNumMinimo(abcMapeoLineaColumnaEntity.getNumMinimo());

			catValorDTO.setCatCadenaDTO(catCadenaDTO);
			catValorDTO.setCatNumeroDTO(catNumeroDTO);


			catColumna.setIdABCCatColumna(abcMapeoLineaColumnaEntity.getLlaveMapeoLineaColumna().getIdABCCatColumna());






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


					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					CatFechaDTO catFechaDTO = new CatFechaDTO();

					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					TipoFecha  tipoFecha = new TipoFecha();


					tipoCadena.setIdABCCatCadena(abcMapeoLineaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoLineaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoLineaColumnaEntity.getIdABCCatValor());
					tipoFecha.setIdCatFecha(abcMapeoLineaColumnaEntity.getIdFecha());

					catNumeroDTO.setTipoNumero(tipoNumero);

					catNumeroDTO.setNumDecimales(abcMapeoLineaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoLineaColumnaEntity.getNumEnteros());

					catCadenaDTO.setTipoCadena(tipoCadena);
					catFechaDTO.setTipoFecha(tipoFecha);
					catCadenaDTO.setNumMaximo(abcMapeoLineaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoLineaColumnaEntity.getNumMinimo());

					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					catValorDTO.setCatFechaDTO(catFechaDTO);

					catColumna.setIdABCCatColumna(abcMapeoLineaColumnaEntity.getLlaveMapeoLineaColumna().getIdABCCatColumna());

					mapeoLineaColumnaResponseDTO.setCatColumna(catColumna);
					mapeoLineaColumnaResponseDTO.setCatValorDTO(catValorDTO);
					mapeoLineaColumnaResponseDTO.setFecCreacion(abcMapeoLineaColumnaEntity.getFecCreacion());
					mapeoLineaColumnaResponseDTO.setFecUltModificacion(abcMapeoLineaColumnaEntity.getFecUltModificacion());
					mapeoLineaColumnaResponseDTO.setBolActivo(abcMapeoLineaColumnaEntity.getBolActivo());
					mapeoLineaColumnaResponseDTO.setRegex(abcMapeoLineaColumnaEntity.getRegex());
					mapeoLineaColumnaResponseDTO.setFinRequerido(abcMapeoLineaColumnaEntity.getFiRequerido());

					mapeoLineaColumnaResponseDTOLista.add(mapeoLineaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityLista = abcMapeoLineaColumnaRepository.findByLlaveMapeoLineaColumna_IdABCConfigMapeoLinea(id);


			if(!abcMapeoLineaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity: abcMapeoLineaColumnaEntityLista) {
					MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();


					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					CatFechaDTO catFechaDTO = new CatFechaDTO();

					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					TipoFecha  tipoFecha = new TipoFecha();

					tipoCadena.setIdABCCatCadena(abcMapeoLineaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoLineaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoLineaColumnaEntity.getIdABCCatValor());
					tipoFecha.setIdCatFecha(abcMapeoLineaColumnaEntity.getIdFecha());

					catNumeroDTO.setNumDecimales(abcMapeoLineaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoLineaColumnaEntity.getNumEnteros());
					catNumeroDTO.setTipoNumero(tipoNumero);

					catCadenaDTO.setNumMaximo(abcMapeoLineaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoLineaColumnaEntity.getNumMinimo());
					catCadenaDTO.setTipoCadena(tipoCadena);

					catFechaDTO.setTipoFecha(tipoFecha);

					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					catValorDTO.setCatFechaDTO(catFechaDTO);


					catColumna.setIdABCCatColumna(abcMapeoLineaColumnaEntity.getLlaveMapeoLineaColumna().getIdABCCatColumna());


					mapeoLineaColumnaResponseDTO.setCatColumna(catColumna);
					mapeoLineaColumnaResponseDTO.setFecCreacion(abcMapeoLineaColumnaEntity.getFecCreacion());
					mapeoLineaColumnaResponseDTO.setFecUltModificacion(abcMapeoLineaColumnaEntity.getFecUltModificacion());
					mapeoLineaColumnaResponseDTO.setBolActivo(abcMapeoLineaColumnaEntity.getBolActivo());
					mapeoLineaColumnaResponseDTO.setRegex(abcMapeoLineaColumnaEntity.getRegex());
					mapeoLineaColumnaResponseDTO.setFinRequerido(abcMapeoLineaColumnaEntity.getFiRequerido());
					mapeoLineaColumnaResponseDTO.setCatValorDTO(catValorDTO);

					mapeoLineaColumnaResponseDTOLista.add(mapeoLineaColumnaResponseDTO);


				}

			}

		}

		return mapeoLineaColumnaResponseDTOLista;

	}

	public Long actualizarMapeoLineaColumna(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long id=null;
		Long IdABCCatColumna = mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatColumna().getIdABCCatColumna();
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();
		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(IdABCCatColumna);
		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = 	abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);

		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();

			abcMapeoLineaColumnaEntity.setLlaveMapeoLineaColumna(llaveMapeoLineaColumna);
			abcMapeoLineaColumnaEntity.setIdABCCatValor(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
			abcMapeoLineaColumnaEntity.setIdABCCatCadena(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
			abcMapeoLineaColumnaEntity.setIdABCCatNumero(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
			abcMapeoLineaColumnaEntity.setIdFecha(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatFechaDTO().getTipoFecha().getIdCatFecha());
			abcMapeoLineaColumnaEntity.setFiRequerido(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getFiRequerido());
			abcMapeoLineaColumnaEntity.setNumMinimo(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
			abcMapeoLineaColumnaEntity.setNumMaximo(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
			abcMapeoLineaColumnaEntity.setNumEnteros(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
			abcMapeoLineaColumnaEntity.setNumDecimales(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
			abcMapeoLineaColumnaEntity.setRegex(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getRegex());
			abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
			Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
			abcMapeoLineaColumnaEntity.setFecUltModificacion(fechaActual);

			abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);

			id= abcMapeoLineaColumnaEntity.getLlaveMapeoLineaColumna().getIdABCConfigMapeoLinea();

		}else {
			id=null;
		}


		return id;


	}



	public Boolean activar(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatColumna().getIdABCCatColumna();

		Boolean activado= false;
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(IdABCCatColumna);


		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();

			if (!abcMapeoLineaColumnaEntity.getBolActivo()) {

				abcMapeoLineaColumnaEntity.setBolActivo(true);
				abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
				abcMapeoLineaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);
				activado=true;
			}
		}

		return activado;
	}

	public Boolean desactivar(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getCatColumna().getIdABCCatColumna();
		Boolean desactivado= false;
		LlaveMapeoLineaColumna llaveMapeoLineaColumna = new LlaveMapeoLineaColumna();

		llaveMapeoLineaColumna.setIdABCConfigMapeoLinea(mapeoLineaColumnaRequestDTO.getLineaColumnaDTO().getIdABCConfigMapeoLinea());
		llaveMapeoLineaColumna.setIdABCCatColumna(IdABCCatColumna);

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional =  abcMapeoLineaColumnaRepository.findById(llaveMapeoLineaColumna);
		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityOptional.get();

			if (abcMapeoLineaColumnaEntity.getBolActivo()) {

				abcMapeoLineaColumnaEntity.setBolActivo(false);
				abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
				abcMapeoLineaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaRepository.save(abcMapeoLineaColumnaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}




}
