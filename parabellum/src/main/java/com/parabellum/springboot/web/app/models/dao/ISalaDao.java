package com.parabellum.springboot.web.app.models.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.parabellum.springboot.web.app.models.entity.Sala;

public interface ISalaDao extends PagingAndSortingRepository<Sala, Long>{
	

}
