package com.ista.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name = "juego", uniqueConstraints = {@UniqueConstraint(columnNames = {"proceso_id"})})
public class Juego implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_juego;

	private String nombre_juego;
	private String descripcion_juego;
	
	public String getNombre_juego() {
		return nombre_juego;
	}
	public void setNombre_juego(String nombre_juego) {
		this.nombre_juego = nombre_juego;
	}
	public String getDescripcion_juego() {
		return descripcion_juego;
	}
	public void setDescripcion_juego(String descripcion_juego) {
		this.descripcion_juego = descripcion_juego;
	}
	
	

	
	

}
