package com.ista.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.demo.Dao.UsuarioDai;
import com.ista.demo.Entity.Historial_traduccion;
import com.ista.demo.Entity.Usuario;
import com.ista.demo.Service.IHistorialTraduccionService;

@RestController
@RequestMapping("/api")
public class HitorialController {

	@Autowired
	private IHistorialTraduccionService hitorialServ;

	@Autowired
	private UsuarioDai usuarioDai; // Inyección de UsuarioDai

	@GetMapping("/historial")
	public List<Historial_traduccion> indext() {
		return hitorialServ.findAll();
	}

	@GetMapping("/historial/{id}")
	public Historial_traduccion show(@PathVariable Long id) {
		return hitorialServ.findById(id);
	}

	@PostMapping("/historial")
	@ResponseStatus(HttpStatus.CREATED)
	public Historial_traduccion create(@RequestBody Historial_traduccion histo) {
		return hitorialServ.save(histo);
	}

	@PutMapping("/historial/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Historial_traduccion update(@RequestBody Historial_traduccion histo, @PathVariable Long id) {
		Historial_traduccion histo1 = hitorialServ.findById(id);
		histo1.setTexto(histo.getTexto());
		histo1.setTipo_traduccion(histo.getTipo_traduccion());
		histo1.setFecha_traduccion(histo.getFecha_traduccion());

		return hitorialServ.save(histo1);
	}

	@DeleteMapping("/historial/{id}")
	public void delete(@PathVariable Long id) {
		hitorialServ.delete(id);
	}

	// Nuevo metodo para obtener las traducciones de un usuario
	@GetMapping("/historial/usuario/{userId}")
	public List<Historial_traduccion> getHistorialByUsuarioId(@PathVariable Long userId) {
		return hitorialServ.findByUsuarioId(userId);
	}

	// Metodo para crear la traduccion con relacion al usuario
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Historial_traduccion crearHistorial(@RequestBody Historial_traduccion historial) {
		// Buscar el usuario por su ID
		Usuario usuario = usuarioDai.findById(historial.getUsuario().getId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		// Asociar el usuario al historial
		historial.setUsuario(usuario);

		// No envíes un ID manualmente
		historial.setId_historial_traduccion(null);

		// Guardar el historial
		return hitorialServ.save(historial);
	}

	// Nuevo metodo de consutar por fechas
	@GetMapping("/historial/usuario/{userId}/rango")
	public List<Historial_traduccion> getHistorialByUsuarioAndDateRange(@PathVariable("userId") Long userId,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
		return hitorialServ.findByUsuarioIdAndFechaBetween(userId, start, end);
	}
}
