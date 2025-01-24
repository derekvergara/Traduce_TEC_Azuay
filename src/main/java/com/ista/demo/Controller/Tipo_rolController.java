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

import com.ista.demo.Entity.Tipo_rol;
import com.ista.demo.Service.ITipo_rolService;

@RestController
@RequestMapping("/api")
public class Tipo_rolController {

	@Autowired
	private ITipo_rolService tipo_rolServ;
	
	@GetMapping("/tipo_rol")
	public List<Tipo_rol> indext(){
		return tipo_rolServ.findAll();
	}
	
	@GetMapping("/tipo_rol/{id}")
	public Tipo_rol show(@PathVariable Long id) {
		return tipo_rolServ.findById(id);
	}
	
	@PostMapping("/tipo_rol")
	@ResponseStatus(HttpStatus.CREATED)
	public Tipo_rol create(@RequestBody Tipo_rol tip_rol){
		return tipo_rolServ.save(tip_rol);
	}
	
	@PutMapping("/tipo_rol/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tipo_rol update(@RequestBody Tipo_rol tipo_rol, @PathVariable Long id) {
		Tipo_rol tiprol1 = tipo_rolServ.findById(id);
		
		return tipo_rolServ.save(tiprol1);
	}
	
	@DeleteMapping("/tipo_rol/{id}")
	public void delete(@PathVariable Long id) {
		tipo_rolServ.delete(id);
	}

}
