package com.ista.demo.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.IProgresoDao;
import com.ista.demo.Entity.Progreso;

@Service
public class ProgresoServicelmp implements IProgresoService{

	@Autowired
	private IProgresoDao progresoDao;

	@Override
	@Transactional(readOnly = true )
	public List<Progreso> findAll() {
		// TODO Auto-generated method stub
		return (List<Progreso>)progresoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Progreso findById(Long id) {
		// TODO Auto-generated method stub
		return progresoDao.findById(id).orElse(null);
	}

	@Override
	public Progreso save(Progreso progreso) {
		// TODO Auto-generated method stub
		return progresoDao.save(progreso);
	}

	@Override
	public void delete(Long id) {
		progresoDao.deleteById(id);
	}
	
	@Override
    public Optional<Progreso> findByUsuarioAndJuego(Long usuarioId, Long juegoId) {
        return progresoDao.findByUsuario_IdAndJuego_IdJuego(usuarioId, juegoId);
    }

}
