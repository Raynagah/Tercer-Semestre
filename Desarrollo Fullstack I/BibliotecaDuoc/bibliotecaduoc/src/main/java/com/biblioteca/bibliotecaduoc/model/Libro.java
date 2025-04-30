package com.biblioteca.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1-Llamar a Lombok para escribir menos código repetitivo
@Data //Genera getters, setters, toString, equals, hashCode y un constructor con los campos requeridos.
@AllArgsConstructor //Genera un constructor con todos los campos
@NoArgsConstructor //Genera un constructor vacío
public class Libro {
    //Atributos de la clase Libro
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;
}
