package com.parabellum.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parabellum.springboot.web.app.models.dao.IProyeccionDao;
import com.parabellum.springboot.web.app.models.dao.ISalaDao;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;
import com.parabellum.springboot.web.app.models.entity.Sala;
import com.parabellum.springboot.web.app.models.entity.Usuario;

@Service
public class SalaServiceImpl implements ISalaService {
	
	@Autowired
	private ISalaDao salaDao;
	
	@Autowired
	private IProyeccionDao proyeccionDao;

	@Transactional(readOnly = true)
	public List<Sala> findAll() {

		return (List<Sala>) salaDao.findAll();
		
	}

	@Transactional
	public void save(Sala sala) {

		salaDao.save(sala);
		
	}

	@Transactional(readOnly = true)
	public Sala findOne(Long id) {

		return salaDao.findById(id).orElse(null);
		
	}

	@Transactional
	public void delete(Long id) {
		
		salaDao.deleteById(id);
		
	}
	
	@Transactional
	public void saveProyeccion(Proyeccion proyeccion) {
		
		proyeccionDao.save(proyeccion);
		
	}
	
	@Transactional(readOnly = true)
	public Page<Sala> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return salaDao.findAll(pageable);
	}
	
}
