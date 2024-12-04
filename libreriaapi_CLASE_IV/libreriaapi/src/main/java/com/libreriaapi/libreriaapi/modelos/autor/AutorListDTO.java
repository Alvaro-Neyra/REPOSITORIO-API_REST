package com.libreriaapi.libreriaapi.modelos.autor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorListDTO {
    private String idAutor;
    private String nombreAutor;
    private Boolean autorActivo;
}
