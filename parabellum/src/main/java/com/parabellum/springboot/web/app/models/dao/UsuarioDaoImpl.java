package com.parabellum.springboot.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.parabellum.springboot.web.app.models.entity.Usuario;

@Repository("usuarioDaoJPA")
public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext 
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		
		return em.createQuery("from Usuario").getResultList();
		
	}
	
	/*
	 * Metodo utilizado para guardar un usuario en la base
	 */
	public void save(Usuario usuario) {
		
		em.persist(usuario);
		
	}

	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
