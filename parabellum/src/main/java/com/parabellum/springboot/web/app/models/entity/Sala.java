package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy = "salas", fetch = FetchType.EAGER)
	@Column(name = "id_sala")
	private Long idSala;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private int nAsiento;

	@NotEmpty
	private boolean estado;
	
	@OneToMany(mappedBy="salas",fetch=FetchType.EAGER)
	private List<Funcion> funciones;
	

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getnAsiento() {
		return nAsiento;
	}

	public void setnAsiento(int nAsiento) {
		this.nAsiento = nAsiento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
