package com.ista.demo.Service;

import java.util.List;
import java.util.Optional;

import com.ista.demo.Entity.Progreso;

public interface IProgresoService {
	
public List<Progreso> findAll();
	
	public Progreso findById(Long id);
	
	public Progreso save(Progreso progreso);
	
	public void delete(Long id);
	
	// Nuevo método para buscar progreso por usuario y juego
    Optional<Progreso> findByUsuarioAndJuego(Long usuarioId, Long juegoId);
}
