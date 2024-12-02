package com.libreriaapi.libreriaapi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    @Column(nullable = false, unique = true)
    private Long idLibro;

    private Integer ejemplares;

    private Boolean libroActivo;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "idEditorial", nullable = false)
    private Editorial editorial;

    public Libro(Long idLibro, Integer ejemplares, Boolean libroActivo, String titulo, Autor autor,
            Editorial editorial) {
        this.idLibro = idLibro;
        this.ejemplares = ejemplares;
        this.libroActivo = libroActivo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }
}
