package com.ista.demo.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="tipo_rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id"})})
public class Tipo_rol implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_tipo_rol;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a M y definimos tipo cascada
	@JoinColumn(name="tipo_rol_id")//creamos la llave foranea
	private List<Roles> roles1; //para la clase roles

	public List<Roles> getRoles1() {
		return roles1;
	}

	public void setRoles1(List<Roles> roles1) {
		this.roles1 = roles1;
	}
	
	
}
