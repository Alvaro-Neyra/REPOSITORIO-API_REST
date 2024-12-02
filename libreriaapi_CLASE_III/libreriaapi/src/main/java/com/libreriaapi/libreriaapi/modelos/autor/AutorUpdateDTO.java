package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.Data;

@Data
public class AutorUpdateDTO {
    private String nombreAutor;
    private Boolean autorActivo;
}