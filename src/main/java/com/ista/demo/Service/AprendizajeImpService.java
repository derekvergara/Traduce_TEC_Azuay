package com.ista.demo.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return ((Collection<Aprendizaje>) aprendizajeDao.findAll()).stream()
                .map(this::convertirImagenABase64) // Convierte cada aprendizaje a Base64
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aprendizaje> findById(Long id) {
        return aprendizajeDao.findById(id).map(this::convertirImagenABase64); // Convierte a Base64 si se encuentra
    }

    @Override
    @Transactional
    public Aprendizaje save(Aprendizaje aprendizaje) {
        return aprendizajeDao.save(aprendizaje);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        aprendizajeDao.deleteById(id);
    }

    // Método para convertir imagen a Base64
    private Aprendizaje convertirImagenABase64(Aprendizaje aprendizaje) {
        if (aprendizaje.getImagen() != null) {
            String base64 = java.util.Base64.getEncoder().encodeToString(aprendizaje.getImagen());
            aprendizaje.setImagenBase64(base64); // Guardar el Base64 en el campo
        }
        return aprendizaje;
    }
}
