package com.ista.demo.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore

	//relaciones
			@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion M a 1 y definimos tipo cascada
			@JoinColumn(name="nivel_id")//creamos la llave foranea
			private Nivel nivel_id; //para la clase historial
    @JsonIgnore

			@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion m a 1 y definimos tipo cascada
			@JoinColumn(name="categoria_id")//creamos la llave foranea
			private Categoria categoria_id; //para la clase proceso

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

			public Nivel getNivel_id() {
				return nivel_id;
			}

			public void setNivel_id(Nivel nivel_id) {
				this.nivel_id = nivel_id;
			}

			public Categoria getCategoria_id() {
				return categoria_id;
			}

			public void setCategoria_id(Categoria categoria_id) {
				this.categoria_id = categoria_id;
			}
			
	
	
			
	
	

}
