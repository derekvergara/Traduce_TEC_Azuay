package com.ista.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.demo.Entity.Usuario;
import com.ista.demo.Service.UsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@GetMapping("/usuario")
	public List<Usuario> indext(){
		return usuarioServ.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioServ.findById(id);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario canci){
		return usuarioServ.save(canci);
	}
	
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usu1 = usuarioServ.findById(id);
		usu1.setUsuario(usuario.getUsuario());
		usu1.setPasword(usuario.getPasword());
		usu1.setCarnet_discapacidad(usuario.isCarnet_discapacidad());
		usu1.setEdad(usuario.getEdad());
		usu1.setTelefono(usuario.getTelefono());
		usu1.setPorcentaje_de_discapacidad(usuario.getPorcentaje_de_discapacidad());
		
		return usuarioServ.save(usu1);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable Long id) {
		usuarioServ.delete(id);
	}

}
