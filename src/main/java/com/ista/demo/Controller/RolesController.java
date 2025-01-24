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

import com.ista.demo.Entity.Roles;
import com.ista.demo.Service.IRolesService;

@RestController
@RequestMapping("/api")
public class RolesController {

	@Autowired
	private IRolesService rolesServ;
	
	@GetMapping("/roles")
	public List<Roles> indext(){
		return rolesServ.findAll();
	}
	
	@GetMapping("/roles/{id}")
	public Roles show(@PathVariable Long id) {
		return rolesServ.findById(id);
	}
	
	@PostMapping("/roles")
	@ResponseStatus(HttpStatus.CREATED)
	public Roles create(@RequestBody Roles rol){
		return rolesServ.save(rol);
	}
	
	@PutMapping("/roles/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Roles update(@RequestBody Roles roles, @PathVariable Long id) {
		Roles rol1 = rolesServ.findById(id);
		rol1.setDescripcion_rol(roles.getDescripcion_rol());
		
		return rolesServ.save(rol1);
	}
	
	@DeleteMapping("/roles/{id}")
	public void delete(@PathVariable Long id) {
		rolesServ.delete(id);
	}

}
