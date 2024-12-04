package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroListActivosDTO {
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private Integer idEditorial;
    private Boolean libroActivo;

    public LibroListActivosDTO(String titulo, Integer ejemplares) {
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }
}
