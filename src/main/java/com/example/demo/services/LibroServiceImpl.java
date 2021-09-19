package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{

	private List<Libro> listaLibros;
		
	public LibroServiceImpl() {
		this.listaLibros = new ArrayList<>();
		
	}

	@Override
	public List<Libro> listar() {
		
		return listaLibros;
	}

	@Override
	public Libro obtenerPorId(Integer id) {
		
		Libro resultado = null;
		
		for(Libro libro : this.listaLibros) {
			if(id == libro.getId()) {
				resultado = libro;
				break;
			}
		}
		
		return resultado;
		
	}

	@Override
	public void eliminarLibro(Integer id) {
		
		for(Libro libro : this.listaLibros) {
			if (id == libro.getId()) {
				listaLibros.remove(libro);
				break;
			}
		}
		
	}

	@Override
	public void crearLibro(Libro libro) {
		this.listaLibros.add(libro);
		
	}

	@Override
	public void editarLibro(Libro libro) {
		for(Libro lib : this.listaLibros) {
			if(libro.getId() == lib.getId()) {
				lib.setTitulo(libro.getTitulo());			
				lib.setDescripcion(libro.getDescripcion());
				lib.setAnno(libro.getAnno());
				lib.setIsbn(libro.getIsbn());
				lib.setCantidad_paginas(libro.getCantidad_paginas());
				
			}
		}
	}

}
