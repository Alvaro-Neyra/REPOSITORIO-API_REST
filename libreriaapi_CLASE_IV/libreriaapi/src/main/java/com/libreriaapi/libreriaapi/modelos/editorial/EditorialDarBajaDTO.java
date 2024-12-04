package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditorialDarBajaDTO {
    private Integer idEditorial;
    private String nombreEditorial;

    public EditorialDarBajaDTO(Integer idEditorial, String nombreEditorial) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
    }
}
