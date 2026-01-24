package mx.com.proyectohu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import mx.com.proyectohu.entity.BitacoraUsuarioEntity;

@Repository
public interface  BitacoraUsarioRepository extends JpaRepository<BitacoraUsuarioEntity, Long> {

}
