package com.egg.libreriaapi.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;

/**
 * Interfaz de repositorio para la entidad Libro.
 * 
 * Esta interfaz extiende JpaRepository, proporcionando métodos estándar para operaciones CRUD.
 * También incluye consultas personalizadas para recuperar información específica de la base de datos.
 */
@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

 /**
     * Consulta personalizada para recuperar una lista de libros activos.
     * 
     * Esta consulta utiliza el patrón DTO para crear instancias de LibroListarActivosDTO,
     * que solo incluyen los campos necesarios: título y ejemplares.
     * 
     * La consulta busca libros cuyo atributo 'libroActivo' sea verdadero.
     * 
     * @return List<LibroListarActivosDTO> - Lista de objetos LibroListarActivosDTO con información de libros activos.
     */    @Query("SELECT new com.egg.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.libroActivo = true")
    List<LibroListarActivosDTO> encontrarActivos();
}
