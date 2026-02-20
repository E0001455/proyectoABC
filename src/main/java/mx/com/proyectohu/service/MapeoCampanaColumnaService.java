package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.CampanaColumnaDTO;
import mx.com.proyectohu.dto.CampanaColumnaDTO.CatColumna;
import mx.com.proyectohu.dto.CatCadenaDTO;
import mx.com.proyectohu.dto.CatNumeroDTO;
import mx.com.proyectohu.dto.CatValorDTO;
import mx.com.proyectohu.dto.LineaColumnaDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.dto.CatCadenaDTO.TipoCadena;
import mx.com.proyectohu.dto.CatNumeroDTO.TipoNumero;
import mx.com.proyectohu.dto.CatValorDTO.TipoValor;

import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoCampanaColumna;
import mx.com.proyectohu.mapper.MapeoCampanaColumnaMapper;
import mx.com.proyectohu.repository.ABCMapeoCampanaColumnaRepository;




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
		abcMapeoCampanaColumnaEntity.setBolActivo(true);
		abcMapeoCampanaColumnaEntity.setFecCreacion(new Date());
		abcMapeoCampanaColumnaEntity.setIdUsusario(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());
		abcMapeoCampanaColumnaEntity.setIdABCCatValor(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
		abcMapeoCampanaColumnaEntity.setIdABCCatCadena(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
		abcMapeoCampanaColumnaEntity.setIdABCCatNumero(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
		abcMapeoCampanaColumnaEntity.setBolObligatorio(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getBolObligatorio());
		abcMapeoCampanaColumnaEntity.setNumMinimo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
		abcMapeoCampanaColumnaEntity.setNumMaximo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
		abcMapeoCampanaColumnaEntity.setNumEnteros(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
		abcMapeoCampanaColumnaEntity.setNumDecimales(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
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

					CampanaColumnaDTO campanaColumnaDTO = new CampanaColumnaDTO();
					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					
					tipoCadena.setIdABCCatCadena(abcMapeoCampanaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoCampanaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoCampanaColumnaEntity.getIdABCCatValor());
					
					catNumeroDTO.setTipoNumero(tipoNumero);
					
					catNumeroDTO.setNumDecimales(abcMapeoCampanaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoCampanaColumnaEntity.getNumEnteros());
					
					catCadenaDTO.setTipoCadena(tipoCadena);
					
					catCadenaDTO.setNumMaximo(abcMapeoCampanaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoCampanaColumnaEntity.getNumMinimo());
					
					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					
					catColumna.setIdABCCatColumna(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCCatColumna());

					campanaColumnaDTO.setBolObligatorio(abcMapeoCampanaColumnaEntity.getBolObligatorio());
					campanaColumnaDTO.setIdABCConfigMapeoCampana(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCConfigMapeoCampana());
					campanaColumnaDTO.setCatColumna(catColumna);
					campanaColumnaDTO.setCatValorDTO(catValorDTO);
					campanaColumnaDTO.setRegex(abcMapeoCampanaColumnaEntity.getRegex());


					
					mapeoCampanaColumnaResponseDTO.setCampanaColumnaDTO(campanaColumnaDTO);
					mapeoCampanaColumnaResponseDTO.setFecCreacion(abcMapeoCampanaColumnaEntity.getFecCreacion());
					mapeoCampanaColumnaResponseDTO.setFecUltModificacion(abcMapeoCampanaColumnaEntity.getFecUltModificacion());
					mapeoCampanaColumnaResponseDTO.setBolActivo(abcMapeoCampanaColumnaEntity.getBolActivo());
					mapeoCampanaColumnaResponseDTO.setIdUsuario(abcMapeoCampanaColumnaEntity.getIdABCUsuarioUltModificacion());
					
					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityLista = abcMapeoCampanaColumnaRepository.findByLlaveMapeoCampanaColumna_IdABCConfigMapeoCampana(id);


			if(!abcMapeoCampanaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity: abcMapeoCampanaColumnaEntityLista) {
					MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
					CampanaColumnaDTO campanaColumnaDTO = new CampanaColumnaDTO();
					CatColumna catColumna = new CatColumna();
					CatValorDTO catValorDTO = new CatValorDTO();
					CatCadenaDTO catCadenaDTO = new CatCadenaDTO();
					CatNumeroDTO catNumeroDTO = new CatNumeroDTO();
					TipoCadena tipoCadena = new TipoCadena();
					TipoNumero tipoNumero = new TipoNumero();
					TipoValor tipoValor = new TipoValor();
					
					tipoCadena.setIdABCCatCadena(abcMapeoCampanaColumnaEntity.getIdABCCatCadena());
					tipoNumero.setIdABCCatNumero(abcMapeoCampanaColumnaEntity.getIdABCCatNumero());
					tipoValor.setIdABCCatValor(abcMapeoCampanaColumnaEntity.getIdABCCatValor());
					
					catNumeroDTO.setTipoNumero(tipoNumero);
					
					catNumeroDTO.setNumDecimales(abcMapeoCampanaColumnaEntity.getNumDecimales());
					catNumeroDTO.setNumEnteros(abcMapeoCampanaColumnaEntity.getNumEnteros());
					
					catCadenaDTO.setTipoCadena(tipoCadena);
					
					catCadenaDTO.setNumMaximo(abcMapeoCampanaColumnaEntity.getNumMaximo());
					catCadenaDTO.setNumMinimo(abcMapeoCampanaColumnaEntity.getNumMinimo());
					
					catValorDTO.setCatCadenaDTO(catCadenaDTO);
					catValorDTO.setCatNumeroDTO(catNumeroDTO);
					catValorDTO.setTipoValor(tipoValor);
					
					catColumna.setIdABCCatColumna(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCCatColumna());

					campanaColumnaDTO.setBolObligatorio(abcMapeoCampanaColumnaEntity.getBolObligatorio());
					campanaColumnaDTO.setIdABCConfigMapeoCampana(abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCConfigMapeoCampana());
					campanaColumnaDTO.setCatColumna(catColumna);
					campanaColumnaDTO.setCatValorDTO(catValorDTO);
					campanaColumnaDTO.setRegex(abcMapeoCampanaColumnaEntity.getRegex());


					
					mapeoCampanaColumnaResponseDTO.setCampanaColumnaDTO(campanaColumnaDTO);
					mapeoCampanaColumnaResponseDTO.setFecCreacion(abcMapeoCampanaColumnaEntity.getFecCreacion());
					mapeoCampanaColumnaResponseDTO.setFecUltModificacion(abcMapeoCampanaColumnaEntity.getFecUltModificacion());
					mapeoCampanaColumnaResponseDTO.setBolActivo(abcMapeoCampanaColumnaEntity.getBolActivo());
					mapeoCampanaColumnaResponseDTO.setIdUsuario(abcMapeoCampanaColumnaEntity.getIdABCUsuarioUltModificacion());
					
					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}

		}

		return mapeoCampanaColumnaResponseDTOLista;

	}

	public MapeoCampanaColumnaResponseDTO actualizarMapeoCampanaColumna(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {

		MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatColumna().getIdABCCatColumna());
		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();


			abcMapeoCampanaColumnaEntity.setLlaveMapeoCampanaColumna(llaveMapeoCampanaColumna);
			abcMapeoCampanaColumnaEntity.setBolActivo(true);
			abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
			abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());
			abcMapeoCampanaColumnaEntity.setIdABCCatValor(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getTipoValor().getIdABCCatValor());
			abcMapeoCampanaColumnaEntity.setIdABCCatCadena(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getTipoCadena().getIdABCCatCadena());
			abcMapeoCampanaColumnaEntity.setIdABCCatNumero(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getTipoNumero().getIdABCCatNumero());
			abcMapeoCampanaColumnaEntity.setBolObligatorio(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getBolObligatorio());
			abcMapeoCampanaColumnaEntity.setNumMinimo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMinimo());
			abcMapeoCampanaColumnaEntity.setNumMaximo(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatCadenaDTO().getNumMaximo());
			abcMapeoCampanaColumnaEntity.setNumEnteros(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumEnteros());
			abcMapeoCampanaColumnaEntity.setNumDecimales(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getCatValorDTO().getCatNumeroDTO().getNumDecimales());
			abcMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getCampanaColumnaDTO().getRegex());
			abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);
	
			 
			long id= abcMapeoCampanaColumnaEntity.getLlaveMapeoCampanaColumna().getIdABCConfigMapeoCampana();
			CampanaColumnaDTO campanaColumnaDTO = new CampanaColumnaDTO();
			campanaColumnaDTO.setIdABCConfigMapeoCampana(id);
			mapeoCampanaColumnaResponseDTO.setCampanaColumnaDTO(campanaColumnaDTO);

		}else {
			mapeoCampanaColumnaResponseDTO=null;
		}


		return mapeoCampanaColumnaResponseDTO;


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
				abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());
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
				abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());
				abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}

	


}
