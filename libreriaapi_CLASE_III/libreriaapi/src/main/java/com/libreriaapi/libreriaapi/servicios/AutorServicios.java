package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.modelos.autor.AutorCreateDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorListDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorPatchDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorUpdateDTO;
import com.libreriaapi.libreriaapi.repositorios.AutorRepositorio;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicios {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) {
        Autor autor = new Autor();
        autor.setNombreAutor(nombre);
        autor.setAutorActivo(true);
        autorRepositorio.save(autor);
    }

    @Transactional
    public void crearAutor(AutorCreateDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombreAutor(autorDTO.getNombreAutor());
        autor.setAutorActivo(autorDTO.getAutorActivo());
        autorRepositorio.save(autor);
    }

    @Transactional
    public Autor obtenerAutorPorId(String id) throws Exception{
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            return autorOpcional.get();
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {
        return autorRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public List<AutorListDTO> listarAutoresDTO() {
        return autorRepositorio.listar();
    }

    @Transactional
    public List<AutorListActivosDTO> listarAutoresActivos() {
        return autorRepositorio.listarActivos();
    }

    @Transactional(readOnly = true)
    public Autor getOne(String id) {
        return autorRepositorio.getOne(id);
    }

    @Transactional
    public void darBajaAutor(String id) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setAutorActivo(false);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    @Transactional
    public void darBajaAutor(AutorDarBajaDTO autorDTO) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(autorDTO.getIdAutor());
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setAutorActivo(false);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    @Transactional
    public void darBajaAutorPorNombre(String nombre) throws Exception {
        Autor autor = autorRepositorio.buscarPorNombreAutor(nombre);
        if (autor != null) {
            autor.setAutorActivo(false);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    @Transactional
    public void darBajaAutorPorNombre(AutorDarBajaDTO autorDTO) throws Exception {
        Autor autor = autorRepositorio.buscarPorNombreAutor(autorDTO.getNombreAutor());
        if (autor != null) {
            autor.setAutorActivo(false);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    @Transactional
    public void actualizarAutorParcial(String id, String nuevoNombre, Boolean activo) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();

            if (nuevoNombre != null) {
                autor.setNombreAutor(nuevoNombre);
            }
            if (activo != null) {
                autor.setAutorActivo(activo);
            }

            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontró el autor con ID: " + id);
        }
    }

    @Transactional
    public void actualizarAutorParcial(AutorPatchDTO autorDTO) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(autorDTO.getIdAutor());
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();

            if (autorDTO.getNombreAutor() != null) {
                autor.setNombreAutor(autorDTO.getNombreAutor());
            }
            if (autorDTO.getAutorActivo() != null) {
                autor.setAutorActivo(autorDTO.getAutorActivo());
            }

            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontró el autor con ID: " + autorDTO.getIdAutor());
        }
    }

    @Transactional
    public void actualizarAutor(String id, String nuevoNombre, Boolean activo) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setNombreAutor(nuevoNombre);
            autor.setAutorActivo(activo);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }        
    }

    @Transactional
    public void actualizarAutor(AutorUpdateDTO autorDTO) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(autorDTO.getIdAutor());
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setNombreAutor(autorDTO.getNombreAutor());
            autor.setAutorActivo(autorDTO.getAutorActivo());
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }
}
