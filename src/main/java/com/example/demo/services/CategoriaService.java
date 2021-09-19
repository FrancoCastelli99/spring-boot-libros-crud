package com.example.demo.services;

import java.util.List;

import com.example.demo.models.domain.Categoria;

public interface CategoriaService {

	public List<Categoria> listar();
	
	public Categoria obtenerPorId(Integer id);
	
	public void eliminarCategoria(Integer id);
	
	public void editarCategoria(Categoria categoria);
	
	public void crearCategoria(Categoria categoria);
	
}
