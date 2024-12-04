package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorPatchDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;

    public AutorPatchDTO(String idAutor, String nombreAutor, Boolean autorActivo) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.autorActivo = autorActivo;
    }
}
