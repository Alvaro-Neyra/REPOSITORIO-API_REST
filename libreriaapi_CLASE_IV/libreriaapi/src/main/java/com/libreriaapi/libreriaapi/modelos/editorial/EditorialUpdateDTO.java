package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;

@Data
public class EditorialUpdateDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;

    public EditorialUpdateDTO(Integer idEditorial, String nombreEditorial, Boolean editorialActiva) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
        this.editorialActiva = editorialActiva;
    }
}
