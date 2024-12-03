package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorDarBajaDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;

    public AutorDarBajaDTO(String idAutor, String nombreAutor, Boolean autorActivo) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.autorActivo = autorActivo;
    }
}
