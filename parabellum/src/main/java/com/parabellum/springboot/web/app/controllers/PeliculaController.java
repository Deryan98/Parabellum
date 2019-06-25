package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabellum.springboot.web.app.models.entity.Pelicula;

@Controller
@RequestMapping("/admin")
public class PeliculaController {

	@GetMapping("/movie-form")
	public String crear(Map<String, Object> model) {
		Pelicula pelicula = new Pelicula();
		model.put("pelicula", pelicula);
		model.put("titulo","Formulario de Pelicula");
		return "forms/movie-form";
	}
	
}
