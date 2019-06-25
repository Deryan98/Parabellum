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

import com.parabellum.springboot.web.app.models.entity.Usuario;
import com.parabellum.springboot.web.app.models.service.IUsuarioService;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/admin")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/*
	 * Devuelve la lista de usuarios registrados.
	 */
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public String userlist(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "tables/user-table";
	}
	
	/*
	 * crea un formulario para registrar usuarios.
	 */
	
	@GetMapping("/user-form")
	public String crear(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo","Formulario de Usuario");
		return "forms/user-form";
	}
	
	/*
	 * Al enviar el formulario de registro de usuarios,
	 * guarda el usuario en la base de datos
	 */
	@RequestMapping(value="/user-form", method=RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Usuario");
			return "forms/user-form";
		}	
		usuarioService.save(usuario);
		status.setComplete();
		return "redirect:/admin/usuarios";
	}
	
	@RequestMapping(value="/user-form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Usuario usuario = null;
		if(id>0)
			usuario = usuarioService.findOne(id);
		else
			return "redirect:admin/usuarios";
		
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "forms/user-form";
	}

}
