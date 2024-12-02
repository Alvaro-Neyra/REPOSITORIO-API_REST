package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.libreriaapi.libreriaapi.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    @Query("SELECT a FROM Autor a WHERE a.nombreAutor = :nombre")
    Autor buscarPorNombreAutor(@Param("nombre") String nombre);
    @Query("SELECT a FROM Autor a WHERE a.idAutor = :id")
    Autor buscarPorIdAutor(@Param("id") String id);
}
