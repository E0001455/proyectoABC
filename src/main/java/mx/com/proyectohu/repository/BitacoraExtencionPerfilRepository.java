package mx.com.proyectohu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.dto.MapeoLineaRecordDTO;
import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;
import mx.com.proyectohu.entity.ActividadLineaEntity;
import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;
import mx.com.proyectohu.entity.ExtensionPerfilEntity;
import mx.com.proyectohu.entity.ListaContactoEntity;

@Repository
public interface  BitacoraExtencionPerfilRepository extends JpaRepository<BitacoraExtencionPerfilEntity, Long> {

	


}
