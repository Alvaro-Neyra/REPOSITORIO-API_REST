package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.repositorios.EditorialRepositorio;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EditorialServicios {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(nombre);
        editorial.setEditorialActiva(true);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public Editorial obtenerEditorialPorId(Integer id) throws Exception{
        Optional<Editorial> editorial = editorialRepositorio.findById((id));
        if (editorial.isPresent()) {
            return editorial.get();
        } else {
            throw new Exception("No se encontro la editorial");
        }
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        return editorialRepositorio.findAll();
    }

    @Transactional
    public void darBajaEditorial(Integer id) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setEditorialActiva(false);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void darBajaEditorialPorNombre(String nombre) throws Exception {
        Editorial editorial = editorialRepositorio.buscarPorNombreEditorial(nombre);
        if (editorial != null) {
            editorial.setEditorialActiva(false);
            editorialRepositorio.save(editorial);
        } else {
            throw new Exception("No se encontro la editorial");
        }
    }

    @Transactional
    public void actualizarEditorialParcial(Integer id, String nuevoNombre, Boolean activa) throws Exception {
        Optional<Editorial> editorial = editorialRepositorio.findById(id);

        if (!editorial.isPresent()) {
            throw new Exception("No se encontro la editorial");
        }

        if (nuevoNombre != null) {
            editorial.get().setNombreEditorial(nuevoNombre);
        }
        if (activa != null) {
            editorial.get().setEditorialActiva(activa);
        }

        editorialRepositorio.save(editorial.get());
    }

    @Transactional
    public void actualizarEditorial(Integer id, String nuevoNombre, Boolean activo) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setNombreEditorial(nuevoNombre);
        editorial.setEditorialActiva(activo);
        editorialRepositorio.save(editorial);
    }
}
