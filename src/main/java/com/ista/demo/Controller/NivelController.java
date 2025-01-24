
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

import com.ista.demo.Entity.Nivel;
import com.ista.demo.Service.INivelService;


@RestController
@RequestMapping("/api")
public class NivelController {
	

	@Autowired
	private INivelService NivelServ;
	
	@GetMapping("/Nivel")
	public List<Nivel> indext(){
		return NivelServ.findAll();
	}
	
	@GetMapping("/Nivel/{id}")
	public Nivel show(@PathVariable Long id) {
		return NivelServ.findById(id);
	}
	
	@PostMapping("/Nivel")
	@ResponseStatus(HttpStatus.CREATED)
	public Nivel create(@RequestBody Nivel proce){
		return NivelServ.save(proce);
	}
	
	@PutMapping("/Nivel/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Nivel update(@RequestBody Nivel nivel, @PathVariable Long id) {
		Nivel nivel1 = NivelServ.findById(id);
		nivel1.setNombre_nivel(nivel.getNombre_nivel());
		nivel1.setDescripcion(nivel.getDescripcion());
		
		return NivelServ.save(nivel1);
	}
	
	@DeleteMapping("/Nivel/{id}")
	public void delete(@PathVariable Long id) {
		NivelServ.delete(id);
	}

}
