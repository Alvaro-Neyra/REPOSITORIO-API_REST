package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;

@Data
public class EditorialListDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;

    public EditorialListDTO(Integer idEditorial, String nombreEditorial, Boolean editorialActiva) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
        this.editorialActiva = editorialActiva;
    }
}
