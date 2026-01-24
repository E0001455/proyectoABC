package mx.com.proyectohu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.ABCConfigMapeoLineaEntity;

@Repository
public interface  ABCConfigMapeoLineaRepository extends JpaRepository<ABCConfigMapeoLineaEntity, Long> {

}
