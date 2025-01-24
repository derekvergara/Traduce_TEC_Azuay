package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.JuegoDao;
import com.ista.demo.Dao.UsuarioDai;
import com.ista.demo.Entity.Juego;
import com.ista.demo.Entity.Usuario;

@Service
public class JuegolmpService implements IJuegoService {

	
	@Autowired
	private JuegoDao juegoDao;

	@Override
	@Transactional(readOnly = true )
	public List<Juego> findAll() {
		// TODO Auto-generated method stub
		return (List<Juego>)juegoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Juego findById(Long id) {
		// TODO Auto-generated method stub
		return juegoDao.findById(id).orElse(null);
	}

	@Override
	public Juego save(Juego juego) {
		// TODO Auto-generated method stub
		return juegoDao.save(juego);
	}

	@Override
	public void delete(Long id) {

		juegoDao.deleteById(id);
		
	}

}
