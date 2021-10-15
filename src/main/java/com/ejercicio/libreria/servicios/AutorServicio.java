package com.ejercicio.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.libreria.entidades.Autor;
import com.ejercicio.libreria.repositorios.AutorRepositorio;

@Service
public class AutorServicio {

	@Autowired
	private AutorRepositorio autorRepositorio;

	@Transactional
	public void guardarAutor(String nombre) {
		Autor autor = new Autor();
		autor.setNombre(nombre);
		autor.setAlta(true);
		autorRepositorio.save(autor);
	}

	@Transactional
	public void eliminarAutor(Autor autor) {
		autorRepositorio.delete(autor);
	}
	
	@Transactional 
	public void modificarAutor() {
		
	}
	
	@Transactional(readOnly = true)
	public List<Autor> listarAutores() {
		return autorRepositorio.findAll();
	}
	
}
