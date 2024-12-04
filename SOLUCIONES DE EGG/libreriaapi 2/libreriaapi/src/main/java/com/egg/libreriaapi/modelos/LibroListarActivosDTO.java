package com.egg.libreriaapi.modelos;

import lombok.Data;

@Data
public class LibroListarActivosDTO {
    
private String titulo;
private int ejemplares;

//Creo un constructor solamente con los atributos que voy a almacenar en ppatron DTO
public LibroListarActivosDTO(String titulo, int ejemplares) {
    this.titulo = titulo;
    this.ejemplares = ejemplares;
}
}
