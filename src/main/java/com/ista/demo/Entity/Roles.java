package com.ista.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name="roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"tipo_rol_id"})})
public class Roles implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_roles;

	private String descripcion_rol;

	public String getDescripcion_rol() {
		return descripcion_rol;
	}

	public void setDescripcion_rol(String descripcion_rol) {
		this.descripcion_rol = descripcion_rol;
	}
	
	

}
