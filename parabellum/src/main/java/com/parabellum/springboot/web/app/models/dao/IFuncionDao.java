package com.parabellum.springboot.web.app.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.parabellum.springboot.web.app.models.entity.Funcion;
import com.parabellum.springboot.web.app.models.entity.Usuario;

public interface IFuncionDao extends CrudRepository<Funcion, Long>{

}
