package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibroDarBajaDTO {
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private Integer idEditorial;

    public LibroDarBajaDTO(Long isbn, String titulo, Integer ejemplares, String idAutor, Integer idEditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
    }
}
