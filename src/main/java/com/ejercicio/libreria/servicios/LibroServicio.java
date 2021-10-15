package com.ejercicio.libreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.libreria.entidades.Autor;
import com.ejercicio.libreria.entidades.Editorial;
import com.ejercicio.libreria.entidades.Libro;
import com.ejercicio.libreria.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

	@Autowired
	private LibroRepositorio libroRepositorio;

	@Transactional
	public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
			Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {

		Libro libro = new Libro();

		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAnio(anio);
		libro.setEjemplares(ejemplares);
		libro.setEjemplaresPrestados(0);
		libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
		libro.setAlta(true);

		libro.setAutor(autor);
		libro.setEditorial(editorial);

		libroRepositorio.save(libro);

	}

	@Transactional
	public void modificarLibro(String id, String titulo, Integer anio, Autor autor, Editorial editorial) {

		Optional<Libro> respuesta = libroRepositorio.findById(id);

		if (respuesta.isPresent()) {

			Libro libro = respuesta.get();

			libro.setTitulo(titulo);
			libro.setAnio(anio);
			libro.setAutor(autor);
			libro.setEditorial(editorial);

			libroRepositorio.save(libro);

		} else {

			System.out.println("No se encontro el libro");

		}

	}

	@Transactional
	public void eliminarLibro(String id) {

		Optional<Libro> respuesta = libroRepositorio.findById(id);

		if (respuesta.isPresent()) {
			
			Libro libro = respuesta.get();
			
			libro.setAlta(false);
			
			libroRepositorio.save(libro);
		
		} else {

			System.out.println("No se encontro el usuario");

		}

	}

	@Transactional(readOnly=true)
	public List<Libro> listarLibros() {
		return libroRepositorio.findAll();
	}

}
