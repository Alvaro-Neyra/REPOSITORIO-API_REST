package com.egg.libreriaapi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.repositorios.EditorialRepositorio;

import jakarta.transaction.Transactional;

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
}