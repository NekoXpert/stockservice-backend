package com.webapp.stockservice_backend.models;

import jakarta.persistence.*; // Importaciones de Java Persistence API (JPA)

@Entity // Indica que la clase es una entidad
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia 
@DiscriminatorColumn(name = "product_type") //
public abstract class Producto { //

}
