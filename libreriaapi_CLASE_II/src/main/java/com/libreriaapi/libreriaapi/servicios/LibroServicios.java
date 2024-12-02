package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.entidades.Libro;
import com.libreriaapi.libreriaapi.repositorios.LibroRepositorio;

@Service
public class LibroServicios {
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorServicios autorServicios;

    @Autowired
    private EditorialServicios editorialServicios;


    @Transactional
    public void crearLibro(Long idLibro, String titulo, Integer ejemplares, String idAutor, Integer idEditorial) throws Exception {
        try {
            Libro libroNuevo = new Libro();
            libroNuevo.setIdLibro(idLibro);
            libroNuevo.setTitulo(titulo);
            libroNuevo.setEjemplares(ejemplares);
            Autor autor = autorServicios.obtenerAutorPorId(idAutor);
            libroNuevo.setAutor(autor);
            Editorial editorial = editorialServicios.obtenerEditorialPorId(idEditorial);
            libroNuevo.setEditorial(editorial);
            libroNuevo.setLibroActivo(true);
            libroRepositorio.save(libroNuevo);
        } catch (Exception e) {
            throw new Exception("Error al crear un nuevo libro: " + e.getMessage());
        }
    }

    @Transactional
    public Libro obtenerLibroPorId(Long id) throws Exception{
        Optional<Libro> libro = libroRepositorio.findById(id);
        if (libro.isPresent()) {
            return libro.get();
        } else {
            throw new Exception("No se encontro el libro");
        }
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    @Transactional
    public void darBajaLibro(Long id) throws Exception {
        Optional<Libro> libro = libroRepositorio.findById(id);
        if (libro.isPresent()) {
            Libro libroBaja = libro.get();
            libroBaja.setLibroActivo(false);
            libroRepositorio.save(libroBaja);
        } else {
            throw new Exception("No se encontro el libro");
        }
    }

    @Transactional
    public void darBajaLibroPorTitulo(String titulo) throws Exception {
        Libro libro = libroRepositorio.buscarPorTitulo(titulo);
        if (libro != null) {
            libro.setLibroActivo(false);
            libroRepositorio.save(libro);
        } else {
            throw new Exception("No se encontro el libro");
        }
    }

    @Transactional
    public void actualizarLibroParcial(Long idLibro, String titulo, Integer ejemplares, String idAutor, Integer idEditorial) throws Exception{
        try {
            Optional<Libro> libroOptional = libroRepositorio.findById(idLibro);
            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
    
                if (titulo != null) {
                    libro.setTitulo(titulo);
                }
                if (ejemplares != null) {
                    libro.setEjemplares(ejemplares);
                }
                if (idAutor != null) {
                    Autor autor = autorServicios.obtenerAutorPorId(idAutor);
                    libro.setAutor(autor);
                }
                if (idEditorial != null) {
                    Editorial editorial = editorialServicios.obtenerEditorialPorId(idEditorial);
                    libro.setEditorial(editorial);
                }
    
                libroRepositorio.save(libro);
            } else {
                throw new Exception("Libro no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar parcialmente el libro: " + e.getMessage());
        }
    }

    @Transactional
    public void actualizarLibro(Long idLibro, String titulo, Integer ejemplares, String idAutor, Integer idEditorial) throws Exception {
        try {
            Optional<Libro> libro = libroRepositorio.findById(idLibro);
            if (libro.isPresent()) {
                Libro libroActualizado = libro.get();
                libroActualizado.setTitulo(titulo);
                libroActualizado.setEjemplares(ejemplares);
                Autor autor = autorServicios.obtenerAutorPorId(idAutor);
                libroActualizado.setAutor(autor);
                Editorial editorial = editorialServicios.obtenerEditorialPorId(idEditorial);
                libroActualizado.setEditorial(editorial);
                libroRepositorio.save(libroActualizado);
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el libro: " + e.getMessage());
        }
    }
}
