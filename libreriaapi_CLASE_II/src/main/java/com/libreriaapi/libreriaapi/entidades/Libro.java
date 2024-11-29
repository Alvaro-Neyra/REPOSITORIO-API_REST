package com.libreriaapi.libreriaapi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    @Column(name = "id_libro")
    private Long id_libro;

    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Column(name = "libro_activo")
    private Boolean libro_activo;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    public Libro(Long id_libro, Integer ejemplares, Boolean libro_activo, String titulo, Autor autor,
            Editorial editorial) {
        this.id_libro = id_libro;
        this.ejemplares = ejemplares;
        this.libro_activo = libro_activo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }
}
