package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.service.IPeliculaService;

@Controller
@RequestMapping("/admin")
public class PeliculaController {
	
	
	@Autowired
	IPeliculaService peliculaService;

	@GetMapping("/movie-form")
	public String crear(Map<String, Object> model) {
		Pelicula pelicula = new Pelicula();
		model.put("pelicula", pelicula);
		model.put("titulo","Formulario de Pelicula");
		return "forms/movie-form";
	}
	
	@GetMapping("/peliculas")
	public String movieList(Model model) {
		model.addAttribute("titulo", "Listado de Peliculas");
		model.addAttribute("peliculas", peliculaService.findAll());
		return "tables/movie-table";
	}
	
}
