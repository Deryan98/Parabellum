package com.parabellum.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.parabellum.springboot.web.app.models.entity.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long>{

}
