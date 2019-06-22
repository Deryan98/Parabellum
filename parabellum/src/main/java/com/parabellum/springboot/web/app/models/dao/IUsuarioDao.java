package com.parabellum.springboot.web.app.models.dao;

import java.util.List;

import com.parabellum.springboot.web.app.models.entity.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
}
