package com.parabellum.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/auth")
public class AuthController {

	@GetMapping({"/index", "","/main"})
	public String index(Model model) {
		model.addAttribute("title", "Text");
		model.addAttribute("header", "Text");
		return "index";
	}
}
