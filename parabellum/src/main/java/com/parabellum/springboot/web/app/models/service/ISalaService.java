package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import com.parabellum.springboot.web.app.models.entity.Sala;

public interface ISalaService {
	
	public List<Sala> findAll();
	
	public void save(Sala sala);
	
	public Sala findOne(Long id);
	
	public void delete(Long id);

}
