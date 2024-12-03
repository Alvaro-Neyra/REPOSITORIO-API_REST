package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.libreriaapi.libreriaapi.entidades.Editorial;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.editorial.EditorialListDTO;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Integer> {
    @Query("SELECT e FROM Editorial e WHERE e.nombreEditorial = :nombre")
    Editorial buscarPorNombreEditorial(@Param("nombre") String nombre);
    @Query("SELECT e FROM Editorial e WHERE e.idEditorial = :id")
    Editorial buscarPorIdEditorial(@Param("id") Integer id);
    @Query("SELECT new com.libreriaapi.libreriaapi.modelos.editorial.EditorialListActivosDTO(e.idEditorial, e.nombreEditorial, e.editorialActiva) " +
            "FROM Editorial e WHERE e.editorialActiva = true")
    List<EditorialListActivosDTO> listarActivos();
    @Query("SELECT new com.libreriaapi.libreriaapi.modelos.editorial.EditorialListDTO(e.idEditorial, e.nombreEditorial, e.editorialActiva) " +
            "FROM Editorial e")
    List<EditorialListDTO> listar();
}
