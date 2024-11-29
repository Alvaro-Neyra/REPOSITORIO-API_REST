package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libreriaapi.libreriaapi.entidades.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, String> {
    @Query("SELECT a FROM Autor a WHERE a.nombre_autor = :nombre")
    Autor buscarPorNombreAutor(@Param("nombre") String nombre);
    @Query("SELECT a FROM Autor a WHERE a.id_autor = :id")
    Autor buscarPorIdAutor(@Param("id") String id);
}
