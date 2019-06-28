package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "create_at")
	private Date createAt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modified_at")
	private Date modifiedAt;
		
	@OneToMany(mappedBy="pelicula", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Proyeccion> proyecciones;
	
	
	/*
	 * Constructor para instanciar la lista de Proyecciones
	 */
	public Pelicula() {
		proyecciones = new ArrayList<Proyeccion>();
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * Setters and Getters
	 */


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


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public boolean isEstreno() {
		return estreno;
	}


	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getFormato() {
		return formato;
	}


	public void setFormato(String formato) {
		this.formato = formato;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public List<Proyeccion> getProyecciones() {
		return proyecciones;
	}


	public void setProyecciones(List<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}
	
	
	
	
	public Date getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public void addProyeccion(Proyeccion proyeccion) {
		proyecciones.add(proyeccion);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
