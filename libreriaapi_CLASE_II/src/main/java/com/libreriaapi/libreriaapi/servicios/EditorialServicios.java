package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.repositorios.EditorialRepositorio;

@Service
public class EditorialServicios {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(nombre);
        editorial.setEditorialActiva(true);
        editorialRepositorio.save(editorial);
    }

    public Editorial obtenerEditorialPorId(Integer id) throws Exception{
        Optional<Editorial> editorial = editorialRepositorio.findById((id));
        if (editorial.isPresent()) {
            return editorial.get();
        } else {
            throw new Exception("No se encontro la editorial");
        }
    }

    public List<Editorial> listarEditoriales() {
        return editorialRepositorio.findAll();
    }

    public void darBajaEditorial(Integer id) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setEditorialActiva(false);
        editorialRepositorio.save(editorial);
    }

    public void darBajaEditorialPorNombre(String nombre) throws Exception {
        Editorial editorial = editorialRepositorio.buscarPorNombreEditorial(nombre);
        if (editorial != null) {
            editorial.setEditorialActiva(false);
            editorialRepositorio.save(editorial);
        } else {
            throw new Exception("No se encontro la editorial");
        }
    }

    public void actualizarEditorial(Integer id, String nuevoNombre) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setNombreEditorial(nuevoNombre);
        editorialRepositorio.save(editorial);
    }
}
