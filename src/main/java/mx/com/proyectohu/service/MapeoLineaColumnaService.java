package mx.com.proyectohu.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
import mx.com.proyectohu.repository.ABCConfigMapeoLineaRepository;
import mx.com.proyectohu.repository.ABCMapeoLineaColumnaRepository;
import mx.com.proyectohu.dto.CatalogosResponseDTO;
import mx.com.proyectohu.dto.LineacolumnaDao;
import mx.com.proyectohu.dto.MapeoLineaColumnaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaColumnaResponseDTO;
import mx.com.proyectohu.dto.MapeoLineaRequestDTO;
import mx.com.proyectohu.dto.MapeoLineaResponseDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ABCMapeoLineaColumnaEntity;
import mx.com.proyectohu.entity.ColumnalineaUpdate;
import mx.com.proyectohu.mapper.MapeoLineasColumnaMapper;
import mx.com.proyectohu.mapper.MapeoLineasMapper;

@Service
public class MapeoLineaColumnaService {

	@Autowired
	public ABCMapeoLineaColumnaRepository abcMapeoLineaColumnaRepository;

	@Autowired
	public MapeoLineasColumnaMapper   mapeoLineasColumnaMapper;
	
	@Autowired
	public ColumnalineaUpdate columnalineaUpdate;
	

	@Value("${spring.datasource.url}")
	public String url;

	@Value("${spring.datasource.username}")
	public String user;
	
	@Value("${spring.datasource.password}")
	public String password;
	
	private final JdbcTemplate jdbcTemplate;

	public MapeoLineaColumnaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	



	public Long  registrarMapeoLineaColumna(Long idMapeoLineaNegocio, MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {


		ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = new ABCMapeoLineaColumnaEntity();


		abcMapeoLineaColumnaEntity.setIdABCConfigMapeoLinea(idMapeoLineaNegocio);
		abcMapeoLineaColumnaEntity.setIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
		abcMapeoLineaColumnaEntity.setBolActivo(true);
		abcMapeoLineaColumnaEntity.setBolCarga(true);
		abcMapeoLineaColumnaEntity.setBolValidacion(true);
		abcMapeoLineaColumnaEntity.setBolEnvio(true);
		abcMapeoLineaColumnaEntity.setRegex(mapeoLineaColumnaRequestDTO.getRegex());
		abcMapeoLineaColumnaEntity.setFecCreacion(new Date());
		abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
		abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());


		abcMapeoLineaColumnaRepository.insertarMapeoLineaColumna(abcMapeoLineaColumnaEntity.getIdABCConfigMapeoLinea(),
				abcMapeoLineaColumnaEntity.getIdABCCatColumna(),
				abcMapeoLineaColumnaEntity.getBolActivo(),
				abcMapeoLineaColumnaEntity.getBolCarga(),
				abcMapeoLineaColumnaEntity.getBolValidacion(),
				abcMapeoLineaColumnaEntity.getBolEnvio(),
				abcMapeoLineaColumnaEntity.getRegex(),
				abcMapeoLineaColumnaEntity.getFecCreacion(),
				abcMapeoLineaColumnaEntity.getIdABCUsuarioUltModificacion(),
				abcMapeoLineaColumnaEntity.getFecUltModificacion());



		return	idMapeoLineaNegocio;	

	}

	public MapeoLineaColumnaResponseDTO consultarMapeoLineaColumna(Long id, Long idABCCatColumna) {
		MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = abcMapeoLineaColumnaRepository.findByIdABCConfigMapeoLineaAndIdABCCatColumna(id,idABCCatColumna);

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
			List<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityLista = abcMapeoLineaColumnaRepository.findAll(Sort.by(Sort.Direction.ASC,"idABCConfigMapeoLinea"));


			if(!abcMapeoLineaColumnaEntityLista.isEmpty()) {

				for(ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity: abcMapeoLineaColumnaEntityLista) {
					MapeoLineaColumnaResponseDTO mapeoLineaColumnaResponseDTO = new MapeoLineaColumnaResponseDTO();
					mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntity);
					mapeoLineaColumnaResponseDTOLista.add(mapeoLineaColumnaResponseDTO);


				}

			}
		}else {
			List<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityLista = abcMapeoLineaColumnaRepository.findByIdABCConfigMapeoLinea(id);


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
		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = 
				abcMapeoLineaColumnaRepository.findByIdABCConfigMapeoLineaAndIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea(),mapeoLineaColumnaRequestDTO.getIdABCCatColumna());

		if (abcMapeoLineaColumnaEntityOptional.isPresent()) {

			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntityAUX = abcMapeoLineaColumnaEntityOptional.get();
			ABCMapeoLineaColumnaEntity abcMapeoLineaColumnaEntity = abcMapeoLineaColumnaEntityAUX; 
/*
			abcMapeoLineaColumnaEntity.setBolCarga(mapeoLineaColumnaRequestDTO.getBolCarga());
			abcMapeoLineaColumnaEntity.setBolValidacion(mapeoLineaColumnaRequestDTO.getBolValidacion());
			abcMapeoLineaColumnaEntity.setBolEnvio(mapeoLineaColumnaRequestDTO.getBolEnvio());
			abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
			abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());
*/
			
		
		
			abcMapeoLineaColumnaEntity.setBolCarga(mapeoLineaColumnaRequestDTO.getBolCarga());
			abcMapeoLineaColumnaEntity.setBolValidacion(mapeoLineaColumnaRequestDTO.getBolValidacion());
			abcMapeoLineaColumnaEntity.setBolEnvio(mapeoLineaColumnaRequestDTO.getBolEnvio());
			abcMapeoLineaColumnaEntity.setRegex(mapeoLineaColumnaRequestDTO.getRegex());
			
			abcMapeoLineaColumnaEntity.setIdABCUsuarioUltModificacion(mapeoLineaColumnaRequestDTO.getIdUsuario());
			abcMapeoLineaColumnaEntity.setFecUltModificacion(new Date());
			
			
		/*	columnalineaUpdate.updateMapeoLineaColumna(abcMapeoLineaColumnaEntity.getIdABCConfigMapeoLinea(),
					abcMapeoLineaColumnaEntity.getIdABCCatColumna(),
					abcMapeoLineaColumnaEntity.getBolActivo(),
					abcMapeoLineaColumnaEntity.getBolCarga(),
					abcMapeoLineaColumnaEntity.getBolValidacion(),
					abcMapeoLineaColumnaEntity.getBolEnvio(),
					abcMapeoLineaColumnaEntity.getRegex(),
					abcMapeoLineaColumnaEntity.getFecCreacion(),
					abcMapeoLineaColumnaEntity.getIdABCUsuarioUltModificacion(),
					abcMapeoLineaColumnaEntity.getFecUltModificacion());*/
			
			
	
			
			 String sql = "UPDATE ABC_MAPEO_LINEA_COLUMNA SET BOL_CARGA=?,\r\n"
	 			 		+ "BOL_VALIDACION=?,\r\n"
	 			 		+ "BOL_ENVIO=?,\r\n"
	 			 		+ "REGEX=?,\r\n"
	 			 		+ "ID_ABC_USUARIO_ULT_MODIFICACION= ?,\r\n"
	 			 		+ "FEC_ULT_MODIFICACION= ?\r\n"
	 			 		+ "where ID_ABC_CONFIG_MAPEO_LINEA = ?\r\n"
	 			 		+ "and ID_ABC_CAT_COLUMNA=?";
			
			
		
			 jdbcTemplate.update(sql,
					 abcMapeoLineaColumnaEntity.getBolCarga(),
				 abcMapeoLineaColumnaEntity.getBolValidacion(),
				abcMapeoLineaColumnaEntity.getBolEnvio(),
				 abcMapeoLineaColumnaEntity.getRegex(),
				abcMapeoLineaColumnaEntity.getIdABCUsuarioUltModificacion(),
				abcMapeoLineaColumnaEntity.getFecUltModificacion(),
				abcMapeoLineaColumnaEntity.getIdABCConfigMapeoLinea(),
				abcMapeoLineaColumnaEntity.getIdABCCatColumna()
					 
					 
					 
					 
					 );
	/*		try {
				LineacolumnaDao lineacolumnaDao = new LineacolumnaDao(url,user,password);
				Boolean actualizado=lineacolumnaDao.actualizar(abcMapeoLineaColumnaEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
			mapeoLineaColumnaResponseDTO = mapeoLineasColumnaMapper.llenarDTO(abcMapeoLineaColumnaEntity);

		}else {
			mapeoLineaColumnaResponseDTO=null;
		}


		return mapeoLineaColumnaResponseDTO;


	}


	public Boolean activar(MapeoLineaColumnaRequestDTO mapeoLineaColumnaRequestDTO) {
		Boolean activado= false;


		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = 
				abcMapeoLineaColumnaRepository.findByIdABCConfigMapeoLineaAndIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea(),mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
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

		Optional<ABCMapeoLineaColumnaEntity> abcMapeoLineaColumnaEntityOptional = 
				abcMapeoLineaColumnaRepository.findByIdABCConfigMapeoLineaAndIdABCCatColumna(mapeoLineaColumnaRequestDTO.getIdABCConfigMapeoLinea(),mapeoLineaColumnaRequestDTO.getIdABCCatColumna());
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
