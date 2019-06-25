package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class Proyeccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy="proyecciones",fetch= FetchType.EAGER)
	@Column(name = "id_proyeccion")
	private Long idProyeccion;
	
	@NotNull
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@NotNull
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@NotNull
	@Column(name="costo")
	private Float costo;
	
	@NotNull
	@Column(name="estado")
	private Boolean estado;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pelicula")
	private Long idPelicula;

	
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

	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}
	
	
}
