package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialCreateDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialDeleteDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialPatchDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialUpdateDTO;
import com.libreriaapi.libreriaapi.servicios.EditorialServicios;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/editorial")
@Validated
public class EditorialControlador {
    @Autowired
    private EditorialServicios editorialServicios;

    @PostMapping("crear")
    public ResponseEntity<Object> crearEditorial(@RequestParam String nombre) {
        try {
            editorialServicios.crearEditorial(nombre);
            return new ResponseEntity<>("Editorial creada correctamente: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear una nueva editorial: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("crearDTO")
    public ResponseEntity<Object> crearEditorial(@RequestBody EditorialCreateDTO editorialDTO) {
        try {
            editorialServicios.crearEditorial(editorialDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear una nueva editorial: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listar")
    public ResponseEntity<Object> listarEditoriales() {
        try {
            return ResponseEntity.ok(editorialServicios.listarEditoriales());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar las editoriales: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarDTO")
    public ResponseEntity<Object> listarEditorialesDTO() {
        try {
            return ResponseEntity.ok(editorialServicios.listarEditorialesDTO());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar las editoriales: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarActivos")
    public ResponseEntity<Object> listarEditorialesActivos() {
        try {
            return ResponseEntity.ok(editorialServicios.listarEditorialesActivos());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar las editoriales activas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarEditorial/{id}")
    public ResponseEntity<Editorial> listarEditorial(@PathVariable Integer id) {
        try {
            Editorial editorial = editorialServicios.getOne(id);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("darBaja")
    public ResponseEntity<Object> darBajaEditorial(@RequestParam Integer id) {
        try {
            editorialServicios.darBajaEditorial(id);
            return ResponseEntity.ok("Editorial dada de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("darBajaDTO")
    public ResponseEntity<Object> darBajaEditorial(@RequestBody EditorialDarBajaDTO editorialDTO) {
        try {
            editorialServicios.darBajaEditorial(editorialDTO);
            return ResponseEntity.ok("Editorial dada de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("darBajaPorNombre")
    public ResponseEntity<Object> darBajaEditorialPorNombre(@RequestParam String nombre) {
        try {
            editorialServicios.darBajaEditorialPorNombre(nombre);
            return ResponseEntity.ok("Editorial dada de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("darBajaPorNombreDTO")
    public ResponseEntity<Object> darBajaEditorialPorNombre(@RequestBody EditorialDarBajaDTO editorialDTO) {
        try {
            editorialServicios.darBajaEditorialPorNombre(editorialDTO);
            return ResponseEntity.ok("Editorial dada de baja correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("modificarParcial")
    public ResponseEntity<Object> modificarEditorialParcial(
            @RequestParam Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Boolean activo) {
        try {
            editorialServicios.actualizarEditorialParcial(id, nombre, activo);
            return ResponseEntity.ok("Editorial modificada parcialmente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la editorial: " + e.getMessage());
        }
    }

    @PatchMapping("modificarDTOParcial")
    public ResponseEntity<Object> modificarEditorial(@RequestBody EditorialPatchDTO editorialDTO) {
        try {
            editorialServicios.actualizarEditorialParcial(editorialDTO);
            return ResponseEntity.ok("Editorial modificada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("modificar")
    public ResponseEntity<Object> modificarEditorial(@RequestParam Integer id, @RequestParam String nombre, @RequestParam Boolean activo) {
        try {
            editorialServicios.actualizarEditorial(id, nombre, activo);
            return ResponseEntity.ok("Editorial modificada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("modificarDTO")
    public ResponseEntity<Object> modificarEditorial(@RequestBody EditorialUpdateDTO editorialDTO) {
        try {
            editorialServicios.actualizarEditorial(editorialDTO);
            return ResponseEntity.ok("Editorial modificada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Object> eliminarEditorial(@RequestParam Integer id) {
        try {
            editorialServicios.eliminarEditorial(id);
            return ResponseEntity.ok("Editorial eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("eliminarDTO")
    public ResponseEntity<Object> eliminarEditorial(@RequestBody EditorialDeleteDTO editorialDTO) {
        try {
            editorialServicios.eliminarEditorial(editorialDTO);
            return ResponseEntity.ok("Editorial eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
