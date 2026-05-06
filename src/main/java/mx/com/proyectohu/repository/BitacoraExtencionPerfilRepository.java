package mx.com.proyectohu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.proyectohu.entity.BitacoraExtencionPerfilEntity;

@Repository
public interface  BitacoraExtencionPerfilRepository extends JpaRepository<BitacoraExtencionPerfilEntity, Long> {

	


}
