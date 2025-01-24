package com.ista.demo.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="categoria")

public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_categoria;

	private String nombre_categoria;
	private String descripcion;
	
	//relaciones
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a m y definimos tipo cascada
	@JoinColumn(name="id_categoria")//creamos la llave foranea
	private List<Aprendizaje> aprendizajes; //para la clase

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Aprendizaje> getAprendizajes() {
		return aprendizajes;
	}

	public void setAprendizajes(List<Aprendizaje> aprendizajes) {
		this.aprendizajes = aprendizajes;
	}
	
	
	
	

}
