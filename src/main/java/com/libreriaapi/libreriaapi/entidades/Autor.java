package com.libreriaapi.libreriaapi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autor {
    @Id
    private String id_autor;
    private Boolean autor_activo;
    private String nombre_autor;

    public Autor() {
    }

    public Autor(String id_autor, Boolean autor_activo, String nombre_autor) {
        this.id_autor = id_autor;
        this.autor_activo = autor_activo;
        this.nombre_autor = nombre_autor;
    }

    public String getId_autor() {
        return id_autor;
    }

    public Boolean getAutor_activo() {
        return autor_activo;
    }

    public void setAutor_activo(Boolean autor_activo) {
        this.autor_activo = autor_activo;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    @Override
    public String toString() {
        return "Autor [id_autor=" + id_autor + ", autor_activo=" + autor_activo + ", nombre_autor=" + nombre_autor
                + "]";
    }

    
}
