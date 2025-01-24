package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Aprendizaje;

public interface IAprendizajeService {
	
public List<Aprendizaje> findAll();
	
	public Aprendizaje findById(Long id);
	
	public Aprendizaje save(Aprendizaje aprendizajes);
	
	public void delete(Long id);

}
