package com.ista.demo.Entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name="historial_traduccion", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id"})})
public class Historial_traduccion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id_historial_traduccion;

	private String texto;
	private String tipo_traduccion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_traduccion;
	

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

}
