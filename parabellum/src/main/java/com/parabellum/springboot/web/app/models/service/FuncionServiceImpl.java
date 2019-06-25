package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parabellum.springboot.web.app.models.entity.Funcion;

public class FuncionServiceImpl implements IFuncionService{

	@Autowired
	private IFuncionService funcionService;
	
	@Override
	public List<Funcion> findAll() {
		// TODO Auto-generated method stub
		return (List<Funcion>) funcionService.findAll();
	}

	@Override
	public void save(Funcion funcion) {
		// TODO Auto-generated method stub
		funcionService.save(funcion);
	}

	@Override
	public Funcion findOne(Long id) {
		// TODO Auto-generated method stub
		return funcionService.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		funcionService.delete(id);
	}

	
}
