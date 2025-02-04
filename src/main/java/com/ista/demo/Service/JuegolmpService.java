package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.JuegoDao;
import com.ista.demo.Entity.Juego;

@Service
public class JuegolmpService implements IJuegoService {

    @Autowired
    private JuegoDao juegoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Juego> findAll() {
        return (List<Juego>) juegoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Juego findById(Long id) {
        return juegoDao.findById(id).orElse(null);
    }

    @Override
    public Juego save(Juego juego) {
        return juegoDao.save(juego);
    }

    @Override
    public void delete(Long id) {
        juegoDao.deleteById(id);
    }

    // Nuevo método para obtener el número total de niveles de un juego
    @Transactional(readOnly = true)
    public int getNivelesDeJuego(Long idJuego) {
        Juego juego = findById(idJuego);
        return (juego != null) ? juego.getNiveles() : 0; // Retorna 0 si el juego no existe
    }
}
