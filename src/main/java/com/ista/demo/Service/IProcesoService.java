package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Proceso;

public interface IProcesoService {
	
public List<Proceso> findAll();
	
	public Proceso findById(Long id);
	
	public Proceso save(Proceso proceso);
	
	public void delete(Long id);
	

}
