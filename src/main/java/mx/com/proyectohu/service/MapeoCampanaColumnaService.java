package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.entity.LlaveMapeoCampanaColumna;
import mx.com.proyectohu.mapper.MapeoCampanaColumnaMapper;
import mx.com.proyectohu.repository.ABCMapeoCampanaColumnaRepository;




@Service
public class MapeoCampanaColumnaService {

	@Autowired
	public ABCMapeoCampanaColumnaRepository abcMapeoCampanaColumnaRepository;

	@Autowired
	public MapeoCampanaColumnaMapper   mapeoCampanaColumnaMapper;
	



	public Long  registrarMapeoCampanaColumna(Long idMapeoCampana, MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {


		ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = new ABCMapeoCampanaColumnaEntity();
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(idMapeoCampana);
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
		
		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);
		
		if(abcMapeoCampanaColumnaEntityOptional.isPresent()) {
			return idMapeoCampana=null;
		}
		abcMapeoCampanaColumnaEntity.setLlaveMapeoCampanaColumna(llaveMapeoCampanaColumna);
		abcMapeoCampanaColumnaEntity.setBolActivo(true);
		abcMapeoCampanaColumnaEntity.setBolCarga(true);
		abcMapeoCampanaColumnaEntity.setBolValidacion(true);
		abcMapeoCampanaColumnaEntity.setBolEnvio(true);
		abcMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getRegex());
		abcMapeoCampanaColumnaEntity.setFecCreacion(new Date());
		abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());

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

			mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntityOptional.get());

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
					mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntity);
					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityLista = abcMapeoCampanaColumnaRepository.findByLlaveMapeoCampanaColumna_IdABCConfigMapeoCampana(id);


			if(!abcMapeoCampanaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity: abcMapeoCampanaColumnaEntityLista) {
					MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
					mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntity);
					mapeoCampanaColumnaResponseDTOLista.add(mapeoCampanaColumnaResponseDTO);


				}

			}

		}

		return mapeoCampanaColumnaResponseDTOLista;

	}

	public MapeoCampanaColumnaResponseDTO actualizarMapeoCampanaColumna(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {

		MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();


			abcMapeoCampanaColumnaEntity.setBolCarga(mapeoCampanaColumnaRequestDTO.getBolCarga());
			abcMapeoCampanaColumnaEntity.setBolValidacion(mapeoCampanaColumnaRequestDTO.getBolValidacion());
			abcMapeoCampanaColumnaEntity.setBolEnvio(mapeoCampanaColumnaRequestDTO.getBolEnvio());
			abcMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getRegex());
			abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
			abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());

			abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaRepository.save(abcMapeoCampanaColumnaEntity);
	
			 
			mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntity);

		}else {
			mapeoCampanaColumnaResponseDTO=null;
		}


		return mapeoCampanaColumnaResponseDTO;


	}


	public Boolean activar(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Boolean activado= false;
		
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = 
				abcMapeoCampanaColumnaRepository.findById(llaveMapeoCampanaColumna);
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
		Boolean desactivado= false;
		LlaveMapeoCampanaColumna llaveMapeoCampanaColumna = new LlaveMapeoCampanaColumna();
		llaveMapeoCampanaColumna.setIdABCConfigMapeoCampana(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana());
		llaveMapeoCampanaColumna.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());


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
