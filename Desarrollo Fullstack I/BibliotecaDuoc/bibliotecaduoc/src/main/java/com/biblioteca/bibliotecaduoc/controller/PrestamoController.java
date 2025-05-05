package com.biblioteca.bibliotecaduoc.controller;

//Import
import com.biblioteca.bibliotecaduoc.model.Prestamo;
import com.biblioteca.bibliotecaduoc.repository.PrestamoRepository;
import com.biblioteca.bibliotecaduoc.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Import listas
import java.util.List;


@RestController //Esta importacion define esta clase como un controlador de tipo REST
@RequestMapping("/api/v1/solicitudes") //Defino una ruta base
public class PrestamoController {
    @Autowired//Jeringa
    private PrestamoService servicioInyectado;

    //Llamar a postmapping | EndPoint para poder realizar solicitudes de tipo POST (Crear datos) = Insert

    @PostMapping
    public String crearPrestamo(@RequestBody Prestamo prestamo){ //RequestBody tomará los datos que le ingresemos en formato JSON y los inyectará en el POST
        servicioInyectado.crearPrestamo(prestamo);
        return "Solicitud de préstamo registrada exitosamente";
    }

    //a
    @GetMapping
    public List<Prestamo> obtenerPrestamos(){
        return servicioInyectado.listarPrestamos();
    }

}
