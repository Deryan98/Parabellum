package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import com.parabellum.springboot.web.app.models.entity.Funcion;

public interface IFuncionService {
	
public List<Funcion> findAll();
	
	public void save(Funcion funcion);
	
	public Funcion findOne(Long id);
	
	public void delete(Long id);

}
