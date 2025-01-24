package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Juego;

public interface IJuegoService {
	
public List<Juego> findAll();
	
	public Juego findById(Long id);
	
	public Juego save(Juego juego);
	
	public void delete(Long id);
	

}
