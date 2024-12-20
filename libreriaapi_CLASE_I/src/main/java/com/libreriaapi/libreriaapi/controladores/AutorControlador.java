package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.servicios.AutorServicios;

@RestController
@RequestMapping("/autor")
public class AutorControlador {
    @Autowired
    private AutorServicios autorServicios;

    @PostMapping("crear")
    public ResponseEntity<Object> crearAutor(String nombre) {
        try {
            autorServicios.crearAutor(nombre);
            return new ResponseEntity<>("Autor creado correctamente: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear un nuevo Autor: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
