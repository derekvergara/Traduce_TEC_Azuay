package com.ista.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.IhistorialDao;
import com.ista.demo.Entity.Historial_traduccion;

@Service
public class HistorialTraduccionServicelpm implements IHistorialTraduccionService {
	
	@Autowired
	private IhistorialDao historialDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historial_traduccion> findAll() {
		return (List<Historial_traduccion>)historialDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true )
	public Historial_traduccion findById(Long id) {
		// TODO Auto-generated method stub
		return historialDao.findById(id).orElse(null);
	}
	
	@Override
	public Historial_traduccion save(Historial_traduccion historial_traduccion) {
		// TODO Auto-generated method stub
		return historialDao.save(historial_traduccion);
	}

	@Override
	public void delete(Long id) {

		historialDao.deleteById(id);
		
	}
	
	@Override
    public List<Historial_traduccion> findByUsuarioId(Long userId) {
        return historialDao.findByUsuarioId(userId);
    }
    
 // nuevo metodo.
    @Override
    public List<Historial_traduccion> findByUsuarioIdAndFechaBetween(Long userId, Date start, Date end) {
        return historialDao.findByUsuarioIdAndFechaBetween(userId, start, end);
    }

}
