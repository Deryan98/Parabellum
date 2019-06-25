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
@Table(name="funciones")
public class Funcion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcion")
	private Long idFuncion;
	
	@NotNull
	@Column(name="estado")
	private boolean estado;
	
	@NotNull
	@Column(name="horario")
	private Date horario;
	
	@NotNull
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_sala")
	private Sala salas;
	
	public Sala getSalas() {
		return salas;
	}

	public void setSalas(Sala salas) {
		this.salas = salas;
	}

	@NotNull
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_proyeccion")
	private Proyeccion proyecciones;

	
	//Getters and Setters
	public Long getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Long idFuncion) {
		this.idFuncion = idFuncion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	

	public Proyeccion getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(Proyeccion proyecciones) {
		this.proyecciones = proyecciones;
	}
	
	
	
}
