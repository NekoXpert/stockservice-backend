package com.webapp.stockservice_backend.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Electronics")
public class ProductoElectronico extends Producto {

}