package com.ista.demo.Service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.IProcesoDao;
import com.ista.demo.Entity.Proceso;

@Service
public class ProcesoServicelmp implements IProcesoService{

	@Autowired
	private IProcesoDao procesoDao;

	@Override
	@Transactional(readOnly = true )
	public List<Proceso> findAll() {
		// TODO Auto-generated method stub
		return (List<Proceso>)procesoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Proceso findById(Long id) {
		// TODO Auto-generated method stub
		return procesoDao.findById(id).orElse(null);
	}

	@Override
	public Proceso save(Proceso proceso) {
		// TODO Auto-generated method stub
		return procesoDao.save(proceso);
	}

	@Override
	public void delete(Long id) {

		procesoDao.deleteById(id);
		
	}

}
