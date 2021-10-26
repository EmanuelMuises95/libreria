package com.ejercicio.libreria.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ejercicio.libreria.entidades.Autor;
import com.ejercicio.libreria.errores.ErrorServicio;
import com.ejercicio.libreria.repositorios.AutorRepositorio;
import com.ejercicio.libreria.servicios.AutorServicio;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

	@Autowired
	private AutorServicio autorServicio;
		
	@GetMapping("/mostrar-todos")
	public ModelAndView verAutores(){
	
		ModelAndView modelo = new ModelAndView("autor");
		
		List<Autor> autores = autorServicio.listarAutores();
		
		modelo.addObject("autores", autores);
		
		return modelo;
	}

	@GetMapping("/autor-cargar")
	public ModelAndView cargarAutor() {
		return new ModelAndView("autor-crear") ;
	}
	
	@PostMapping("/autor-cargar")
	public String cargarAutor(ModelMap modelo, @RequestParam String nombre) {
		
		try {
			autorServicio.guardarAutor(nombre);
		}catch(ErrorServicio e) {
			modelo.put("error", e.getMessage());
			return "autor-crear";
		}
		
		return "redirect:/autor/";

	}
	
	@GetMapping("/autor-modificar")
	public String modificarAutor(ModelMap modelo, @RequestParam String id) {
		
		Autor autor = autorServicio.buscarAutorPorID(id).get();
		
		modelo.addAttribute("autores", autor);
		
		return "autor-modificar";
	}
	
	@PostMapping("/autor-modificar")
	public String modificarAutor(ModelMap modelo,@RequestParam String id, @RequestParam String nombre) {
		
		try {
			autorServicio.modificarAutor(id,nombre);
		}catch(ErrorServicio e) {
			modelo.put("error", e.getMessage());
			return "autor-modificar";
		}
		
		return "redirect:/autor/mostrar-todos";

	}
}