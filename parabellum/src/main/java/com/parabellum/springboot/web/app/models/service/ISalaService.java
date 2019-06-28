package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.parabellum.springboot.web.app.models.entity.Proyeccion;
import com.parabellum.springboot.web.app.models.entity.Sala;
import com.parabellum.springboot.web.app.models.entity.Usuario;

public interface ISalaService {
	
	public List<Sala> findAll();
	
	public Page<Sala> findAll(Pageable pageable);
	
	public void save(Sala sala);
	
	public Sala findOne(Long id);
	
	public void delete(Long id);
	
	public void saveProyeccion(Proyeccion proyeccion);

}
