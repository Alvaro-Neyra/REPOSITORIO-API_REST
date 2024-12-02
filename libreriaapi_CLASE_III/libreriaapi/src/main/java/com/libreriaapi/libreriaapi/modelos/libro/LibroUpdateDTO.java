package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;

@Data
public class LibroUpdateDTO {
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private Integer idEditorial;
    private Boolean libroActivo;
}