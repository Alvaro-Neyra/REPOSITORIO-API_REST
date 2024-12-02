package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;

@Data
public class LibroListDTO {
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private Integer idEditorial;
    private Boolean libroActivo;
}
