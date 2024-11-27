package com.libreriaapi.libreriaapi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
    @Id
    private Long id_libro;
    private Integer ejemplares;
    private Boolean libro_activo;
    private String titulo;

    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long id_libro, Integer ejemplares, Boolean libro_activo, String titulo, Autor autor,
            Editorial editorial) {
        this.id_libro = id_libro;
        this.ejemplares = ejemplares;
        this.libro_activo = libro_activo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Boolean getLibro_activo() {
        return libro_activo;
    }

    public void setLibro_activo(Boolean libro_activo) {
        this.libro_activo = libro_activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    
}
