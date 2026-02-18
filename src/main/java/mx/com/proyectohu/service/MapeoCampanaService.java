package mx.com.proyectohu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.MapeoCampanaRecordDTO;
import mx.com.proyectohu.dto.MapeoCampanaRequestDTO;
import mx.com.proyectohu.dto.MapeoCampanaResponseDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO.CatCampana;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO.CatLineaNegocio;
import mx.com.proyectohu.entity.ABCConfigMapeoCampanaEntity;
import mx.com.proyectohu.mapper.MapeoCampanaMapper;
import mx.com.proyectohu.repository.ABCConfigMapeoCampanaRepository;





@Service
public class MapeoCampanaService {

	@Autowired
	public ABCConfigMapeoCampanaRepository abcConfigMapeoCampanaRepository;

	@Autowired
	public MapeoCampanaMapper   mapeoCampanaMapper;


	public Long  registrarLineaNegocio(Long idCatLineaNegocio, Long idCatCampana, MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {


		ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = new ABCConfigMapeoCampanaEntity();
		Long idMapeoCampana = 0L;

		abcConfigMapeoCampanaEntity.setIdABCUsuario(mapeoCampanaRequestDTO.getIdUsuario());
		abcConfigMapeoCampanaEntity.setIdABCCatLineaNegocio(idCatLineaNegocio);
		abcConfigMapeoCampanaEntity.setIdABCCatCampana(idCatCampana);
		abcConfigMapeoCampanaEntity.setBolActivo(true);
		abcConfigMapeoCampanaEntity.setNombre(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getNombre());
		abcConfigMapeoCampanaEntity.setDescripcion(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getDescripcion());
		abcConfigMapeoCampanaEntity.setDictaminado(true);
		abcConfigMapeoCampanaEntity.setFecCreacion(new Date());
		abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
		abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());
		abcConfigMapeoCampanaEntity.setBolValidacion(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getBolValidacion());
		abcConfigMapeoCampanaEntity.setBolEnvio(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getBolEnvio());

		idMapeoCampana=abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity).getIdABCConfigMapeoCampana();



		return	idMapeoCampana;	

	}


	public List<MapeoCampanaResponseDTO>  consultarMapeosCampana(){
		List<MapeoCampanaResponseDTO> mapeoCampanaResponseDTOlista = new ArrayList<MapeoCampanaResponseDTO>();


	
			List<MapeoCampanaRecordDTO> mapeoCampanaRecordDTOLista = abcConfigMapeoCampanaRepository.consultarMapeoCampanasColumnas();

			for(MapeoCampanaRecordDTO mapeoCampanaRecordDTO: mapeoCampanaRecordDTOLista) {
				MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();
				CatLineaNegocio catLineaNegocio = new CatLineaNegocio();
				CatCampana catCampana = new CatCampana();
				
				catCampana.setIdABCCatCampana(mapeoCampanaRecordDTO.idABCCatCampana());
				catLineaNegocio.setCatCampana(catCampana);
				catLineaNegocio.setIdABCConfigMapeoLinea(mapeoCampanaRecordDTO.idABCCatLineaNegocio());
				
				mapeoCampanaResponseDTO.setIdABCConfigMapeoCampana( mapeoCampanaRecordDTO.idABCConfigMapeoCampana() );
				mapeoCampanaResponseDTO.setCatLineaNegocio(catLineaNegocio);
				mapeoCampanaResponseDTO.setBolActivo(mapeoCampanaRecordDTO.bolActivo());
				mapeoCampanaResponseDTO.setNombre(mapeoCampanaRecordDTO.nombre() );
				mapeoCampanaResponseDTO.setDescripcion(mapeoCampanaRecordDTO.descripcion() );
				mapeoCampanaResponseDTO.setFecCreacion(mapeoCampanaRecordDTO.fecCreacion() );	
				mapeoCampanaResponseDTO.setFecUltModificacion(mapeoCampanaRecordDTO.fecUltModificacion() );
				mapeoCampanaResponseDTO.setColumnas(mapeoCampanaRecordDTO.columnas().intValue());
				mapeoCampanaResponseDTO.setBolValidacion(mapeoCampanaRecordDTO.bolValidacion() );
				mapeoCampanaResponseDTO.setBolEnvio(mapeoCampanaRecordDTO.bolEnvio() );
				mapeoCampanaResponseDTOlista.add(mapeoCampanaResponseDTO);
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
			abcConfigMapeoCampanaEntity.setBolValidacion(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getBolValidacion());
			abcConfigMapeoCampanaEntity.setBolEnvio(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getBolEnvio());

			abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);
			mapeoCampanaResponseDTO.setIdABCConfigMapeoCampana(abcConfigMapeoCampanaEntity.getIdABCConfigMapeoCampana());
			

		}else {
			mapeoCampanaResponseDTO=null;
		}


		return mapeoCampanaResponseDTO;


	}


	public MapeoCampanaResponseDTO activar(MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();


		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana());

		if (abcConfigMapeoCampanaEntityOptional.isPresent()) {

			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaEntityOptional.get();

			if (!abcConfigMapeoCampanaEntity.getBolActivo()) {
				abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
				abcConfigMapeoCampanaEntity.setBolActivo(true);
				abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);
				mapeoCampanaResponseDTO.setIdABCConfigMapeoCampana(abcConfigMapeoCampanaEntity.getIdABCConfigMapeoCampana());
			}
		}

		return mapeoCampanaResponseDTO;
	}

	public MapeoCampanaResponseDTO desactivar(MapeoCampanaRequestDTO mapeoCampanaRequestDTO) {
		MapeoCampanaResponseDTO mapeoCampanaResponseDTO= new MapeoCampanaResponseDTO();


		Optional<ABCConfigMapeoCampanaEntity> abcConfigMapeoCampanaEntityOptional = abcConfigMapeoCampanaRepository.findById(mapeoCampanaRequestDTO.getMapeoCampanaDTO().getIdABCConfigMapeoCampana());

		if (abcConfigMapeoCampanaEntityOptional.isPresent()) {

			ABCConfigMapeoCampanaEntity abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaEntityOptional.get();

			if (abcConfigMapeoCampanaEntity.getBolActivo()) {
				abcConfigMapeoCampanaEntity.setIdABCUsuarioUltModificacion(mapeoCampanaRequestDTO.getIdUsuario());
				abcConfigMapeoCampanaEntity.setBolActivo(false);
				abcConfigMapeoCampanaEntity.setFecUltModificacion(new Date());
				abcConfigMapeoCampanaEntity = abcConfigMapeoCampanaRepository.save(abcConfigMapeoCampanaEntity);
				mapeoCampanaResponseDTO.setIdABCConfigMapeoCampana(abcConfigMapeoCampanaEntity.getIdABCConfigMapeoCampana());
			}
		}

		return mapeoCampanaResponseDTO;
	}



}
