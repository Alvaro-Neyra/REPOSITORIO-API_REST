package com.egg.libreriaapi.entidades;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_editorial")
    private String id;

    @Column(name = "nombre_editorial")
    private String nomnbreEditorial;

    @Column(name = "editorial_activa")
    private boolean editorialActiva;

    //Defino que el atributo editorialActiva inicialice en "true" al crear una instancia de Editorial
    public  Editorial (){
        this.editorialActiva = true;
    }

  
    
}
