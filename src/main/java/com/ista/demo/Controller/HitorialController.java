package com.ista.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.demo.Entity.Historial_traduccion;
import com.ista.demo.Service.IHistorialTraduccionService;

@RestController
@RequestMapping("/api")
public class HitorialController {

	@Autowired
	private IHistorialTraduccionService hitorialServ;
	
	@GetMapping("/historial")
	public List<Historial_traduccion> indext(){
		return hitorialServ.findAll();
	}
	
	@GetMapping("/historial/{id}")
	public Historial_traduccion show(@PathVariable Long id) {
		return hitorialServ.findById(id);
	}
	
	@PostMapping("/historial")
	@ResponseStatus(HttpStatus.CREATED)
	public Historial_traduccion create(@RequestBody Historial_traduccion histo){
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

}
