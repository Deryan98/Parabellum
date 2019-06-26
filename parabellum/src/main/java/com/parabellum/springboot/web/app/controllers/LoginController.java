package com.parabellum.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parabellum.springboot.web.app.models.service.IUsuarioService;

@Controller
public class LoginController {

	@Autowired
	IUsuarioService userService;
	
	@RequestMapping("/")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	
}
