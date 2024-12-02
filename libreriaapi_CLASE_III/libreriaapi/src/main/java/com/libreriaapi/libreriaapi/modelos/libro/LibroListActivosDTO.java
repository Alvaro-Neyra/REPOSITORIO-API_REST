package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;

@Data
public class LibroListActivosDTO {
    private String titulo;
    private Integer ejemplares;

    public LibroListActivosDTO(String titulo, Integer ejemplares) {
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }
}
