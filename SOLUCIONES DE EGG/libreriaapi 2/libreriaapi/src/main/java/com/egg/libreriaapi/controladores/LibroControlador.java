package com.egg.libreriaapi.controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.servicios.LibroServicio;

@RestController // Indica que esta clase es un controlador REST que maneja solicitudes HTTP y devuelve respuestas en formato JSON.
@RequestMapping("/libro") // Define la ruta base para todas las solicitudes manejadas por este controlador.
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @PostMapping("/crear")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
        try {
            libroServicio.crearLibro(libroDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
        }
    }

         @GetMapping("/listarActivos")
    public ResponseEntity<List<LibroListarActivosDTO>> listarAutores() {
        try {
            List<LibroListarActivosDTO> librosActivos = libroServicio.listarLibrosActivos();
            return ResponseEntity.ok(librosActivos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}


