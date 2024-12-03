package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;

@Data
public class EditorialDarBajaDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;

    public EditorialDarBajaDTO(Integer idEditorial, String nombreEditorial) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
    }
}
