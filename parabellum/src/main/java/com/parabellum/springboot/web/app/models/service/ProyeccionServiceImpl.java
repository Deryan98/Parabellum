package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parabellum.springboot.web.app.models.dao.IProyeccionDao;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;

@Service
public class ProyeccionServiceImpl implements IProyeccionService {

	@Autowired
	private IProyeccionDao proyeccionDao;

	@Transactional(readOnly = true)
	public List<Proyeccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Proyeccion>) proyeccionDao.findAll();
	}

	@Transactional
	public void save(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionDao.save(proyeccion);
	}

	@Transactional(readOnly = true)
	public Proyeccion findOne(Long id) {
		// TODO Auto-generated method stub
		return proyeccionDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proyeccionDao.deleteById(id);
	}

}
