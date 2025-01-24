package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.INivelDao;
import com.ista.demo.Entity.Nivel;

@Service
public class NivelImpService implements INivelService {
	

	@Autowired
	private INivelDao NivelDao;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel> findAll() {
		// TODO Auto-generated method stub
		return (List<Nivel>) NivelDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel findById(Long id) {
		// TODO Auto-generated method stub
		return NivelDao.findById(id).orElse(null);
	}

	@Override
	public Nivel save(Nivel nivel) {
		// TODO Auto-generated method stub
		return NivelDao.save(nivel);
	}

	@Override
	public void delete(Long id) {

		NivelDao.deleteById(id);

	}

}
