package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorDeleteDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;

    public AutorDeleteDTO(String idAutor, String nombreAutor, Boolean autorActivo) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.autorActivo = autorActivo;
    }   
}
