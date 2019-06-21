package com.parabellum.springboot.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parabellum.springboot.web.app.models.entity.Usuario;

@Repository("usuarioDaoJPA")
public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext 
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Usuario").getResultList();
	}

}
