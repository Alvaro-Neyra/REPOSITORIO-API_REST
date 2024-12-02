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

    @GetMapping("listar")
    public ResponseEntity<Object> listarAutores() {
        try {
            return ResponseEntity.ok(autorServicios.listarAutores());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los autores: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("darBaja")
    public ResponseEntity<Object> darBajaAutor(@RequestParam String id) {
        try {
            autorServicios.darBajaAutor(id);
            return ResponseEntity.ok("Autor dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("darBajaPorNombre")
    public ResponseEntity<Object> darBajaAutorPorTitulo(@RequestParam String nombre) {
        try {
            autorServicios.darBajaAutorPorNombre(nombre);
            return ResponseEntity.ok("Autor dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PatchMapping("modificar")
    public ResponseEntity<Object> modificarAutor(@RequestParam String id, @RequestParam String nombre) {
        try {
            autorServicios.actualizarAutor(id, nombre);
            return ResponseEntity.ok(autorServicios.obtenerAutorPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
