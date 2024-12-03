package com.libreriaapi.libreriaapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.libreriaapi.libreriaapi.modelos.libro.LibroListActivosDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibroListDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibrosPorAutorDTO;
import com.libreriaapi.libreriaapi.modelos.libro.LibrosPorEditorialDTO;
import com.libreriaapi.libreriaapi.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
        @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
        Libro buscarPorTitulo(@Param("titulo") String titulo);
        @Query("SELECT l FROM Libro l WHERE l.idLibro = :id")
        Libro buscarPorId(@Param("id") Long id);
        @Query("SELECT new com.libreriaapi.libreriaapi.modelos.libro.LibroListActivosDTO(l.idLibro, l.titulo, l.ejemplares, l.autor.idAutor, l.editorial.idEditorial, l.libroActivo) " +
                "FROM Libro l WHERE l.libroActivo = true")
        List<LibroListActivosDTO> listarActivos();
        @Query("SELECT new com.libreriaapi.libreriaapi.modelos.libro.LibroListDTO(l.idLibro, l.titulo, l.ejemplares, l.autor.idAutor, l.editorial.idEditorial, l.libroActivo) " +
        "FROM Libro l")
        List<LibroListDTO> listar();
        @Query("SELECT new com.libreriaapi.libreriaapi.modelos.libro.LibrosPorEditorialDTO(l.idLibro, l.titulo, l.ejemplares, l.autor.idAutor, l.editorial.idEditorial, l.libroActivo) " +
        "FROM Libro l WHERE l.editorial.idEditorial = :idEditorial")
        List<LibrosPorEditorialDTO> listarPorEditorial(@Param("idEditorial") Integer idEditorial);
        @Query("SELECT new com.libreriaapi.libreriaapi.modelos.libro.LibrosPorAutorDTO(l.idLibro, l.titulo, l.ejemplares, l.autor.idAutor, l.editorial.idEditorial, l.libroActivo) " +
        "FROM Libro l WHERE l.autor.idAutor = :idAutor")
        List<LibrosPorAutorDTO> listarPorAutor(@Param("idAutor") String idAutor);
        @Query("SELECT new com.libreriaapi.libreriaapi.modelos.libro.LibrosPorAutorDTO(l.idLibro, l.titulo, l.ejemplares, l.autor.idAutor, l.editorial.idEditorial, l.libroActivo) " +
        "FROM Libro l WHERE l.autor.idAutor = :idAutor AND l.editorial.idEditorial = :idEditorial")
        List<LibrosPorAutorDTO> listarPorAutorYEditorial(@Param("idAutor") String idAutor, @Param("idEditorial") Integer idEditorial);
}
