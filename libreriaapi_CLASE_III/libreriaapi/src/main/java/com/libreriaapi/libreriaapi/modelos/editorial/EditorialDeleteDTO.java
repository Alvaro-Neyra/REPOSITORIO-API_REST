package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;

@Data
public class EditorialDeleteDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;

    public EditorialDeleteDTO(Integer idEditorial, String nombreEditorial, Boolean editorialActiva) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
        this.editorialActiva = editorialActiva;
    }
}
