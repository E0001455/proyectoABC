package mx.com.proyectohu.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ColumnalineaUpdate {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int updateMapeoLineaColumna(
            Long idABCConfigMapeoLinea,
            Long idABCCatColumna,
            Boolean bolActivo,
            Boolean bolCarga,
            Boolean bolValidacion,
            Boolean bolEnvio,
            String regex,
            Date fecCreacion,
            Long idABCUsuarioUltModificacion,
            Date fecUltModificacion
    ) {

        return entityManager.createNativeQuery(
                "UPDATE ABC_MAPEO_LINEA_COLUMNA SET " +
                "BOL_ACTIVO = ?3, " +
                "BOL_CARGA = ?4, " +
                "BOL_VALIDACION = ?5, " +
                "BOL_ENVIO = ?6, " +
                "REGEX = ?7, " +
                "FEC_CREACION = ?8, " +
                "ID_ABC_USUARIO_ULT_MODIFICACION = ?9, " +
                "FEC_ULT_MODIFICACION = ?10 " +
                "WHERE ID_ABC_CONFIG_MAPEO_LINEA = ?1 " +
                "AND ID_ABC_CAT_COLUMNA = ?2"
        )
        .setParameter(1, idABCConfigMapeoLinea)
        .setParameter(2, idABCCatColumna)
        .setParameter(3, bolActivo)
        .setParameter(4, bolCarga)
        .setParameter(5, bolValidacion)
        .setParameter(6, bolEnvio)
        .setParameter(7, regex)
        .setParameter(8, fecCreacion)
        .setParameter(9, idABCUsuarioUltModificacion)
        .setParameter(10, fecUltModificacion)
        .executeUpdate();
    }
}
