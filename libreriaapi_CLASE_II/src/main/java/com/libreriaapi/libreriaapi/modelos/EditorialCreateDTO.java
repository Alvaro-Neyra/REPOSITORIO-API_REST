package com.libreriaapi.libreriaapi.modelos;

import lombok.Data;

@Data
public class EditorialCreateDTO {
    private Integer idEditorial;
    private Boolean editorialActiva;
    private String nombreEditorial;
}
