package mx.com.proyectohu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ExtensionPerfilEntity;

@Repository
public interface  ExtencionPerfilRepository extends JpaRepository<ExtensionPerfilEntity, Long> {

	



}
