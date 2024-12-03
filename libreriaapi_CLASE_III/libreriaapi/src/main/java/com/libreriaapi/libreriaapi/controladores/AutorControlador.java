package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.modelos.autor.AutorCreateDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorPatchDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorUpdateDTO;
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

    @PostMapping("crearDTO")
    public ResponseEntity<Object> crearAutor(@RequestBody AutorCreateDTO autorDTO) {
        try {
            autorServicios.crearAutor(autorDTO);
            return new ResponseEntity<>(HttpStatus.OK);
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

    @GetMapping("listarDTO")
    public ResponseEntity<Object> listarAutoresDTO() {
        try {
            return ResponseEntity.ok(autorServicios.listarAutoresDTO());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los autores: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarActivos")
    public ResponseEntity<Object> listarAutoresActivos() {
        try {
            return ResponseEntity.ok(autorServicios.listarAutoresActivos());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los autores activos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

    @PostMapping("darBajaDTO")
    public ResponseEntity<Object> darBajaAutor(@RequestBody AutorDarBajaDTO autorDTO) {
        try {
            autorServicios.darBajaAutor(autorDTO);
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

    @PostMapping("darBajaPorNombreDTO")
    public ResponseEntity<Object> darBajaAutorPorTitulo(@RequestBody AutorDarBajaDTO autorDTO) {
        try {
            autorServicios.darBajaAutorPorNombre(autorDTO);
            return ResponseEntity.ok("Autor dado de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PatchMapping("modificarParcial")
    public ResponseEntity<Object> modificarAutorParcial(
            @RequestParam String id,
            @RequestParam(required = false) String nuevoNombre,
            @RequestParam(required = false) Boolean activo) {
        try {
            autorServicios.actualizarAutorParcial(id, nuevoNombre, activo);
            return ResponseEntity.ok("Autor modificado parcialmente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el autor: " + e.getMessage());
        }
    }

    @PatchMapping("modificarParcialDTO")
    public ResponseEntity<Object> modificarAutorParcial(@RequestBody AutorPatchDTO autorDTO) {
        try {
            autorServicios.actualizarAutorParcial(autorDTO);
            return ResponseEntity.ok("Autor modificado parcialmente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el autor: " + e.getMessage());
        }
    }


    @PutMapping("modificar")
    public ResponseEntity<Object> modificarAutor(@RequestParam String id, @RequestParam String nombre, @RequestParam Boolean activo) {
        try {
            autorServicios.actualizarAutor(id, nombre, activo);
            return ResponseEntity.ok(autorServicios.obtenerAutorPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("modificarDTO")
    public ResponseEntity<Object> modificarAutor(@RequestBody AutorUpdateDTO autorDTO) {
        try {
            autorServicios.actualizarAutor(autorDTO);
            return ResponseEntity.ok(autorServicios.obtenerAutorPorId(autorDTO.getIdAutor()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
