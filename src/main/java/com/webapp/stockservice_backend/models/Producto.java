package com.webapp.stockservice_backend.models;

import jakarta.persistence.*; // Importaciones de Java Persistence API (JPA)

@Entity // Indica que la clase es una entidad
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia 
@DiscriminatorColumn(name = "product_type") //
public abstract class Producto { //
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación de ID automática 
    private Long id;

    private String nombre;
    private int cantidad;
    private double precio;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método abstracto para descripción
    public abstract String getDescripcion();
}
