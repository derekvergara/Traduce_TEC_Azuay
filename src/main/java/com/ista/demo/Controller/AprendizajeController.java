
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

import com.ista.demo.Entity.Aprendizaje;
import com.ista.demo.Service.IAprendizajeService;

@RestController
@RequestMapping("/api")
public class AprendizajeController {
	
	@Autowired
	private IAprendizajeService AprendizajeServ;
	
	@GetMapping("/Aprendizaje")
	public List<Aprendizaje> indext(){
		return AprendizajeServ.findAll();
	}
	
	@GetMapping("/Aprendizaje/{id}")
	public Aprendizaje show(@PathVariable("id") Long id) {
		return AprendizajeServ.findById(id);
	}
	
	@PostMapping("/Aprendizaje")
	@ResponseStatus(HttpStatus.CREATED)
	public Aprendizaje create(@RequestBody Aprendizaje proce){
		return AprendizajeServ.save(proce);
	}
	
	@PutMapping("/Aprendizaje/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aprendizaje update(@RequestBody Aprendizaje aprendizaje, @PathVariable("id") Long id) {
		Aprendizaje apren1 = AprendizajeServ.findById(id);
		apren1.setNombre_aprendizaje(aprendizaje.getNombre_aprendizaje());
		apren1.setSignificado(aprendizaje.getSignificado());
		apren1.setImagen(aprendizaje.getImagen());
		apren1.setCategoria_id(aprendizaje.getCategoria_id());
		apren1.setNivel_id(aprendizaje.getNivel_id());

		return AprendizajeServ.save(apren1);
	}
	
	@DeleteMapping("/Aprendizaje/{id}")
	public void delete(@PathVariable("id") Long id) {
		AprendizajeServ.delete(id);
	}


}
