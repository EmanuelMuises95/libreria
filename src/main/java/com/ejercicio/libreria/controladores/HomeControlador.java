package com.ejercicio.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControlador {

	@GetMapping("/")
	public String home(ModelMap modelo) {
		return "home";
	}
	
}