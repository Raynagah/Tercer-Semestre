package com.biblioteca.bibliotecaduoc.controller;

//1-Imports
import com.biblioteca.bibliotecaduoc.model.Libro;
import com.biblioteca.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//2-Imports
import java.util.List;
import java.util.Optional;

@RestController //Protocolo HTTP
@RequestMapping ("/api/libros")


public class LibroController {

    @Autowired
    private LibroService libroService; //Importamos LibroService porque contiene la lógica del negocio

    //Endpoint
    @GetMapping("/total")
    public int totalLibros(){
        return libroService.obtenerTotalLibros();
    }

    @GetMapping("/buscar/isbn/{isbn}")
    public Optional<Libro> buscarPorIsbn(@PathVariable String isbn){
        return libroService.buscarLibroPorIsbn(isbn);
    }

    @GetMapping("/buscar/anio/{anio}")
    public long contarPorAnio(@PathVariable int anio){
        return libroService.contarLibrosPorAnio(anio);
    }

    @GetMapping("/buscar/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor){
        return libroService.buscarLibrosPorAutor(autor);
    }

    @GetMapping("/buscar/antiguo")
    public Optional<Libro> buscarMasAntiguo(){
        return libroService.obtenerLibroMasAntiguo();
    }

    @GetMapping("/buscar/nuevo")
    public Optional<Libro> buscarMasNuevo(){
        return libroService.obtenerLibroMasNuevo();
    }

    @GetMapping("/listar/ordenado")
    public List<Libro> listarOrdenadosPorAnio(){
        return libroService.listarLibrosOrdenadosPorAnio();
    }



}












