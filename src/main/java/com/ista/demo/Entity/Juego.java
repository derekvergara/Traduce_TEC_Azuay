package com.ista.demo.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "juego")
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego") // Aquí puedes seguir usando el nombre de la BD
    private Long idJuego; // CAMBIO: Ahora usa camelCase

    private String nombre_juego;
    private String descripcion_juego;
    private int niveles; // Niveles del juego, se desbloquea progresivamente.

    // Getters y Setters
    public Long getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Long idJuego) {
		this.idJuego = idJuego;
	}

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

	public int getNiveles() {
		return niveles;
	}

	public void setNiveles(int niveles) {
		this.niveles = niveles;
	}
}
