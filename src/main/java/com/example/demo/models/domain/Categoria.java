package com.example.demo.models.domain;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Categoria {

	@NotNull
	private Integer id;
	
	@Size(min = 3) 
	private String descripcion;
	
	private List<Libro> lista_libros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Libro> getLista_libros() {
		return lista_libros;
	}

	public void setLista_libros(List<Libro> lista_libros) {
		this.lista_libros = lista_libros;
	}

	public Categoria() {
		
	}

	public Categoria(Integer id, String descripcion, List<Libro> lista_libros) {
		this.id = id;
		this.descripcion = descripcion;
		this.lista_libros = lista_libros;
	}
	
	
	
	
	
	
}
