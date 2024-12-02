package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.Data;

@Data
public class EditorialListDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;
}
