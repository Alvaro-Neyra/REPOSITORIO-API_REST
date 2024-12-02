package com.libreriaapi.libreriaapi.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idAutor;

    private Boolean autorActivo;
    private String nombreAutor;

    public Autor(Boolean autorActivo, String nombreAutor) {
        this.autorActivo = autorActivo;
        this.nombreAutor = nombreAutor;
    }
}
