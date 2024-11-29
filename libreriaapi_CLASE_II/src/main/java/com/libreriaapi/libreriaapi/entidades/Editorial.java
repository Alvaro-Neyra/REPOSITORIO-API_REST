package com.libreriaapi.libreriaapi.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_editorial;
    private Boolean editorial_activa;
    private String nombre_editorial;

    public Editorial() {
    }

    public Editorial(Integer id_editorial, Boolean editorial_activa, String nombre_editorial) {
        this.id_editorial = id_editorial;
        this.editorial_activa = editorial_activa;
        this.nombre_editorial = nombre_editorial;
    }

    public Integer getId_editorial() {
        return id_editorial;
    }

    public Boolean getEditorial_activa() {
        return editorial_activa;
    }

    public void setEditorial_activa(Boolean editorial_activa) {
        this.editorial_activa = editorial_activa;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    @Override
    public String toString() {
        return "Editorial [id_editorial=" + id_editorial + ", editorial_activa=" + editorial_activa
                + ", nombre_editorial=" + nombre_editorial + "]";
    }
}
