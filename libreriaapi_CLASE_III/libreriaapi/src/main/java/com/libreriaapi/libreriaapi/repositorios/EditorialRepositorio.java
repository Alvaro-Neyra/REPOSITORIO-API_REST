package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.libreriaapi.libreriaapi.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Integer> {
    @Query("SELECT e FROM Editorial e WHERE e.nombreEditorial = :nombre")
    Editorial buscarPorNombreEditorial(@Param("nombre") String nombre);
    @Query("SELECT e FROM Editorial e WHERE e.idEditorial = :id")
    Editorial buscarPorIdEditorial(@Param("id") Integer id);
}
