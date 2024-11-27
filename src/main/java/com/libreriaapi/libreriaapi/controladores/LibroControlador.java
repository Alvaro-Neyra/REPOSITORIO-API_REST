package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.servicios.LibroServicios;

public class LibroControlador {
    @Autowired
    private LibroServicios libroServicios;

    @PostMapping("crear")
    public ResponseEntity<Object> crearLibro(@RequestParam Long idLibro,
                                            @RequestParam String titulo,    
                                            @RequestParam Integer ejemplares,
                                            @RequestParam Autor idAutor,
                                            @RequestParam Editorial idEditorial) {
        try {
            libroServicios.crearLibro(idLibro, titulo, ejemplares, idAutor, idEditorial);
            return new ResponseEntity<>("Libro creado correctamente: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear un nuevo libro: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
