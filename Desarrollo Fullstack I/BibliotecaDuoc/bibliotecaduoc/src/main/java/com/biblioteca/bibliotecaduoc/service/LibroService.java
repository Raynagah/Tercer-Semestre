package com.biblioteca.bibliotecaduoc.service;
//Clase para crear la lógica del negocio


//1-Importaciones
import com.biblioteca.bibliotecaduoc.model.Libro;
import com.biblioteca.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//2-Importaciones 2
import java.util.List;
import java.util.Optional;

//3-Importar opción de Service para marcar esta clase como un servicio de Spring
@Service

public class LibroService {
    //4-Autowired actua como inyector hacia el repositor de manera interna para consumirlo en el servicio
    @Autowired
    private LibroRepository libroRepository;
    //5-Cuenta el total
    public int obtenerTotalLibros(){
        return libroRepository.totalLibros();
    }
    //6-Buscar un libro por ISBN
    public Optional<Libro> buscarLibroPorIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }
    //7-Cuenta libros por año especifico
    public long contarLibrosPorAnio(int anio){
        return libroRepository.contarPorAnio(anio);
    }
    //8-Buscar todos los libros de un autor
    public List<Libro> buscarLibrosPorAutor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }
    //9-Obtiene libro por fecha más antigua
    public Optional<Libro> obtenerLibroMasAntiguo(){
        return libroRepository.libroMasAntiguo();
    }
    //10-Obtener libro más reciente
    public Optional<Libro> obtenerLibroMasNuevo(){
        return  libroRepository.libroMasNuevo();
    }
    //11-Todos los libros ordenados de manera ASC por año de publicacion
    public List<Libro> listarLibrosOrdenadosPorAnio(){
        return libroRepository.listarOrdenadosPorAnio();
    }
}
