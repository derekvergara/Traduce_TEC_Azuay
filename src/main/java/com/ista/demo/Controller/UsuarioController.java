package com.ista.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin(origins = {"http://localhost:4200"})
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
	public Usuario create(@RequestBody Usuario usu){
		return usuarioServ.save(usu);
	}
	
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usu1 = usuarioServ.findById(id);
		usu1.setUsuario(usuario.getUsuario());
		usu1.setPasword(usuario.getPasword());
		usu1.setCarnet_discapacidad(usuario.getCarnet_discapacidad());
		usu1.setEdad(usuario.getEdad());
		usu1.setTelefono(usuario.getTelefono());
		usu1.setPorcentaje_de_discapacidad(usuario.getPorcentaje_de_discapacidad());
		usu1.setCorreo(usuario.getCorreo());
		usu1.setNombre(usuario.getNombre());
		usu1.setNumero_carnet(usuario.getNumero_carnet());
		
		return usuarioServ.save(usu1);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable Long id) {
		usuarioServ.delete(id);
	}
	
	// Endpoint para poder iniciar sesion.
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
	    String username = credentials.get("usuario");
	    String password = credentials.get("pasword");

	    Usuario usuario = usuarioServ.findByUsuario(username);

	    if (usuario != null && usuario.getPasword().equals(password)) {
	        // Login exitoso: incluir el id y otros datos del usuario en la respuesta
	        Map<String, Object> response = new HashMap<>();
	        response.put("success", true);
	        response.put("id", usuario.getId());
	        response.put("nombre", usuario.getNombre());
	        response.put("edad", usuario.getEdad());
	        response.put("correo", usuario.getCorreo());
	        response.put("telefono", usuario.getTelefono());
	        response.put("carnet_discapacidad", usuario.getCarnet_discapacidad());
	        response.put("numero_carnet", usuario.getNumero_carnet());
	        response.put("porcentaje_de_discapacidad", usuario.getPorcentaje_de_discapacidad());
	        // Puedes incluir más datos si es necesario

	        return ResponseEntity.ok(response);
	    } else {
	        // Credenciales incorrectas
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false));
	    }
	}

}
