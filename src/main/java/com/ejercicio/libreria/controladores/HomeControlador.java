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
	
	@GetMapping("/autor")
	public String autor(ModelMap modelo) {
		return "autor.html";
	}
	
	@GetMapping("/editorial")
	public String editorial(ModelMap modelo) {
		return "editorial";
	}
	
	@GetMapping("/libro")
	public String libro(ModelMap modelo) {
		return "libro";
	}
	
}