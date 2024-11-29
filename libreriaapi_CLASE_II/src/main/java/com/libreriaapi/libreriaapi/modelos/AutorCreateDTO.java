package com.libreriaapi.libreriaapi.modelos;

import lombok.Data;

@Data
public class AutorCreateDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;
}
