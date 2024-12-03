package com.libreriaapi.libreriaapi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.libreriaapi.libreriaapi.entidades.Autor;
import com.libreriaapi.libreriaapi.modelos.autor.AutorListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.autor.AutorListDTO;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    @Query("SELECT a FROM Autor a WHERE a.nombreAutor = :nombre")
    Autor buscarPorNombreAutor(@Param("nombre") String nombre);
    @Query("SELECT a FROM Autor a WHERE a.idAutor = :id")
    Autor buscarPorIdAutor(@Param("id") String id);
    @Query("SELECT new com.libreriaapi.libreriaapi.modelos.autor.AutorListActivosDTO(a.idAutor, a.nombreAutor, a.autorActivo) " +
            "FROM Autor a WHERE a.autorActivo = true")
    List<AutorListActivosDTO> listarActivos();
    @Query("SELECT new com.libreriaapi.libreriaapi.modelos.autor.AutorListDTO(a.idAutor, a.nombreAutor, a.autorActivo) " +
            "FROM Autor a")
    List<AutorListDTO> listar();

}
