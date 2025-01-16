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
import jakarta.persistence.UniqueConstraint;


@Entity
@Table (name = "proceso", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id"})})
public class Proceso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_proceso;
	private float porcentaje_proceso;
	
	//relaciones
			@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a M y definimos tipo cascada
			@JoinColumn(name="proceso_id")//creamos la llave foranea
			private List<Juego> Juego1; //para la clase historial

			

	public List<Juego> getJuego1() {
				return Juego1;
			}

			public void setJuego1(List<Juego> juego1) {
				Juego1 = juego1;
			}

	public float getPorcentaje_proceso() {
		return porcentaje_proceso;
	}

	public void setPorcentaje_proceso(float porcentaje_proceso) {
		this.porcentaje_proceso = porcentaje_proceso;
	}

}
