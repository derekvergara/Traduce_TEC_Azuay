package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.IAprendizajeDao;
import com.ista.demo.Entity.Aprendizaje;


@Service
public class AprendizajeImpService implements IAprendizajeService {
	
	@Autowired
	private IAprendizajeDao aprendizajeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Aprendizaje> findAll() {
		// TODO Auto-generated method stub
		return (List<Aprendizaje>) aprendizajeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Aprendizaje findById(Long id) {
		// TODO Auto-generated method stub
		return aprendizajeDao.findById(id).orElse(null);
	}

	@Override
	public Aprendizaje save(Aprendizaje aprendizaje) {
		// TODO Auto-generated method stub
		return aprendizajeDao.save(aprendizaje);
	}

	@Override
	public void delete(Long id) {

		aprendizajeDao.deleteById(id);

	}

}
