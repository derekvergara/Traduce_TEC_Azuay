package com.ista.demo.Controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ista.demo.Entity.Aprendizaje;
import com.ista.demo.Service.IAprendizajeService;

@RestController
@RequestMapping("/api")
public class AprendizajeController {
    
    @Autowired
    private IAprendizajeService AprendizajeServ;
    
    @GetMapping("/Aprendizaje")
    public List<Aprendizaje> getAllAprendizajes() {
        List<Aprendizaje> aprendizajes = AprendizajeServ.findAll();
        for (Aprendizaje aprendizaje : aprendizajes) {
            if (aprendizaje.getImagen() != null) {
                // Convertir el BLOB (imagen en bytes) a Base64
                byte[] imageBytes = aprendizaje.getImagen();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                aprendizaje.setImagenBase64("data:image/jpeg;base64," + base64Image); // o el tipo MIME correspondiente
            }
        }
        return aprendizajes;
    }

    @GetMapping("/Aprendizaje/{id}")
    public ResponseEntity<Aprendizaje> getAprendizaje(@PathVariable Long id) {
        Optional<Aprendizaje> aprendizajeOpt = AprendizajeServ.findById(id);
        if (aprendizajeOpt.isPresent()) {
            Aprendizaje aprendizaje = aprendizajeOpt.get();
            return ResponseEntity.ok(aprendizaje); // Devuelve el objeto aprendizaje con la imagen en Base64
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/Aprendizaje", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Aprendizaje> createAprendizaje(
            @RequestParam("nombre_aprendizaje") String nombreAprendizaje,
            @RequestParam("significado") String significado,
            @RequestParam("imagen") MultipartFile imagen) {
        
        try {
            Aprendizaje nuevoAprendizaje = new Aprendizaje();
            nuevoAprendizaje.setNombre_aprendizaje(nombreAprendizaje);
            nuevoAprendizaje.setSignificado(significado);
            nuevoAprendizaje.setImagen(imagen.getBytes()); // Convertimos la imagen a bytes

            Aprendizaje aprendizajeGuardado = AprendizajeServ.save(nuevoAprendizaje);
            return ResponseEntity.ok(aprendizajeGuardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    
    @DeleteMapping("/Aprendizaje/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        AprendizajeServ.delete(id);
    }
}
