package com.ista.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.demo.Entity.Juego;
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
        Optional<Progreso> progresoExistente = Optional.ofNullable(progresoServ.findById(id));
        
        if (progresoExistente.isPresent()) {
            Progreso prog = progresoExistente.get();
            
            System.out.println("🔍 Actualizando progreso:");
            System.out.println("   - ID progreso: " + prog.getId_progreso());
            System.out.println("   - Nivel actual (antes): " + prog.getNivel_actual());

            if (prog.getJuego() == null) {
                System.out.println("⚠️ Error: El juego es NULL en la base de datos. Buscando el juego manualmente...");
                
                // Buscar el juego manualmente si es NULL
                Optional<Juego> juego = Optional.ofNullable(juegoService.findById(progreso.getJuego().getIdJuego()));
                if (juego.isPresent()) {
                    prog.setJuego(juego.get()); // Asignamos el juego manualmente
                } else {
                    System.out.println("❌ Error: No se encontró el juego con ID " + progreso.getJuego().getIdJuego());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                }
            }

            System.out.println("   - Juego ID (guardado): " + prog.getJuego().getIdJuego());
            
         // Solo actualiza el nivel si es mayor
            if (progreso.getNivel_actual() > prog.getNivel_actual()) {
                prog.setNivel_actual(progreso.getNivel_actual());
                prog.setPorcentaje_progreso(progreso.getPorcentaje_progreso());
                progresoServ.save(prog);
                System.out.println("✅ Progreso actualizado correctamente.");
            } else {
                System.out.println("⚠️ No se actualiza el nivel porque el nuevo nivel es menor o igual al actual.");
            }
            
            return ResponseEntity.ok(prog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
