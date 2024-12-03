package com.libreriaapi.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialCreateDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialDarBajaDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialListDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialPatchDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialUpdateDTO;
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
    public void crearEditorial(EditorialCreateDTO editorialDTO) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
        editorial.setEditorialActiva(editorialDTO.getEditorialActiva());
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

    @Transactional(readOnly = true)
    public List<EditorialListDTO> listarEditorialesDTO() {
        return editorialRepositorio.listar();
    }

    @Transactional(readOnly = true)
    public List<EditorialListActivosDTO> listarEditorialesActivos() {
        return editorialRepositorio.listarActivos();
    }

    @Transactional(readOnly = true)
    public Editorial getOne(Integer id) {
        return editorialRepositorio.getOne(id);
    }

    @Transactional
    public void darBajaEditorial(Integer id) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setEditorialActiva(false);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void darBajaEditorial(EditorialDarBajaDTO editorialDTO) throws Exception {
        Editorial editorial = obtenerEditorialPorId(editorialDTO.getIdEditorial());
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
    public void darBajaEditorialPorNombre(EditorialDarBajaDTO editorialDTO) throws Exception {
        Editorial editorial = editorialRepositorio.buscarPorNombreEditorial(editorialDTO.getNombreEditorial());
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
    public void actualizarEditorialParcial(EditorialPatchDTO editorialDTO) throws Exception {
        Optional<Editorial> optionalEditorial = editorialRepositorio.findById(editorialDTO.getIdEditorial());
        if (!optionalEditorial.isPresent()) {
            throw new Exception("No se encontró la editorial con el ID proporcionado.");
        }
    
        Editorial editorial = optionalEditorial.get();
    
        if (editorialDTO.getNombreEditorial() != null) {
            editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
        }
        if (editorialDTO.getEditorialActiva() != null) {
            editorial.setEditorialActiva(editorialDTO.getEditorialActiva());
        }
    
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void actualizarEditorial(Integer id, String nuevoNombre, Boolean activo) throws Exception {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setNombreEditorial(nuevoNombre);
        editorial.setEditorialActiva(activo);
        editorialRepositorio.save(editorial);
    }

    @Transactional
    public void actualizarEditorial(EditorialUpdateDTO editorialDTO) throws Exception {
        Editorial editorial = obtenerEditorialPorId(editorialDTO.getIdEditorial());
        editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
        editorial.setEditorialActiva(editorialDTO.getEditorialActiva());
        editorialRepositorio.save(editorial);
    }
}
