package com.biblioteca.bibliotecaduoc.repository;

import org.springframework.stereotype.Repository;

//1.CRUD

import com.biblioteca.bibliotecaduoc.model.Libro;

//2. Importaciones
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LibroRepository {
    //3.Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //4.Constructor que se inicialice automaticamente y me cree 10 libros en mi lista
    public LibroRepository() {
        //Agregar los libros
        //id,isbn,titulo,editorial,fecha de publicacion,autor
        listaLibros.add(new Libro(1, "9788499924743", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R R Martin"));
        listaLibros.add(new Libro(2, "9788435063834", "Cien años de soledad", "Editorial Sudamericana", 1967, "Gabriel García Márquez"));
        listaLibros.add(new Libro(3, "9780345816023", "La chica del tren", "Alfaguara", 2015, "Paula Hawkins"));
        listaLibros.add(new Libro(4, "9788490625297", "El nombre del viento", "Plaza & Janés", 2007, "Patrick Rothfuss"));
        listaLibros.add(new Libro(5, "9786071130631", "El amor en los tiempos del cólera", "Editorial Mondadori", 1985, "Gabriel García Márquez"));
        listaLibros.add(new Libro(6, "9788483830191", "El alquimista", "Editorial Planeta", 1988, "Paulo Coelho"));
        listaLibros.add(new Libro(7, "9788420432852", "1984", "Editorial Debolsillo", 1949, "George Orwell"));
        listaLibros.add(new Libro(8, "9788433988771", "Los pilares de la tierra", "Editorial Planeta", 1989, "Ken Follett"));
        listaLibros.add(new Libro(9, "9788466315002", "La sombra del viento", "Editorial Planeta", 2001, "Carlos Ruiz Zafón"));
        listaLibros.add(new Libro(10, "9780061122415", "Matar a un ruiseñor", "J.B. Lippincott & Co.", 1960, "Harper Lee"));


    }

    //7.Metodo para obtener la cantidad total de libros
    public int totalLibros(){
        return listaLibros.size();
    }

    //8.Buscar un libro por su isbn y va a retornar la primera coincidencia
    public Optional<Libro> buscarPorIsbn(String isbn){
        return listaLibros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst();
    }
    //9.Metodo que cuenta los libros de un año especifico
    public long contarPorAnio(int anio){
        return listaLibros.stream().filter(libro -> libro.getFechaPublicacion()==anio).count();
    }

    //10.Buscar todos los libros de un autor especifico
    public List<Libro> buscarPorAutor(String autor){
        return listaLibros.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor)).collect(Collectors.toList());
    }
    //11.Encontrar el libro con menor año de publicacion. Ademas obtiene el minimo por año
    public Optional<Libro> libroMasAntiguo(){
        return listaLibros.stream().min(Comparator.comparingInt(Libro::getFechaPublicacion));
    }
    //12.Encontrar el libro con el año mas reciente de publicacion.
    public Optional<Libro> libroMasNuevo(){
        return listaLibros.stream().max(Comparator.comparingInt(Libro::getFechaPublicacion));
    }

    //13.Devolver la lista completa ordenada por año de manera ascendente
    public List<Libro> listarOrdenadosPorAnio(){
        return listaLibros.stream().sorted(Comparator.comparingInt(Libro::getFechaPublicacion)).collect(Collectors.toList());
    }








    //Metodo que retorna todos los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    //Buscar un libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    //Buscar un libro por su isbn
    /*public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }*/

    //Metodo que guarda el libro en el arreglo y retorna libro: guardar
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }
    //Metodo que actualiza el libro por el id, retorna libro actualizado: actualizar
    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = 1;
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion,libro1);
        return libro1;
    }

    //Metodo que elimina el libro mediante su id: eliminar
    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if (libro !=null){
            listaLibros.remove(libro);
        }
        //Alternativa 2
        int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(1).getId()== id){
                idPosicion=i;
                break;
            }
        }
        if (idPosicion>0){
            listaLibros.remove(idPosicion);
        }
        //otra alternativa
        listaLibros.removeIf(x ->x.getId()==id);
    }


}
