package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parabellum.springboot.web.app.models.dao.IPeliculaDao;
import com.parabellum.springboot.web.app.models.dao.IProyeccionDao;
import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	private IPeliculaDao peliculaDao;
	
	@Autowired
	private IProyeccionDao proyeccionDao;
	
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		
		return (List<Pelicula>) peliculaDao.findAll();
		
	}
	
	@Transactional
	public void save(Pelicula pelicula) {
		
		peliculaDao.save(pelicula);
		
	}
	
	@Transactional(readOnly = true)
	public Pelicula findOne(Long id) {
		
		return peliculaDao.findById(id).orElse(null);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		peliculaDao.deleteById(id);
		
	}
	
	@Transactional
	public void saveProyeccion(Proyeccion proyeccion) {
		
		proyeccionDao.save(proyeccion);
		
	}
	
	
	@Transactional(readOnly = true)
	public Page<Pelicula> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return peliculaDao.findAll(pageable);
	}
	
	
}
