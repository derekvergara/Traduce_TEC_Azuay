package com.ista.demo.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ista.demo.Entity.Progreso;

public interface IProgresoDao extends CrudRepository<Progreso, Long>{
	// Buscar un progreso por usuario y juego
	Optional<Progreso> findByUsuario_IdAndJuego_IdJuego(Long usuarioId, Long juegoId);

}
