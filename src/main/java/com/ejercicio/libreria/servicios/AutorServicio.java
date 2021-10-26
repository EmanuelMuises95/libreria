package com.ejercicio.libreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.libreria.entidades.Autor;
import com.ejercicio.libreria.errores.ErrorServicio;
import com.ejercicio.libreria.repositorios.AutorRepositorio;

@Service
public class AutorServicio {

	@Autowired
	private AutorRepositorio autorRepositorio;

	@Transactional
	public void guardarAutor(String nombre) throws ErrorServicio {

		validar(nombre);

		Autor autor = new Autor();
		autor.setNombre(nombre);
		autor.setAlta(true);

		autorRepositorio.save(autor);
	}

	@Transactional
	public void eliminarAutor(String id, String nombre) throws ErrorServicio {

		validar(nombre);
		
		Optional<Autor> respuesta = autorRepositorio.findById(id);
		
		if (respuesta.isPresent()) {
			Autor autor = respuesta.get();
			autorRepositorio.delete(autor);
		} else {
			throw new ErrorServicio("El no se encuentra en la lista de Autores");
		}

	}

	@Transactional
	public void deshabilitarAutor(String id, String nombre) throws ErrorServicio{
		
		validar(nombre);
		
		Optional<Autor> respuesta = autorRepositorio.findById(id);
		
		if (respuesta.isPresent()) {
			Autor autor = respuesta.get();
			autor.setAlta(false);
			autorRepositorio.save(autor);
		} else {
			throw new ErrorServicio("No se encontro el Autor que quiere deshabilitar");
		}
		
	}
	
	@Transactional
	public void habilitarAutor(String id, String nombre) throws ErrorServicio{
		
		validar(nombre);
		
		Optional<Autor> respuesta = autorRepositorio.findById(id);
		
		if (respuesta.isPresent()) {
			Autor autor = respuesta.get();
			autor.setAlta(true);
			autorRepositorio.save(autor);
		} else {
			throw new ErrorServicio("No se encontro el Autor que quiere deshabilitar");
		}
		
	}
	
	@Transactional
	public void modificarAutor(String id, String nombre) throws ErrorServicio {

		validar(nombre);

		Optional<Autor> respuesta = autorRepositorio.findById(id);

		if (respuesta.isPresent()) {
			Autor autor = respuesta.get();
			autorRepositorio.save(autor);
		} else {
			throw new ErrorServicio("No se encontro el Autor");
		}

		
	}

	@Transactional(readOnly = true)
	public List<Autor> listarAutores() {
		return autorRepositorio.findAll();
	}
	
	@Transactional
	public Optional<Autor> buscarAutorPorID(String id){
		Optional<Autor> respuesta = autorRepositorio.findById(id);
		return respuesta;
	}


	private void validar(String nombre) throws ErrorServicio {
		if (nombre == null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre no puede estar nulo o vacío");
		}
	}
}