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

import com.ista.demo.Entity.Juego;
import com.ista.demo.Service.IJuegoService;

@RestController
@RequestMapping("/api")
public class JuegoController {

	@Autowired
	private IJuegoService juegoServ;
	
	@GetMapping("/juego")
	public List<Juego> indext(){
		return juegoServ.findAll();
	}
	
	@GetMapping("/juego/{id}")
	public Juego show(@PathVariable Long id) {
		return juegoServ.findById(id);
	}
	
	@PostMapping("/juego")
	@ResponseStatus(HttpStatus.CREATED)
	public Juego create(@RequestBody Juego jue){
		return juegoServ.save(jue);
	}
	
	@PutMapping("/juego/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Juego update(@RequestBody Juego jue, @PathVariable Long id) {
		Juego jue1 = juegoServ.findById(id);
		jue1.setNombre_juego(jue.getNombre_juego());
		jue1.setDescripcion_juego(jue.getDescripcion_juego());
		jue1.setNiveles(jue.getNiveles());
		
		return juegoServ.save(jue1);
	}
	
	@DeleteMapping("/juego/{id}")
	public void delete(@PathVariable Long id) {
		juegoServ.delete(id);
	}
	
}
