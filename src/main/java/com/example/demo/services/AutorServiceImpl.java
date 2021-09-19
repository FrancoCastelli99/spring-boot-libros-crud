package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.domain.Autor;
import com.example.demo.models.domain.Libro;

@Service
public class AutorServiceImpl implements AutorService {

    private List<Autor> listaAutor;
	
	public AutorServiceImpl() {
		
		this.listaAutor = new ArrayList<>();
				
	}
	
	
	@Override
	public List<Autor> listar() {
	
		return listaAutor;
	}

	@Override
	public Autor obtenerPorId(Integer id) {
		
		Autor resultado = null;
		
		for(Autor autor : this.listaAutor) {
			if (id == autor.getId()) {
				resultado = autor;
				break;
			}
		}
		return resultado;
		
	}

	@Override
	public void eliminarAutor(Integer id) {
		for(Autor autor : this.listaAutor) {
			if (id == autor.getId()) {
				listaAutor.remove(autor);
				break;
			}
		}
		
	}

	@Override
	public void crearAutor(Autor autor) {
		this.listaAutor.add(autor);
		
	}

	
	@Override
	public void editarAutor(Autor autor) {
		for(Autor aut : this.listaAutor) {
			if(autor.getId() == aut.getId()) {
				aut.setNombre(autor.getNombre());			
				aut.setApellido(autor.getApellido());
				aut.setNacionalidad(autor.getNacionalidad());
				aut.setSeudonimo(autor.getSeudonimo());
				aut.setFecha_nacimiento(autor.getFecha_nacimiento());
				
			}
		}
	}

	
	


}
