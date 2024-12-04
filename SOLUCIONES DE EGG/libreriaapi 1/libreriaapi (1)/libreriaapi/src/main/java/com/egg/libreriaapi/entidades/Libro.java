package com.egg.libreriaapi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "id_libro")
    private Long idLibro;
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Column(name = "libro_activo")
    private boolean libroActivo;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

}
