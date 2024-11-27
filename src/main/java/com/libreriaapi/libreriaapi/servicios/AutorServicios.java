package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.repositorios.AutorRepositorio;

@Service
public class AutorServicios {
    @Autowired
    private AutorRepositorio autorRepositorio;

    public void crearAutor(String nombre) {
        Autor autor = new Autor();
        autor.setNombre_autor(nombre);
        autor.setAutor_activo(true);
        autorRepositorio.save(autor);
    }

    public Autor obtenerAutorPorId(String id) throws Exception{
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            return autorOpcional.get();
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    public List<Autor> listarAutores() {
        return autorRepositorio.findAll();
    }

    public void darBajaAutor(String id) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setAutor_activo(false);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }
    }

    public void actualizarAutor(String id, String nuevoNombre) throws Exception {
        Optional<Autor> autorOpcional = autorRepositorio.findById(id);
        if (autorOpcional.isPresent()) {
            Autor autor = autorOpcional.get();
            autor.setNombre_autor(nuevoNombre);
            autorRepositorio.save(autor);
        } else {
            throw new Exception("No se encontro el autor");
        }        
    }
}
