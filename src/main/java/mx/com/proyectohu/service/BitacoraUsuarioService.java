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
		bitacoraUsuarioEntity.setIdABCCatEvento(bitacoraUsuarioRequestDTO.getBitacoraDTO().getEventoDTO().getIdABCCatEvento());
		bitacoraUsuarioEntity.setIdABCCatObjeto(bitacoraUsuarioRequestDTO.getBitacoraDTO().getObjetoDTO().getIdABCCatObjeto());
		bitacoraUsuarioEntity.setIdABCCatColumnaLinea(bitacoraUsuarioRequestDTO.getBitacoraDTO().getColumnaLineaDTO()!=null
				?bitacoraUsuarioRequestDTO.getBitacoraDTO().getColumnaLineaDTO().getIdABCCatColumnaLinea():null);
		bitacoraUsuarioEntity.setIdABCCatColumnaCampana(bitacoraUsuarioRequestDTO.getBitacoraDTO().getColumnaCampanaDTO()!=null
				?bitacoraUsuarioRequestDTO.getBitacoraDTO().getColumnaCampanaDTO().getIdABCCatColumnaCampana():null);
		bitacoraUsuarioEntity.setDetalle(bitacoraUsuarioRequestDTO.getBitacoraDTO().getDetalle());
		bitacoraUsuarioEntity.setIp(bitacoraUsuarioRequestDTO.getBitacoraDTO().getIp());
		bitacoraUsuarioEntity.setNavegador(bitacoraUsuarioRequestDTO.getBitacoraDTO().getNavegador());
		bitacoraUsuarioEntity.setFecCreacion(new Date());


		idBitacoraUsuario=bitacoraUsarioRepository.save(bitacoraUsuarioEntity).getIdABCBitacoraUsuario();



		return	idBitacoraUsuario;	

	}

	

}
