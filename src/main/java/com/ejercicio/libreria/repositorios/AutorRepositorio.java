package com.ejercicio.libreria.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejercicio.libreria.entidades.Autor;


@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{

	@Query("DELETE x FROM Autor x WHERE x.autor.nombre = :nombre")
	public Autor buscarAutorPorNombre(@Param("nombre") String nombre);
}
