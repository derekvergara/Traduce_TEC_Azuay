package com.ista.demo.Entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name="historial_traduccion")
public class Historial_traduccion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_historial_traduccion;

	private String texto;
	private String tipo_traduccion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_traduccion;
	
	 // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Llave foránea hacia Usuario
    @JsonBackReference
    private Usuario usuario;
	

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo_traduccion() {
		return tipo_traduccion;
	}

	public void setTipo_traduccion(String tipo_traduccion) {
		this.tipo_traduccion = tipo_traduccion;
	}

	public Date getFecha_traduccion() {
		return fecha_traduccion;
	}

	public void setFecha_traduccion(Date fecha_traduccion) {
		this.fecha_traduccion = fecha_traduccion;
	}

	////////////////
	public Long getId_historial_traduccion() {
		return id_historial_traduccion;
	}

	public void setId_historial_traduccion(Long id_historial_traduccion) {
		this.id_historial_traduccion = id_historial_traduccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
