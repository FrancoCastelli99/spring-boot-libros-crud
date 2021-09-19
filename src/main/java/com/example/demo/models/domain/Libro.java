package com.example.demo.models.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Libro {
	
	@Min(value = 10)
	private Integer id;
	
	@NotNull
	private Integer anno;
	
	@NotNull
	@Min(value = 0)
	private Integer cantidad_paginas;
	
	@NotEmpty
	@Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
	private String isbn;
	
	@NotEmpty
	@NotBlank(message = "No debe contener Espacios")
	@Size(min = 5 , max = 65 )
	private String titulo;
	
	@Pattern(regexp = "[a-zA-Z]+")
	private String descripcion;
	
	@NotNull
	private Autor autor;
	
	@NotNull
	private Categoria categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Integer getCantidad_paginas() {
		return cantidad_paginas;
	}

	public void setCantidad_paginas(Integer cantidad_paginas) {
		this.cantidad_paginas = cantidad_paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//CONSTRUCTORES
	
	public Libro() {
		
	}

	public Libro(Integer id, Integer anno, Integer cantidad_paginas, String isbn, String titulo, String descripcion,
			Autor autor, Categoria categoria) {  
		this.id = id;
		this.anno = anno;
		this.cantidad_paginas = cantidad_paginas;
		this.isbn = isbn;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	
	
}
