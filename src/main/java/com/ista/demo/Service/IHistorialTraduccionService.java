package com.ista.demo.Service;

import java.util.Date;
import java.util.List;


import com.ista.demo.Entity.Historial_traduccion;

public interface IHistorialTraduccionService {

public List<Historial_traduccion> findAll();
	
	public Historial_traduccion findById(Long id);
	
	public Historial_traduccion save(Historial_traduccion historial_traduccion);
	
	public void delete(Long id);
	
	List<Historial_traduccion> findByUsuarioId(Long userId); 
	
	List<Historial_traduccion> findByUsuarioIdAndFechaBetween(Long userId, Date start, Date end); // Nuevo método
}
