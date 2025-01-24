package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.ICategoriaDao;
import com.ista.demo.Entity.Categoria;

@Service
public class CategoriaImpService implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categoria);
	}

	@Override
	public void delete(Long id) {

		categoriaDao.deleteById(id);

	}
}
