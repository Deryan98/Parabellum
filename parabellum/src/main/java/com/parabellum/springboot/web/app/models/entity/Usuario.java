package com.parabellum.springboot.web.app.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	private String nombre;
	
	private String apellido;
	
	private String usuario;
	
	private String email;
	
	private String contraseña;
	
	private Date fecha_nacimiento;
	
	private int edad;
	
	private String direccion;
	
	private double saldo;
	
	private boolean estado;
	
	private Long id_municipio;
	
	private Long id_rol;
	
}
