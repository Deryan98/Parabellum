package com.parabellum.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parabellum.springboot.web.app.models.entity.Pelicula;


public interface IPeliculaDao extends PagingAndSortingRepository<Pelicula, Long>{

}
