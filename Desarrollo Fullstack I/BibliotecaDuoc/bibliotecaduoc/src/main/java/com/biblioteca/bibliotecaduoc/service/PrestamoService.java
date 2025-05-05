package com.biblioteca.bibliotecaduoc.service;

//Import 1
import com.biblioteca.bibliotecaduoc.model.Prestamo;
import com.biblioteca.bibliotecaduoc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Import 2
import java.util.List;

@Service //Importo Service para indicarle a la clase que debe comportarse como un servicio

public class PrestamoService {

    @Autowired //Permite inyectar un servicio (en este caso el servicio Prestamos) y consumirlo acá

    private PrestamoRepository prestamoRepository;

    //Llamo al primer metodo de prestamo
    public void crearPrestamo(Prestamo prestamo){
        prestamoRepository.agregarPrestamo(prestamo);
    }

    //Llamo al segundo metodo de prestamo
    public List<Prestamo> listarPrestamos(){
        return prestamoRepository.obtenerTodosLosPrestamos();
    }







}
