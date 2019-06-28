package com.parabellum.springboot.web.app.controllers;

import java.util.Date;
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

import com.parabellum.springboot.web.app.models.entity.Sala;
import com.parabellum.springboot.web.app.models.service.ISalaService;

@Controller
@SessionAttributes("sala")
@RequestMapping("/admin")
public class SalaController {

	@Autowired
	private ISalaService salaService;
	
	@GetMapping("/salas")
	public String salaList(Model model) {
		model.addAttribute("titulo", "Listado de Salas");
		model.addAttribute("salas", salaService.findAll());
		return "tables/sala-table";
	}
	
	@GetMapping("/sala-form")
	public String crear(Map<String, Object> model) {
		Sala sala = new Sala();
		model.put("sala", sala);
		model.put("titulo","Formulario de Sala");
		return "forms/sala-form";
	}
	
	@RequestMapping(value="/sala-form", method=RequestMethod.POST)
	public String guardar(@Valid Sala sala, BindingResult result, Model model, SessionStatus status,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Sala");
			return  "forms/sala-form";
		}
		
		String mensajeFlash = (sala.getIdSala() != null) ? "Sala Editada con éxito!"
				: "Sala Creada con éxito!";
		sala.setModifiedAt(new Date());
		salaService.save(sala);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/admin/salas";
		}
	
	@RequestMapping(value = "/sala-form/{id}")
	public String editar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Map<String, Object> model) {
		
		Sala sala = null;
		
		if (id > 0) {
			
			sala = salaService.findOne(id);
			
			if (sala == null) {
				
				flash.addFlashAttribute("error", "El ID de la sala no existe en la BBDD!");
				
				return "redirect:/admin/salas";
			}
		} else {
			
			flash.addFlashAttribute("error", "El ID de la sala no puede ser cero!");
			
			return "redirect:/admin/salas";
		}

		model.put("sala", sala);
		
		model.put("titulo", "Editar Sala");
		
		return "forms/sala-form";
	}
}
