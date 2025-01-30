package com.ista.demo.Service;

import java.util.List;

import com.ista.demo.Entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	Usuario findByUsuario(String usuario);
}
