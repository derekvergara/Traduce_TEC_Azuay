package com.ista.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.demo.Entity.Progreso;
import com.ista.demo.Service.IProgresoService;
import com.ista.demo.Service.JuegolmpService;

@RestController
@RequestMapping("/api")
public class ProgresoController {

    @Autowired
    private IProgresoService progresoServ;

    @Autowired
    private JuegolmpService juegoService;

    // Obtener el progreso de un usuario en un juego
    @GetMapping("/progreso/{usuarioId}/{juegoId}")
    public ResponseEntity<Progreso> obtenerProgreso(@PathVariable Long usuarioId, @PathVariable Long juegoId) {
        Optional<Progreso> progresoExistente = progresoServ.findByUsuarioAndJuego(usuarioId, juegoId);
        return progresoExistente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o cargar el progreso del usuario en el juego
    @PostMapping("/progreso")
    public ResponseEntity<Progreso> crearProgreso(@RequestBody Progreso progreso) {
        Optional<Progreso> progresoExistente = progresoServ.findByUsuarioAndJuego(progreso.getUsuario().getId(), progreso.getJuego().getIdJuego());
        if (progresoExistente.isPresent()) {
            return ResponseEntity.ok(progresoExistente.get()); // Si ya existe, devolver el progreso actual
        }
        
        // Crear un nuevo progreso en el nivel 1 con 0% de avance
        progreso.setNivel_actual(1);
        progreso.setPorcentaje_progreso(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(progresoServ.save(progreso));
    }

    // Actualizar el progreso del usuario
    @PutMapping("/progreso/{id}")
    public ResponseEntity<Progreso> actualizarProgreso(@PathVariable Long id, @RequestBody Progreso progreso) {
        Progreso progresoExistente = progresoServ.findById(id);
        if (progresoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Obtener el número total de niveles del juego
        int nivelesTotales = juegoService.getNivelesDeJuego(progresoExistente.getJuego().getIdJuego());
        
        // Validar que el progreso solo aumente y nunca retroceda
        if (progreso.getNivel_actual() > progresoExistente.getNivel_actual() && progreso.getNivel_actual() <= nivelesTotales) {
            progresoExistente.setNivel_actual(progreso.getNivel_actual());
            progresoExistente.setPorcentaje_progreso(progreso.getPorcentaje_progreso());
            return ResponseEntity.ok(progresoServ.save(progresoExistente));
        }
        
        return ResponseEntity.badRequest().body(progresoExistente);
    }
}
