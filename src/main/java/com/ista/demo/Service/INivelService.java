package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Nivel;

public interface INivelService {
	
public List<Nivel> findAll();
	
	public Nivel findById(Long id);
	
	public Nivel save(Nivel Nivels);
	
	public void delete(Long id);

}
