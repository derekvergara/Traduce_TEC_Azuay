package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Categoria;

public interface ICategoriaService {
	
	
public List<Categoria> findAll();
	
	public Categoria findById(Long id);
	
	public Categoria save(Categoria categorias);
	
	public void delete(Long id);
}
