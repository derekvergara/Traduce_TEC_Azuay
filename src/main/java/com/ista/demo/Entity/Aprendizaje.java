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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aprendizaje")
public class Aprendizaje implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_aprendizaje;
	
	private String nombre_aprendizaje;
	private String significado;
	private String imagen;
	
	//relaciones
			@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion M a 1 y definimos tipo cascada
			@JoinColumn(name="id_aprendizaje")//creamos la llave foranea
			private List<Nivel> nivel_relacion; //para la clase historial
			
			@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion m a 1 y definimos tipo cascada
			@JoinColumn(name="id_aprendizaje")//creamos la llave foranea
			private List<Categoria> categoria_relacion; //para la clase proceso

			public Long getId_aprendizaje() {
				return id_aprendizaje;
			}

			public void setId_aprendizaje(Long id_aprendizaje) {
				this.id_aprendizaje = id_aprendizaje;
			}

			public String getNombre_aprendizaje() {
				return nombre_aprendizaje;
			}

			public void setNombre_aprendizaje(String nombre_aprendizaje) {
				this.nombre_aprendizaje = nombre_aprendizaje;
			}

			public String getSignificado() {
				return significado;
			}

			public void setSignificado(String significado) {
				this.significado = significado;
			}

			public String getImagen() {
				return imagen;
			}

			public void setImagen(String imagen) {
				this.imagen = imagen;
			}

			public List<Nivel> getNivel_relacion() {
				return nivel_relacion;
			}

			public void setNivel_relacion(List<Nivel> nivel_relacion) {
				this.nivel_relacion = nivel_relacion;
			}

			public List<Categoria> getCategoria_relacion() {
				return categoria_relacion;
			}

			public void setCategoria_relacion(List<Categoria> categoria_relacion) {
				this.categoria_relacion = categoria_relacion;
			}
			
	
	
			
	
	

}
