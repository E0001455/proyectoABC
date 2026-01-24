package mx.com.proyectohu.service;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.mapper.MapeoCampanaMapper;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;





@Service
public class MapeoCampanaService {

	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;

	@Autowired
	public MapeoCampanaMapper   mapeoCampanaMapper;


	public Long  registrarLineaNegocio(Long idCatLineaNegocio, Long idCatCampana, MapeoCampanaRequestDTO mapeoCamapanaRequestDTO) {


		ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = new ABCConfigMapeoCampanaEntity();
		Long idMapeoCampana = 0L;

		abcConfigMapeoCampanaEntity.setIdABCUsuario(mapeoCamapanaRequestDTO.getIdUsuario());
		abcConfigMapeoCampanaEntity.setIdABCCatLineaNegocio(idCatLineaNegocio);
		abcConfigMapeoCampanaEntity.setIdABCCatCampana(idCatCampana);
		abcConfigMapeoCampanaEntity.setBolActivo(true);
		abcConfigMapeoCampanaEntity.setNombre(mapeoCamapanaRequestDTO.getMapeoCampanaDTO().getNombre());
		abcConfigMapeoCampanaEntity.setDescripcion(mapeoCamapanaRequestDTO.getMapeoCampanaDTO().getDescripcion());
		abcConfigMapeoCampanaEntity.setBolDictaminacion(null);
		abcConfigMapeoCampanaEntity.setFecCreacion(new Date());
		abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCamapanaRequestDTO.getIdUsuario());
		abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());


		idMapeoCampana=abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity).getIdABCConfigMapeoCampana();



		return	idMapeoCampana;	

	}



	public MapeoCampanaResponseDTO consultarMapeoCampana(Long idlineaneocio, Long idcampana ) {
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO = new MapeoCampanaResponseDTO();


		if (idlineaneocio>0&& idcampana>0 ) {
			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntityOptional = null;
					

			if (abcConfigMapeoCampanaEntityOptional!=null) {

				mapeoCampanaResponseDTO = mapeoCampanaMapper.llenarCampanaDTO(abcConfigMapeoCampanaEntityOptional);

			}else {
				mapeoCampanaResponseDTO= null;
			}

		}






		return mapeoCampanaResponseDTO;
	}


	public List<MapeoCampanaResponseDTO>  consultarMapeosCampana(Long idlineaneocio, Long idcampana){
		List<MapeoCampanaResponseDTO> mapeoCampanaResponseDTOlista = new ArrayList<MapeoCampanaResponseDTO>();


		if (idlineaneocio > 0 && idcampana > 0) {
			Iterable<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityIterable = 
					abcConfigMapeoCampanaRepository.findByIdABCCatLineaNegocioAndIdABCCatCampana(idlineaneocio,idcampana);

			for(ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity: abcConfigMapeoCampanaEntityIterable) {
				MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();
				mapeoCampanaResponseDTO = mapeoCampanaMapper.llenarCampanaDTO(abcConfigMapeoCampanaEntity);
				mapeoCampanaResponseDTOlista.add(mapeoCampanaResponseDTO);
			}

		}

		if (idlineaneocio > 0 && idcampana == 0 ) {
			Iterable<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityIterable = abcConfigMapeoCampanaRepository.findByIdABCCatLineaNegocio(idlineaneocio);

			for(ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity: abcConfigMapeoCampanaEntityIterable) {
				MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();
				mapeoCampanaResponseDTO = mapeoCampanaMapper.llenarCampanaDTO(abcConfigMapeoCampanaEntity);
				mapeoCampanaResponseDTOlista.add(mapeoCampanaResponseDTO);
			}

		}
		
		if (idlineaneocio == 0 && idcampana == 0 ) {
			Iterable<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityIterable = abcConfigMapeoCampanaRepository.findAll();

			for(ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity: abcConfigMapeoCampanaEntityIterable) {
				MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();
				mapeoCampanaResponseDTO = mapeoCampanaMapper.llenarCampanaDTO(abcConfigMapeoCampanaEntity);
				mapeoCampanaResponseDTOlista.add(mapeoCampanaResponseDTO);
			}

		}




		return mapeoCampanaResponseDTOlista;

	}

	public MapeoCampanaResponseDTO actualizarMapeoCampana(MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {


		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana());
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();
		if (abcConfigMapeoCampanaEntityOptional.isPresent()) {

			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaEntityOptional.get();
			abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
			abcConfigMapeoCampanaEntity.setNombre(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getNombre());
			abcConfigMapeoCampanaEntity.setDescripcion(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getDescripcion());
			abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());


			abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);

			mapeoCampanaResponseDTO = mapeoCampanaMapper.llenarCampanaDTO(abcConfigMapeoCampanaEntity);

		}else {
			mapeoCampanaResponseDTO=null;
		}


		return mapeoCampanaResponseDTO;


	}


	public Boolean activar(MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
		Boolean activado= false;


		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana());

		if (abcConfigMapeoCampanaEntityOptional.isPresent()) {

			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaEntityOptional.get();

			if (!abcConfigMapeoCampanaEntity.getBolActivo()) {
				abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
				abcConfigMapeoCampanaEntity.setBolActivo(true);
				abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);
				activado=true;
			}
		}

		return activado;
	}
	
	public Boolean desactivar(MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
		Boolean desactivado= false;


		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana());

		if (abcConfigMapeoCampanaEntityOptional.isPresent()) {

			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaEntityOptional.get();

			if (abcConfigMapeoCampanaEntity.getBolActivo()) {
				abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
				abcConfigMapeoCampanaEntity.setBolActivo(false);
				abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);
				desactivado=true;
			}
		}

		return desactivado;
	}



}
