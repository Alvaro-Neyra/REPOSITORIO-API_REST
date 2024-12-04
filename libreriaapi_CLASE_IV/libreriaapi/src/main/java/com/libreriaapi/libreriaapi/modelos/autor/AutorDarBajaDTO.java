package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorDarBajaDTO {
    private String idAutor;
    private String nombreAutor;

    public AutorDarBajaDTO(String idAutor, String nombreAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
    }
}
