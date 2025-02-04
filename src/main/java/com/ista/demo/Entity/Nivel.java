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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincremental
    private Long id_nivel;

    private String nombre_nivel;
    private String descripcion;


    // Relaciones
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nivel_id") // Llave foránea en la tabla aprendizajes
    private List<Aprendizaje> aprendizajes;

    // Getters y Setters
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
