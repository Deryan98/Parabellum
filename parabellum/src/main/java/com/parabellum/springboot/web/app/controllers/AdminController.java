package com.parabellum.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parabellum.springboot.web.app.models.dao.IUsuarioDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("usuarioDaoJPA")
	private IUsuarioDao usuarioDao;
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("usuarios", usuarioDao.findAll());
		return "listar";
	}

}
