package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.domain.Autor;
import com.example.demo.models.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	
	
	private List<Categoria> listaCategoria;

	public CategoriaServiceImpl() {
		this.listaCategoria = new ArrayList<>();
		
	}

	@Override
	public List<Categoria> listar() {
		return listaCategoria;
	}

	@Override
	public Categoria obtenerPorId(Integer id) {
		
		Categoria resultado = null;
		
		for(Categoria categoria : this.listaCategoria) {
			if (id == categoria.getId()) {
				resultado = categoria;
				break;
			}
		}
		return resultado;
		
	}

	@Override
	public void crearCategoria(Categoria categoria) {
		this.listaCategoria.add(categoria);
	}

	@Override
	public void eliminarCategoria(Integer id) {
		for(Categoria categoria : this.listaCategoria) {
			if (id == categoria.getId()) {
				listaCategoria.remove(categoria);
				break;
			}
		}
	}

	@Override
	public void editarCategoria(Categoria categoria) {
		for(Categoria cat : this.listaCategoria) {
			if(categoria.getId() == cat.getId()) {
				cat.setDescripcion(categoria.getDescripcion());							
			}
		}
		
	}

}
