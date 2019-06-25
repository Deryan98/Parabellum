package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import com.parabellum.springboot.web.app.models.entity.Proyeccion;



public interface IProyeccionService  {

	public List<Proyeccion> findAll();
	
	public void save(Proyeccion proyeccion);
	
	public Proyeccion findOne(Long id);
	
	public void delete(Long id);
}
