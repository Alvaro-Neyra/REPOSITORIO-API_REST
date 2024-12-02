package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.servicios.LibroServicios;


@RestController
@RequestMapping("libro")
public class LibroControlador {
    @Autowired
    private LibroServicios libroServicios;

    @PostMapping("crear")
    public ResponseEntity<Object> crearLibro(@RequestParam Long idLibro,@RequestParam String titulo,@RequestParam Integer ejemplares,@RequestParam String idAutor,@RequestParam Integer idEditorial) {
        try {
            libroServicios.crearLibro(idLibro, titulo, ejemplares, idAutor, idEditorial);
            return new ResponseEntity<>("Libro creado correctamente: " + titulo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear un nuevo libro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listar")
    public ResponseEntity<Object> listarLibros() {
        try {
            return ResponseEntity.ok(libroServicios.listarLibros());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("darBaja")
    public ResponseEntity<Object> darBajaLibro(@RequestParam Long id) {
        try {
            libroServicios.darBajaLibro(id);
            return ResponseEntity.ok("Libro dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("darBajaPorTitulo")
    public ResponseEntity<Object> darBajaLibroPorTitulo(@RequestParam String titulo) {
        try {
            libroServicios.darBajaLibroPorTitulo(titulo);
            return ResponseEntity.ok("Libro dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("modificar")
    public ResponseEntity<Object> modificarLibro(@RequestParam Long id, @RequestParam String titulo, @RequestParam Integer ejemplares, @RequestParam Autor idAutor, @RequestParam Editorial idEditorial) {
        try {
            libroServicios.actualizarLibro(id, titulo, ejemplares, idAutor, idEditorial);
            return ResponseEntity.ok("Libro modificado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
