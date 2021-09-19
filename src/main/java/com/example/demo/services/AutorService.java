package com.example.demo.services;

import java.util.List;

import com.example.demo.models.domain.Autor;
import com.example.demo.models.domain.Libro;

public interface AutorService {

	public List<Autor> listar();
	
	public Autor obtenerPorId(Integer id);
	
	public void crearAutor(Autor autor);
	
	public void editarAutor(Autor autor);

	public void eliminarAutor(Integer id);
	
}
