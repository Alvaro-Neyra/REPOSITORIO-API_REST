package com.egg.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.servicios.AutorServicio;

@RestController // Indica que esta clase es un controlador REST, manejando solicitudes HTTP.
@RequestMapping("/autor") // Define la ruta base para acceder a los métodos de este controlador.
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio; // Inyecta el servicio para manejar la lógica de negocio relacionada con autores.

    @PostMapping("crear") // Método HTTP POST para crear un nuevo autor en la base de datos.
    public ResponseEntity<Object> crearAutor(String nombre) {
        try {
            autorServicio.crearAutor(nombre); // Llama al servicio para crear un autor.
            return new ResponseEntity<>(HttpStatus.OK);
            //return new ResponseEntity<>(HttpStatus.CREATED); // Devuelve un estado 201 Created en caso de éxito. (OTRA OPCION DE IMPLEMENTACION)

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);// Devuelve un estado 500 Internal Server Error en caso de fallo.
        }
    }

    @GetMapping("/listar") // Método HTTP GET para recuperar una lista de autores.
    public ResponseEntity<List<Autor>> listarAutores() {
        try {
            List<Autor> autores = autorServicio.listarAutores(); //Obtiene la lista de autores desde el servicio.
            return ResponseEntity.ok(autores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/modificar") // Método HTTP PATCH para modificar un autor existente en la base de datos.
    public ResponseEntity<Void> modificarAutor(@RequestParam String nombre, @RequestParam String id) {
        /*
         * Este método recibe parámetros en la solicitud. Los nombres de los parámetros (nombre, id) deben coincidir con
         * los nombres utilizados en la anotación @RequestParam. La solicitud se debe enviar en formato de parámetros de consulta.
         */
        try {
            autorServicio.modificarAutor(nombre, id);// "Nombre", hace referencia a "como viaja el dato, no al nombre
                                                     // del atributo de la entidad"
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
