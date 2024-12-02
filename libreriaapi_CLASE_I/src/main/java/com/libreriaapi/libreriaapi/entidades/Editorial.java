package com.libreriaapi.libreriaapi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEditorial;

    private Boolean editorialActiva;
    private String nombreEditorial;

    public Editorial(Boolean editorialActiva, String nombreEditorial) {
        this.editorialActiva = editorialActiva;
        this.nombreEditorial = nombreEditorial;
    }
}
