package cl.gonzalobenavides.bookapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gonzalobenavides.bookapi.models.Libro;
import cl.gonzalobenavides.bookapi.repo.LibroRepo;

@Service
public class LibroServ {
	
	@Autowired
	private LibroRepo LibroRepo;
	
	//Devolviendo todos los libros.
	public List<Libro> allLibros() {
		return LibroRepo.findAll();
	}
	
	//Creando un libro.
	public Libro createLibro(Libro b) {
		return LibroRepo.save(b);
	}
	
	//Obteniendo la información de un libro
	public Libro findLibro(Long id) {
		Optional<Libro> optionalLibro = LibroRepo.findById(id);
		if(optionalLibro.isPresent()) {
			return optionalLibro.get();
		} else {
			return null;
		}
	}
	
	public Libro updateLibro(Long id, String title, String desc, String lang, Integer n) {
		Libro update = findLibro(id);
		
		update.setTitle(title);
		update.setDescription(desc);
		update.setLanguage(lang);
		update.setNumberPages(n);
		
		if(update != null)
			LibroRepo.save(update);
		return update;
	}
	
	public void deleteBook(Long id) {
		Libro libro = findLibro(id);
		if(libro != null)
			LibroRepo.delete(libro);
	}
}