package cl.gonzalobenavides.bookapi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gonzalobenavides.bookapi.models.Libro;

@Repository
public interface LibroRepo extends CrudRepository<Libro, Long>{
		
		//Este método recupera todos los libros de la base de datos
		List<Libro> findAll();
		//Este método encuentra un libro por su descripción
		List<Libro> findByDescriptionContaining(String search);
		//Este método encuentra un libro por su id
		Optional<Libro> findById(Long search);
		//Este método cuenta cuántos libros contiene cierta cadena en el título
		Long countByTitleContaining(String search);
		//Este método borra un libro que empieza con un título específico
		Long deleteByTitleStartingWith(String search);
		//Este método agrega un libro
		Libro save(Libro libro);
}
