package com.ejercicio.libreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.libreria.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{

}
