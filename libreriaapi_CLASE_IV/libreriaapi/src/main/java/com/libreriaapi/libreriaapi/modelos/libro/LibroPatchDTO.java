package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;

@Data
public class LibroPatchDTO {
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private Integer idEditorial;
    private Boolean libroActivo;

    public LibroPatchDTO(Long isbn, String titulo, Integer ejemplares, String idAutor, Integer idEditorial, Boolean libroActivo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
        this.libroActivo = libroActivo;
    }
}
