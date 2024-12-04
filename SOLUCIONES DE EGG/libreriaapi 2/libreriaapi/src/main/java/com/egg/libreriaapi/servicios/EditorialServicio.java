package com.egg.libreriaapi.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.repositorios.EditorialRepositorio;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre)  {
      
        Editorial editorial = new Editorial();// Instancio un objeto del tipo Autor
        editorial.setNomnbreEditorial(nombre);// Seteo el atributo, con el valor recibido como parámetro
        editorial.setEditorialActiva(true);
        editorialRepositorio.save(editorial); // Persisto el dato en mi BBDD
    }

    @Transactional
    public void crearEditorial(EditorialCreateDTO editorialCreateDTO)  {
        
        Editorial editorialNva = new Editorial();// Instancio un objeto del tipo Editorial
        editorialNva.setNomnbreEditorial(editorialCreateDTO.getNombreEditorialDTO());// Seteo el atributo, con el valor recibido como parámetro
        editorialNva.setEditorialActiva(editorialCreateDTO.isEditorialActiva());

        editorialRepositorio.save(editorialNva); // Persisto el dato en mi BBDD
    }

       // Metodo para recuperar una "lista de autores ACTIVOS y NO ACTIVOS "
    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

          // Metodo para recuperar una editorial
    @Transactional(readOnly = true)
    public Editorial getOne(String id) {
        return editorialRepositorio.getReferenceById(id);
    }
}