package com.libreriaapi.libreriaapi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.servicios.EditorialServicios;


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
}
