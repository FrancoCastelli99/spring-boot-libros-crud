package com.example.demo.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Autor {

	@NotNull
	private Integer id;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@Size( min = 4)
	private String nombre;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@Size( min = 4)
	private String apellido;
	
	private String nacionalidad;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@Size( min = 3)
	@NotBlank
	private String seudonimo;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	private List<Libro> lista_libros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSeudonimo() {
		return seudonimo;
	}

	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public List<Libro> getLista_libros() {
		return lista_libros;
	}

	public void setLista_libros(List<Libro> lista_libros) {
		this.lista_libros = lista_libros;
	}

	public Autor() {
		
	}

	public Autor(Integer id, String nombre, String apellido, String nacionalidad, String seudonimo,
			Date fecha_nacimiento, List<Libro> lista_libros) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.seudonimo = seudonimo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.lista_libros = lista_libros;
	}
	
	
	
	
	
	
}
