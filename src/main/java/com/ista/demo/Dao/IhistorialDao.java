package com.ista.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ista.demo.Entity.Historial_traduccion;

public interface IhistorialDao extends CrudRepository<Historial_traduccion, Long> {

	@Query("SELECT h FROM Historial_traduccion h WHERE h.usuario.id = :userId")
    List<Historial_traduccion> findByUsuarioId(@Param("userId") Long userId);
}
