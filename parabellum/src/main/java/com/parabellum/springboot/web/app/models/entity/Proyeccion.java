package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="proyecciones")
public class Proyeccion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyeccion")
	private Long idProyeccion;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@NotNull
	@Column(name="costo")
	private Float costo;
	
	@NotNull
	@Column(name="estado")
	private Boolean estado;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pelicula")
	private Pelicula pelicula;
	
	private Long forPelicula;

	@NotNull
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_sala")
	private Sala sala;
	
	private Long forSala;

	


	public Long getForPelicula() {
		return forPelicula;
	}


	public void setForPelicula(Long forPelicula) {
		this.forPelicula = forPelicula;
	}


	public Long getForSala() {
		return forSala;
	}


	public void setForSala(Long forSala) {
		this.forSala = forSala;
	}


	public Sala getSala() {
		return sala;
	}

	
	public void setSala(Sala sala) {
		this.sala = sala;
	}

	//Getters and Setters
	public Long getIdProyeccion() {
		return idProyeccion;
	}

	public void setIdProyeccion(Long idProyeccion) {
		this.idProyeccion = idProyeccion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
