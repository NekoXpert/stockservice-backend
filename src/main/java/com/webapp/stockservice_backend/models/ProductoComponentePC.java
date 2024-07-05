package com.webapp.stockservice_backend.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ComponentePC")
public class ProductoComponentePC extends Producto {

    private String tipoComponente;
    private String especificaciones;

    // Getters y Setters
    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    @Override
    public String getDescripcion() {
        return "Componente de PC: " + this.getNombre() + " - " + this.tipoComponente + " " + this.especificaciones;
    }
}
