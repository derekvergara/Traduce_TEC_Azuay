package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Roles;

public interface IRolesService {

public List<Roles> findAll();
	
	public Roles findById(Long id);
	
	public Roles save(Roles roles);
	
	public void delete(Long id);
	
}
