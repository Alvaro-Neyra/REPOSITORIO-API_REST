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

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.servicios.EditorialServicio;

@RestController // Indica que esta clase es un controlador REST que maneja solicitudes HTTP y
                // devuelve respuestas en formato JSON.
@RequestMapping("/editorial") // Define la ruta base para todas las solicitudes manejadas por este
                              // controlador.
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio; // Inyecta el servicio de editoriales para acceder a la lógica de
                                                 // negocio relacionada con editoriales.

    @PostMapping("/crear") // Define un método que maneja solicitudes HTTP POST para crear una editorial
                           // usando un nombre.
    public ResponseEntity<Object> crearEditorial(String nombre) {
        /*
         * Este método maneja solicitudes POST para crear una nueva editorial.
         * El nombre de la editorial se recibe como parámetro de consulta en la URL. No
         * recibe el "atributo editorialActiva,
         * ya que decido ponerlo en true al crear una isntancia de la entidad."
         */
        try {
            editorialServicio.crearEditorial(nombre);// Llama al servicio para crear una editorial con el nombre
                                                     // proporcionado.
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("crearDTO")
    public ResponseEntity<Object> crearEditorial(@RequestBody EditorialCreateDTO editorialCreateDTO) {
        /*
         * Este método maneja solicitudes HTTP POST para crear una nueva editorial.
         * Recibe un objeto EditorialCreateDTO en el cuerpo de la solicitud.
         * Puedes optar por diferentes enfoques para establecer el estado de alta de la
         * editorial:
         * 
         * 1. **Opción 1**: Establecer el estado de alta a TRUE mediante el constructor
         * al crear una instancia de Editorial.
         * - En este enfoque, solo se recibe el nombre en el DTO, y el estado de alta se
         * fija por defecto al crear la instancia de Editorial.
         * 
         * 2. **Opción 2**: Configurar el estado de alta manualmente al utilizar un DTO.
         * - En este caso, se recibe toda la información necesaria, incluyendo el estado
         * de alta, en el DTO, y se asigna manualmente al crear la editorial.
         * 
         * Estos enfoques permiten distintas formas de resolver el problema,
         * proporcionando flexibilidad en cómo manejar la creación y configuración de
         * las entidades.
         */
        try {
            editorialServicio.crearEditorial(editorialCreateDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Editorial>> listarEditoriales() {
        try {
            List<Editorial> editoriales = editorialServicio.listarEditoriales();
            return ResponseEntity.ok(editoriales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
