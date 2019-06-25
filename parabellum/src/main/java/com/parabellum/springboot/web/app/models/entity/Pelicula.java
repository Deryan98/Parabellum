package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy="peliculas",fetch= FetchType.EAGER)
	@Column(name = "id_pelicula")
	private Long idPelicula;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String duracion;
	
	@NotNull
	private boolean estreno;
	
	@NotEmpty 
	private String genero;
	
	@NotEmpty
	private String formato;
	
	@NotEmpty
	private String idioma;
	
	@NotNull
	private boolean estado;
	
	@OneToMany(mappedBy="peliculas", fetch= FetchType.EAGER)
	private List<Proyeccion> proyecciones;
	public List<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(List<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Creando Setters y Getters
	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
		
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	public String getDuracion() {
		return duracion;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}
	
	public boolean isEstreno() {
		return estreno;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
