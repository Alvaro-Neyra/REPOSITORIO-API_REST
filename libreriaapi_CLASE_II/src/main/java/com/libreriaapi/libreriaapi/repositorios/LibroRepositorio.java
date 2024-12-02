package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.libreriaapi.libreriaapi.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarPorTitulo(@Param("titulo") String titulo);
    @Query("SELECT l FROM Libro l WHERE l.idLibro = :id")
    Libro buscarPorId(@Param("id") Long id);
}
