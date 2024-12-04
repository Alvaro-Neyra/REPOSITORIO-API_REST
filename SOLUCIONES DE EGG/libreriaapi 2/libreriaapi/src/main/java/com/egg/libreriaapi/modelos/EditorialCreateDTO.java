package com.egg.libreriaapi.modelos;

import lombok.Data;

@Data
public class EditorialCreateDTO {
private String nombreEditorialDTO;
private boolean editorialActiva;

    //Defino que el atributo editorialActiva se inicializa con el valor por defecto "false", por lo tanto
    // se debe recibir el valor en el JSON en caso de querer que sea "true"
}
