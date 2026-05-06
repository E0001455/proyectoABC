package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.com.proyectohu.dto.CatCadenaDTO;
import mx.com.proyectohu.dto.CatFechaDTO;
import mx.com.proyectohu.dto.CatNumeroDTO;
import mx.com.proyectohu.dto.CatValorDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO.CatColumna;
import mx.com.proyectohu.dto.CatCadenaDTO.TipoCadena;
import mx.com.proyectohu.dto.CatFechaDTO.TipoFecha;
import mx.com.proyectohu.dto.CatNumeroDTO.TipoNumero;
import mx.com.proyectohu.dto.CatValorDTO.TipoValor;

import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoCampanaColumna;
import mx.com.proyectohu.repository.ABCMapeoCampanaColumnaRepository;
import mx.com.proyectohu.util.FechaUtil;




@Service
public class MapeoCampanaColumnaService {

	@Autowired
	public ABCMapeoCampanaColumnaRepository abcMapeoCampanaColumnaRepository;






	public Long  registrarMapeoCampanaColumna(Long idMapeoCampana, MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {


		ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = new ABCMapeoCampanaColumnaEntity();
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(idMapeoCampana);
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatColumna().getIdABCCatColumna());

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if(abcMapeoCampanaColumnaEntityOptional.isPresent()) {
			return idMapeoCampana=null;
		}
		abcMapeoCampanaColumnaEntity.setLlaveMapeoCampanaColumna(llaveMapeoCampanaColumna);
		abcMapeoCampanaColumnaEntity.setIdUsuario(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		abcMapeoCampanaColumnaEntity.setIdABCCatValor(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
		abcMapeoCampanaColumnaEntity.setIdABCCatCadena(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
		abcMapeoCampanaColumnaEntity.setIdABCCatNumero(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
		abcMapeoCampanaColumnaEntity.setIdFecha(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatFechaDTO().getTipoFecha().getIdCatFecha());
		abcMapeoCampanaColumnaEntity.setBolActivo(true);
		abcMapeoCampanaColumnaEntity.setFiRequerido(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getFinRequerido());
		abcMapeoCampanaColumnaEntity.setNumMinimo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
		abcMapeoCampanaColumnaEntity.setNumMaximo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
		abcMapeoCampanaColumnaEntity.setNumEnteros(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
		abcMapeoCampanaColumnaEntity.setNumDecimales(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
		abcMapeoCampanaColumnaEntity.setFecCreacion(FechaUtil.obtenerFechaActual());
		abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		abcMapeoCampanaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());


		idMapeoCampana = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity).getLlaveMapeoCampanaColumna().getIdABCConfigMapeoCampana();

		return	idMapeoCampana;	

	}

	public MapeoCampanaColumnaResponseDTO consultarMapeoCampanaColumna(Long id, Long idABCCatColumna) {
		MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();


		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(id);
		llaveMapeoCampanaColumna.setIdABCCatColumna(idABCCatColumna);

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			//	mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntityOptional.get());

		}else {
			mapeoCampanaColumnaResponseDTO = null;
		}


		return mapeoCampanaColumnaResponseDTO;
	}


	public List<MapeoCampanaColumnaResponseDTO>  consultarMapeosCampanaColumna(Long id, Long idABCCatColumna){
		List<MapeoCampanaColumnaResponseDTO> mapeoCampanaColumnaResponseDTOLista = new ArrayList<MapeoCampanaColumnaResponseDTO>();

		if (id==0 && idABCCatColumna==null ) {
			List<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityLista = abcMapeoCampanaColumnaRepository.findAll();


			if(!abcMapeoCampanaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity: abcMapeoCampanaColumnaEntityLista) {
					MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					CatFechaDTO catFechaDTO = new CatFechaDTO();

					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					TipoFecha  tipoFecha = new TipoFecha();

					tipoCadena.setIdABCCatCadena(abcMapeoCampanaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoCampanaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoCampanaColumnaEntity.getIdABCCatValor());
					tipoFecha.setIdCatFecha(abcMapeoCampanaColumnaEntity.getIdFecha());

					catNumeroDTO.setTipoNumero(tipoNumero);

					catNumeroDTO.setNumDecimales(abcMapeoCampanaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoCampanaColumnaEntity.getNumEnteros());

					catCadenaDTO.setTipoCadena(tipoCadena);
					catFechaDTO.setTipoFecha(tipoFecha);

					catCadenaDTO.setNumMaximo(abcMapeoCampanaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoCampanaColumnaEntity.getNumMinimo());

					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					catValorDTO.setCatFechaDTO(catFechaDTO);

					catColumna.setIdABCCatColumna(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCCatColumna());

					mapeoCampanaColumnaResponseDTO.setCatColumna(catColumna);
					mapeoCampanaColumnaResponseDTO.setCatValorDTO(catValorDTO);
					mapeoCampanaColumnaResponseDTO.setFecCreacion(abcMapeoCampanaColumnaEntity.getFecCreacion());
					mapeoCampanaColumnaResponseDTO.setFecUltModificacion(abcMapeoCampanaColumnaEntity.getFecUltModificacion());
					mapeoCampanaColumnaResponseDTO.setBolActivo(abcMapeoCampanaColumnaEntity.getBolActivo());
					mapeoCampanaColumnaResponseDTO.setRegex(abcMapeoCampanaColumnaEntity.getRegex());
					mapeoCampanaColumnaResponseDTO.setFinRequerido(abcMapeoCampanaColumnaEntity.getFiRequerido());

					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityLista = abcMapeoCampanaColumnaRepository.findByLlaveMapeoCampanaColumna_IdABCConfigMapeoCampana(id);


			if(!abcMapeoCampanaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity: abcMapeoCampanaColumnaEntityLista) {
					MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					CatFechaDTO catFechaDTO = new CatFechaDTO();

					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					TipoFecha  tipoFecha = new TipoFecha();

					tipoCadena.setIdABCCatCadena(abcMapeoCampanaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoCampanaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoCampanaColumnaEntity.getIdABCCatValor());
					tipoFecha.setIdCatFecha(abcMapeoCampanaColumnaEntity.getIdFecha());
					catNumeroDTO.setTipoNumero(tipoNumero);

					catNumeroDTO.setNumDecimales(abcMapeoCampanaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoCampanaColumnaEntity.getNumEnteros());

					catCadenaDTO.setTipoCadena(tipoCadena);
					catFechaDTO.setTipoFecha(tipoFecha);
					catCadenaDTO.setNumMaximo(abcMapeoCampanaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoCampanaColumnaEntity.getNumMinimo());

					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					catValorDTO.setCatFechaDTO(catFechaDTO);
					catColumna.setIdABCCatColumna(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCCatColumna());
					mapeoCampanaColumnaResponseDTO.setCatColumna(catColumna);
					mapeoCampanaColumnaResponseDTO.setCatValorDTO(catValorDTO);
					mapeoCampanaColumnaResponseDTO.setFecCreacion(abcMapeoCampanaColumnaEntity.getFecCreacion());
					mapeoCampanaColumnaResponseDTO.setFecUltModificacion(abcMapeoCampanaColumnaEntity.getFecUltModificacion());
					mapeoCampanaColumnaResponseDTO.setBolActivo(abcMapeoCampanaColumnaEntity.getBolActivo());
					mapeoCampanaColumnaResponseDTO.setRegex(abcMapeoCampanaColumnaEntity.getRegex());
					mapeoCampanaColumnaResponseDTO.setFinRequerido(abcMapeoCampanaColumnaEntity.getFiRequerido());

					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}

		}

		return mapeoCampanaColumnaResponseDTOLista;

	}

	public Long actualizarMapeoCampanaColumna(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Long id =null;
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatColumna().getIdABCCatColumna());
		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();


			abcMapeoCampanaColumnaEntity.setLlaveMapeoCampanaColumna(llaveMapeoCampanaColumna);
			abcMapeoCampanaColumnaEntity.setBolActivo(true);
			abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
			abcMapeoCampanaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
			abcMapeoCampanaColumnaEntity.setIdABCCatValor(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
			abcMapeoCampanaColumnaEntity.setIdABCCatCadena(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
			abcMapeoCampanaColumnaEntity.setIdABCCatNumero(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
			abcMapeoCampanaColumnaEntity.setIdFecha(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatFechaDTO().getTipoFecha().getIdCatFecha());
			abcMapeoCampanaColumnaEntity.setNumMinimo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
			abcMapeoCampanaColumnaEntity.setNumMaximo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
			abcMapeoCampanaColumnaEntity.setNumEnteros(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
			abcMapeoCampanaColumnaEntity.setNumDecimales(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
			abcMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getRegex());

			abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);


			id= abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCConfigMapeoCampana();

		}else {
			id=null;
		}


		return id;


	}


	public Boolean activar(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatColumna().getIdABCCatColumna();
		Boolean activado= false;

		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(IdABCCatColumna);

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();

			if (!abcMapeoCampanaColumnaEntity.getBolActivo()) {

				abcMapeoCampanaColumnaEntity.setBolActivo(true);
				abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
				abcMapeoCampanaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);
				activado=true;
			}
		}

		return activado;
	}

	public Boolean desactivar(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Long IdABCCatColumna = mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatColumna().getIdABCCatColumna();
		Boolean desactivado= false;
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(IdABCCatColumna);


		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = 
				abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);
		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();

			if (abcMapeoCampanaColumnaEntity.getBolActivo()) {

				abcMapeoCampanaColumnaEntity.setBolActivo(false);
				abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
				abcMapeoCampanaColumnaEntity.setFecUltModificacion(FechaUtil.obtenerFechaActual());
				abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}




}
