package com.libreriaapi.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriaapi.libreriaapi.modelos.libro.LibroCreateDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroDeleteDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroPatchDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroUpdateDTO;
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

    @PostMapping("crearDTO")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
        try {
            libroServicios.crearLibro(libroDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
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

    @GetMapping("listarDTO")
    public ResponseEntity<Object> listarLibrosDTO() {
        try {
            return ResponseEntity.ok(libroServicios.listarLibrosDTO());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarActivos")
    public ResponseEntity<Object> listarLibrosActivos() {
        try {
            return ResponseEntity.ok(libroServicios.listarLibrosActivos());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros activos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarPorAutor")
    public ResponseEntity<Object> listarLibrosPorAutor(@RequestParam String idAutor) {
        try {
            return ResponseEntity.ok(libroServicios.listarLibrosPorAutor(idAutor));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros por autor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarPorEditorial")
    public ResponseEntity<Object> listarLibrosPorEditorial(@RequestParam Integer idEditorial) {
        try {
            return ResponseEntity.ok(libroServicios.listarLibrosPorEditorial(idEditorial));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros por editorial: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listarPorAutorYEditorial")
    public ResponseEntity<Object> listarLibrosPorAutorYEditorial(@RequestParam String idAutor, @RequestParam Integer idEditorial) {
        try {
            return ResponseEntity.ok(libroServicios.listarLibrosPorEditorialYLibros(idAutor, idEditorial));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar los libros por autor y editorial: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

    @PostMapping("darBajaDTO")
    public ResponseEntity<Object> darBajaLibroDTO(@RequestParam Long id) {
        try {
            LibroDarBajaDTO libro = libroServicios.darBajaLibroDTO(id);
            return ResponseEntity.ok(libro);
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

    @PostMapping("darBajaPorTituloDTO")
    public ResponseEntity<Object> darBajaLibroPorTituloDTO(@RequestParam String titulo) {
        try {
            List<LibroDarBajaDTO> librosDTO = libroServicios.darBajaLibroPorTituloDTO(titulo);
            return ResponseEntity.ok(librosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al dar de baja el libro por titulo: " + e.getMessage());
        }
    }

    @PatchMapping("modificarParcial")
    public ResponseEntity<Object> modificarLibroParcial(
        @RequestParam Long id,
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) Integer ejemplares,
        @RequestParam(required = false) String idAutor,
        @RequestParam(required = false) Integer idEditorial) {
        try {
            libroServicios.actualizarLibroParcial(id, titulo, ejemplares, idAutor, idEditorial);
            return ResponseEntity.ok("Libro modificado parcialmente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el libro parcialmente: " + e.getMessage());
        }
    }

    @PatchMapping("modificarParcialDTO")
    public ResponseEntity<Object> modificarLibroParcial(@RequestBody LibroPatchDTO libroDTO) {
        try {
            libroServicios.actualizarLibroParcial(libroDTO);
            return ResponseEntity.ok("Libro modificado parcialmente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el libro parcialmente: " + e.getMessage());
        }
    }

    @PutMapping("modificar")
    public ResponseEntity<Object> modificarLibro(@RequestParam Long id, @RequestParam String titulo, @RequestParam Integer ejemplares, @RequestParam String idAutor, @RequestParam Integer idEditorial) {
        try {
            libroServicios.actualizarLibro(id, titulo, ejemplares, idAutor, idEditorial);
            return ResponseEntity.ok("Libro modificado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("modificarDTO")
    public ResponseEntity<Object> modificarLibro(@RequestBody LibroUpdateDTO libroDTO) {
        try {
            libroServicios.actualizarLibro(libroDTO);
            return ResponseEntity.ok("Libro modificado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Object> eliminarLibro(@RequestParam Long id) {
        try {
            libroServicios.eliminarLibro(id);
            return ResponseEntity.ok("Libro eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("eliminarDTO")
    public ResponseEntity<Object> eliminarLibro(@RequestBody LibroDeleteDTO libroDTO) {
        try {
            libroServicios.eliminarLibro(libroDTO);
            return ResponseEntity.ok("Libro eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
