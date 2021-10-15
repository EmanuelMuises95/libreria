package com.ejercicio.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.libreria.entidades.Editorial;
import com.ejercicio.libreria.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {

	@Autowired
	private EditorialRepositorio editorialRepositorio;

	@Transactional
	public void guardarEditorial(String nombre) {
		Editorial editorial = new Editorial();
		editorial.setNombre(nombre);
		editorial.setAlta(true);
		editorialRepositorio.save(editorial);
	}

	@Transactional(readOnly = true)
	public List<Editorial> consultaEditoriales() {
		return editorialRepositorio.findAll();
	}

}