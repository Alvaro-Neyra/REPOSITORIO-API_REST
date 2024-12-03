package com.libreriaapi.libreriaapi.modelos.libro;

import lombok.Data;

@Data
public class LibrosPorAutorDTO {
    private Long idLibro;
    private String titulo;
    private Integer ejemplares;
    private Boolean libroActivo;
    private String idAutor;
    private Integer idEditorial;

    public LibrosPorAutorDTO(Long idLibro,String titulo,Integer ejemplares, String idAutor,
                                Integer idEditorial, Boolean libroActivo) {
        this.idLibro = idLibro;
        this.ejemplares = ejemplares;
        this.libroActivo = libroActivo;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
    }
}
