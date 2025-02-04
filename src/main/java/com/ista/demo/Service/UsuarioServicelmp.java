package com.ista.demo.Service;

import java.nio.ReadOnlyBufferException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.UsuarioDai;
import com.ista.demo.Entity.Usuario;


@Service
public class UsuarioServicelmp implements UsuarioService {
	
	@Autowired
	private UsuarioDai usuarioDao;

	@Override
	@Transactional(readOnly = true )
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	public void delete(Long id) {

		usuarioDao.deleteById(id);
		
	}
	
	@Override
	public Usuario findByUsuario(String usuario) {
	    return usuarioDao.findByUsuario(usuario);
	}

}
