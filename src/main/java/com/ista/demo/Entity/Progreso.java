package com.ista.demo.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso")
public class Progreso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_progreso;

    private int nivel_actual; // Último nivel desbloqueado.
    private float porcentaje_progreso;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Relación con Usuario
    @JsonBackReference // Evita la serialización infinita
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id", nullable = false) // Relación con Juego
    private Juego juego;

    // Getters y Setters
    public Long getId_progreso() {
        return id_progreso;
    }

    public void setId_progreso(Long id_progreso) {
        this.id_progreso = id_progreso;
    }

    public int getNivel_actual() {
        return nivel_actual;
    }

    public void setNivel_actual(int nivel_actual) {
        this.nivel_actual = nivel_actual;
    }

    public float getPorcentaje_progreso() {
        return porcentaje_progreso;
    }

    public void setPorcentaje_progreso(float porcentaje_progreso) {
        this.porcentaje_progreso = porcentaje_progreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
