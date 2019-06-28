package com.parabellum.springboot.web.app.controllers;

import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.entity.Proyeccion;
import com.parabellum.springboot.web.app.models.entity.Sala;
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
		model.addAttribute("idPelicula");
		model.addAttribute("idSala");
		model.addAttribute("peliculas", peliculaService.findAll());
		model.addAttribute("salas", salaService.findAll());
		return "forms/proyeccion-form";
	}
	
	@RequestMapping(value="/proyeccion-form", method=RequestMethod.POST)
	public String guardar(
			@RequestParam(name="idSala", required=false , defaultValue= "1") Long idSala,
			@RequestParam(name="idPelicula", required=false, defaultValue= "1") Long idPelicula,
			@Valid Proyeccion proyeccion, BindingResult result, 
			Model model, 
			SessionStatus status,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Pelicula");
			model.addAttribute("peliculas", peliculaService.findAll());
			model.addAttribute("salas", salaService.findAll());
			return  "forms/proyeccion-form";
		}
		System.out.println("Hola");
		System.out.println("ID DE LA PELICULA"+ peliculaService.findOne(idPelicula).getIdPelicula());
		String mensajeFlash = (proyeccion.getIdProyeccion() != null) ? "Proyección Editada con éxito!"
				: "Proyección Creada con éxito!";
		
		proyeccion.setPelicula(peliculaService.findOne(idPelicula));
		
		proyeccion.setSala(salaService.findOne(idSala));
		
		proyeccion.setModifiedAt(new Date());
		proyeccionService.save(proyeccion);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/admin/proyecciones";
	}
	
	@RequestMapping(value = "/proyeccion-form/{id}")
	public String editar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Map<String, Object> model) {
		
		Proyeccion proyeccion = null;
		
		if (id > 0) {
			
			proyeccion = proyeccionService.findOne(id);
			
			if (proyeccion == null) {
				
				flash.addFlashAttribute("error", "El ID de la proyeccion no existe en la BBDD!");
				
				return "redirect:/admin/proyecciones";
			}
		} else {
			
			flash.addFlashAttribute("error", "El ID de la proyeccion no puede ser cero!");
			
			return "redirect:/admin/proyecciones";
		}

		model.put("peliculas", peliculaService.findAll());
		model.put("salas", salaService.findAll());
		model.put("proyeccion", proyeccion);
		
		model.put("titulo", "Editar Proyeccion");
		
		return "forms/proyeccion-form";
	}
}
