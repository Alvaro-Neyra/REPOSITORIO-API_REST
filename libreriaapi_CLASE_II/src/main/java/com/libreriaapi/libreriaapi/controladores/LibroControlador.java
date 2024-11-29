package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.libreriaapi.libreriaapi.modelos.LibroCreateDTO;
import com.libreriaapi.libreriaapi.servicios.LibroServicios;

public class LibroControlador {
    @Autowired
    private LibroServicios libroServicios;

    @PostMapping("crear")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroCreateDTO) {
        try {
            libroServicios.crearLibro(libroCreateDTO);
            return new ResponseEntity<>("Libro creado correctamente: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear un nuevo libro: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
