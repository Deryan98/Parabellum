package com.parabellum.springboot.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.parabellum.springboot.web.app.models.entity.Usuario;
import com.parabellum.springboot.web.app.models.service.IUsuarioService;
import com.parabellum.springboot.web.app.util.paginator.PageRender;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/admin")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	/*
	 * Devuelve la lista de usuarios registrados.
	 */
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String userlist(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
		
		PageRender<Usuario> pageRender = new PageRender<>("/admin/usuarios", usuarios);

		model.addAttribute("titulo", "Listado de Usuarios");

		model.addAttribute("usuarios", usuarios);
		
		model.addAttribute("page", pageRender);

		return "tables/user-table";
	}

	/*
	 * crea un formulario para registrar usuarios.
	 */

	@GetMapping("/user-form")
	public String crear(Map<String, Object> model) {
		
		Usuario usuario = new Usuario();
		
		model.put("usuario", usuario);
		
		model.put("titulo", "Formulario de Usuario");
		
		return "forms/user-form";
	}

	/*
	 * Al enviar el formulario de registro de usuarios, guarda el usuario en la base
	 * de datos
	 */
	@RequestMapping(value = "/user-form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Formulario de Usuario");
			
			return "forms/user-form";
			
		}
		String mensajeFlash = (usuario.getIdUsuario() != null) ? "Usuario Editado con éxito!"
				: "Usuario Creado con éxito!";
		
		usuarioService.save(usuario);
		
		status.setComplete();
		
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/admin/usuarios";
	}

	@RequestMapping(value = "/user-form/{id}")
	public String editar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Map<String, Object> model) {
		
		Usuario usuario = null;
		
		if (id > 0) {
			
			usuario = usuarioService.findOne(id);
			
			if (usuario == null) {
				
				flash.addFlashAttribute("error", "El ID del usuario no existe en la BBDD!");
				
				return "redirect:/admin/usuarios";
			}
		} else {
			
			flash.addFlashAttribute("error", "El ID del usuario no puede ser cero!");
			
			return "redirect:/admin/usuarios";
		}

		model.put("usuario", usuario);
		
		model.put("titulo", "Editar Usuario");
		
		return "forms/user-form";
	}

}
