package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parabellum.springboot.web.app.models.entity.Pelicula;
import com.parabellum.springboot.web.app.models.service.IPeliculaService;

@Controller()
@RequestMapping("/app")
public class MovieController {
	
	@Autowired
	IPeliculaService peliculaService;
	
	@Value("${texts.indexcontroller.index.title}")
	private String indexTitle;
	
	@Value("${texts.indexcontroller.movie.title}")
	private String movieTitle;

	/*
	 * Método del controlador que devuelve a la vista principal del cliente
	 * @param model recibe este objeto para poder inyectar dependencias
	 * @return index devuelve a la vista principal del cliente
	 */
	@GetMapping({"/index", "","/","/home"})
	public String index(Model model) {
		model.addAttribute("title", indexTitle);
		model.addAttribute("header", indexTitle);
		model.addAttribute("peliculas",peliculaService.findAll());
		return "index";
	}
	

	/*
	 *Método controlador que redirige a la vista de una película que se defina en la pantalla principal
	 *@param model objeto para inyectar dependencias
	 *@return single-page devuelve a la vista individual de cada pelicula
	 */
	
	@GetMapping("/movie-info/{idPelicula}")
	public String movieInfo(@PathVariable(value = "idPelicula") Long idPelicula, Model model) {
		model.addAttribute("pelicula", peliculaService.findOne(idPelicula));
		model.addAttribute("title",movieTitle );
		model.addAttribute("header", indexTitle);
		return "movie-info";
	}
	

}
