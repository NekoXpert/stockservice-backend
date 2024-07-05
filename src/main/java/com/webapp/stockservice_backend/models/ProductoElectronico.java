package com.webapp.stockservice_backend.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Electronics")
public class ProductoElectronico extends Producto {
    private String marca;
    private String modelo;

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getDescripcion() {
        return "Producto Electrónico: " + this.getNombre() + " - " + this.marca + " " + this.modelo;
    }
}
