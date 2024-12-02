package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorListDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;
}
