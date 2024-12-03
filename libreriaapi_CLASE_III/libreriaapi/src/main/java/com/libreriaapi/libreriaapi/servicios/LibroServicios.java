package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.entidades.Libro;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialUpdateDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroCreateDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroDeleteDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroListDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroPatchDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroUpdateDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibrosPorAutorDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibrosPorEditorialDTO;
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
    public void crearLibro(LibroCreateDTO libroCreateDTO) {
        Libro libroNvo = new Libro();
        libroNvo.setIdLibro(libroCreateDTO.getIsbn());
        libroNvo.setTitulo(libroCreateDTO.getTitulo());
        libroNvo.setEjemplares(libroCreateDTO.getEjemplares());
        libroNvo.setLibroActivo(libroCreateDTO.getLibroActivo());
        Autor autor = autorServicios.getOne(libroCreateDTO.getIdAutor());
        if (autor != null) {
            libroNvo.setAutor(autor);
        }
        Editorial editorial = editorialServicios.getOne(libroCreateDTO.getIdEditorial());
        if (editorial != null) {
            libroNvo.setEditorial(editorial);
        }
        libroRepositorio.save(libroNvo);
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

    @Transactional(readOnly = true)
    public List<LibroListDTO> listarLibrosDTO() {
        return libroRepositorio.listar();
    }

    @Transactional(readOnly = true)
    public List<LibroListActivosDTO> listarLibrosActivos() {
        return libroRepositorio.listarActivos();
    }

    @Transactional(readOnly = true)
    public List<LibrosPorAutorDTO> listarLibrosPorAutor(String idAutor) {
        return libroRepositorio.listarPorAutor(idAutor);
    }

    @Transactional(readOnly = true)
    public List<LibrosPorEditorialDTO> listarLibrosPorEditorial(Integer idEditorial) {
        return libroRepositorio.listarPorEditorial(idEditorial);
    }

    @Transactional(readOnly = true)
    public List<LibrosPorAutorDTO> listarLibrosPorEditorialYLibros(String idAutor, Integer idEditorial) {
        return libroRepositorio.listarPorAutorYEditorial(idAutor, idEditorial);
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
    public void darBajaLibro(LibroDarBajaDTO libroDTO) throws Exception {
        Optional<Libro> libro = libroRepositorio.findById(libroDTO.getIsbn());
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
    public void darBajaLibroPorTitulo(LibroDarBajaDTO libroDTO) throws Exception {
        Libro libro = libroRepositorio.buscarPorTitulo(libroDTO.getTitulo());
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
    public void actualizarLibroParcial(LibroPatchDTO libroDTO) throws Exception {
        try {
            Optional<Libro> libroOptional = libroRepositorio.findById(libroDTO.getIsbn());
            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
    
                if (libroDTO.getTitulo() != null) {
                    libro.setTitulo(libroDTO.getTitulo());
                }
                if (libroDTO.getEjemplares() != null) {
                    libro.setEjemplares(libroDTO.getEjemplares());
                }
                if (libroDTO.getIdAutor() != null) {
                    Autor autor = autorServicios.getOne(libroDTO.getIdAutor());
                    libro.setAutor(autor);
                }
                if (libroDTO.getIdEditorial() != null) {
                    Editorial editorial = editorialServicios.getOne(libroDTO.getIdEditorial());
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

    @Transactional
    public void actualizarLibro(LibroUpdateDTO libroDTO) throws Exception {
        try {
            Optional<Libro> libro = libroRepositorio.findById(libroDTO.getIsbn());
            if (libro.isPresent()) {
                Libro libroActualizado = libro.get();
                libroActualizado.setTitulo(libroDTO.getTitulo());
                libroActualizado.setEjemplares(libroDTO.getEjemplares());
                Autor autor = autorServicios.getOne(libroDTO.getIdAutor());
                libroActualizado.setAutor(autor);
                Editorial editorial = editorialServicios.getOne(libroDTO.getIdEditorial());
                libroActualizado.setEditorial(editorial);
                libroRepositorio.save(libroActualizado);
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el libro: " + e.getMessage());
        }
    }

    @Transactional
    public void eliminarLibro(Long id) {
        libroRepositorio.deleteById(id);
    }

    @Transactional
    public void eliminarLibro(LibroDeleteDTO libroDTO) {
        libroRepositorio.deleteById(libroDTO.getIsbn());
    }
}
