package com.biblioteca.bibliotecaduoc.repository;

//1-Import
import com.biblioteca.bibliotecaduoc.model.Prestamo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Repository;
//2-Import
import java.util.List;
import java.util.ArrayList;

@Repository //Definimos la clase como un repositorio de SpringBoot

public class PrestamoRepository {
    //3-Crear y agregar una lista, además de inicializarla como vacía
    private List<Prestamo> prestamos = new ArrayList<>();

    //4-Crear un metodo para agregar prestamos
    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }
    //5-Listar todos los prestamos
    public List<Prestamo> obtenerTodosLosPrestamos(){
        return prestamos;
    }




}
