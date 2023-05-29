package cl.gonzalobenavides.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.gonzalobenavides.bookapi.models.Libro;
import cl.gonzalobenavides.bookapi.services.LibroServ;
import jakarta.websocket.server.PathParam;

@Controller("/api")
public class BookController {	

	@Autowired
	private LibroServ service;

	@RequestMapping(path = "/books/new", method = RequestMethod.POST)
	public Libro write(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("language") String language,
			@RequestParam("pages") Integer pages) {
		Libro libro = new Libro(title, description, language, pages);
		service.createLibro(libro);
		return libro;
	}
	
	@RequestMapping(path = "/books/{id}", method = RequestMethod.PUT)
	public Libro edit(@PathVariable("id") Long id, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("language") String language,
			@RequestParam("pages") Integer pages) {
		Libro libro = service.updateLibro(id, title, description, language, pages);
		return libro;
	}

	@RequestMapping(path = "/books/{id}", method = RequestMethod.DELETE)
	public void burn(@PathVariable("id") Long id) {
		service.deleteBook(id);
	}
	
	@RequestMapping(path="/books/{id}", method = RequestMethod.GET)
	public String check(@PathVariable("id") Long id, Model mod) {
		Libro libro = service.findLibro(id);
		mod.addAttribute("libro", libro);
		
		return "../show.jsp";
	}
}
