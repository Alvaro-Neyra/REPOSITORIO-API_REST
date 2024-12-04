package com.libreriaapi.libreriaapi.modelos.editorial;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditorialListActivosDTO {
    private Integer idEditorial;
    private String nombreEditorial;
    private Boolean editorialActiva;
}