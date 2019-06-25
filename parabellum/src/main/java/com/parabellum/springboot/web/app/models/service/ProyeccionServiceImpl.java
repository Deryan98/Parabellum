package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parabellum.springboot.web.app.models.entity.Proyeccion;

public class ProyeccionServiceImpl implements IProyeccionService {

	@Autowired
	IProyeccionService proyeccionService;


	public List<Proyeccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Proyeccion>) proyeccionService.findAll();
	}

	
	public void save(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionService.save(proyeccion);
	}

	
	public Proyeccion findOne(Long id) {
		// TODO Auto-generated method stub
		return proyeccionService.findOne(id);
	}

	
	public void delete(Long id) {
		// TODO Auto-generated method stub
			proyeccionService.delete(id);
	}

}
