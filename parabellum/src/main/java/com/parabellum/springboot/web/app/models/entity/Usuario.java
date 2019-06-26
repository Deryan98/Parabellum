package com.parabellum.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	private String usuario;

	@NotEmpty
	@Email
	private String email;

	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "create_at")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
		estado = true;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@NotEmpty
	private String contrasenia;

	@NotEmpty
	private String direccion;

	@NotNull
	private double saldo;

	@NotNull
	private int edad;

	@NotNull
	private boolean estado;
	
	/*
	 * Metodos accesores
	 */

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contraseña) {
		this.contrasenia = contraseña;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	private static final long serialVersionUID = 1L;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * Esta anotación sirve para indicar el formato con el que se va guardar una
	 * fecha
	 */
	/*
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @DateTimeFormat(pattern="yyyy-MM-dd")
	 * 
	 * @Column(name="fecha_nacimiento") private Date fechaNacimiento;
	 * 
	 * private int edad;
	 * 
	 * private String direccion;
	 * 
	 * private double saldo;
	 * 
	 * private boolean estado;
	 * 
	 */

	/*
	 * 
	 * private Long id_municipio;
	 * 
	 * private Long id_rol;
	 * 
	 */

}
