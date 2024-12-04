package com.egg.libreriaapi.modelos;

import lombok.Data;

@Data // Esta anotación de Lombock genera automáticamente métodos comunes en una clase de Java
//Getters y Setters - toString - equals() y hashCode() - AllArgsConstructor y NoArgsConstructor
public class LibroCreateDTO {
    private Long isbn;//Este dato sera utilizado como idLibro
    private String titulo;
    private Integer ejemplares;
    private String idAutor;
    private String idEditorial;
    private boolean libroActivo;
    
 
}
