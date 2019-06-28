package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;

public interface IPeliculaService {
	
	public List<Pelicula> findAll();
	
	public Page<Pelicula> findAll(Pageable pageable);
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(Long id);
	
	public void delete(Long id);
	
	public void saveProyeccion(Proyeccion proyeccion);

}
