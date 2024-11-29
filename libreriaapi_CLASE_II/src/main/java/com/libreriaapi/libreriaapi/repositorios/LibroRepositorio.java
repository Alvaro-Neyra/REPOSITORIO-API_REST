package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libreriaapi.libreriaapi.entidades.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarPorTituloLibro(@Param("titulo") String titulo);
    @Query("SELECT l FROM Libro l WHERE l.id_libro = :id")
    Libro buscarPorIdLibro(@Param("id") Long id);
}
