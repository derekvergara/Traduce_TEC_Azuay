package com.ista.demo.Service;

import java.util.List;
import java.util.Optional;

import com.ista.demo.Entity.Aprendizaje;

public interface IAprendizajeService {
	
public List<Aprendizaje> findAll();
	
	public Optional<Aprendizaje> findById(Long id);
	
	public Aprendizaje save(Aprendizaje aprendizajes);
	
	public void delete(Long id);

}
