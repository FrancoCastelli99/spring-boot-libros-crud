package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.editors.AutorEditor;
import com.example.demo.editors.CategoriaEditor;
import com.example.demo.models.domain.Autor;
import com.example.demo.models.domain.Categoria;
import com.example.demo.models.domain.Libro;
import com.example.demo.services.AutorService;
import com.example.demo.services.CategoriaService;
import com.example.demo.services.LibroService;

@Controller
@SessionAttributes("libro")
public class IndexController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorEditor autorEditor;
	
	@Autowired
	private CategoriaEditor categoriaEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Autor.class, "autor" , autorEditor);
		binder.registerCustomEditor(Categoria.class, "categoria" , categoriaEditor);
	}
	
	@GetMapping({"/", "index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping({"/autor"})
	public String autor(Model model) {
		return "indexAutor";
	}
	
	@GetMapping({"/categoria"})
	public String categoria(Model model) {
		return "indexCategoria";
	}
	
	
	@GetMapping({"/crearLibro"})
	public String crearLibro(Model model) {
		
		Libro libro = new Libro();
		
		model.addAttribute("libro", libro);
		return "crearLibro";
	}
	
	
	@GetMapping({"/crearAutor"})
	public String crearAutor(Model model) {
		
		Autor autor = new Autor();
		
		model.addAttribute("autor", autor);
		return "crearAutor";
	}
	
	@GetMapping({"/crearCategoria"})
	public String crearCategoria(Model model) {
		
		Categoria categoria = new Categoria();
		
		model.addAttribute("categoria", categoria);
		return "crearCategoria";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@SessionAttribute(name= "libro", required = false) Libro libro, @PathVariable Integer id, Model model) {
		model.addAttribute("resultado", "El numero es : "+ id);
		libro = libroService.obtenerPorId(id);
		model.addAttribute("libro", libro);
		return "modificar/ver";
		
	}
	
	@GetMapping("/editarAutor/{id}")
	public String editarAutor(@SessionAttribute(name= "autor", required = false) Autor autor, @PathVariable Integer id, Model model) {
		model.addAttribute("resultado", "El numero es : "+ id);
		autor = autorService.obtenerPorId(id);
		model.addAttribute("autor", autor);
		return "modificar/verAutor";
		
	}

	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@SessionAttribute(name= "categoria", required = false) Categoria categoria, @PathVariable Integer id, Model model) {
		model.addAttribute("resultado", "El numero es : "+ id);
		categoria = categoriaService.obtenerPorId(id);
		model.addAttribute("categoria", categoria);
		return "modificar/verCategoria";
		
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@SessionAttribute(name= "libro", required = false) Libro libro, @PathVariable Integer id) {
		
		libroService.eliminarLibro(id);
		
		return "index";
		
	}
	
	@GetMapping("/eliminarAutor/{id}")
	public String eliminarAutor(@SessionAttribute(name= "autor", required = false) Autor autor, @PathVariable Integer id) {
		
		autorService.eliminarAutor(id);
		
		return "indexAutor";
		
	}

	@GetMapping("/eliminarCategoria/{id}")
	public String eliminarCategoria(@SessionAttribute(name= "categoria", required = false) Categoria categoria, @PathVariable Integer id) {
		
		categoriaService.eliminarCategoria(id);
		
		return "indexCategoria";
		
	}
	
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid Libro libro, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			return "crearLibro";
		}
		
		libroService.crearLibro(libro);
		return "index";
		
	}
	
	
	@PostMapping("/formAutor")
	public String procesarFormularioAutor(@Valid Autor autor, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			return "crearAutor";
		}
		
		autorService.crearAutor(autor);
		
		return "indexAutor";
		
	}
	
	@PostMapping("/formCategoria")
	public String procesarFormularioCategoria(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			return "crearCategoria";
		}
		
		categoriaService.crearCategoria(categoria);
		
		return "indexCategoria";
		
	}
	
	
	@PostMapping("/edit")
	public String edit(@Valid Libro libro, Model model, SessionStatus status) {
		
		libroService.editarLibro(libro);
		
		return "index";
		
	}
	
	
	@PostMapping("/editAutor")
	public String editAutor(@Valid Autor autor, Model model, SessionStatus status) {
		
		autorService.editarAutor(autor);
		
		return "indexAutor";
		
	}

	@PostMapping("/editCategoria")
	public String editCategoria(@Valid Categoria categoria, Model model, SessionStatus status) {
		
		categoriaService.editarCategoria(categoria);
		
		return "indexCategoria";
		
	}
	
	
	@ModelAttribute("listaLibro")
	public List<Libro> listaLibro(){
		return libroService.listar();
	}
	
	
	
	@ModelAttribute("listaAutor")
	public List<Autor> listaAutor() {

		return autorService.listar();

	}
	
	@ModelAttribute("listaCategoria")
	public List<Categoria> listaCategoria() {

		return categoriaService.listar();

	}
	
	
	
}
