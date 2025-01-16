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

import com.ista.demo.Entity.Proceso;
import com.ista.demo.Service.IProcesoService;

@RestController
@RequestMapping("/api")
public class ProcesoController {

	@Autowired
	private IProcesoService procesoServ;
	
	@GetMapping("/proceso")
	public List<Proceso> indext(){
		return procesoServ.findAll();
	}
	
	@GetMapping("/proceso/{id}")
	public Proceso show(@PathVariable Long id) {
		return procesoServ.findById(id);
	}
	
	@PostMapping("/proceso")
	@ResponseStatus(HttpStatus.CREATED)
	public Proceso create(@RequestBody Proceso proce){
		return procesoServ.save(proce);
	}
	
	@PutMapping("/proceso/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proceso update(@RequestBody Proceso proceso, @PathVariable Long id) {
		Proceso proce1 = procesoServ.findById(id);
		proce1.setPorcentaje_proceso(proceso.getPorcentaje_proceso());
		
		return procesoServ.save(proce1);
	}
	
	@DeleteMapping("/proceso/{id}")
	public void delete(@PathVariable Long id) {
		procesoServ.delete(id);
	}

}
