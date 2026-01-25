package mx.com.proyectohu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.proyectohu.repository.BitacoraUsarioRepository;
import mx.com.proyectohu.dto.BitacoraUsuarioRequestDTO;
import mx.com.proyectohu.entity.BitacoraUsuarioEntity;

@Service
public class BitacoraUsuarioService {

	@Autowired
	public BitacoraUsarioRepository bitacoraUsarioRepository;
	



	public Long  registrarBitacoraUsuario(BitacoraUsuarioRequestDTO bitacoraUsuarioRequestDTO) {


		BitacoraUsuarioEntity bitacoraUsuarioEntity = new BitacoraUsuarioEntity();
		Long idBitacoraUsuario = 0L;

	
		bitacoraUsuarioEntity.setIdABCUsuario(bitacoraUsuarioRequestDTO.getIdABCUsuario());
		bitacoraUsuarioEntity.setIdABCCatEvento(bitacoraUsuarioRequestDTO.getIdABCCatEvento());
		bitacoraUsuarioEntity.setIdABCCatObjeto(bitacoraUsuarioRequestDTO.getIdABCCatObjeto());
		bitacoraUsuarioEntity.setIdABCCatColumna(bitacoraUsuarioRequestDTO.getIdABCCatColumna());
		bitacoraUsuarioEntity.setDetalle(bitacoraUsuarioRequestDTO.getDetalle());
		bitacoraUsuarioEntity.setIp(bitacoraUsuarioRequestDTO.getIp());
		bitacoraUsuarioEntity.setNavegador(bitacoraUsuarioRequestDTO.getNavegador());
		bitacoraUsuarioEntity.setFecCreacion(new Date());
		bitacoraUsuarioEntity.setFecUltModificacion(new Date());


		idBitacoraUsuario=bitacoraUsarioRepository.save(bitacoraUsuarioEntity).getIdABCBitacoraUsuario();



		return	idBitacoraUsuario;	

	}

	

}
