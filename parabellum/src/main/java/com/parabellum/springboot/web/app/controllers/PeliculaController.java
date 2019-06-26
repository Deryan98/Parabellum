package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.entity.Usuario;
import com.parabellum.springboot.web.app.models.service.IPeliculaService;

@Controller
@SessionAttributes("pelicula")
@RequestMapping("/admin")
public class PeliculaController {
	
	
	@Autowired
	private IPeliculaService peliculaService;
	
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
	public String guardar(@Valid Pelicula pelicula, BindingResult result, Model model, SessionStatus status,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Pelicula");
			return  "forms/movie-form";
		}
		
		System.out.println("ID DE LA PELICULA"+ pelicula.getIdPelicula());
		
		String mensajeFlash = (pelicula.getIdPelicula() != null) ? "Pelicula Editada con éxito!"
				: "Pelicula Creada con éxito!";
		peliculaService.save(pelicula);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/admin/peliculas";
		}
	
	@RequestMapping(value = "/movie-form/{id}")
	public String editar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Map<String, Object> model) {
		
		Pelicula pelicula = null;
		
		if (id > 0) {
			
			pelicula = peliculaService.findOne(id);
			
			if (pelicula == null) {
				
				flash.addFlashAttribute("error", "El ID de la pelicula no existe en la BBDD!");
				
				return "redirect:/admin/peliculas";
			}
		} else {
			
			flash.addFlashAttribute("error", "El ID de la pelicula no puede ser cero!");
			
			return "redirect:/admin/peliculas";
		}

		model.put("pelicula", pelicula);
		
		model.put("titulo", "Editar Pelicula");
		
		return "forms/movie-form";
	}

}
