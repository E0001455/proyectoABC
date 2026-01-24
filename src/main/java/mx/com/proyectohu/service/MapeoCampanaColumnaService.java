package mx.com.proyectohu.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.MapeoCampanaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaColumnaResponseDTO;
import mx.com.proyectohu.entity.ABCMapeoCampanaColumnaEntity;
import mx.com.proyectohu.mapper.MapeoCampanaColumnaMapper;
import mx.com.proyectohu.repository.ABCMapeoCampanaColumnaRepository;




@Service
public class MapeoCampanaColumnaService {

	@Autowired
	public ABCMapeoCampanaColumnaRepository abcMapeoCampanaColumnaRepository;

	@Autowired
	public MapeoCampanaColumnaMapper   mapeoCampanaColumnaMapper;
	
	private final JdbcTemplate jdbcTemplate;

	public MapeoCampanaColumnaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


	public Long  registrarMapeoCampanaColumna(Long idMapeoCampanaNegocio, MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {


		ABCMapeoCampanaColumnaEntity ABCMapeoCampanaColumnaEntity = new ABCMapeoCampanaColumnaEntity();


		ABCMapeoCampanaColumnaEntity.setIdABCConfigMapeoCampana(idMapeoCampanaNegocio);
		ABCMapeoCampanaColumnaEntity.setIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
		ABCMapeoCampanaColumnaEntity.setBolActivo(true);
		ABCMapeoCampanaColumnaEntity.setBolCarga(true);
		ABCMapeoCampanaColumnaEntity.setBolValidacion(true);
		ABCMapeoCampanaColumnaEntity.setBolEnvio(true);
		ABCMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getRegex());
		ABCMapeoCampanaColumnaEntity.setFecCreacion(new Date());
		ABCMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
		ABCMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());


		abcMapeoCampanaColumnaRepository.insertarMapeoCampanaColumna(ABCMapeoCampanaColumnaEntity.getIdABCConfigMapeoCampana(),
				ABCMapeoCampanaColumnaEntity.getIdABCCatColumna(),
				ABCMapeoCampanaColumnaEntity.getBolActivo(),
				ABCMapeoCampanaColumnaEntity.getBolCarga(),
				ABCMapeoCampanaColumnaEntity.getBolValidacion(),
				ABCMapeoCampanaColumnaEntity.getBolEnvio(),
				ABCMapeoCampanaColumnaEntity.getRegex(),
				ABCMapeoCampanaColumnaEntity.getFecCreacion(),
				ABCMapeoCampanaColumnaEntity.getIdABCUsuarioUltModificacion(),
				ABCMapeoCampanaColumnaEntity.getFecUltModificacion());



		return	idMapeoCampanaNegocio;	

	}

	public MapeoCampanaColumnaResponseDTO consultarMapeoCampanaColumna(Long id, Long idABCCatColumna) {
		MapeoCampanaColumnaResponseDTO mapeoCampanaColumnaResponseDTO = new MapeoCampanaColumnaResponseDTO();

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = abcMapeoCampanaColumnaRepository.findByIdABCConfigMapeoCampanaAndIdABCCatColumna(id,idABCCatColumna);

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
			List<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityLista = abcMapeoCampanaColumnaRepository.findByIdABCConfigMapeoCampana(id);


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
		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = 
				abcMapeoCampanaColumnaRepository.findByIdABCConfigMapeoCampanaAndIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana(),mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());

		if (abcMapeoCampanaColumnaEntityOptional.isPresent()) {

			ABCMapeoCampanaColumnaEntity abcMapeoCampanaColumnaEntity = abcMapeoCampanaColumnaEntityOptional.get();


			abcMapeoCampanaColumnaEntity.setBolCarga(mapeoCampanaColumnaRequestDTO.getBolCarga());
			abcMapeoCampanaColumnaEntity.setBolValidacion(mapeoCampanaColumnaRequestDTO.getBolValidacion());
			abcMapeoCampanaColumnaEntity.setBolEnvio(mapeoCampanaColumnaRequestDTO.getBolEnvio());
			abcMapeoCampanaColumnaEntity.setRegex(mapeoCampanaColumnaRequestDTO.getRegex());
			abcMapeoCampanaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaColumnaRequestDTO.getIdUsuario());
			abcMapeoCampanaColumnaEntity.setFecUltModificacion(new Date());


			 String sql = "UPDATE ABC_MAPEO_CAMPANA_COLUMNA SET BOL_CARGA=?,\r\n"
	 			 		+ "BOL_VALIDACION=?,\r\n"
	 			 		+ "BOL_ENVIO=?,\r\n"
	 			 		+ "REGEX=?,\r\n"
	 			 		+ "ID_ABC_USUARIO_ULT_MODIFICACION= ?,\r\n"
	 			 		+ "FEC_ULT_MODIFICACION= ?\r\n"
	 			 		+ "where ID_ABC_CONFIG_MAPEO_CAMPANA = ?\r\n"
	 			 		+ "and ID_ABC_CAT_COLUMNA=?";
			
			
		
			 jdbcTemplate.update(sql,
					 abcMapeoCampanaColumnaEntity.getBolCarga(),
					 abcMapeoCampanaColumnaEntity.getBolValidacion(),
					 abcMapeoCampanaColumnaEntity.getBolEnvio(),
					 abcMapeoCampanaColumnaEntity.getRegex(),
					 abcMapeoCampanaColumnaEntity.getIdABCUsuarioUltModificacion(),
					 abcMapeoCampanaColumnaEntity.getFecUltModificacion(),
					 abcMapeoCampanaColumnaEntity.getIdABCConfigMapeoCampana(),
					 abcMapeoCampanaColumnaEntity.getIdABCCatColumna());
			 
			mapeoCampanaColumnaResponseDTO = mapeoCampanaColumnaMapper.llenarDTO(abcMapeoCampanaColumnaEntity);

		}else {
			mapeoCampanaColumnaResponseDTO=null;
		}


		return mapeoCampanaColumnaResponseDTO;


	}


	public Boolean activar(MapeoCampanaColumnaRequestDTO mapeoCampanaColumnaRequestDTO) {
		Boolean activado= false;


		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = 
				abcMapeoCampanaColumnaRepository.findByIdABCConfigMapeoCampanaAndIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana(),mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
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

		Optional<ABCMapeoCampanaColumnaEntity> abcMapeoCampanaColumnaEntityOptional = 
				abcMapeoCampanaColumnaRepository.findByIdABCConfigMapeoCampanaAndIdABCCatColumna(mapeoCampanaColumnaRequestDTO.getIdABCConfigMapeoCampana(),mapeoCampanaColumnaRequestDTO.getIdABCCatColumna());
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
