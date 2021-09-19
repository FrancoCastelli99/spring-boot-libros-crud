package com.example.demo.services;

import java.util.List;

import com.example.demo.models.domain.Libro;

public interface LibroService {

	public List<Libro> listar();
	
	public Libro obtenerPorId(Integer id);
	
	public void eliminarLibro(Integer id);
	
	public void crearLibro(Libro libro);
	
	public void editarLibro(Libro libro);
	
}
