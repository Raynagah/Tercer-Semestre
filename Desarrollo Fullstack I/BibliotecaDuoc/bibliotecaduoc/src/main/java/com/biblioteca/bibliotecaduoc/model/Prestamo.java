package com.biblioteca.bibliotecaduoc.model;

//1-Import
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

//2-Import
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Prestamo {

    //3-Atributos especificos que tengan relación con la clase Prestamo
    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private Date fecha_solicitud;
    private Date fecha_entrega;
    private int cantidad_dias;
    private int multas;











}
