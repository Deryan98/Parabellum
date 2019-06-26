package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salas")
public class Sala implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sala")
	private Long idSala;

	@NotEmpty
	private String nombre;

	@NotNull
	@Column(name = "n_asientos")
	private int nAsiento;

	@NotNull
	private boolean estado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "create_at")
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getCreateAt() {
		return createAt;
	}
	
	@OneToMany(mappedBy="sala",fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Proyeccion> proyecciones;
	

	public List<Proyeccion> getFunciones() {
		return proyecciones;
	}

	public void setFunciones(List<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
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
