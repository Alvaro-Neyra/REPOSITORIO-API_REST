package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutorListActivosDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;
}
