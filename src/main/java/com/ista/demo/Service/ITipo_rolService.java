package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Tipo_rol;

public interface ITipo_rolService {

public List<Tipo_rol> findAll();
	
	public Tipo_rol findById(Long id);
	
	public Tipo_rol save(Tipo_rol tipo_rol);
	
	public void delete(Long id);

}
