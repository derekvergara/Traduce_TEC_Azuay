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

import com.ista.demo.Entity.Categoria;
import com.ista.demo.Service.ICategoriaService;


@RestController
@RequestMapping("/api")
public class CategoriaController {
	

	@Autowired
	private ICategoriaService CategoriaServ;
	
	@GetMapping("/Categoria")
	public List<Categoria> indext(){
		return CategoriaServ.findAll();
	}
	
	@GetMapping("/Categoria/{id}")
	public Categoria show(@PathVariable("id") Long id) {
		return CategoriaServ.findById(id);
	}
	
	@PostMapping("/Categoria")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria cate){
		return CategoriaServ.save(cate);
	}
	
	@PutMapping("/Categoria/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria update(@RequestBody Categoria categoria, @PathVariable("id") Long id) {
		Categoria cate1 = CategoriaServ.findById(id);
		cate1.setNombre_categoria(categoria.getNombre_categoria());
		cate1.setDescripcion(categoria.getDescripcion());
		cate1.setAprendizajes(categoria.getAprendizajes());

		return CategoriaServ.save(cate1);
	}
	
	@DeleteMapping("/Categoria/{id}")
	public void delete(@PathVariable("id") Long id) {
		CategoriaServ.delete(id);
	}


}
