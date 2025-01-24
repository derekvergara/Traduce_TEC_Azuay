package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.ITipo_rolDao;
import com.ista.demo.Entity.Tipo_rol;

@Service
public class Tipo_rolServicelmp implements ITipo_rolService{

	@Autowired
	private ITipo_rolDao tipo_rolDao;

	@Override
	@Transactional(readOnly = true )
	public List<Tipo_rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Tipo_rol>)tipo_rolDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Tipo_rol findById(Long id) {
		// TODO Auto-generated method stub
		return tipo_rolDao.findById(id).orElse(null);
	}

	@Override
	public Tipo_rol save(Tipo_rol tipo_rol) {
		// TODO Auto-generated method stub
		return tipo_rolDao.save(tipo_rol);
	}

	@Override
	public void delete(Long id) {

		tipo_rolDao.deleteById(id);
		
	}	
}
