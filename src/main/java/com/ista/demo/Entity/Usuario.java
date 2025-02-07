package com.ista.demo.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)//id auto
	private Long id;
	
	private String usuario;
	private String pasword;
	private int edad;
	private String telefono;
	private boolean carnet_discapacidad;
	private int porcentaje_de_discapacidad;
	private String correo;
	private String nombre;
	private String numero_carnet;
	
	//relaciones
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a M y definimos tipo cascada
		@JoinColumn(name="usuario_id")//creamos la llave foranea
		@JsonManagedReference // Relación gestionada desde el lado de Usuario
		private List<Historial_traduccion> historial_traduccion1; //para la clase historial
		
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a M y definimos tipo cascada
		@JoinColumn(name="usuario_id")//creamos la llave foranea
		@JsonManagedReference // Controla la serialización
		private List<Progreso> proceso1; //para la clase proceso
		

		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//relacion 1 a M y definimos tipo cascada
		@JoinColumn(name="usuario_id")//creamos la llave foranea
		private List<Tipo_rol> tipo_tol1; //para la clase 
	
		

		
		
	public String getNumero_carnet() {
			return numero_carnet;
		}
		public void setNumero_carnet(String numero_carnet) {
			this.numero_carnet = numero_carnet;
		}
	public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	public List<Tipo_rol> getTipo_tol1() {
			return tipo_tol1;
		}
		public void setTipo_tol1(List<Tipo_rol> tipo_tol1) {
			this.tipo_tol1 = tipo_tol1;
		}
	public List<Progreso> getProceso1() {
			return proceso1;
		}
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		public void setProceso1(List<Progreso> proceso1) {
			this.proceso1 = proceso1;
		}
	public List<Historial_traduccion> getHistorial_traduccion1() {
			return historial_traduccion1;
		}
		public void setHistorial_traduccion1(List<Historial_traduccion> historial_traduccion1) {
			this.historial_traduccion1 = historial_traduccion1;
		}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean getCarnet_discapacidad() {
		return carnet_discapacidad;
	}
	public void setCarnet_discapacidad(boolean carnet_discapacidad) {
		this.carnet_discapacidad = carnet_discapacidad;
	}
	public int getPorcentaje_de_discapacidad() {
		return porcentaje_de_discapacidad;
	}
	public void setPorcentaje_de_discapacidad(int porcentaje_de_discapacidad) {
		this.porcentaje_de_discapacidad = porcentaje_de_discapacidad;
	}
	
}
