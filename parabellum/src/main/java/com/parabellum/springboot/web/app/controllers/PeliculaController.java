package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.service.IPeliculaService;

@Controller
@RequestMapping("/admin")
public class PeliculaController {
	
	
	@Autowired
	IPeliculaService peliculaService;
	
	@GetMapping("/peliculas")
	public String movieList(Model model) {
		model.addAttribute("titulo", "Listado de Peliculas");
		model.addAttribute("peliculas", peliculaService.findAll());
		return "tables/movie-table";
	}
	
	@GetMapping("/movie-form")
	public String crear(Map<String, Object> model) {
		Pelicula pelicula = new Pelicula();
		model.put("pelicula", pelicula);
		model.put("titulo","Formulario de Pelicula");
		return "forms/movie-form";
	}
	
	@RequestMapping(value="/movie-form", method=RequestMethod.POST)
	public String guardar(@Valid Pelicula pelicula, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Pelicula");
			return  "forms/movie-form";
		}
		peliculaService.save(pelicula);
		status.setComplete();
		return "redirect:/admin/peliculas";
			
		}
	
}
