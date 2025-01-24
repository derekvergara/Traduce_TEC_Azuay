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
@Table (name="nivel")

public class Nivel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_nivel;

	private String nombre_nivel;
	private String descripcion;
	
	//relaciones
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a m y definimos tipo cascada
	@JoinColumn(name="id_nivel")//creamos la llave foranea
	private List<Aprendizaje> aprendizajes; //para la clase

	public Long getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(Long id_nivel) {
		this.id_nivel = id_nivel;
	}

	public String getNombre_nivel() {
		return nombre_nivel;
	}

	public void setNombre_nivel(String nombre_nivel) {
		this.nombre_nivel = nombre_nivel;
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
