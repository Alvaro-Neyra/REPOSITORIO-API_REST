package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.entidades.Libro;
import com.libreriaapi.libreriaapi.modelos.LibroCreateDTO;
import com.libreriaapi.libreriaapi.repositorios.LibroRepositorio;

public class LibroServicios {
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorServicios autorServicios;

    @Autowired
    private EditorialServicios editorialServicios;


    @Transactional
    public void crearLibro(LibroCreateDTO libroCreateDTO) throws Exception {
        try {
            Libro libroNuevo = new Libro();
            libroNuevo.setId_libro(libroCreateDTO.getIsbn());
            libroNuevo.setTitulo(libroCreateDTO.getTitulo());
            libroNuevo.setEjemplares(libroCreateDTO.getEjemplares());
            Autor autor = autorServicios.obtenerAutorPorId(libroCreateDTO.getIdAutor());
            if (autor != null) {
                libroNuevo.setAutor(autor);
            }
            Editorial editorial = editorialServicios.obtenerEditorialPorId(libroCreateDTO.getIdEditorial());
            if (editorial != null) {
                libroNuevo.setEditorial(editorial);
            }
            libroRepositorio.save(libroNuevo);
        }  catch (Exception e) {
            throw new Exception("Error al crear un nuevo libro: " + e.getMessage());
        }
    }

    public Libro obtenerLibroPorId(Long id) throws Exception{
        Optional<Libro> libro = libroRepositorio.findById(id);
        if (libro.isPresent()) {
            return libro.get();
        } else {
            throw new Exception("No se encontro el libro");
        }
    }

    List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    public void darBajaLibro(Long id) throws Exception {
        Optional<Libro> libro = libroRepositorio.findById(id);
        if (libro.isPresent()) {
            Libro libroBaja = libro.get();
            libroBaja.setLibro_activo(false);
            libroRepositorio.save(libroBaja);
        } else {
            throw new Exception("No se encontro el libro");
        }
    }

    public void actualizarLibro(Long idLibro, String titulo, Integer ejemplares, Autor autor, Editorial editorial) {
        Optional<Libro> libro = libroRepositorio.findById(idLibro);
        if (libro.isPresent()) {
            Libro libroActualizado = libro.get();
            libroActualizado.setTitulo(titulo);
            libroActualizado.setEjemplares(ejemplares);
            libroActualizado.setAutor(autor);
            libroActualizado.setEditorial(editorial);
            libroRepositorio.save(libroActualizado);
        }
    }
}
