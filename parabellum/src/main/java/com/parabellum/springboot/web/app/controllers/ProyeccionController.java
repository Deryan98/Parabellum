package com.parabellum.springboot.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;
import com.parabellum.springboot.web.app.models.service.IPeliculaService;
import com.parabellum.springboot.web.app.models.service.IProyeccionService;
import com.parabellum.springboot.web.app.models.service.ISalaService;

@Controller
@SessionAttributes("proyeccion")
@RequestMapping("/admin")
public class ProyeccionController {
	
	@Autowired
	IProyeccionService proyeccionService;
	
	@Autowired
	ISalaService salaService;
	
	@Autowired
	IPeliculaService peliculaService;
	
	@GetMapping("/proyecciones")
	public String proyeccionesList(Model model) {
		model.addAttribute("titulo", "Listado de Proyecciones");
		model.addAttribute("proyecciones", proyeccionService.findAll());
		return "/tables/proyeccion-table";
	}
	
	@GetMapping("/proyeccion-form")
	public String crear(Model model) {
		Proyeccion proyeccion = new Proyeccion();
		model.addAttribute("titulo", "Formulario Proyección");
		model.addAttribute("proyeccion", proyeccion);
		model.addAttribute("peliculas", peliculaService.findAll());
		model.addAttribute("salas", salaService.findAll());
		return "forms/proyeccion-form";
	}
	
	@RequestMapping(value="/proyeccion-form/", method=RequestMethod.POST)
	public String guardar(@Valid Proyeccion proyeccion, BindingResult result, Model model, SessionStatus status,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Pelicula");
			return  "forms/proyeccion-form";
		}
		//System.out.println("ID DE LA PELICULA"+ pelicula.getIdPelicula());
		String mensajeFlash = (proyeccion.getIdProyeccion() != null) ? "Proyección Editada con éxito!"
				: "Proyección Creada con éxito!";
		
		proyeccion.setPelicula(peliculaService.findOne(proyeccion.getForPelicula()));
		
		proyeccion.setSala(salaService.findOne(proyeccion.getForSala()));
		
		proyeccionService.save(proyeccion);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/admin/proyecciones";
	}
}
